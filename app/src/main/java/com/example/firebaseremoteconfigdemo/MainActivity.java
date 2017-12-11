package com.example.firebaseremoteconfigdemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements UpdateHelper.OnUpdateCheckListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        UpdateHelper.with(MainActivity.this).onUpdateCheck(MainActivity.this).check();
    }

    @Override


    public void onUpdateCheckListener(final String urlApp) {

        AlertDialog.Builder alertDialog  = new AlertDialog.Builder(this);

        alertDialog.setTitle("New Update Available");
        alertDialog.setTitle("Do you to update to the new Features");

        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent storeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlApp));
                startActivity(storeIntent);
                Toast.makeText(MainActivity.this, ""+urlApp, Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();
            }
        });

        alertDialog.show();

    }


}
