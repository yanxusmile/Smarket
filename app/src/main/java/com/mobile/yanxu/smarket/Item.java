package com.mobile.yanxu.smarket;

import android.graphics.drawable.Drawable;

/**
 * Created by yanxu on 30/09/2014.
 */
public class Item {
    public String name;
    public Drawable itemImage;
    public String description;
    public String comments;
    public double price;
    public boolean selected;

    public Item(String name, Drawable itemImage, String description, String comments,
                   double price) {
        this.name = name;
        this.itemImage = itemImage;
        this.description = description;
        this.comments = comments;
        this.price = price;
    }

//    public String getname() {
//        return name;
//    }
//
//    public Drawable getitemImage() {
//        return itemImage;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public String getComments() {
//        return comments;
//    }
//
//    public boolean isSelected() {
//        return selected;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setItemImage(Drawable itemImage) {
//        this.itemImage = itemImage;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public void setComments(String comments) {
//        this.comments = comments;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public void setSelected(boolean selected) {
//        this.selected = selected;
//    }
}

