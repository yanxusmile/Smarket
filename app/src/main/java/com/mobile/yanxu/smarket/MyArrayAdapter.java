package com.mobile.yanxu.smarket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yanxu on 13/09/2014.
 */
public class MyArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final ArrayList<String> arrStr;

    public MyArrayAdapter(Context context,  ArrayList<String> arrStr) {
        super(context, R.layout.layout_cart_item, arrStr);
        this.context = context;
        this.arrStr = arrStr;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.layout_cart_item, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.textView);
//            ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
        ImageButton btnDeleteItem = (ImageButton) rowView.findViewById(R.id.btnDeleteItem);
        btnDeleteItem.setTag(position);

        textView.setText(arrStr.get(position));
        btnDeleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer index = (Integer) rowView.getTag();
                remove(arrStr.get(index));
                notifyDataSetChanged();
            }
        });


        return rowView;
    }
}
