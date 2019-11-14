package com.example.lifewirehours;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView displayHours;
    EditText userYears;
    EditText userAge;
    TextView outputText;
    SharedPreferences sharedPref;
    int intYears;
    int hours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayHours = (TextView) findViewById(R.id.displayHours);
        userYears = (EditText) findViewById(R.id.userYears);
        userAge = (EditText) findViewById(R.id.userAge);
        outputText = (TextView) findViewById(R.id.outputText);

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String defaultValue = getString(R.string.user_age);
        String savedAge = sharedPref.getString("AgeData", defaultValue);
        setAgeIfEmpty(savedAge);

        Button calcButton = (Button) findViewById(R.id.calcButton);
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float range = 300;

                if (Float.parseFloat(userYears.getText().toString()) <= range) {
                    float years = Float.parseFloat(userYears.getText().toString());
                    float totalHours = years*365*24;
                    String setHours = Float.toString(totalHours);
                    displayHours.setText(setHours);
                    intYears = (int)years;
                    hours = (int)totalHours;
                }
            }
        });

        EditText ageText = (EditText) findViewById(R.id.userAge);
        ageText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ageNumber = userAge.getText().toString();
                userAge.setText(ageNumber);

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("AgeData", ageNumber);
                editor.apply();

                Toast myToast = Toast.makeText(getApplicationContext(), "Age Saved!",
                        Toast.LENGTH_SHORT);
                myToast.show();
            }
        });

        ageText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @SuppressLint("StringFormatMatches")
            @Override
            public void afterTextChanged(Editable s) {
                int age = Integer.parseInt(userAge.getText().toString());
                String text;

                if (age < intYears/3){
                    text = getString(R.string.Message_1, age);
                    outputText.setText(text);
                }

                else{
                    text = getString(R.string.Message_2, age);
                    outputText.setText(text);
                }
            }
        });
    }

    public void setAgeIfEmpty(String data) {
        if (!TextUtils.isEmpty(userAge.getText())) {
            userAge.setText(data);
        }
    }
}