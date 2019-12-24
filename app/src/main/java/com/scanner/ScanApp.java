package com.scanner;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ScanApp extends AppCompatActivity {
    private EditText ETshow,et;
    private TextView tv1,tv2,tv3,tv4,tv5,tv6;
    private CheckBox checkbox;
    private Button scan_butt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),"scanApp",Toast.LENGTH_LONG).show();

        ETshow = (EditText)findViewById(R.id.editText2);
        scan_butt = (Button)findViewById(R.id.button2);
        scan_butt.setText("Scan");

        checkbox = (CheckBox)findViewById(R.id.checklogin);
        checkbox.setVisibility(View.INVISIBLE);
        et = (EditText)findViewById(R.id.editText);
        et.setVisibility(View.INVISIBLE);
        tv1 = (TextView)findViewById(R.id.textView);
        tv1.setVisibility(View.INVISIBLE);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv2.setVisibility(View.INVISIBLE);
        tv3 = (TextView)findViewById(R.id.textView3);
        tv3.setVisibility(View.INVISIBLE);
        tv4 = (TextView)findViewById(R.id.textView4);
        tv4.setVisibility(View.INVISIBLE);
        tv5 = (TextView)findViewById(R.id.textView5);
        tv5.setVisibility(View.INVISIBLE);
        tv6 = (TextView)findViewById(R.id.textView6);
        tv6.setVisibility(View.INVISIBLE);


    }

    public void onClick(View view) {
        if (view.getId() == R.id.button2) {
            Intent scanner = new Intent("com.google.zxing.client.android.SCAN");
            startActivityForResult(Intent.createChooser(scanner,"Scan with"), 1);
        }
        if (view.getId() == R.id.menu){
            Intent menu = new Intent(getApplicationContext(),MainMenu.class);
            startActivity(menu);
        }
    }

    @SuppressLint("MissingSuperCall")
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
//        if (requestCode == REQUEST_QR_SCAN && resultCode == RESULT_OK) {
            String contents_sheet = intent.getStringExtra("SCAN_RESULT");
            ETshow.setText(contents_sheet);
        }
    }

}
