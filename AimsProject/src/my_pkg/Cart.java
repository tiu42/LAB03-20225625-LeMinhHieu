package my_pkg;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc orderedItems[] =
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public void addDVD(DigitalVideoDisc disc) {
		if(this.qtyOrdered < MAX_NUMBERS_ORDERED) {
			orderedItems[qtyOrdered] = disc;
			System.out.println("The disc has been added!");
			qtyOrdered++;
			return;
		}
		System.out.println("The cart is full!");
		return;
	}
	
	public void addDVD(DigitalVideoDisc [] dvdList) {
		int l = dvdList.length;
		for (int i=0; i<l; i++) {
			if(this.qtyOrdered < MAX_NUMBERS_ORDERED) {
				orderedItems[qtyOrdered] = dvdList[i];
				System.out.println("The disc has been added!");
				qtyOrdered++;
			}
			else {
				System.out.println("The cart is full!");
				return;
			}
		}
		return;
	}
	
	public void addDVD(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2, DigitalVideoDisc dvd3) {
		if(this.qtyOrdered < MAX_NUMBERS_ORDERED) {
			orderedItems[qtyOrdered] = dvd1;
			System.out.println("The 1st disc has been added!");
			qtyOrdered++;
		}
		else {
			System.out.println("The cart is full!");
			return;
		}
		if(this.qtyOrdered < MAX_NUMBERS_ORDERED) {
			orderedItems[qtyOrdered] = dvd2;
			System.out.println("The 2nd disc has been added!");
			qtyOrdered++;
		}
		else {
			System.out.println("The cart is full!");
			return;
		}
		if(this.qtyOrdered < MAX_NUMBERS_ORDERED) {
			orderedItems[qtyOrdered] = dvd3;
			System.out.println("The 3rd disc has been added!");
			qtyOrdered++;
		}
		else {
			System.out.println("The cart is full!");
			return;
		}
		return;
	}
	
	public void addDVD(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if(this.qtyOrdered < MAX_NUMBERS_ORDERED) {
			orderedItems[qtyOrdered] = dvd1;
			System.out.println("The 1st disc has been added!");
			qtyOrdered++;
		}
		else {
			System.out.println("The cart is full!");
			return;
		}
		if(this.qtyOrdered < MAX_NUMBERS_ORDERED) {
			orderedItems[qtyOrdered] = dvd2;
			System.out.println("The 2nd disc has been added!");
			qtyOrdered++;
		}
		else {
			System.out.println("The cart is full!");
			return;
		}
		return;
	}
	
	public void removeDVD(DigitalVideoDisc disc) {
		for(int i=0; i<this.qtyOrdered;i++) {
			if(orderedItems[i] == disc) {
				for (int j = i; j < qtyOrdered - 1; j++) {
					orderedItems[j] = orderedItems[j + 1];
                }
				orderedItems[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed.");
                return;
			}
		}
		System.out.println("The disc is not in the cart.");
	}
	
	public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += orderedItems[i].getCost();
        }
        return total;
    }

    public void displayCart() {
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println(orderedItems[i].getTitle());
        }
        System.out.println("Total cost: " + totalCost());
    }
	
    public void printCart() {
    	System.out.println("***********************CART***********************");
    	System.out.println("Ordered Items:");
    	for (int i = 0; i < qtyOrdered; i++) {
    		int idx = i+1;
            System.out.println(idx + "." + orderedItems[i].toString());
        }
    	System.out.println("Total cost: " + totalCost());
    	System.out.println("***************************************************");
    }
    
    public void searchDVD(int id) {
    	for(int i=0; i<this.qtyOrdered;i++) {
			if(orderedItems[i].getId() == id) {
                System.out.println("Found disc: " + id + ". " + orderedItems[i].toString());
                return;
			}
		}
		System.out.println("Disc not found!");
    }
    
    public void searchDVD(String title) {
    	for(int i=0; i<this.qtyOrdered;i++) {
			if(orderedItems[i].isMatch(title)) {
                System.out.println("Found disc: " + orderedItems[i].getId() + ". " + orderedItems[i].toString());
                return;
			}
		}
		System.out.println("Disc not found!");
    }
}
