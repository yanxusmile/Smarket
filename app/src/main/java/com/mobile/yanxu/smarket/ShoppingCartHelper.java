package com.mobile.yanxu.smarket;

import android.content.res.Resources;

import java.util.List;
import java.util.Vector;

/**
 * Created by yanxu on 30/09/2014.
 * need to modified to receive the data from server
 */
public class ShoppingCartHelper {

    public static final String Item_INDEX = "Item_INDEX";

    private static List<Item> catalog;
    private static List<Item> cart;

    public static List<Item> getCatalog(Resources res){
        if(catalog == null) {
            catalog = new Vector<Item>();
            catalog.add(new Item("Dead or Alive", res
                    .getDrawable(R.drawable.ic_launcher), 29.99,
                    "Dead or Alive by Tom Clancy with Grant Blackwood", "comment1", 5, 1, 3.5));
            catalog.add(new Item("Switch", res
                    .getDrawable(R.drawable.ic_launcher), 24.99,
                    "Switch by Chip Heath and Dan Heath", "comment2", 3, 1, 1.5));
            catalog.add(new Item("Watchmen", res
                    .getDrawable(R.drawable.ic_launcher), 14.99,
                    "Watchmen by Alan Moore and Dave Gibbons", "comment3", 1, 4, 3));
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
