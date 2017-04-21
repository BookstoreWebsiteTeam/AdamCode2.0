package shoppingcart;

import java.util.*;
import java.text.DecimalFormat;

public class ShoppingCart {

    //the shopping cart will be sent books with a specified quantity whenever they need to be added to the cart, then the class
    //will be sent an integer denoting the book type that was sent. The types and integers are as follows on the next line:
    //new = 1, used = 2, rental = 3, ebook = 4. Since only one type of book can be sent at a time, only one of these
    //integers needs to be sent at a time. They will be stored in an Array in the same position as the ArrayList that 
    //the book object is in.
    private int numItemsInCart; //displays total num of items in the cart
    private boolean onlyEbook; //used to determing if shipping needs to be applied (does not with only ebooks)
    private double subtotalPrice; //tracks price without tax and shipping added
    private double totalPrice; //tracks price with shipping and tax added
    private ArrayList<Book> cart = new ArrayList<>(); //used to store Book items in the shopping cart
    private ArrayList<Integer> bookType = new ArrayList<>(); //stores the type of book at the same index as it appears in cart
    private ArrayList<Integer> quantityInCart = new ArrayList<>(); //stores the quantity in the same index as it appears in cart
    private ArrayList<Book> currentBookList = new ArrayList<>();
    //private ObjectIO = new ObjectIO();
    //private int[] bookType = new int[200]; //create a vector to store book type in so they are the same location as in the shopping cart
    private final double tax = .07; //this is the modifier for tax
    private final double shippingCost = 15.00; //this is the flat shipping cost to be applied to any order with physical books
    DecimalFormat df = new DecimalFormat("#.00"); //for formatting the totalPrice
    //private Vector bookType = new Vector();

    public ShoppingCart() { //basic empty constructor. Creates an empty cart and sets variables to 0
        numItemsInCart = 0;
        onlyEbook = false; //default set to false to prevent basic issues
        subtotalPrice = 0;
        totalPrice = 0;
    }

    public ShoppingCart(Book a, int quantity, int type) { //constructor that allows the immediated adding of a book to the cart
        //with this constructor, the only items in the cart are the total quantity
        //subtotalPrice = a.getPrice() * quantity; 
        //TODO: Rewrite prev line so that the price is based on the type of book.
        double tempPrice;
        switch (type) { // adds the price of the books passed to the subtotal price
            case 1:
                tempPrice = a.getNewPrice();
                subtotalPrice = tempPrice * quantity;
                break;
            case 2:
                tempPrice = a.getUsedPrice();
                subtotalPrice = tempPrice * quantity;
                break;
            case 3:
                tempPrice = a.getRentalPrice();
                subtotalPrice = tempPrice * quantity;
                break;
            case 4:
                tempPrice = a.getEbookPrice();
                subtotalPrice = tempPrice * quantity;
                break;
            //TODO: Write Exception handling here
            default:
                break;
        }
        try {
            switch (type) { //then adds the quantity to the cart if the quantity added is less than or equal to the total
                //quantity that the book object has available. If they have 9 books and you try to add 10, it
                //will not allow it.
                case 1:
                    if (quantity <= a.getNewQuantity()) {
                        cart.add(a);
                        quantityInCart.add(quantity);
                        bookType.add(type);
                        numItemsInCart += quantity;
                    } else {
                        //TODO Error message
                    }
                    break;
                case 2:
                    if (quantity <= a.getUsedQuantity()) {
                        cart.add(a);
                        quantityInCart.add(quantity);
                        bookType.add(type);
                        numItemsInCart += quantity;
                    } else {
                        //TODO Error message
                    }
                    break;
                case 3:
                    if (quantity <= a.getRentalQuantity()) {
                        cart.add(a);
                        quantityInCart.add(quantity);
                        bookType.add(type);
                        numItemsInCart += quantity;
                    } else {
                        //TODO Error message
                    }
                    break;
                case 4:
                    if (quantity <= a.getEbookQuantity()) {
                        cart.add(a);
                        quantityInCart.add(quantity);
                        bookType.add(type);
                        numItemsInCart += quantity;
                    } else {
                        //TODO Error message
                    }
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error Adding to Cart: " + e.getMessage());
        }
    }

    private void addShipping() { //adds shipping to the totalPrice
        totalPrice += shippingCost;
    }
    
    public Book getBook(int index) {
        Book a = cart.get(index);
        return a;
    }
    
    public int getBookType(int index) {
        return bookType.get(index);
    }
    
    public int getBookQuantity(int index) {
        return quantityInCart.get(index);
    }

    public double getSubtotal() { //returns subtotal
        return subtotalPrice;
    }

    public int getNumItemsInCart() { //returns the number of items in the shopping cart
        return numItemsInCart;
    }

    private void setEbookValue(boolean ebook) { //changes the value of the boolean onlyEbook, false if there is anything but ebooks in the cart.
        onlyEbook = ebook;
    }

    public String getTotalPrice() { //returns the total price of the items in the cart (shipping and tax included)
        calculateTotalPrice();
        String returnTotalPrice = df.format(totalPrice);
        return returnTotalPrice;
    }

    public void calculateTotalPrice() { //sets the total price based on the subtotal and then if there are only ebooks,
        //it skips adding shipping, if there are physical books it adds shipping.
        if (checkForOnlyEbooks()) {
            totalPrice = subtotalPrice + (subtotalPrice * tax);
        } else {
            totalPrice = subtotalPrice + ((subtotalPrice + shippingCost) * tax);
        }
    }

    public void addToCart(Book newBook, int quantity, int type) {
        //adds the book passed to the method to the end of the array list. Will by default add one book,
        //but can add as many books as specified. This will also check to see if the book is an ebook,
        // and will adjust the shipping if needed.
        /*if(ebook && onlyEbook == true) {
        } else if(ebook && onlyEbook == false) {
            
        } else if(ebook == false && onlyEbook == true) {
            setEbookValue(ebook);
            addShipping();
        }*/
        double tempPrice;
        switch (type) {
            case 1:
                tempPrice = newBook.getNewPrice();
                subtotalPrice += tempPrice * quantity;
                break;
            case 2:
                tempPrice = newBook.getUsedPrice();
                subtotalPrice += tempPrice * quantity;
                break;
            case 3:
                tempPrice = newBook.getRentalPrice();
                subtotalPrice += tempPrice * quantity;
                break;
            case 4:
                tempPrice = newBook.getEbookPrice();
                subtotalPrice += tempPrice * quantity;
                break;
            //TODO: Write Exception handling here
            default:
                break;
        }
        try {
            switch (type) {
                case 1:
                    if (quantity <= newBook.getNewQuantity()) {
                        cart.add(newBook);
                        quantityInCart.add(quantity);
                        bookType.add(type);
                        numItemsInCart += quantity;
                    } else {
                        //TODO Error message
                    }
                    break;
                case 2:
                    if (quantity <= newBook.getUsedQuantity()) {
                        cart.add(newBook);
                        quantityInCart.add(quantity);
                        bookType.add(type);
                        numItemsInCart += quantity;
                    } else {
                        //TODO Error message
                    }
                    break;
                case 3:
                    if (quantity <= newBook.getRentalQuantity()) {
                        cart.add(newBook);
                        quantityInCart.add(quantity);
                        bookType.add(type);
                        numItemsInCart += quantity;
                    } else {
                        //TODO Error message
                    }
                    break;
                case 4:
                    if (quantity <= newBook.getEbookQuantity()) {
                        cart.add(newBook);
                        quantityInCart.add(quantity);
                        bookType.add(type);
                        numItemsInCart += quantity;
                    } else {
                        //TODO Error message
                    }
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error Adding to Cart: " + e.getMessage());
        }
    }

    public void removeShipping() {
        //if all regular books are deleted, and only ebooks remain, this should remove the shipping cost from the totalPrice
        totalPrice -= shippingCost;
    }

    public boolean checkForOnlyEbooks() {
        //This method scans the bookTypes array, looking for any instances of ebooks values (4),
        //and if it finds any books that are not ebooks, it will return false, if all books in the cart are ebooks,
        //the method will return true.
        int checkingForEbooks;
        for (int i = 0; i < cart.size(); i++) {
            checkingForEbooks = bookType.get(i);
            if (checkingForEbooks != 4) {
                return false;
            }
        }
        return true;
    }

    public void removeFromCart(String ISBN, int type) {
        Book a;
        String bookISBN;
        int tempType;
        double tempPrice;
        try {
            for (int i = 0; i < cart.size(); i++) {
                a = cart.get(i);
                bookISBN = a.getIsbn();
                if (bookISBN.equals(ISBN)) {
                    if (bookType.get(i) == type) {
                        switch (type) {
                            case 1:
                                tempPrice = a.getNewPrice();
                                subtotalPrice -= tempPrice * quantityInCart.get(i);
                                break;
                            case 2:
                                tempPrice = a.getUsedPrice();
                                subtotalPrice -= tempPrice * quantityInCart.get(i);
                                break;
                            case 3:
                                tempPrice = a.getRentalPrice();
                                subtotalPrice -= tempPrice * quantityInCart.get(i);
                                break;
                            case 4:
                                tempPrice = a.getEbookPrice();
                                subtotalPrice -= tempPrice * quantityInCart.get(i);
                                break;
                            //TODO: Write Exception handling here
                            default:
                                break;
                        }
                        cart.remove(i);
                        bookType.remove(i);
                        numItemsInCart -= quantityInCart.get(i);
                        quantityInCart.remove(i);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error Removing from Cart: " + e.getMessage());
        }
    }

    /*public void updateCurrentBookList() {
        currentBookList = reimport();
    }*/
 /*public Book printBook(int index) {
        Book a;
        a = cart.get(index);
        return a;
    }*/

    public void updateCart(String isbn, int newQuantity, int type) {
        int changeInQuantity;
        Book a;
        String tempIsbn;
        double tempPrice;
        try {
            for (int i = 0; i < cart.size(); i++) {
                a = cart.get(i);
                tempIsbn = a.getIsbn();
                if (isbn.equals(tempIsbn)) {
                    if (bookType.get(i) == type) {
                        switch (type) {
                            case 1:
                                if (a.getNewQuantity() >= newQuantity) {
                                    changeInQuantity = newQuantity - quantityInCart.get(i);
                                    quantityInCart.set(i, newQuantity);
                                    numItemsInCart += changeInQuantity;
                                    tempPrice = a.getNewPrice();
                                    subtotalPrice += changeInQuantity * tempPrice;
                                } else {
                                    System.out.println("Unable to add book to cart, new quantity is invalid. Please select a number at or below " + a.getNewQuantity());
                                }
                                break;
                            case 2:
                                if (a.getUsedQuantity() >= newQuantity) {
                                    changeInQuantity = newQuantity - quantityInCart.get(i);
                                    quantityInCart.set(i, newQuantity);
                                    numItemsInCart += changeInQuantity;
                                    tempPrice = a.getUsedPrice();
                                    subtotalPrice += changeInQuantity * tempPrice;
                                } else {
                                    System.out.println("Unable to add book to cart, new quantity is invalid. Please select a number at or below " + a.getUsedQuantity());
                                }
                                break;
                            case 3:
                                if (a.getRentalQuantity() >= newQuantity) {
                                    changeInQuantity = newQuantity - quantityInCart.get(i);
                                    quantityInCart.set(i, newQuantity);
                                    numItemsInCart += changeInQuantity;
                                    tempPrice = a.getRentalPrice();
                                    subtotalPrice += changeInQuantity * tempPrice;
                                } else {
                                    System.out.println("Unable to add book to cart, new quantity is invalid. Please select a number at or below " + a.getRentalQuantity());
                                }
                                break;
                            case 4:
                                if (a.getEbookQuantity() >= newQuantity) {
                                    changeInQuantity = newQuantity - quantityInCart.get(i);
                                    quantityInCart.set(i, newQuantity);
                                    numItemsInCart += changeInQuantity;
                                    tempPrice = a.getEbookPrice();
                                    subtotalPrice += changeInQuantity * tempPrice;
                                } else {
                                    System.out.println("Unable to add book to cart, new quantity is invalid. Please select a number at or below " + a.getEbookQuantity());
                                }
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error Updating Cart: " + e.getMessage());
        }
    }
}

//Programmed by: Adam Hayes
//Tested By:
//Originally Created: April 2nd, 2017
//First Revision: April 6th, 2017
//Second Revision: April 8th, 2017
//Third Revision: April 15th, 2017
