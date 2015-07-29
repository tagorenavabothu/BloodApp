package com.blooddonar.app;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.cordova.DroidGap;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.FROYO)
public class MyPhoneGapActivity extends DroidGap {
	 Boolean isInternetPresent = false;
	 ConnectionDetector cd;
	@SuppressLint("NewApi")
	@Override
	public void onCreate(Bundle savedInstanceState) {
	
		
		try {
            PackageInfo info = getPackageManager().getPackageInfo("com.blooddonar.app",PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String sign=Base64.encodeToString(md.digest(), Base64.DEFAULT);
                //Log.e("MY KEY HASH:", sign);
                //Toast.makeText(getApplicationContext(),sign,         Toast.LENGTH_LONG).show();
            }
} catch (NameNotFoundException e) {
} catch (NoSuchAlgorithmException e) {
}
		
		
		
		
		super.onCreate(savedInstanceState);		
		super.loadUrl("file:///android_asset/www/index.html");
		cd = new ConnectionDetector(getApplicationContext());
		isInternetPresent = cd.isConnectingToInternet();
		 
        // check for Internet status
        if (isInternetPresent) {
            // Internet Connection is Present
            // make HTTP requests
           //Toast.makeText(getApplicationContext(), "avaliable connection", Toast.LENGTH_LONG).show();
           
           
           
           
           
        } else {
            // Internet connection is not present
            // Ask user to connect to Internet
             AlertDialog alertDialog = new AlertDialog.Builder(
            		 MyPhoneGapActivity.this).create();
 
        // Setting Dialog Title
        alertDialog.setTitle("Alert Dialog");
 
        // Setting Dialog Message
        alertDialog.setMessage("app requires internet connection");
 
      
        
 
        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                	finish();
                // Write your code here to execute after dialog closed
                //Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                }
        });
 
        // Showing Alert Message
        alertDialog.show();
        	 //Toast.makeText(getApplicationContext(), "no avaliable connection", Toast.LENGTH_LONG).show();
        }
	}
}
