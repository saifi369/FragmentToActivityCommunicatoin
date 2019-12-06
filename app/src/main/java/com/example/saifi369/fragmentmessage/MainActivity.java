package com.example.saifi369.fragmentmessage;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity
        implements DetailFragment.DetailFragmentListener {

    public static final String FRAGMENT_TAG = "output_fragment_tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(task -> showFragment());

        OutputFragment outputFragment = new OutputFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.output_fragment_container, outputFragment, FRAGMENT_TAG)
                .commit();
    }

    private void showFragment() {

        DetailFragment fragment=new DetailFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.data_fragment_container,fragment,"Tag")
                .commit();

    }

    @Override
    public void onDetailFragmentFinish(Person person) {

        OutputFragment fragment = (OutputFragment) getSupportFragmentManager()
                .findFragmentByTag(FRAGMENT_TAG);

        fragment.displayPerson(person);

        Log.d("MyTag", "onDetailFragmentFinish: Person: " + person.toString());
    }
}
