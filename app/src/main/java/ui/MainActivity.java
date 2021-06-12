package ui;

import androidx.annotation.NonNull;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ru.geekbrains.lession3.fragmentswork.R;

public class MainActivity extends SettingsTheme {

    private final static String KEY_CALCULATOR = "CALC";

    Proba proba = new Proba();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSaveTheme = findViewById(R.id.save_theme);
        buttonSaveTheme.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                saveAppTheme();
                Toast.makeText(MainActivity.this, String.format("%d", getCurThemeNumber()), Toast.LENGTH_SHORT).show();
            }
        });

        Button buttonOne = findViewById(R.id.theme_one);
        buttonOne.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                setCurThemeNumber(0);
                saveAppTheme();
            }
        });

        Button buttonTwo = findViewById(R.id.theme_two);
        buttonTwo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                setCurThemeNumber(1);
                saveAppTheme();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        proba.setDates(proba.getDates() + 1);
        outState.putParcelable(KEY_CALCULATOR, proba);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        proba = savedInstanceState.getParcelable(KEY_CALCULATOR);
        Toast.makeText(this, String.format("%d", proba.getDates()), Toast.LENGTH_SHORT).show();
    }
}