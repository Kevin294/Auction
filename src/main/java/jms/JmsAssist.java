package jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSSessionMode;
import javax.jms.Topic;
import javax.naming.NamingException;

import entities.Auction;

@Stateless
public class JmsAssist {

	@Inject
	@JMSConnectionFactory("jms/dat250/ConnectionFactory")
	@JMSSessionMode(JMSContext.AUTO_ACKNOWLEDGE)
	private JMSContext context;

	@Resource(lookup = "jms/dat250/Topic")
	private Topic topic;

	public void submit(Auction auction) throws NamingException, JMSException {
		context.createProducer().setProperty("auctionWinner", String.valueOf(auction.isActive())).send(topic, auction);

	}
}
