package com.example.myapplication.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.R;

public class MyShopActivity extends AppCompatActivity {

    private Button btnsetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_my_shop);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnhome = findViewById(R.id.Home);
        Button btnprofile = findViewById(R.id.Profile);
        Button btnsetting = findViewById(R.id.Setting);
        Button btncart = findViewById(R.id.Cart);


        //Home Ko click garne
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MyShopActivity.this, "home button", Toast.LENGTH_SHORT).show();
//                FragmentManager manager = getSupportFragmentManager();
//                FragmentTransaction transaction = manager.beginTransaction();
//
//                HomeFragment home = new HomeFragment();
//                transaction.replace(R.id.frame, home);
//                transaction.commit();

                HomeFragment home = new HomeFragment();
                switchFragment(home);

            }
        });


        //Profile Ko click garne
        btnprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MyShopActivity.this, "profile button", Toast.LENGTH_SHORT).show();
//                FragmentManager manager = getSupportFragmentManager();
//                FragmentTransaction transaction = manager.beginTransaction();
//
//                ProfileFragment profile = new ProfileFragment();
//                transaction.replace(R.id.frame, profile);
//                transaction.commit();
                ProfileFragment profile = new ProfileFragment();
                switchFragment(profile);
            }
        });

        //Setting Ko click garne
        btnsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MyShopActivity.this, "setting button", Toast.LENGTH_SHORT).show();
//                FragmentManager manager = getSupportFragmentManager();
//                FragmentTransaction transaction = manager.beginTransaction();
//
//                SettingFragment setting = new SettingFragment();
//                transaction.replace(R.id.frame, setting);
//                transaction.commit();
                SettingFragment setting = new SettingFragment();
                switchFragment(setting);
            }
        });

        //Cart ko click garne
        btncart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MyShopActivity.this, "cart button", Toast.LENGTH_SHORT).show();
//                FragmentManager manager = getSupportFragmentManager();
//                FragmentTransaction transaction = manager.beginTransaction();
//
//                CartFragment cart = new CartFragment();
//                transaction.replace(R.id.frame, cart);
//                transaction.commit();
                CartFragment cart = new CartFragment();
                switchFragment(cart);

            }
        });
    }

    void switchFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        HomeFragment home = new HomeFragment();
        transaction.replace(R.id.frame, fragment);
        transaction.commit();
    }


}