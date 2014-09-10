package com.mobile.yanxu.smarket;

import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import com.mobile.yanxu.smarket.R;
/**
 * Created by yanxu on 9/09/2014.
 */
public class HomeFragment extends Fragment {

//
//    public static HomeFragment newInstance() {
//        HomeFragment fragment = new HomeFragment();
//        Bundle args = new Bundle();
////        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
    public HomeFragment() {
//        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        return rootView;
    }
}
