package com.necer.testnet.utils;

import android.view.View;

/**
 * Created by necer on 2018/10/11.
 */
public class Util {

    public static boolean isEnabled(View view) {

        return view != null && view.getVisibility() == View.VISIBLE;
    }

}
