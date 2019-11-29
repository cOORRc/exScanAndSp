package com.scanner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class MainActivity extends AppCompatActivity {
    public static String IP = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        String ip = Formatter.formatIpAddress(inetAddress.hashCode());
                        Toast.makeText(getApplicationContext(), "Status == " + ip, Toast.LENGTH_SHORT).show();
                        Log.i("IP ", String.valueOf(ip));
                        IP = ip;
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        Log.i("IP ", String.valueOf(IP));

/**AlertDialog simply and to do this in your onClick**/
//        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
//        alertDialog.setTitle("Alert");
//        alertDialog.setMessage("Alert message to be shown");
//        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//        alertDialog.show();
    }

/**หาค่า ip เอามาไว้ใช้งานภายในแอพ**/
//    public String getLocalIpAddress() {
//        try {
//            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
//                NetworkInterface intf = en.nextElement();
//                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
//                    InetAddress inetAddress = enumIpAddr.nextElement();
//                    if (!inetAddress.isLoopbackAddress()) {
//                        String ip = Formatter.formatIpAddress(inetAddress.hashCode());
//                        Toast.makeText(getApplicationContext(), "Status == " + ip, Toast.LENGTH_SHORT).show();
//                        Log.i("IP ", String.valueOf(ip));
//                        IP = ip;
//                        return ip;
//                    }
//                }
//            }
//        }
//        catch (SocketException ex) {
//            Log.e("IP ", ex.toString());
//            Toast.makeText(getApplicationContext(), "Status == " + ex, Toast.LENGTH_SHORT).show();
//        }
//        Log.i("IPqqqqq ", String.valueOf(IP));
//        Toast.makeText(getApplicationContext(), "StatusOutside == " + IP, Toast.LENGTH_SHORT).show();
//
//        return null;
//    }
}
