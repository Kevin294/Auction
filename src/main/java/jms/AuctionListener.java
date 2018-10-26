package jms;

import java.io.IOException;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import com.google.gson.JsonObject;

import entities.Auction;



@MessageDriven(mappedName = "jms/dat250/Topic", activationConfig = {
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
	//	@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "auctionWinner = 'false'")
		})
public class AuctionListener implements MessageListener{
	
	@Override
	public void onMessage(Message message) {

		try {
			Auction auction = message.getBody(Auction.class);
			JsonObject json = new JsonObject();
			json.addProperty("Seller", auction.getUser().getUsername());
			json.addProperty("Product", auction.getProduct().getName());
			json.addProperty("Price", auction.getBid().getValue());
			json.addProperty("Winner", auction.getBid().getOwner());
			
			Logger logger = Logger.getLogger(getClass().getName());
			logger.info("DTWEET User: " + auction.getUser().getUsername()); 
			logger.info("DTWEET Product: " + auction.getProduct().getName());
			logger.info("DTWEET:...");
			logger.info("DTWEET JSON: " + json);
			
			try {
				AuctionConnection dc = new AuctionConnection();
				dc.publish(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
