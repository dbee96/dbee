package com.example.jualan;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityOrder extends AppCompatActivity
        implements onItemSelected, AdapterView.OnItemSelectedListener{
    private int mCount = 0;
    private TextView NmItem, TextSpinner;
    private EditText nama, alamat, telepon, catatan, mShowCount;
    private RadioGroup metode;
    private RadioButton namametode;
    private Spinner ukuran;
    private Object view;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.NmItem);
        textView.setText(message);
        

        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }


        ukuran = spinner;


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.labels_array,
                android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

        nama = findViewById(R.id.nama);
        alamat = findViewById(R.id.alamat);
        telepon = findViewById(R.id.telepon);
        catatan = findViewById(R.id.catatan);
        mShowCount = findViewById(R.id.show_count);
        metode = findViewById(R.id.metode);
        NmItem = textView;
        TextSpinner =findViewById(R.id.textSpinner);
    }


    public void countup(View view) {
        ++mCount;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }

    public void countdown(View view) {
        --mCount;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView,
                               View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);
        TextSpinner.setText((spinnerLabel));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked.
        switch (view.getId()) {
            case R.id.sameday:
                if (checked)
                    // Same day service
                    displayToast(getString(R.string.cash_on_delivery));
                break;
            case R.id.nextday:
                if (checked)
                    // Next day delivery
                    displayToast(getString(R.string.transfer_bank));
                break;
            case R.id.pickup:
                if (checked)
                    // Pick up
                    displayToast(getString(R.string.indomaret_alfamart));
                break;
            default:
                // Do nothing.
                break;
        }
    }

    public void launchthird(View view) {

        int radioId = metode.getCheckedRadioButtonId();
        namametode = (RadioButton) findViewById(radioId);
             

        String usernama = nama.getText().toString();
        String useralamat = alamat.getText().toString();
        String usertelepon = telepon.getText().toString();
        String usercatatan = catatan.getText().toString();
        String userjumlah = mShowCount.getText().toString();
        String usermetode = namametode.getText().toString();
        String userukuran = TextSpinner.getText().toString();
        String useritem = NmItem.getText().toString();


        Intent intent = new Intent(ActivityOrder.this, ThirdActivity.class);


        intent.putExtra("keynama", usernama);
        intent.putExtra("keyalamat", useralamat);
        intent.putExtra("keytelepon", usertelepon);
        intent.putExtra("keycatatan", usercatatan);
        intent.putExtra("keyjumlah", userjumlah);
        intent.putExtra("keymetode", usermetode);
        intent.putExtra("keyNmItem", useritem);
        intent.putExtra("keyukuran", userukuran);

        startActivity(intent);
    }


}
