package com.mussees.go.azzerrifi.gomusees;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void RchMusee(View view) {
        Intent i = new Intent(MenuActivity.this, RechercheMuseeActivity.class);
        startActivity(i);
    }

    public void museesProche(View view) {
        Intent i = new Intent(MenuActivity.this, MapsActivity.class);
        startActivity(i);
    }
}
