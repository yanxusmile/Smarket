package com.mobile.yanxu.smarket;

import android.graphics.drawable.Drawable;

/**
 * Created by yanxu on 30/09/2014.
 */
public class Item {
    private String name;
    private Drawable itemImage;
    private String description;
    private String comments;
    private double price;
    private boolean selected;

    public Item(String name, Drawable itemImage, String description, String comments,
                   double price) {
        this.name = name;
        this.itemImage = itemImage;
        this.description = description;
        this.comments = comments;
        this.price = price;
    }

    public String getname() {
        return name;
    }
    
    public Drawable getitemImage() {
        return itemImage;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }


    public String getComments() {
        return comments;
    }

    public boolean isSelected() {
        return selected;
    }
}

