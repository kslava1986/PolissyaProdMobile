package com.example.pp.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {

    private ToastUtil() {
    }

    private static void runToast(Context context, String msg, int duration){
        Toast toast = Toast.makeText(context, msg, duration);
        //todo добавить кастомизацию отображения тостов :)
        //toast.setView(null);

        toast.show();
    }

    public static void showLongToast(Context context, String msg){
        runToast(context, msg, Toast.LENGTH_LONG);
    }

    public static void showShortToast(Context context, String msg){
        runToast(context, msg, Toast.LENGTH_SHORT);
    }
}
