package com.example.listycity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.content.Intent;

public class AddCityActivity extends AppCompatActivity {
    EditText editText;
    Button confButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_city);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editText = findViewById(R.id.edit_city_name);
        confButton = findViewById(R.id.conf_button);

        confButton.setOnClickListener(this::handleConfButton);
    }

    private void handleConfButton(View v) {
        String cityName = editText.getText().toString().trim();

        if (!cityName.isEmpty()) {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("CITY_NAME", cityName);
            setResult(RESULT_OK, resultIntent);
            finish();
        }
    }
}