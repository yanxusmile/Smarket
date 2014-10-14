package com.mobile.yanxu.smarket;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/**
 * Created by yanxu on 30/09/2014.
 */
public class Item
{
    public String name;
    public Drawable itemImage;
	public double price;
    public String description;
    public String comments;
	public int likeNo;
	public int shareNo;
	public double ratingScore;
    public boolean selected;

    private int m_itemID;
    private String m_Name;
    private double m_Price;
    private String m_Description;
    private String m_Image;
    private Bitmap m_Bitmap;
    private Drawable m_drawableImage;

    public Item()
    {

    }

	public Item(String name, Drawable itemImage, double price, String description, String comments, int likeNo, int shareNo, double ratingScore)
    {
		this.name = name;
		this.itemImage = itemImage;
		this.price = price;
		this.description = description;
		this.comments = comments;
		this.likeNo = likeNo;
		this.shareNo = shareNo;
		this.ratingScore = ratingScore;
	}

    public Drawable getDrawableImage()
    {
        return this.m_drawableImage;
    }

    public int getItemID()
    {
        return this.m_itemID;
    }

    public String getName()
    {
        return this.m_Name;
    }

    public Bitmap getBitmap()
    {
        return this.m_Bitmap;
    }

    public double getPrice()
    {
        return this.m_Price;
    }

    public String getDescription()
    {
        return this.m_Description;
    }

    public String getImage()
    {
        return this.m_Image;
    }

    public void setItemID(int itemID)
    {
        this.m_itemID = itemID;
    }

    public void setName(String name)
    {
        this.m_Name = name;
    }

    public void setPrice(double price)
    {
        this.m_Price = price;
    }

    public void setDescription(String description)
    {
        this.m_Description = description;
    }

    public void setImage(String image)
    {
        this.m_Image = image;
    }

    public void setBitmap(Bitmap bitmap)
    {
        this.m_Bitmap = bitmap;
    }

    public void setDrawableImage(Drawable drawableImage)
    {
        this.m_drawableImage = drawableImage;
    }
}

