package com.example.agame;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;

public class Click {
    public static int i = 0;
   // public static TextView tv;
    public static class clickButton extends AppCompatButton {
        public int tag = Integer.parseInt((String) this.getTag());

        @RequiresApi(api = Build.VERSION_CODES.N)
        public clickButton(Context context, AttributeSet attrs) {
            super(context, attrs);
            //tv = tv();
            GameLogic.buttonList.add(this);
            setOnClickListener(view -> {
                if (tag == 1)
                    GameLogic.gameLogic.buttonActivities(tv());
                else
                    GameLogic.gameLogic.trainee(tv(), this);
            });

        }

        public TextView tv() {
            i++;
            return getRootView().findViewById(R.id.text_view);
        }
    }
}



