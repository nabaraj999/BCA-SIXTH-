package db;

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

public class UiActivity extends AppCompatActivity {

    MyDatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ui);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dbHelper = new MyDatabaseHelper( this);

        EditText Dbname = findViewById(R.id.db_name);
        EditText DbContact = findViewById(R.id.db_contact);
        EditText DbAddress = findViewById(R.id.db_address);

        Button btn_add = findViewById(R.id.btn_add);
        Button btn_view = findViewById(R.id.btn_view);
        Button btn_delete = findViewById(R.id.btn_delete);
        Button btn_update = findViewById(R.id.btn_update);



        //onclick listener for the add (calls the add page)
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Dbname.getText().toString();
                String contact = DbContact.getText().toString();
                String address = DbAddress.getText().toString();
                 int ContactNumber= Integer.parseInt(contact);

             dbHelper.insertUser(name,address,contact);
            }
        });


        //onclick listener for the view (calls the view page)
        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UiActivity.this, "View ko toast", Toast.LENGTH_SHORT).show();

            }
        });

        //onclick listener for the delete (calls the delete page)
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UiActivity.this, "delete ko toast", Toast.LENGTH_SHORT).show();

            }
        });
        //onclick listener for the update (calls the update page)
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UiActivity.this, "update ko toast", Toast.LENGTH_SHORT).show();

            }
        });

    }
}