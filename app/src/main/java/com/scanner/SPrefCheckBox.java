package com.scanner;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SPrefCheckBox extends AppCompatActivity {
/**SharedPreferences**/
    private static final String PREFS_NAME = "preferences";
    private static final String PREF_UNAME = "Username";
    private static final String PREF_PASSWORD = "Password";
    private final String DefaultUnameValue = "";
    private String UnameValue;
    private boolean CheckValue;
    private final String DefaultPasswordValue = "";
    private String PasswordValue;
/**----------------------------------------------------**/

    private EditText input_username;
    private EditText input_password;
    private Button saveButton;
    private CheckBox ch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        input_username = (EditText) findViewById(R.id.edittext);
        input_password = (EditText) findViewById(R.id.edittext2);
        ch = (CheckBox) findViewById(R.id.checkBox);
//        ch.setChecked(true);  //set checked on checkbox
        saveButton = (Button) findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch.isChecked()){
                    Toast.makeText(SPrefCheckBox.this,"save data",Toast.LENGTH_SHORT).show();
                    Intent gotonext = new Intent(SPrefCheckBox.this,Main2Activity.class);
                    startActivity(gotonext);
                }
                Intent gotonext = new Intent(SPrefCheckBox.this,Main2Activity.class);
                startActivity(gotonext);
            }
        });
//        clearData();
    }

    public void onCheckBoxClick(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        // เช็ค checkbox ที่เลือก
        switch(view.getId()) {
            case R.id.checkBox:
                if (checked){
                    Toast.makeText(SPrefCheckBox.this,"check",Toast.LENGTH_SHORT).show();
                    savePreferences();
                }
                break;
        }
    }

    @Override
    public void onResume() {  //เรียกแอกกลับมาใช้งานอีกครั้ง
        super.onResume();
        loadPreferences();
//        เาอ api เก็บไว้ในนี้
//        Intent gotonext = new Intent(SPrefCheckBox.this,Main2Activity.class);
//        startActivity(gotonext);
        if (input_password.getText().toString().trim().length() > 0){
//            savePreferences();
            Intent gotonext = new Intent(SPrefCheckBox.this,Main2Activity.class);
            startActivity(gotonext);
        }
    }

    @Override
    public void onPause() { //แอพหยุดใช้งานชั่วคราว  ปิดการใช้งานแอพแล้วไปหน้าแรกเลย
        super.onPause();
//        savePreferences();
    }

    private void savePreferences() {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        // Edit and commit
        UnameValue = input_username.getText().toString();
        PasswordValue = input_password.getText().toString();
        System.out.println("onPause save name: " + UnameValue);
        System.out.println("onPause save password: " + PasswordValue);

        editor.putString(PREF_UNAME, UnameValue);
        editor.putString(PREF_PASSWORD, PasswordValue);
        editor.putBoolean("PREF_Check", ch.isChecked());
        editor.commit();
    }

    private void loadPreferences() {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        // Get value
        UnameValue = settings.getString(PREF_UNAME, DefaultUnameValue);
        PasswordValue = settings.getString(PREF_PASSWORD, DefaultPasswordValue);
        CheckValue = settings.getBoolean("PREF_Check", true);
        input_username.setText(UnameValue);
        input_password.setText(PasswordValue);
        System.out.println("onResume load name: " + UnameValue);
        System.out.println("onResume load password: " + PasswordValue);
        Log.i("SharedPreferences","editor"+UnameValue+","+PasswordValue);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.menu:
                Intent gotoMenu = new Intent(SPrefCheckBox.this,MainMenu.class);
                startActivity(gotoMenu);
        }
    }
}

