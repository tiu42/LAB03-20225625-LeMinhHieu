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
	
}
