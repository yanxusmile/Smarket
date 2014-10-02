package com.mobile.yanxu.smarket;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;

import java.util.List;

/**
 * Created by yanxu on 9/09/2014.
 */
public class HomeFragment extends Fragment {

    private List<Item> mItemList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

		//data of item list
        mItemList = ShoppingCartHelper.getCatalog(getResources());

        // Create the list
        ListView ListViewHome = (ListView) rootView.findViewById(R.id.ListViewHome);
        ListViewHome.setAdapter(new ItemAdapter(mItemList, inflater, false));

        ListViewHome.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent ItemDetailsIntent = new Intent( getActivity(),ItemDetailsActivity.class);
                ItemDetailsIntent.putExtra(ShoppingCartHelper.Item_INDEX, position);
                startActivity(ItemDetailsIntent);
            }
        });


        return rootView;
    }

}
