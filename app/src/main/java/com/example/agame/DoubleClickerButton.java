package com.example.agame;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;

public class DoubleClickerButton extends AppCompatButton {
    public static float Price = 100;
    public static int ClickValue = 1;
    public static int Count = 0;
    @RequiresApi(api = Build.VERSION_CODES.N)
    public DoubleClickerButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(view -> {
            buy();
            GameLogic.setPoints(-Price);
            Price *= 1.7;
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void checkPrice() {
        this.setEnabled(GameLogic.points >= Price);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void buy() {
        ClickValue++;
        MainActivity.doubleClickerCount.setText(String.valueOf(++Count));
    }
}
