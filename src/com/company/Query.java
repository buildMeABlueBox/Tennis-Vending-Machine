package com.company;

public enum Query{
    ITEM("item"),
    AMOUNT("amount"),
    CONTINUE_SHOPPING("continue");

    String str;

    Query(String str){
        this.str = str;
    }

}
