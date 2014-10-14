package com.mobile.yanxu.smarket;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanxu on 10/09/2014.
 */
public class CartFragment extends Fragment {

    private List<Item> mCartList;
	private List<Item> mHistoryList;
    private ItemAdapter mItemAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_cart, container, false);

        mCartList = LocalData.getCart();
	    mHistoryList = LocalData.getHistoryLog();

        // Make sure to clear the selections
        for(int i=0; i<mCartList.size(); i++) {
            mCartList.get(i).selected = false;
        }

        // Create the list
        final ListView listViewCart = (ListView) rootView.findViewById(R.id.listViewCart);
        mItemAdapter = new ItemAdapter(mCartList, inflater, true);
        listViewCart.setAdapter(mItemAdapter);

        listViewCart.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Item selectedItem = mCartList.get(position);
                if(selectedItem.selected)
                    selectedItem.selected = false;
                else
                    selectedItem.selected = true;

                mItemAdapter.notifyDataSetInvalidated();

            }
        });

        Button removeButton = (Button) rootView.findViewById(R.id.btnRemoveFromCart);
        removeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Loop through and remove all the Items that are selected
                // Loop backwards so that the remove works correctly
                for(int i=mCartList.size()-1; i>=0; i--) {

                    if(mCartList.get(i).selected) {
                        mCartList.remove(i);
                    }
                }
                mItemAdapter.notifyDataSetChanged();
            }
        });


	    Button checkoutButton = (Button) rootView.findViewById(R.id.btnCheckout);
	    checkoutButton.setOnClickListener(new OnClickListener()
        {
		    @Override
		    public void onClick(View v)
            {
			    Thread t = new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        for(int i = mCartList.size() - 1; i >= 0; i--)
                        {
                            if(mCartList.get(i).selected)
                            {
                                LocalData.addToHistory(mCartList.get(i));
                                //				    mHistoryList.add(mCartList.get(i));
                                mCartList.remove(i);
                            }
                        }
                    }
                });
			    t.start();

			    mItemAdapter.notifyDataSetChanged();
		    }
	    });
//        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
//                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
//                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
//                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
//                "Android", "iPhone", "WindowsMobile" };
//
//        btnCheckout = (Button) rootView.findViewById(R.id.btnCheckout);
//        btnRemoveFromCart = (Button) rootView.findViewById(R.id.btnRemoveFromCart);
////        btnDeleteItem = (ImageButton) rootView.findViewById(R.id.btnDeleteItem);
//        cartLv = (ListView) rootView.findViewById(R.id.listViewCart);
//        strArr = new ArrayList<String>();
//        adapter = new MyArrayAdapter(getActivity(), strArr);
//        cartLv.setAdapter(adapter);
//
//        for(String s : values) {
//            strArr.add(s);
//            adapter.notifyDataSetChanged();
//        }
////        btnCheckout.setOnClickListener(new OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                strArr.add(0, "abd");
////                adapter.notifyDataSetChanged();
////            }
////        });
//
//        btnRemoveFromCart.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                strArr.clear();
//                adapter.notifyDataSetChanged();
//            }
//        });

//        btnDeleteItem.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                strArr.clear();
//                adapter.notifyDataSetChanged();
//            }
//        });


//        @Override
//        protected void onListItemClick(ListView l, View v, int position, long id) {
//            String item = (String) getListAdapter().getItem(position);
//            Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
//        }


        return rootView;
    }

}
