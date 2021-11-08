package com.example.multiautocompletefield;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.hootsuite.nachos.NachoTextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    NachoTextView nachoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nachoTextView = findViewById(R.id.multiAutocompleteText);

        initEditText();
    }

    private void initEditText() {
        String[] suggestions = new String[]{"PZ-1904+ck", "PZ", "PZ-1904", "PZ+ck", "PZS-2044", "PZS-1189"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line,
                suggestions);

        nachoTextView.setAdapter(adapter);
    }

    public void onClick(View v) {
        List<String> messages = nachoTextView.getChipValues();

        for (String message : messages) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }
}