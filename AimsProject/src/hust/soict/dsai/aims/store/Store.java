package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.exception.DuplicatedItemException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;

public class Store {
	ArrayList<Media> itemsInStore = new ArrayList<Media>();
	public void addMedia(Media media) throws DuplicatedItemException {
		if (itemsInStore.contains(media)) {
			throw new DuplicatedItemException("ERROR: Item already exists.");
		} else {
			itemsInStore.add(0, media);
			System.out.println("Added " + media.toString() + " to store.");
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

	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
	
	public Media fetchMedia(String title) {
		for (Media m : itemsInStore) {
			if (m.isMatch(title))
				return m;
		}
		return null;
	}

	public Media findMedia(String title) {
        for (Media item : itemsInStore) {
            if (item.getTitle().equals(title)) {
                return item;
            }
        }
        return null;
    }
}
