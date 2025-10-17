package com.example.myapplication.result.back;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class ParentActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> resultAucha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_parent);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnAddUser = findViewById(R.id.button);

        // Register ActivityResultLauncher
        resultAucha = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                            String name = result.getData().getStringExtra("UserName");
                            Toast.makeText(ParentActivity.this, "User added: " + name, Toast.LENGTH_SHORT).show();
                        } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                            Toast.makeText(ParentActivity.this, "Action Canceled", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        // Start AddUserActivity when button is clicked
        btnAddUser.setOnClickListener(v -> {
            Intent intent = new Intent(ParentActivity.this, AddUserActivity.class);
            resultAucha.launch(intent);
        });
    }
}
