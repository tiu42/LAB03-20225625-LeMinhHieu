package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Store {
	ArrayList<Media> itemsInStore = new ArrayList<Media>();
	public void addMedia(Media media) {
        if(itemsInStore.contains(media)) {
            System.out.println(media.getTitle() + " is already in the cart!");
        } else {
        	itemsInStore.add(media);
            System.out.println(media.getTitle() + " added!");
        }
    }
	
	public void removeMedia(Media media) {
        if(itemsInStore.contains(media)) {
        	itemsInStore.remove(media);
        	System.out.println(media.getTitle() + " has been removed!");
        } else {
            System.out.println(media.getTitle() + " is not in the store!");
        }
    }
}
