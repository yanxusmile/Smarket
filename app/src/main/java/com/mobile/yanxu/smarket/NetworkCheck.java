package com.mobile.yanxu.smarket;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by yanxu on 14/10/2014.
 */
public class NetworkCheck {

	public static boolean isNetworkAvailable(Context context) {
		ConnectivityManager cm
				= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
		return activeNetwork != null && activeNetwork.isConnected();
	}


}
