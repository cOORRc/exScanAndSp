package com.scanner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class MainActivity extends AppCompatActivity {
    public static String IP = "";
    private Context togetIP;
    private TextView tvWifiManager;
    private TextView tvWifiwifiInf;
    private TextView tvIpAddresses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvIpAddresses = (TextView)findViewById(R.id.textView6);
        tvWifiManager = (TextView)findViewById(R.id.textView2);
        tvWifiwifiInf = (TextView)findViewById(R.id.textView4);

        IPAddresses ip = new IPAddresses(this);
        String ipp = String.valueOf(ip);
//        Toast.makeText(getApplicationContext(), "class_Status == " +ip, Toast.LENGTH_LONG).show();
        Log.i("class_IP ","ip "+ ipp);

        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        String ip_add = Formatter.formatIpAddress(inetAddress.hashCode());
//                        Toast.makeText(getApplicationContext(), "Status == " + ip_add, Toast.LENGTH_SHORT).show();
                        Log.i("try_IP ","IP "+ ip_add);
//                        IP = ip_add;
                        tvIpAddresses.setText(ip_add);
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
//        Log.i("IP ", String.valueOf(IP));

/**หาค่า ip เอามาไว้ใช้งานภายในแอพ**/
        WifiManager wm = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        String test_ip1 = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
        Log.i("IP ","get_ip1 "+test_ip1);
        tvWifiManager.setText(test_ip1);

        WifiManager wifiMan = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInf = wifiMan.getConnectionInfo();
        int ipAddress = wifiInf.getIpAddress();
        String test_ip2 = String.format("%d.%d.%d.%d", (ipAddress & 0xff),(ipAddress >> 8 & 0xff),(ipAddress >> 16 & 0xff),(ipAddress >> 24 & 0xff));
        Log.i("IP ","get_ip2 "+test_ip2);
        tvWifiwifiInf.setText(test_ip2);

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

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.menu:
                Intent gotoMenu = new Intent(MainActivity.this,MainMenu.class);
                startActivity(gotoMenu);
        }
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
