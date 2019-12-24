package com.scanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.app.MediaRouteButton;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {
    private int STORAGE_PERMISSION_CODE = 1;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        initProgressBar();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.button1){
            Intent intent_ip = new Intent(MainMenu.this,MainActivity.class);
            startActivity(intent_ip);
        }
        if (view.getId() == R.id.button2){
            if (ContextCompat.checkSelfPermission(MainMenu.this,
                    Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainMenu.this, "You have already granted this permission!",
                        Toast.LENGTH_SHORT).show();
                Intent intent_Main2 = new Intent(MainMenu.this, Main2Activity.class);
                startActivity(intent_Main2);
            }else {
                requestStoragePermission();
            }
        }
        if (view.getId()== R.id.button3){
                Intent intent_scanapp = new Intent(MainMenu.this,ScanApp.class);
                startActivity(intent_scanapp);
        }
        if (view.getId() == R.id.button4){
            Intent intent_SPrefCheckBox = new Intent(MainMenu.this,SPrefCheckBox.class);
            startActivity(intent_SPrefCheckBox);
        }
//        switch (view.getId()){
//            case R.id.button1:
//                Intent intent_ip = new Intent(MainMenu.this,MainActivity.class);
//                startActivity(intent_ip);
//            case R.id.button2:
//                Intent intent_Main2_Scan = new Intent(MainMenu.this,Main2Activity.class);
//                startActivity(intent_Main2_Scan);
//            case R.id.button3:
//                Intent intent_SPrefCheckBox = new Intent(MainMenu.this,ScanActivity.class);
//                startActivity(intent_SPrefCheckBox);
//        }
    }

    private void showProgressBar(){
        mProgressBar.setVisibility(View.VISIBLE);

    }

    private void hideProgressBar(){
        if(mProgressBar.getVisibility() == View.VISIBLE){
            mProgressBar.setVisibility(View.INVISIBLE);
        }
    }
    private void initProgressBar(){
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)) {

            new AlertDialog.Builder(this)
                    .setTitle("Permission needed")
                    .setMessage("This permission is needed because of this and that")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(MainMenu.this,
                                    new String[] {Manifest.permission.CAMERA}, STORAGE_PERMISSION_CODE);
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();

        } else {
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.CAMERA}, STORAGE_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == STORAGE_PERMISSION_CODE)  {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission GRANTED", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
