package com.example.agame;

import android.annotation.SuppressLint;
import android.os.Build;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;


public class GameLogic {

    public static List<Click.clickButton> buttonList = new ArrayList();
    public static int traineePrice =10;
    public static TextView tv;

    public static class gameLogic {

        @SuppressLint("SetTextI18n")
        public static void onePoint(TextView tv) {
            tv.setText(Integer.toString(Click.i));
        }

        @SuppressLint("SetTextI18n")
        public static void trainee(TextView tv, Click.clickButton traine) {
            traineePrice*=3;
            traine.setEnabled(false);
//            class AutoPoint implements Runnable {
//                @Override
//                public void run() {
//                    while (true) {
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        Click.i++;
//                        tv.setText(java.lang.Integer.toString(Click.i));
//                    }
//                }
//            }
//            AutoPoint ap = new AutoPoint();
//            Thread thread = new Thread(ap);
//            thread.start();
            AutoPoint.autoPoint.start();
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        public static void buttonActivities(TextView tv) {
            onePoint(tv);
            if (Click.i >= traineePrice) {
                buttonList.stream().filter(button -> Integer.parseInt((String) button.getTag()) == 2).forEach(button -> button.setEnabled(true));
            }
        }
    }
}




