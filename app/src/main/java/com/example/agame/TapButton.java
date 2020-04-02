package com.example.agame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;

public class TapButton {
    @SuppressLint("StaticFieldLeak")

    public static class clickButton extends AppCompatButton {

        @RequiresApi(api = Build.VERSION_CODES.N)
        public clickButton(Context context, AttributeSet attrs) {
            super(context, attrs);
            setOnClickListener(view -> GameLogic.setPoints(DoubleClickerButton.ClickValue));
        }
    }
}



