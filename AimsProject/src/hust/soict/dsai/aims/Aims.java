package hust.soict.dsai.aims;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.DuplicatedItemException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.screen.CartScreen;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	
	private static CartScreen cartScreen;
	private static Store store;
	private static Cart cart;
	public static Store getStore() {
		return store;
	}

	public static Cart getCart() {
		return cart;
	}

	public static StoreScreen getStoreScreen() {
		return storeScreen;
	}
	
	public static CartScreen getCartScreen() {
		return cartScreen;
	}

	private static StoreScreen storeScreen;
	//private static CartScreen cartScreen;

	public static void main(String[] args) {
		
		store = new Store();
		cart = new Cart();
		
		// Sample Medias
		ArrayList<Track> tracks = new ArrayList<Track>();
        tracks.add(new Track("Happy new year",3));
        tracks.add(new Track("i want it that way",4));
        
        ArrayList<String> authors = new ArrayList<String>();
        authors.add("Phung Quan");
        authors.add("Gia Huy");
		
		Media[] sample = new Media[] {
				new DigitalVideoDisc("Cinderella","Fantasy", "Le Minh Hieu",18.5f),
				new CompactDisc("Nhac bat hu ngay xua","Nhac Au My Latin","Various artist",25.5f,tracks),
				new Book("Tuoi tho du doi","novel",25.2f,authors),
				new DigitalVideoDisc("Cinderella 2","Fantasy", "Le Minh Hieu",19.5f),
				new CompactDisc("Nhac bat hu ngay nay","Nhac Au My Latin","Various artist",26.5f,tracks),
				new Book("Tuoi tho khong du doi","novel",26.2f,authors),
				new DigitalVideoDisc("Cinderella 3","Fantasy", "Le Minh Hieu",20.5f),
				new CompactDisc("Nhac bat hu ngay sau","Nhac Au My Latin","Various artist",27.5f,tracks),
				new Book("Tuoi tho rat du doi","novel",27.2f,authors),
		};
		
		for(Media m: sample) {
			try {
				store.addMedia(m);
			} catch (DuplicatedItemException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
        
		openStoreScreen();
	}
	
	public static void openStoreScreen() {
		storeScreen = new StoreScreen(store);
	}
	
	public static void closeStoreScreen() {
		storeScreen.setVisible(false);
		storeScreen = null;
	}
	
	public static void openCartScreen() {
		cartScreen = new CartScreen(cart);
	}
	
	public static void closeCartScreen() {
		cartScreen.setVisible(false);
		cartScreen = null;
	}
    
}

