package hust.soict.dsai.test.cart;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.DuplicatedItemException;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) throws LimitExceededException, DuplicatedItemException {
		// TODO Auto-generated method stub
		Cart cart = new Cart();

        // Create some DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers" , 87 , 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geogre Lucas",87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        // Add DVDs to the cart
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        
        //Test the printCart method
        cart.printCart();
        
        //Test the search methods
        cart.searchById(2);
        cart.searchById(0);
        cart.searchByTitle("Aladin");
        cart.searchByTitle("Knives out");
	}

}
