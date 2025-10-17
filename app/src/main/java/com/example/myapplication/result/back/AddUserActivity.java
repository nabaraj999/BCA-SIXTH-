package com.example.myapplication.result.back;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class AddUserActivity extends AppCompatActivity {

    // Declare variables
    private EditText name;
    private Button saveButton, cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_user);

        // Adjust for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        name = findViewById(R.id.editTextText);
        saveButton = findViewById(R.id.et_save);
        cancelButton = findViewById(R.id.et_cancel);

        // Set click listeners
        saveButton.setOnClickListener(this::OnButtonClick);
        cancelButton.setOnClickListener(this::OnButtonClick);
    }

    public void OnButtonClick(View view) {
        int id = view.getId();

        if (id == R.id.et_save) {
            String meroNaam = name.getText().toString().trim();

            if (meroNaam.isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Mero Naam: " + meroNaam, Toast.LENGTH_SHORT).show();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("user_name",meroNaam);

                setResult(RESULT_OK,resultIntent);
                finish();
            }

        } else if (id == R.id.et_cancel) {
            Intent resultIntent = new Intent();
            setResult(RESULT_CANCELED,resultIntent);
            finish();
            Toast.makeText(this, "Cancel Bhayo", Toast.LENGTH_SHORT).show();
            name.setText(""); // clear the input field
        }
    }
}
