package com.example.droid;

import android.view.View;
import android.widget.AdapterView;

public interface onItemSelected {
    void onItemSelected(AdapterView<?> adapterView,
                        View view, int i, long l);

    void onNothingSelected(AdapterView<?> adapterView);
}
