package com.witcher.testjs;

import android.util.Log;

public class L {

    public static void i(String l){
        Log.i("witcher",l+"  当前线程:"+Thread.currentThread().getName());
    }

}
