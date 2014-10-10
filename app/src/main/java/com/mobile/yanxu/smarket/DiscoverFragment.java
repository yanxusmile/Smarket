package com.mobile.yanxu.smarket;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

/**
 * Created by yanxu on 9/09/2014.
 */
public class DiscoverFragment extends Fragment {

	private List<Item> mItemList;

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_discover, container, false);

	    //data of item list
	    mItemList = LocalData.getCatalog(getResources());

	    // Create the list
	    ListView ListViewDiscover = (ListView) rootView.findViewById(R.id.ListViewDiscover);
	    ListViewDiscover.setAdapter(new ItemAdapter(mItemList, inflater, false));

	    ListViewDiscover.setOnItemClickListener(new AdapterView.OnItemClickListener() {

		    @Override
		    public void onItemClick(AdapterView<?> parent, View view, int position,
		                            long id) {
			    Intent ItemDetailsIntent = new Intent( getActivity(),ItemDetailsActivity.class);
			    ItemDetailsIntent.putExtra(LocalData.Item_INDEX, position);
			    startActivity(ItemDetailsIntent);
		    }
	    });

	    return rootView;
    }
}
