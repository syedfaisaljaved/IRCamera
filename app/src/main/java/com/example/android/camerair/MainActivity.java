package com.example.android.camerair;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;


public class MainActivity extends Activity{

    private static final String PREFS_NAME = "MyPrefs" ;
    CameraPreview mPreview;
    FrameLayout preview;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        mPreview=new CameraPreview(this);
        preview=(FrameLayout)findViewById(R.id.camera_preview);
        preview.addView(mPreview);

        //dialog box
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // set title
        alertDialogBuilder.setTitle(R.string.Important);

        // set dialog message
        alertDialogBuilder
                .setMessage(R.string.message)
                .setCancelable(false)
                .setPositiveButton(R.string.OK,new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
//                }).setNegativeButton(R.string.dont, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                SharedPreferences settings = getSharedPreferences(PREFS_NAME,0);
//                SharedPreferences.Editor editor = settings.edit();
//                editor.putString("skipMessage", "true");
//                // Commit the edits!
//                editor.commit();
//            }
        });

//        //sharedpreferences for dont me again dialog box
//        SharedPreferences settings = getSharedPreferences(PREFS_NAME,0);
//        String skipMessage = settings.getString("skipMessage", "true");

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();
    }


}

