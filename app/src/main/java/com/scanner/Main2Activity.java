package com.scanner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
//    public static final int REQUEST_QR_SCAN = 4;
    EditText textContent,textContent2;
//    SharedPreferences Q;
    private static final String PREFS_NAME = "preferences";
    private static final String PREF_UNAME = "Username";
    private static final String PREF_PASSWORD = "Password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textContent = findViewById(R.id.editText);
        textContent2 = findViewById(R.id.editText2);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        String text = settings.getString(PREF_UNAME, "");
        textContent.setText(text);

//        String text = Q.getString(TEXT, "");
        Button buttonIntent = (Button)findViewById(R.id.button);
        buttonIntent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent intent =
//                        new Intent("com.google.zxing.client.android.SCAN");
//                startActivityForResult(Intent.createChooser(intent
//                        , "Scan with"), 1);
////                        , "Scan with"), REQUEST_QR_SCAN);
            }
        });
        Button buttonIntent2 = (Button)findViewById(R.id.button2);
        buttonIntent2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent2 = new Intent("com.google.zxing.client.android.SCAN");
                startActivityForResult(Intent.createChooser(intent2,"Scan with"), 2);

            }
        });
    }

    @SuppressLint("MissingSuperCall")
    public void onActivityResult(int requestCode, int resultCode
            , Intent intent) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
//        if (requestCode == REQUEST_QR_SCAN && resultCode == RESULT_OK) {
            String contents = intent.getStringExtra("SCAN_RESULT");
            textContent.setText(contents);
        }
        if (requestCode == 2 && resultCode == RESULT_OK) {
//        if (requestCode == REQUEST_QR_SCAN && resultCode == RESULT_OK) {
            String contents2 = intent.getStringExtra("SCAN_RESULT");
            textContent2.setText(contents2);
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
