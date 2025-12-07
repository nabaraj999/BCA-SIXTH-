package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MeroCustomListActivity extends AppCompatActivity {
String [] name= {"Abhash","Anjali", "Bimal", "Dipen", "Joyesh", "Mallika", "Manisha","Manjit", "Nabaraj",
        "Nayan", "Pratiksha", "Rashmi", "Ritika","Sangam","Sebak", "Srijana","Sudip","Sushil",
        "Swostika" };
String [] nickname ={"Hallakumar","HAsmati","silent", "chasmiss", "joker", "Fat", "Small",
        "loverBoy", "Mote", "Gayab", "Danger", "Dancer", "Don", "Chattu","Neta", "Boxer",
        "Lamo Kapal Boy", "Commando", "Presenter"};
int[] images = {R.drawable.user,R.drawable.user,R.drawable.user,R.drawable.user,R.drawable.user,
        R.drawable.user,R.drawable.user,R.drawable.user,R.drawable.picofme,R.drawable.user,
        R.drawable.user,R.drawable.user,R.drawable.user,R.drawable.user,R.drawable.user,
        R.drawable.user,R.drawable.user,R.drawable.user,R.drawable.user,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mero_custom_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}

class MeroCustomAdapter extends BaseAdapter{

    MeroCustomAdapter(context c){
        this.context = c;
    }
    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return images[i];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view==null) {
            view = LayoutInflater.from(context).inflate(R.layout.row_new_list, parent, false);
            Image myImage=view.findViewById(R.id.img);
            TextView myName = view.findViewById(R.id.tv_name);
            TextView myNickName = view.findViewById(R.id.tv_nick);
        }
        return null;
    }
}