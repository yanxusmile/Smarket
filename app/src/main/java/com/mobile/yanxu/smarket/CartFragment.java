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

    private Button btnPay;
    private ListView cartLv;
    private ArrayList<String> strArr;
    private ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_cart, container, false);

        btnPay = (Button) rootView.findViewById(R.id.btnPay);
        cartLv = (ListView) rootView.findViewById(R.id.listViewCart);
        strArr = new ArrayList<String>();
        for (int i = 0; i < 2; i++) {
            strArr.add("Row:" + i);
        }
        adapter = new ArrayAdapter<String>(getActivity(), R.layout.layout_cart_item, R.id.textView, strArr);
        cartLv.setAdapter(adapter);
        btnPay.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                strArr.add("abd");
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

//    public void onClickCartPay(View view) {
//        strArr.add("abc");
//        adapter.notifyDataSetChanged();
//    }
//
//    public void onClickCartClear(View view) {
//
//    }

}
