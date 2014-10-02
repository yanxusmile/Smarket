package com.mobile.yanxu.smarket;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yanxu on 30/09/2014.
 */
public class ItemAdapter extends BaseAdapter {
    private List<Item> mItemList;
    private LayoutInflater mInflater;
    private boolean mShowCheckbox;

    public ItemAdapter(List<Item> list, LayoutInflater inflater, boolean showCheckbox) {
        mItemList = list;
        mInflater = inflater;
        mShowCheckbox = showCheckbox;
    }

    @Override
    public int getCount() {
        return mItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return mItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewItem item;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.layout_item_in_list,
                    null);
            item = new ViewItem();

            item.ItemImageView = (ImageView) convertView
                    .findViewById(R.id.ImageViewItemCart);

            item.ItemName = (TextView) convertView.findViewById(R.id.TextViewItemCartName);

            item.ItemCheckbox = (CheckBox) convertView.findViewById(R.id.CheckBoxSelectedItemCart);

	        item.ItemPrice = (TextView) convertView.findViewById(R.id.TextViewItemCartPrice);

            convertView.setTag(item);
        } else {
            item = (ViewItem) convertView.getTag();
        }

        Item curItem = mItemList.get(position);

        item.ItemImageView.setImageDrawable(curItem.itemImage);
        item.ItemName.setText(curItem.name);
	    item.ItemPrice.setText(String.valueOf(curItem.price));

        if(!mShowCheckbox) {
            item.ItemCheckbox.setVisibility(View.GONE);
        } else {
            if(curItem.selected)
                item.ItemCheckbox.setChecked(true);
            else
                item.ItemCheckbox.setChecked(false);
        }


        return convertView;
    }


    private class ViewItem {
        ImageView ItemImageView;
        TextView ItemName;
	    TextView ItemPrice;
        CheckBox ItemCheckbox;
    }
}
