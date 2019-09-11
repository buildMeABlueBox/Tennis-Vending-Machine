package com.company;

public class Main {

    public static void main(String[] args) {
        TennisVendingMachine tvm = new TennisVendingMachine();
        tvm.intializeItems();
        System.out.println("Welcome to the Tennis Vending Machine. Catering towards all of your tennis needs. Below is what we have available:");

        while(!tvm.transactionCompleted){ //TODO: Rewrite logic to cancel transaction
            tvm.showDisplay();
            int itemId = tvm.query(Query.ITEM);
            int amount = tvm.query(Query.AMOUNT);
            tvm.addToCart(itemId, amount);
            tvm.query(Query.CONTINUE_SHOPPING);
        }

        tvm.completeTransaction();

        System.out.println("\nEnd State of Vending Machine: \n");
        tvm.showDisplay();

    }
}
