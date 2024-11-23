package my_pkg;

public class Aims {

	public static void main(String[] args) {
		// Create a new cart
        Cart cart = new Cart();

        // Create some DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers" , 87 , 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geogre Lucas",87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        // Add DVDs to the cart
        cart.addDVD(dvd1);
        cart.addDVD(dvd2);
        cart.addDVD(dvd3);

        // Display the cart
        cart.displayCart();

        // Remove a DVD and display the cart again
        cart.removeDVD(dvd3);
        cart.displayCart();
	}

}
