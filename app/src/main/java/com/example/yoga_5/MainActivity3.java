package com.example.yoga_5;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity3 extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;

    RecyclerView recylerView;
    RecyclerView.LayoutManager recylerViewLayoutManager;

    String s1[], s2[],s3[];
    int images[] = {R.drawable.drum_1,R.drawable.drum_2,R.drawable.drum_3,R.drawable.drum_4};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        recylerView = findViewById(R.id.recyclerView);
        s1 = getResources().getStringArray(R.array.drum);
        s2 = getResources().getStringArray(R.array.harga_drum);
        s3 = getResources().getStringArray(R.array.star_drum);
        MusikAdapter appAdapter = new MusikAdapter(this,s1,s2,s3,images);
        recylerView.setAdapter(appAdapter);
        recylerViewLayoutManager = new LinearLayoutManager(MainActivity3.this, LinearLayoutManager.HORIZONTAL, false);
        recylerView.setLayoutManager(recylerViewLayoutManager);

        dl = (DrawerLayout)findViewById(R.id.dl);
        abdt = new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);

        dl.addDrawerListener(abdt);
        abdt.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nav_view = (NavigationView)findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_g){
                    Intent a = new Intent(MainActivity3.this, MainActivity.class);
                    startActivity(a);
                }else if (id == R.id.nav_b){
                    Intent a = new Intent(MainActivity3.this, MainActivity2.class);
                    startActivity(a);
                }else if (id == R.id.nav_d){
                    Intent a = new Intent(MainActivity3.this, MainActivity3.class);
                    startActivity(a);
                }
                else if (id == R.id.nav_alarm){
                    Intent a = new Intent(MainActivity3.this, AlarmActivity.class);
                    startActivity(a);
                }

                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}