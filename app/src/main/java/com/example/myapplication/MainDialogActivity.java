package com.example.myapplication;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_dialog);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnshowmydialog = findViewById(R.id.btn_show_dialog);
        btnshowmydialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog meroDialog = new Dialog(MainDialogActivity.this);
                meroDialog.setContentView(R.layout.activity_my_dialouge);

                //start refrencing views
                Button btnLike = meroDialog.findViewById(R.id.btn_like);
                Button btnDislike = meroDialog.findViewById(R.id.btn_dislike);

                btnLike.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainDialogActivity.this, "Jau Nata", Toast.LENGTH_SHORT).show();
                        meroDialog.dismiss();
                    }
                });

                btnDislike.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainDialogActivity.this, "Alxi raixas ta", Toast.LENGTH_SHORT).show();
                        meroDialog.dismiss();
                    }
                });

                meroDialog.show();

            }
        });
    }
}