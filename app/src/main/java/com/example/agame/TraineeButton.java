package com.example.agame;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;

public class TraineeButton extends AppCompatButton {
    public static float PointPerSecond = 0;
    public static int Count = 0;
    public static float Price = 10;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public TraineeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(view -> {
            buy();
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void checkPrice() {
        this.setEnabled(GameLogic.points >= Price);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void buy() {
        GameLogic.setPoints(-Price);
        PointPerSecond += 0.3;
        Price *= 1.3;
        MainActivity.traineeCount.setText(String.valueOf(++Count));
    }

}
