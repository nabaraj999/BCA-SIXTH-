package com.example.myapplication.merogrid;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

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
        GridView maingrid=findViewById(R.id.main_grid);
       GridKoAdapter adapter = new GridKoAdapter(GridDekhauneActivity.this);
        maingrid.setAdapter(adapter);
    }
}
class GridKoAdapter extends BaseAdapter{
    private final Context myContext;
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
    
GridKoAdapter(Context context){
   myContext = context;
}

    @Override
    public int getCount() {
       return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(myContext).inflate(R.layout.grid_ko_design,parent,false);
        ImageView img = convertView.findViewById(R.id.grid_image);
        TextView Tvname = convertView.findViewById(R.id.grid_name);
        TextView Tvnickname = convertView.findViewById(R.id.grid_nickname);

        // abo ya nira data halne kaam garam
        img.setImageResource(images[position]);
        Tvname.setText(name[position]);
        Tvnickname.setText(nickName[position]);

        return convertView;
    }
}