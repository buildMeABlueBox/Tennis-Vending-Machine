package com.company;

public enum TennisItem {
    CANNED_BALL(0),
    GRIP(1),
    TENNIS_STRING(2),
    KEYCHAIN(3),
    DAMPENER(4);

    int index;

    TennisItem(int index){
        this.index = index;
    }

}
