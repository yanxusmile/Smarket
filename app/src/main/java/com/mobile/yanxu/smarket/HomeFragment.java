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


public class HomeFragment extends Fragment
{
//    private List<Item> mItemList;
    ListView ListViewHome = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

	//	LocalData.loadCatalog();
     //   mItemList = LocalData.getCatalog(getResources());

        // Create the list
        ListViewHome = (ListView) rootView.findViewById(R.id.ListViewHome);
        ListViewHome.setAdapter(new ItemAdapter(LocalData.getCatalog(getResources()), inflater, false));

        ListViewHome.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent ItemDetailsIntent = new Intent(getActivity(), ItemDetailsActivity.class);
                ItemDetailsIntent.putExtra(LocalData.Item_INDEX, position);
                startActivity(ItemDetailsIntent);
            }
        });

        refresh();

        return rootView;
    }

    private void refresh()
    {
        Thread t = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                LocalData.loadCatalog();
            }
        });
        t.start();

        while (t.isAlive())
        {
            try
            {
                Thread.sleep(50);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        ((ItemAdapter)ListViewHome.getAdapter()).notifyDataSetChanged();
    }
}
