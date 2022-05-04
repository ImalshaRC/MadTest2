package com.example.emedicare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Button OTOLARYNGOLOGIST, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerLayout = findViewById(R.id.drawer_layout);

        OTOLARYNGOLOGIST = findViewById(R.id.btn_oto);
        OTOLARYNGOLOGIST = findViewById(R.id.btn_oto);
        OTOLARYNGOLOGIST = findViewById(R.id.btn_oto);
        OTOLARYNGOLOGIST = findViewById(R.id.btn_oto);

        OTOLARYNGOLOGIST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                user.delete();
//                startActivity(new Intent(Profile.this,MainActivity.class));
            }
        });

    }

    //Nav Drawer

    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome (View view){ recreate(); }

    public void ClickMyProfile (View view){
        redirectActivity(this, Profile.class);
    }

    public void ClickBMI (View view){
        redirectActivity(this, BMI.class);
    }

    public void ClickHealthCal (View view){
        redirectActivity(this, HealthCalculator.class);
    }

    public void ClickCalorieCal (View view){
        redirectActivity(this, CalorieCal.class);
    }

    public void ClickStepCounter (View view){
        redirectActivity(this, StepCounter.class);
    }

    public void ClickLogOut(View view){
        NavDrawer.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        NavDrawer.closeDrawer(drawerLayout);
    }

    public static void redirectActivity(Activity activity,Class aClass) {
        Intent intent = new Intent(activity,aClass);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        activity.startActivity(intent);

    }

    @Override
    protected void onStart() {
        super.onStart();
//        mainAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
//        mainAdapter.stopListening();
    }



}