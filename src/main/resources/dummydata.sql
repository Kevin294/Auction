INSERT INTO public.address(address_id, addressss, areacode, city, country) VALUES (1, 'sleipner', 5221, 'bergen', 'norway');
INSERT INTO public.product(product_id, category, description, name) VALUES (1, 'Accessory', 'Some cool desc', 'Some cool name');
INSERT INTO public.users(username, email, firstname, lastname, phone, password, address_id) VALUES ('kevin294', 'kevin@gmail.com','Kevin', 'Arnesen', 12341234, 'heisann', 1);
INSERT INTO public.bid(bid_id, owner, bidvalue) VALUES (1,'kevin294',50.0);
INSERT INTO public.auction(auction_id, bid_id, product_id, username, active) VALUES (1, 1, 1, 'kevin294', true);
INSERT INTO public.feedback(feedback_id, message, navn, stars, username) VALUES (1,'Great guy', 'navn', 4.5, 'kevin294');