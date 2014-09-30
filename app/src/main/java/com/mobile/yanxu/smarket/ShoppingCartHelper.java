package com.mobile.yanxu.smarket;

import android.content.res.Resources;

import java.util.List;
import java.util.Vector;

/**
 * Created by yanxu on 30/09/2014.
 */
public class ShoppingCartHelper {

    public static final String Item_INDEX = "Item_INDEX";

    private static List<Item> catalog;
    private static List<Item> cart;

    public static List<Item> getCatalog(Resources res){
        if(catalog == null) {
            catalog = new Vector<Item>();
            catalog.add(new Item("Dead or Alive", res
                    .getDrawable(R.drawable.ic_launcher),
                    "Dead or Alive by Tom Clancy with Grant Blackwood", "comment", 29.99));
            catalog.add(new Item("Switch", res
                    .getDrawable(R.drawable.ic_launcher),
                    "Switch by Chip Heath and Dan Heath", "comment", 24.99));
            catalog.add(new Item("Watchmen", res
                    .getDrawable(R.drawable.ic_launcher),
                    "Watchmen by Alan Moore and Dave Gibbons", "comment", 14.99));
        }

        return catalog;
    }

    public static List<Item> getCart() {
        if(cart == null) {
            cart = new Vector<Item>();
        }

        return cart;
    }
}
