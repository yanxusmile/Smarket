package com.mobile.yanxu.smarket;

import android.graphics.drawable.Drawable;

/**
 * Created by yanxu on 30/09/2014.
 */
public class Item {
    public String name;
    public Drawable itemImage;
	public double price;
    public String description;
    public String comments;
	public int likeNo;
	public int shareNo;
	public double ratingScore;
    public boolean selected;

	public Item(String name, Drawable itemImage, double price, String description, String comments,
	            int likeNo, int shareNo, double ratingScore) {
		this.name = name;
		this.itemImage = itemImage;
		this.price = price;
		this.description = description;
		this.comments = comments;
		this.likeNo = likeNo;
		this.shareNo = shareNo;
		this.ratingScore = ratingScore;
	}
}

