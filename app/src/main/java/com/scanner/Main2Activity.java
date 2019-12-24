package com.scanner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    EditText textContent,textContent2;
//    SharedPreferences Q;
    private static final String PREFS_NAME = "preferences";
    private static final String PREF_UNAME = "Username";
    private static final String PREF_PASSWORD = "Password";
    private String barcode,barcode2;

    Button buttonIntent,buttonIntent2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textContent = findViewById(R.id.editText);
        textContent2 = findViewById(R.id.editText2);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        String text = settings.getString(PREF_UNAME, "");

        Toast.makeText(getApplicationContext(),"please permission your camera",Toast.LENGTH_LONG).show();
        textContent.setText(text);
        initView();
    }
    private void initView() {
        buttonIntent = (Button)findViewById(R.id.button);
        buttonIntent2 = (Button)findViewById(R.id.button2);
    }

    public void onClick(View view) {

        if(view.getId() == R.id.button) {
            Intent intents = new Intent(Main2Activity.this,ScanActivity.class);
            startActivityForResult(intents, 0);
            Log.i("push","button 1");
        }

        if(view.getId() == R.id.button2) {
            Intent intents2 = new Intent(Main2Activity.this,ScanActivity.class);
            startActivityForResult(intents2, 1);
            Log.i("push","button 2");
        }

        if(view.getId() == R.id.menu) {
            Intent gotoMenu = new Intent(Main2Activity.this,MainMenu.class);
            startActivity(gotoMenu);
        }

        if(view.getId() == R.id.SP) {
            Intent gotoSP = new Intent(Main2Activity.this,SPrefCheckBox.class);
            startActivity(gotoSP);
        }
    }

    @SuppressLint("MissingSuperCall")
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                barcode = intent.getStringExtra("SCAN_RESULT");
                textContent.setText(barcode);
                Toast.makeText(this,"button 1 : "+barcode,Toast.LENGTH_LONG).show();
            }
        }
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                barcode = intent.getStringExtra("SCAN_RESULT");
                textContent2.setText(barcode);
                Toast.makeText(this,"button 2 : "+barcode,Toast.LENGTH_LONG).show();
            }
        }
    }

    public void logout(View view) {
        SharedPreferences sharedpreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            // ดึง share preference ชื่อ PREFS_NAME เก็บไว้ในตัวแปร sharedpreferences
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();  // ทำการลบข้อมูลทั้งหมดจาก preferences
        editor.commit();  // ยืนยันการแก้ไข preferences
        moveTaskToBack(true);
        Main2Activity.this.finish();
        Toast.makeText(Main2Activity.this,"THANK YOU",Toast.LENGTH_SHORT).show();
    }

//    public void exit(View view){
//        moveTaskToBack(true);
//        Main2Activity.this.finish();
//
//    }
}
