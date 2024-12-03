package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Store {
	public static final int MAX_CAPACITY = 100000;
	private DigitalVideoDisc itemsInStore[] = 
			new DigitalVideoDisc[MAX_CAPACITY];
	private int dvdsAdded = 0;
	public void addDVD(DigitalVideoDisc disc) {
		if(this.dvdsAdded < MAX_CAPACITY) {
			itemsInStore[dvdsAdded] = disc;
			System.out.println("The disc has been added!");
			dvdsAdded++;
			return;
		}
		System.out.println("The store is full!");
		return;
	}
	
	public void removeDVD(DigitalVideoDisc disc) {
		for(int i=0; i<this.dvdsAdded;i++) {
			if(itemsInStore[i] == disc) {
				for (int j = i; j < dvdsAdded - 1; j++) {
					itemsInStore[j] = itemsInStore[j + 1];
                }
				itemsInStore[dvdsAdded - 1] = null;
                dvdsAdded--;
                System.out.println("The disc has been removed.");
                return;
			}
		}
		System.out.println("The disc is not in the store.");
	}
}
