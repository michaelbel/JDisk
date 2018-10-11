package org.michaelbel.jdisk.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import org.michaelbel.jdisk.R;
import org.michaelbel.jdisk.ui.adapter.MainPagerAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Toolbar.OnMenuItemClickListener, ViewPager.OnAdapterChangeListener {

    private Context context = MainActivity.this;

    private MainPagerAdapter adapter;

    private BottomAppBar bottomAppBar;
    private FloatingActionButton fab;
    private TabLayout tabs;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences = getSharedPreferences("mainconfig", MODE_PRIVATE);
        String token = preferences.getString("token", null);
        if (token == null) {
            startActivity(new Intent(context, AuthActivity.class));
            finish();
            return;
        }

        setContentView(R.layout.activity_main);

        bottomAppBar = findViewById(R.id.bottom_app_bar);
        bottomAppBar.setOnMenuItemClickListener(this);
        setSupportActionBar(bottomAppBar);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);

        adapter = new MainPagerAdapter(context, getSupportFragmentManager());

        viewPager = findViewById(R.id.view_pager);
        viewPager.addOnAdapterChangeListener(this);
        viewPager.setAdapter(adapter);

        tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager, true);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_navigation, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.settings_item) {
            startActivity(new Intent(context, SettingsActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(context, "fab clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }

    @Override
    public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter oldAdapter, @Nullable PagerAdapter newAdapter) {

    }
}