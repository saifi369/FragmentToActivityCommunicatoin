package com.example.saifi369.fragmentmessage;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView=findViewById(R.id.tvShow);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment();
            }
        });
    }

    private void showFragment() {

        DetailFragment fragment=new DetailFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.data_fragment_container,fragment,"Tag")
                .commit();

    }

}
