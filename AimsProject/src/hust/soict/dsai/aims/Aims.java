package hust.soict.dsai.aims;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class Aims {

	public static void main(String[] args) {
		DigitalVideoDisc dvd = new DigitalVideoDisc("Cinderella","Fantasy", "Le Minh Hieu",18.5f);
        ArrayList<Track> tracks = new ArrayList<Track>();
        tracks.add(new Track("Happy new year",3));
        tracks.add(new Track("i want it that way",4));
        CompactDisc cd = new CompactDisc("Nhac bat hu ngay xua","Nhac Au My Latin","Various artist",25.5f,tracks);
        ArrayList<String> authors = new ArrayList<String>();
        authors.add("Phung Quan");
        authors.add("Gia Huy");
        Book book   = new Book("Tuoi tho du doi","novel",25.2f,authors);
        Store store = new Store();
        store.addMedia(cd);
        store.addMedia(dvd);
        store.addMedia(book);
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);
        showMenu(scanner, store, cart);
	}
	
	public static void showMenu(Scanner scanner, Store store, Cart cart) {
        while (true) {
            System.out.println("AIMS:");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3");
            
            int option = scanner.nextInt();
            switch (option) {
            case 0:
            	scanner.close();
                System.exit(0);
                break;
            case 1:
            	storeMenu(scanner, store, cart);
            	break;
            case 2:
            	updateStoreMenu(scanner, store);
            	break;
            case 3:
            	cart.printCart();
                cartMenu(scanner,cart);
                break;
            default:
            	System.out.println("Invalid command!");
            	break;
            }
        }
    }
	
	public static void updateStoreMenu(Scanner scanner, Store store) {
        System.out.println("==========================");
        System.out.println("1. add Media");
        System.out.println("2. delete Media");
        System.out.println("3. update Media in Store");
        System.out.println("0. Back");
        System.out.println("==========================");
        System.out.println("Option: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
            	System.out.println("1.DigitalVideoDisc");
            	System.out.println("2.CompactDisc");
            	System.out.println("3.Book");
            	System.out.println("-------");
            	System.out.println("-> Your type:");
                int option2 = scanner.nextInt();
                System.out.print("Enter id: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                System.out.print("Enter category: ");
                String category = scanner.nextLine();
                System.out.print("Enter cost: ");
                float cost = scanner.nextFloat();
                scanner.nextLine();
                switch (option2) {
                    case 1:
                        System.out.print("Enter director's name: ");
                        String director = scanner.nextLine();
                        System.out.print("Enter dvd's length: ");
                        int length = scanner.nextInt();
                        scanner.nextLine();
                        store.addMedia(new DigitalVideoDisc(title,category,director,length,cost));
                    case 3:
                        System.out.print("Enter author's name (Enter nothing to skip): ");
                        StringBuilder author = new StringBuilder(scanner.nextLine());
                        ArrayList<String> authors = new ArrayList<String>();
                        while (!authors.isEmpty()) {
                            authors.add(author.toString());
                            System.out.print("Enter author's name (Enter nothing to skip): ");

                        }
                        store.addMedia(new Book(title,category,cost,authors));
                    case 2:
                        System.out.print("Enter artist's name: ");
                        StringBuffer artist = new StringBuffer(scanner.nextLine());
                        System.out.print("Enter number of track: ");
                        int nbTrack = scanner.nextInt();scanner.nextLine();
                        ArrayList<Track> tracks = new ArrayList<Track>();
                        StringBuilder name = new StringBuilder();
                        for(int i = 0;i< nbTrack;i++) {
                            System.out.print("Enter Track[" + i + "]'s name: ");
                            name.replace(0,name.length(),scanner.nextLine());
                            System.out.print("Enter Track[" + i + "]'s length: ");
                            int l = scanner.nextInt();
                            tracks.add(new Track(name.toString(), l));
                            scanner.nextLine();

                        }
                        store.addMedia(new CompactDisc(title,category,artist.toString(),cost,tracks));
                }
            case 2:
                System.out.println("Enter item's title: ");
                scanner.nextLine();
                String t = scanner.nextLine();
                Iterator<Media> iter = store.getItemsInStore().iterator();
                while (iter.hasNext()) {
                    Media item = iter.next();
                    if(item.getTitle().equals(t)) {
                        iter.remove();
                        System.out.println(item.getClass().getSimpleName() + " " + item.getTitle() + "'ve been deleted from the store !");
                    }
                }
            case 3:
                System.out.println("Enter item's id: ");
                int i = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter title: ");
                String tl = scanner.nextLine();
                System.out.print("Enter category: ");
                String ctg = scanner.nextLine();
                System.out.print("Enter cost: ");
                float ct = scanner.nextFloat();
                store.getItemsInStore().get(i).setCost(ct);
                store.getItemsInStore().get(i).setTitle(tl);
                store.getItemsInStore().get(i).setCategory(ctg);
                System.out.println(store);
        }
    }
	
	public static void mediaDetailsMenu(Scanner scanner, Store store, Cart cart) {
        System.out.print("Enter media's title: ");
        String title = scanner.nextLine();
        Media item = store.findMedia(title);
        if(item == null) {
            System.out.println("There is no such media !");
            return;
        }
        System.out.println(item);
        while (true) {
        	System.out.println("Options:");
        	System.out.println("--------------------------------");
        	System.out.println("1. Add to cart");
        	System.out.println("2. Play");
        	System.out.println("0. Back");
        	System.out.println("--------------------------------");
        	System.out.println("Please choose a number: 0-1-2");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    cart.addMedia(item);
                case 2:
                	if (item instanceof Book) {
                	    System.out.println("This media is unplayable");
                	} else {
                	    if (item instanceof DigitalVideoDisc) {
                	        DigitalVideoDisc dvd = (DigitalVideoDisc) item;
                	        dvd.play();
                	    } else if (item instanceof CompactDisc) {
                	        CompactDisc cd = (CompactDisc) item;
                	        cd.play();
                	    }
                	}
                case 0:
                    return;
            }
        }
    }
	
	public static void storeMenu(Scanner scanner, Store store, Cart cart) {
        System.out.println(store);
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media’s details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1: mediaDetailsMenu(scanner, store, cart);
                case 0:
                    return;
                case 2:
                    System.out.print("Enter media's title: ");
                    String title = scanner.nextLine();
                    Media item = store.findMedia(title);
                    if (item == null) {
                        System.out.println("There is no such media !");
                    } else {
                        cart.addMedia(item);
                    }
                case 3:
                	System.out.print("Enter media's title: ");
                	String t = scanner.nextLine();
                	Media i = store.findMedia(t);
                	if (i == null) {
                	    System.out.println("There is no such media!");
                	} else {
                	    if (i.getClass().getSimpleName().equals("Book")) {
                	        System.out.println("This media is unplayable");
                	    } else {
                	        if (i instanceof DigitalVideoDisc) {
                	            DigitalVideoDisc dvd = (DigitalVideoDisc) i;
                	            dvd.play();
                	        }
                	        if (i instanceof CompactDisc) {
                	            CompactDisc cd = (CompactDisc) i;
                	            cd.play();
                	        }
                	    }
                	}

                case 4:
                    cart.printCart();
                    cartMenu(scanner,cart);
            }
        }
    }
	
	public static void cartMenu(Scanner scanner,Cart cart) {
        while (true) {
        	System.out.println("Options:");
        	System.out.println("--------------------------------");
        	System.out.println("1. Filter medias in cart");
        	System.out.println("2. Sort medias in cart");
        	System.out.println("3. Remove media from cart");
        	System.out.println("4. Play a media");
        	System.out.println("5. Place order");
        	System.out.println("0. Back");
        	System.out.println("--------------------------------");
        	System.out.println("Please choose a number: 0-1-2-3-4-5");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0:
                    return;
                case 1:
                	System.out.println("1. Filter by title");
                	System.out.println("2. Filter by id");
                	System.out.println("----------------");
                	System.out.println("your option: ");
                    int option2 = scanner.nextInt();
                    scanner.nextLine();
                    if (option2 == 1) {
                        int id = scanner.nextInt();
                        cart.searchById(id);
                    } else {
                        String title = scanner.nextLine();
                        cart.searchByTitle(title);
                    }
                case  2:
                	System.out.println("1. sort by title cost");
                	System.out.println("2. sort by cost title");
                	System.out.println("----------------");
                	System.out.println("your option: ");
                    int option3 = scanner.nextInt();
                    scanner.nextLine();
                    if (option3 == 1) {
                        cart.sortByTitleCost();
                        cart.printCart();
                    } else {
                        cart.sortByCostTitle();
                        cart.printCart();
                    }
    
                case 3:
                    System.out.print("Enter media's title: ");
                    String title = scanner.nextLine();
                    Media item = cart.findMedia(title);
                    if (item == null) {
                        System.out.println("There is no such media !");
                    } else {
                        cart.removeMedia(item);
                    }
                case 4:
                	System.out.print("Enter media's title: ");
                	String t = scanner.nextLine();
                	Media i = cart.findMedia(t); 

                	if (i == null) {
                	    System.out.println("There is no such media!");  
                	} else {
                	    if (i.getClass().getSimpleName().equals("Book")) {
                	        System.out.println("This media is unplayable");  
                	    } else {
                	        if (i instanceof DigitalVideoDisc) {
                	            DigitalVideoDisc dvd = (DigitalVideoDisc) i;
                	            dvd.play(); 
                	        }
                	        if (i instanceof CompactDisc) {
                	            CompactDisc cd = (CompactDisc) i;
                	            cd.play();
                	        }
                	    }
                	}

                case 5:
                    System.out.println("Your cart have been paid\nThanks for using our service");
                    cart.emptyCart();
                }
            }
        }
    
}

