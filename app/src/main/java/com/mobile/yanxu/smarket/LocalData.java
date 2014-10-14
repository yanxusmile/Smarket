package com.mobile.yanxu.smarket;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Vector;
import org.json.*;
import java.util.UUID;

public class LocalData
{
	public static final String Item_INDEX = "Item_INDEX";

	private static List<Item> catalog = new Vector<Item>();
	private static List<Item> cart = new Vector<Item>();
	private static List<Item> historyLog = new Vector<Item>();

    private static HttpUtil httpUtil = new HttpUtil();

	public static List<Item> getCatalog(Resources res)
    {
		return catalog;
	}

	public static List<Item> getCart()
    {
		return cart;
	}

	public static List<Item> getHistoryLog()
    {
		return historyLog;
	}

    public static boolean loadCatalog()
    {
        catalog.clear();

        try
        {
            String itemList = httpUtil.doPost("http://10.0.2.2:8080/Server/DBServlet?Type=ItemList");

            JSONObject jsonObject = new JSONObject(itemList);
            JSONArray jsonArray = jsonObject.getJSONArray("Items");

            int n = jsonArray.length();
            for (int i = 0; i < n; i++)
            {
                Item item = new Item();
                item.setItemID(jsonArray.getJSONObject(i).getInt("ItemID"));
                item.setName(jsonArray.getJSONObject(i).getString("Name"));
                item.setPrice(jsonArray.getJSONObject(i).getDouble("Price"));
                item.setDescription(jsonArray.getJSONObject(i).getString("Description"));
                item.setImage(jsonArray.getJSONObject(i).getString("Image"));

                catalog.add(item);
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
            return false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

        loadImageFromNetwork(catalog);

        return true;
    }

    public static void addToHistory(Item item)
    {
        try
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("GUID", UUID.randomUUID().toString().toUpperCase());
            jsonObject.put("UserID", 100);
            jsonObject.put("ItemID", item.getItemID());

            String itemList = httpUtil.doPost("http://10.0.2.2:8080/Server/DBServlet?Type=AddToHistory&Record=" + jsonObject.toString());
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void loadImageFromNetwork(List<Item> itemList)
    {
        for (int i = 0; i < itemList.size(); i++)
        {
            String imageUrl = itemList.get(i).getImage();

            if(imageUrl == null || imageUrl.length() == 0)
                continue;

            String fileName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);

            File file = new File(MyApplication.getContextObject().getCacheDir(), fileName);

            if (!file.exists())
            {
                try
                {
                    FileOutputStream fos = new FileOutputStream(file);
                    InputStream is = new URL(imageUrl).openStream();

                    int data = is.read();
                    while (data != -1)
                    {
                        fos.write(data);
                        data = is.read();
                    }

                    fos.close();
                    is.close();
                }
                catch (IOException e)
                {
                    continue;
                }
            }

            itemList.get(i).setImage(file.toString());
            itemList.get(i).setDrawableImage(Drawable.createFromPath(file.toString()));
        }
    }
}
