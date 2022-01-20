package com.example.jualan;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.jualan.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.android.droidcafe.extra.MESSAGE";

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private String mNameOrderMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ActivityOrder.class);
                intent.putExtra(EXTRA_MESSAGE, mNameOrderMessage);

                startActivity(intent);


            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case R.id.action_order:
                Intent intent = new Intent(MainActivity.this, ActivityOrder.class);
                intent.putExtra(EXTRA_MESSAGE, mNameOrderMessage);
                startActivity(intent);
                return true;
            case R.id.action_status:
                displayToast(getString(R.string.action_status_message));
                return true;
            case R.id.action_favorites:
                displayToast(getString(R.string.action_favorites_message));
                return true;
            case R.id.action_contact:
                displayToast(getString(R.string.action_contact_message));
                return true;
            default:
                // Do nothing
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void showbunga1order(View view) {
        mNameOrderMessage = "Nama Item            : Daisy Flower   " +
                            "Harga Item            : 150.000";
        displayToast("Daisy Flower dipilih");
    }

    public void showbunga2order(View view) {
        mNameOrderMessage = "Nama Item            : Pinky roses     " +
                            "Harga Item            : 165.000";
        displayToast("Pinky roses dipilih");
    }

    public void showbunga3order(View view) {
        mNameOrderMessage = "Nama Item            : Hydrangea       " +
                            "Harga Item            : 100.000";
        displayToast("Hydrangea dipilih");
    }

    public void showbunga4order(View view) {
        mNameOrderMessage = "Nama Item             : B Breath       " +
                            "Harga Item             : 199.000";
        displayToast("B Breath dipilih");
    }

    public void showbunga5order(View view) {
        mNameOrderMessage = "Nama Item             : Cotton Flo     " +
                            "Harga Item             : 125.000";
        displayToast("Cotton Flo dipilih");
    }

    public void showbunga6order(View view) {
        mNameOrderMessage = "Nama Item            : Red Roses       " +
                            "Harga Item            : 205.000";
        displayToast("Red Roses dipilih");
    }

}