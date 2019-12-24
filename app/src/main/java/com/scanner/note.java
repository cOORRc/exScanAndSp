/** Scan
 *  <uses-permission android:name="android.permission.CAMERA" />
 *  <uses-feature android:name="android.hardware.camera" />
 *  <activity
 *      android:name=".Main2Activity"
 *      android:parentActivityName=".SPrefCheckBox"     create back button at navigation
 *      android:screenOrientation="portrait"
 *      android:stateNotNeeded="true">
 *
 *
 *      **/

/** สแกนแบบ Intent **/
//      On Button
//        Intent intent2 = new Intent("com.google.zxing.client.android.SCAN");
//        startActivityForResult(Intent.createChooser(intent2,"Scan with"), 2);

/** สแกนแบบ ในแอพ **/
//      On Button
//          Intent intents = new Intent(Main2Activity.this,ScanActivity.class); //creeata new class for scan
//          startActivityForResult(intents, 0); // 0 is mean we'll take the id to result
//
// doc = https://zxing.github.io/zxing/apidocs/com/google/zxing/integration
//          /android/IntentIntegrator.html#shareText-java.lang.CharSequence-
//
//        IntentIntegrator integrator = new IntentIntegrator(this); // (activity) calling activity reference
//        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
//                integrator.setPrompt("Scan");     เซ็ตข้อความในหน้าสแกน ex. "pls scan your qrcode"
//                integrator.setCameraId(0);      //กล้องหน้า(1) - หลัง(0)
//                integrator.setBeepEnabled(false);
//                integrator.setBarcodeImageEnabled(false);
//                integrator.setOrientationLocked(false);
//                integrator.setOrientationLocked(true);       //สแกนแนวนอน
//                integrator.initiateScan();  //scan for all known barcode types., call initiateScan() and wait for the result in your app.
//                integrator.getMoreExtras();

//  ถ้าเขียนระบุ id ตอนดึงค่ามาใช้ ให้เรียกใช้แบบนี้น๊าาาา
//      outside OnCreate
//          @SuppressLint("MissingSuperCall")
//          public void onActivityResult(int requestCode, int resultCode, Intent intent) {
//          if (requestCode == 0) {         // 0=your id on intent
//            if (resultCode == RESULT_OK) {
//                barcode = intent.getStringExtra("SCAN_RESULT");
//                textContent.setText(barcode);
//                Toast.makeText(this,"button 1 : "+barcode,Toast.LENGTH_LONG).show();
//            }
//          }

/*********************** End Scan ************************/

/**
 * **/

/*********************** End  ************************/