package com.example.myapplication.merogrid;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class GridDekhauneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grid_dekhaune);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
class GridKoAdapter extends BaseAdapter{
    String[] name = {"Abhash", "Anjali", "Bimal", "Dipen", "Joyesh",
            "Mallika", "Manisa", "Manjit", "Nabaraj", "Nayan",
            "Nirjala", "Pratiksha", "Rashmi", "Ritika", "Sangam",
            "Sebak", "Srijana", "Sudip", "Sushil", "Swostika"
    };
    String[] nickName = {"Hallankari", "Hasmati", "Silent", "Chasmis", "Joker",
            "Motax", "Small", "Galatey", "LoverBoi", "Mote",
            "Gayab", "Danger", "Dancer", "Don", "Chattu",
            "Neta", "Boxer", "Lamo Kapal Boy", "Commando", "Presenter"
    };
    int[] images = {R.drawable.picofme,
            R.drawable.picofme,
            R.drawable.picofme, R.drawable.picofme, R.drawable.picofme,
            R.drawable.picofme, R.drawable.picofme, R.drawable.picofme, R.drawable.picofme,
            R.drawable.picofme, R.drawable.picofme, R.drawable.picofme, R.drawable.picofme,
            R.drawable.picofme, R.drawable.picofme, R.drawable.picofme,
            R.drawable.picofme, R.drawable.picofme, R.drawable.picofme, R.drawable.picofme,
    };


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}