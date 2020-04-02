//package com.example.agame;
//
//import android.content.Context;
//import android.content.SharedPreferences;
//import android.os.Build;
//import android.util.AttributeSet;
//
//import androidx.annotation.RequiresApi;
//import androidx.appcompat.widget.AppCompatButton;
//
//import static android.content.Context.MODE_PRIVATE;
//
//public class SaveButton extends AppCompatButton {
//    public static final String SHARED_PREFS = "sharedPreference";
//    private SharedPreferences pref;
//    public static final String COUNT = "COUNT";
//    public static final String DOUBLE_CLICKER_COUNT = "DOUBLE_CLICKER_COUNT";
//    public static final String DOUBLE_CLICKER_PRICE = "DOUBLE_CLICKER_PRICE";
//    public static final String CLICK_VALUE = "CLICK_VALUE";
//    public static final String TRAINEE_COUNT = "TRAINEE_COUNT";
//    public static final String TRAINEE_PRICE = "TRAINEE_PRICE";
//    public static final String POINT_PER_SECOND = "POINT_PER_SECOND";
//    Context context;
//
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    public SaveButton(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        this.context = context;
//        setOnClickListener(view -> {
//            pref = context.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
//            SharedPreferences.Editor editor = pref.edit();
//            editor.putFloat(COUNT, GameLogic.points);
//            editor.putInt(DOUBLE_CLICKER_COUNT, DoubleClickerButton.Count);
//            editor.putFloat(DOUBLE_CLICKER_PRICE, DoubleClickerButton.Price);
//            editor.putInt(CLICK_VALUE, DoubleClickerButton.ClickValue);
//            editor.putInt(TRAINEE_COUNT, TraineeButton.Count);
//            editor.putFloat(TRAINEE_PRICE, TraineeButton.Price);
//            editor.putFloat(POINT_PER_SECOND, TraineeButton.PointPerSecond);
//            editor.apply();
//            //Toast.makeText(context, "Data saved", Toast.LENGTH_SHORT).show();
//        });
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    public void loadData() {
//        pref = context.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
//        GameLogic.points = pref.getFloat(COUNT, 0);
//        DoubleClickerButton.Count = pref.getInt(DOUBLE_CLICKER_COUNT, 0);
//        MainActivity.doubleClickerCount.setText(String.valueOf(DoubleClickerButton.Count));
//        DoubleClickerButton.Price = pref.getFloat(DOUBLE_CLICKER_PRICE, 100);
//        DoubleClickerButton.ClickValue = pref.getInt(CLICK_VALUE, 1);
//        TraineeButton.Count = pref.getInt(TRAINEE_COUNT, 0);
//        MainActivity.traineeCount.setText(String.valueOf(TraineeButton.Count));
//        TraineeButton.Price = pref.getFloat(TRAINEE_PRICE, 10);
//        TraineeButton.PointPerSecond = pref.getFloat(POINT_PER_SECOND, 0);
//    }
//}
