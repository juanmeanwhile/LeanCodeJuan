package io.github.pedrofraca.leancodeandroid;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by mengujua on 18/12/15.
 */
public class Cart {

    public static final String APPLE = "apple";
    public static final String APPLE_FR = "pommes";
    public static final String APPLE_IT = "mele";

    public static final String CHERRIES = "cherries";
    public static final String BANANA = "bananas";

    private static final int CHERRIES_DISSCOUNT = 20;
    private static final int APPLE_IT_DISSCOUNT = 150;
    private static final int APPLE_FR_DISSCOUNT = 100;


    private static final int PRICE_CHERRIES = 75;
    private static final int PRICE_BANANA = 150;
    private static final int PRICE_APPLE = 100;

    private static final String SEPARATOR = ",";
    private static final int BANANA_DISSCOUNT = 75;
    public int mTotal;
    public ArrayList<String> mItems;
    public int mCurrentDisscount;

    private StringBuilder mSb;

    public Cart(){
        mTotal = 0;
        mCurrentDisscount = 0;
        mItems = new ArrayList<String>();
        mSb = new StringBuilder();
    }


    public int addItem(String itemName) throws Exception {
        String[] items = itemName.split(SEPARATOR);
        ArrayList<String> newItems = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();

        //only check that everything is correct
        for (String item : items) {
            priceOfItem(item);
        }

        for (String item : items) {
            int price = priceOfItem(item);
            mItems.add(item);

            mTotal += price;
            mCurrentDisscount = calculateDisccount();
            mSb.append("\n");
            mSb.append(item);
            mSb.append(" --> ");
            mSb.append(mTotal - mCurrentDisscount);

        }

        return mTotal;
    }

    private boolean isApple(String st) {
        return st.equals(APPLE) || st.equals(APPLE_FR) || st.equals(APPLE_IT);
    }

    private boolean isBanana(String st) {
        return st.equals(BANANA);
    }

    private boolean isCherry(String st) {
        return st.equals(CHERRIES);
    }

    private int priceOfItem (String item) throws Exception {
        if (isApple(item)) {
            return PRICE_APPLE;
        } else if (isCherry(item)) {
            return PRICE_CHERRIES;
        } else if (isBanana(item)) {
            return PRICE_BANANA;
        } else {
            throw new Exception("NotSupportedFruit");
        }
    }

    private int calculateDisccount(){
        int cherriesCount = 0;
        int bananaCount = 0;
        int appleFrCount = 0;
        int appleItCount = 0;
        int appleCount = 0;
        for (String item : mItems) {
            if (isCherry(item)) {
                cherriesCount++;
            } else if (isBanana(item)) {
                bananaCount++;
            } else if (item.equals(APPLE_FR)) {
                appleFrCount ++;
            } else if (item.equals(APPLE_IT)) {
                appleItCount++;
            } else if (isApple(item)) {
                appleCount++;
            }

        }

        int disscount = 0;
        disscount += cherriesCount/2 *CHERRIES_DISSCOUNT;
        disscount += bananaCount/2 * BANANA_DISSCOUNT;
        disscount += appleItCount/2* APPLE_IT_DISSCOUNT;
        disscount += appleFrCount/3* APPLE_FR_DISSCOUNT;
        disscount += appleCount/4 * 100;
        disscount += mItems.size()/5 * 200;

        return disscount;
    }

    public String toString(){
        return mSb.toString();
    }

    public int getTotal() {
        return mTotal- mCurrentDisscount;
    }
}
