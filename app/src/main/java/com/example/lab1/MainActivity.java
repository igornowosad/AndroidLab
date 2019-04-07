package com.example.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText nameField = findViewById(R.id.name);
        final EditText surnameField = findViewById(R.id.surname);
        final EditText gradesField = findViewById(R.id.grades);

        Button sendButton = (Button)findViewById(R.id.sendButton);

        nameField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                boolean hasText = !nameField.getText().toString().isEmpty();
                if (!hasFocus && !hasText) {
                    nameField.setError("Required");
                }
            }
        });

        surnameField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                boolean hasText = !surnameField.getText().toString().isEmpty();
                if (!hasFocus && !hasText) {
                    surnameField.setError("Required");
                }
            }
        });

        gradesField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                boolean hasText = !gradesField.getText().toString().isEmpty();
                if (!hasFocus) {
                    gradesField.setError("Required");
                    if (!hasText) {
                        gradesField.setError("Required");
                        return;
                    }
                    Integer value = Integer.parseInt(gradesField.getText().toString());
                    if (value < 5 || value > 15) {
                        gradesField.setError("Provide value between 5 and 15");
                        return;
                    }
                }
            }
        });
    }
}
