package com.example.saifi369.fragmentmessage;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity
        implements DetailFragment.DetailFragmentListener {

    private TextView mTxtOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTxtOutput = findViewById(R.id.tvShow);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(task -> showFragment());
    }

    private void showFragment() {

        DetailFragment fragment=new DetailFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.data_fragment_container,fragment,"Tag")
                .commit();

    }

    public void onClick(Person person) {
        Toast.makeText(this, "Testing", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onDetailFragmentFinish(Person person) {
        mTxtOutput.setText(person.getFirstName());

        Log.d("MyTag", "onDetailFragmentFinish: Person: " + person.toString());
    }
}
