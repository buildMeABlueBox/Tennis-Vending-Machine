package com.company;
import java.util.*;

public class TennisVendingMachine {
    Scanner sc = new Scanner(System.in);
    boolean transactionCompleted = false;
    Map<TennisItem, VendingItem> vendingStorage;
    Map<TennisItem, Integer> cart = new HashMap<>();
    double totalPrice = 0.0;

    public void showDisplay(){
        System.out.println("\n"+
                prettify("ITEM")  +
                prettify("PRICE")  +
                prettify("STOCK") +
                prettify("ITEM ID")
        );
        for(VendingItem item : vendingStorage.values()){
            System.out.println(
                    prettify(item.getName()) +
                    prettify("$"+String.valueOf(item.getPrice()))  +
                    prettify(String.valueOf(item.getStock())) +
                    prettify(String.valueOf(item.getItemId()))
            );
        }
    }

    public void init() {
        vendingStorage = new HashMap<TennisItem, VendingItem>(){{
           put(TennisItem.CANNED_BALL, new CannedBalls("Canned Balls", 10.00, 40, 0));
           put(TennisItem.GRIP, new Grip("Grips", 5.00, 40, 1));
           put(TennisItem.TENNIS_STRING, new TennisString("Strings", 20.00, 20, 2));
           put(TennisItem.KEYCHAIN, new Keychain("Keychains", 8.00, 20, 3));
           put(TennisItem.DAMPENER, new Dampeners("Dampeners", 4.00, 40, 4));
        }};
    }

    /**
     *
     * @param itemId - 0 for CannedBalls, 1 for Grip, 2 for TennisString, 3 for KeyChain, 4 for Dampeners
     * @param amount - amount of items you have in stock
     */
    public void addToCart(int itemId, int amount){
        if(itemId < 0 || itemId > 4) throw  new IllegalArgumentException("the item id you have entered is not recognized");
        TennisItem ti = getTennisItem(itemId);
        VendingItem vi = vendingStorage.get(ti);
        if(vi.getStock() < amount) throw new IllegalArgumentException("There is not enough of this item.");
        cart.put(ti, cart.getOrDefault(ti, 0)+amount);
        totalPrice += amount * vi.getPrice();
    }

    public void completeTransaction(){
        for(TennisItem item : cart.keySet()){
            int currentStock = vendingStorage.get(item).getStock();
            int amountLeft = currentStock - cart.get(item);
            vendingStorage.get(item).setStock(amountLeft);
            cart.put(item, 0);
        }
    }


    public int query(Query type){
        int amount = 0;
        switch(type){
            case AMOUNT:
                System.out.println("How many would you like to purchase? Please refer to the STOCK amount.");
                amount = Integer.parseInt(sc.nextLine());
                break;
            case ITEM:
                System.out.println("\nPlease choose the ITEM ID of the item you would like to buy:" );
                amount = Integer.parseInt(sc.nextLine());
                break;
            case CONTINUE_SHOPPING:
                System.out.println("\nYour total is: $" + totalPrice + ". \nWould you like to buy anything else? type 'y' for yes or 'n' for no.");
                char answer = sc.nextLine().charAt(0);
                if(answer == 'n') {
                    transactionCompleted = true;
                    System.out.println("\nThank you. enjoy your items.\n");
                }
        }
        return amount;
    }

    private TennisItem getTennisItem(int itemId){
        for(TennisItem ti : TennisItem.values()) if(ti.index == itemId) return ti;
        return null;
    }

    /**
     *
     * This function takes in a string and appends whitespace to it.
     * Used For display purposes when displaying vending machine information.
     *
     * @param str
     * @return
     */
    private String prettify(String str){
        int appendAmount = 15-str.length();
        StringBuilder sb = new StringBuilder(str);
        for(int i = 0; i < appendAmount; i++) sb.append(" ");
        return sb.toString();
    }

}
