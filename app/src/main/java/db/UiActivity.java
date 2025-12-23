package db;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
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

        dbHelper = new MyDatabaseHelper(this);

        EditText Dbname = findViewById(R.id.db_name);
        EditText DbContact = findViewById(R.id.db_contact);
        EditText DbAddress = findViewById(R.id.db_address);

        Button btn_add = findViewById(R.id.btn_add);
        Button btn_view = findViewById(R.id.btn_view);
        Button btn_delete = findViewById(R.id.btn_delete);
        Button btn_update = findViewById(R.id.btn_update);

        // ADD
        btn_add.setOnClickListener(v -> {
            String name = Dbname.getText().toString().trim();
            String address = DbAddress.getText().toString().trim();
            String contact = DbContact.getText().toString().trim();

            if(!name.isEmpty() && !address.isEmpty() && !contact.isEmpty()){
                int contactNumber = Integer.parseInt(contact);
                dbHelper.insertUSer(name,address,contactNumber);
                Toast.makeText(this, "Add Sucess Message", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Fill the Form all the way", Toast.LENGTH_SHORT).show();
            }



            int contactNumber = Integer.parseInt(contact);
            dbHelper.insertUSer(name, address, contactNumber);

            Toast.makeText(UiActivity.this, "Data Added", Toast.LENGTH_SHORT).show();
        });

        // VIEW
        btn_view.setOnClickListener(v -> {
            Cursor returnData = dbHelper.getAllUser();

            while (returnData.moveToNext()) {
                int id = returnData.getInt(returnData.getColumnIndexOrThrow("id"));
                String name = returnData.getString(returnData.getColumnIndexOrThrow("name"));
                String address = returnData.getString(returnData.getColumnIndexOrThrow("address"));
                String contact = returnData.getString(returnData.getColumnIndexOrThrow("contact"));

                Log.d("DB_DATA", id + " | " + name + " | " + address + " | " + contact);
            }

            returnData.close();
            Toast.makeText(UiActivity.this, "Data Logged", Toast.LENGTH_SHORT).show();
        });

        // DELETE (logic not added yet)
        btn_delete.setOnClickListener(v ->
                Toast.makeText(UiActivity.this, "Delete clicked", Toast.LENGTH_SHORT).show()
        );

        // UPDATE
        btn_update.setOnClickListener(v -> {
            dbHelper.updateUser(2, "Jack", "Lalitpur");
            Toast.makeText(UiActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
        });
    }
}
