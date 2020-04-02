package com.example.agame;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static TextView pointCount, traineeCount, doubleClickerCount;
    public static final String SHARED_PREFS = "sharedPreference";
    private SharedPreferences pref;
    public static final String COUNT = "COUNT";
    public static final String DOUBLE_CLICKER_COUNT = "DOUBLE_CLICKER_COUNT";
    public static final String DOUBLE_CLICKER_PRICE = "DOUBLE_CLICKER_PRICE";
    public static final String CLICK_VALUE = "CLICK_VALUE";
    public static final String TRAINEE_COUNT = "TRAINEE_COUNT";
    public static final String TRAINEE_PRICE = "TRAINEE_PRICE";
    public static final String POINT_PER_SECOND = "POINT_PER_SECOND";


    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        pointCount = findViewById(R.id.pointsTap);
        traineeCount = findViewById(R.id.traineeCount);
        doubleClickerCount = findViewById(R.id.doubleClickerCount);
        DoubleClickerButton doubleClickerButton = findViewById(R.id.doubleClickerButton);
        TraineeButton traineeButton = findViewById(R.id.traineeButton);


        pointCount.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                doubleClickerButton.checkPrice();
                traineeButton.checkPrice();
            }
        });

        traineeAutoPoint();
        loadData();
    }

    public void traineeAutoPoint() {

        new Thread() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            public void run() {
                while (true) {
                    try {
                        runOnUiThread(() -> {
                            GameLogic.setPoints(TraineeButton.PointPerSecond);
                        });
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
@RequiresApi(api = Build.VERSION_CODES.N)
public void saveApp(){
    pref = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
    SharedPreferences.Editor editor = pref.edit();
    editor.putFloat(COUNT, GameLogic.points);
    editor.putInt(DOUBLE_CLICKER_COUNT, DoubleClickerButton.Count);
    editor.putFloat(DOUBLE_CLICKER_PRICE, DoubleClickerButton.Price);
    editor.putInt(CLICK_VALUE, DoubleClickerButton.ClickValue);
    editor.putInt(TRAINEE_COUNT, TraineeButton.Count);
    editor.putFloat(TRAINEE_PRICE, TraineeButton.Price);
    editor.putFloat(POINT_PER_SECOND, TraineeButton.PointPerSecond);
    editor.apply();
}


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void loadData() {
        pref = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        GameLogic.points = pref.getFloat(COUNT, 0);
        DoubleClickerButton.Count = pref.getInt(DOUBLE_CLICKER_COUNT, 0);
        doubleClickerCount.setText(String.valueOf(DoubleClickerButton.Count));
        DoubleClickerButton.Price = pref.getFloat(DOUBLE_CLICKER_PRICE, 100);
        DoubleClickerButton.ClickValue = pref.getInt(CLICK_VALUE, 1);
        TraineeButton.Count = pref.getInt(TRAINEE_COUNT, 0);
        traineeCount.setText(String.valueOf(TraineeButton.Count));
        TraineeButton.Price = pref.getFloat(TRAINEE_PRICE, 10);
        TraineeButton.PointPerSecond = pref.getFloat(POINT_PER_SECOND, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onStop() {
        saveApp();
        super.onStop();
    }
}




