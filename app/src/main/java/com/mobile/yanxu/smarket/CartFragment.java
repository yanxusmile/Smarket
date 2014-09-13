package com.mobile.yanxu.smarket;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.view.View.OnClickListener;


import java.util.ArrayList;

/**
 * Created by yanxu on 10/09/2014.
 */
public class CartFragment extends Fragment {

    private Button btnPay, btnClear;
    private ListView cartLv;
    private ArrayList<String> strArr;
    private ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_cart, container, false);

        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
                "Android", "iPhone", "WindowsMobile" };

        btnPay = (Button) rootView.findViewById(R.id.btnPay);
        btnClear = (Button) rootView.findViewById(R.id.btnClear);
        cartLv = (ListView) rootView.findViewById(R.id.listViewCart);
        strArr = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getActivity(), R.layout.layout_cart_item, R.id.textView, strArr);
        cartLv.setAdapter(adapter);

        for(String s : values) {
            strArr.add(s);
            adapter.notifyDataSetChanged();
        }
//        btnPay.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                strArr.add(0, "abd");
//                adapter.notifyDataSetChanged();
//            }
//        });

        btnClear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                strArr.clear();
                adapter.notifyDataSetChanged();
            }
        });
//        @Override
//        protected void onListItemClick(ListView l, View v, int position, long id) {
//            String item = (String) getListAdapter().getItem(position);
//            Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
//        }


        return rootView;
    }

}
