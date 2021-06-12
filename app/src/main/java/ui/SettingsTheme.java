package ui;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ru.geekbrains.lession3.fragmentswork.R;

abstract class SettingsTheme extends AppCompatActivity {

    // Числовые переменные для тем
    protected final static int MAIN_THEME = 0;
    protected final static int OTHER_THEME = 1;

    // Ключи для сохранения настроек
    private static final String APP_THEME_CHOOSED = "CUR_THEME";
    private static final String PREFERENCES_NAME = "CALCULATOR";

    // Текущее значение темы
    int curThemeNumber = 0;

    public int getCurThemeNumber() {
        return curThemeNumber;
    }

    public void setCurThemeNumber(int curThemeNumber) {
        this.curThemeNumber = curThemeNumber;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setCurThemeNumber(getCurTheme(MAIN_THEME));
    }

    // Получить сохранённую темы
    protected int getSavedTheme(int appThemeDefault)
    {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        return sharedPreferences.getInt(APP_THEME_CHOOSED, appThemeDefault);
    }
    // Получить текущую тему
    protected int getCurTheme(int appThemeDefault)
    {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        return sharedPreferences.getInt(APP_THEME_CHOOSED, appThemeDefault);
    }

    // Сохранение тем
    protected void saveAppTheme()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(APP_THEME_CHOOSED, getCurThemeNumber());
        editor.apply();
    }
}
