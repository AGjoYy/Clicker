package com.example.agame;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;

public class ResetButton extends AppCompatButton {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public ResetButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(view -> {
            GameLogic.points = 0;
            DoubleClickerButton.Count = 0;
            MainActivity.doubleClickerCount.setText(String.valueOf(DoubleClickerButton.Count));
            DoubleClickerButton.Price = 100;
            DoubleClickerButton.ClickValue = 1;
            TraineeButton.Count = 0;
            MainActivity.traineeCount.setText(String.valueOf(TraineeButton.Count));
            TraineeButton.Price = 10;
            TraineeButton.PointPerSecond = 0;
        });
    }
}

