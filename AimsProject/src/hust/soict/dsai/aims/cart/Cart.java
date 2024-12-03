package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.Media;

public class Cart {
	private ArrayList<Media> orderedItems = new ArrayList<Media>();
	
	public void addMedia(Media media) {
        if(orderedItems.contains(media)) {
            System.out.println(media.getTitle() + " is already in the cart!");
        } else {
        	orderedItems.add(media);
            System.out.println(media.getTitle() + " added!");
        }
    }
	
	public void removeMedia(Media media) {
        if(orderedItems.contains(media)) {
        	orderedItems.remove(media);
        	System.out.println(media.getTitle() + " has been removed!");
        } else {
            System.out.println(media.getTitle() + " is not in the cart!");
        }
    }
	
	public float totalCost() {
		float total = 0;
        for (Media media : orderedItems) {
            total += media.getCost();
        }
        return total;
    }

    public void displayCart() {
        for (Media media : orderedItems) {
            System.out.println(media.getTitle());
        }
        System.out.println("Total cost: " + totalCost());
    }
	
    public void printCart() {
    	int i = 0;
    	System.out.println("***********************CART***********************");
    	System.out.println("Ordered Items:");
    	for (Media media : orderedItems) {
    		int idx = ++i;
            System.out.println(idx + "." + media.toString());
        }
    	System.out.println("Total cost: " + totalCost());
    	System.out.println("***************************************************");
    }
    
    public void searchById(int i) {
        if(i > orderedItems.size()|| i<1) {
            System.out.println("No match found !");
        } else {
            System.out.println("Result: " +  "[" + orderedItems.get(i-1).getTitle() +
                    "] - [" + orderedItems.get(i-1).getCategory() + "] -"
                    +  + orderedItems.get(i-1).getCost() + " $\n");
        }
    }
    
    public void searchByTitle(String title) {
        for(Media item : orderedItems) {
            if(item.getTitle().equals(title)) {
                System.out.println("Result: " +  "[" + item.getTitle() +
                        "] - [" + item.getCategory() + "] -"
                        +item.getCost() + " $\n");
                return;
            }
        }
        System.out.println("No match found");
    }
    
    public void sortByTitleCost() {
        Collections.sort(orderedItems,Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        Collections.sort(orderedItems,Media.COMPARE_BY_COST_TITLE);
    }
    public Media findMedia(String title) {
        for (Media item : orderedItems) {
            if (item.getTitle().equals(title)) {
                return item;
            }
        }
        return null;
    }
    public void emptyCart() {
    	orderedItems.removeAll(orderedItems);
    }

}
