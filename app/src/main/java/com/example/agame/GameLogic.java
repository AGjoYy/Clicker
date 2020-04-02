package com.example.agame;

import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.os.Build;

import androidx.annotation.RequiresApi;

import static com.example.agame.MainActivity.pointCount;

@RequiresApi(api = Build.VERSION_CODES.N)
public class GameLogic {

    public static float points = 0;
    public static NumberFormat nf = new DecimalFormat("#.#");

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void setPoints(double points) {
        GameLogic.points += points;
        pointCount.setText(GameLogic.nf.format(GameLogic.points));
    }


}





