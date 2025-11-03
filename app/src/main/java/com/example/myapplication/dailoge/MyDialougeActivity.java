package com.example.myapplication.dailoge;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class MyDialougeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_my_dialouge);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnshowDialog = findViewById(R.id.btn_show_dialog);
        btnshowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // todo; write dialog box code here
                AlertDialog.Builder dialog = new AlertDialog.Builder(MyDialougeActivity.this);
                dialog.setTitle("Hello it's me nabaraj");
                dialog.setMessage("Aja hamro class ma tourist ako xa ");
                dialog.show();
            }
        });
    }
}