package com.example.saifi369.fragmentmessage;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DetailFragment extends Fragment {

    private static final String TAG = "MyTag";
    private EditText etFirstName,etLastName,etAge;
    private Button btnDone;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        etFirstName=rootView.findViewById(R.id.textFirstName);
        etLastName=rootView.findViewById(R.id.textLastName);
        etAge=rootView.findViewById(R.id.textAge);
        btnDone=rootView.findViewById(R.id.done_button);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                done();
            }
        });

        return rootView;
    }

    private void done() {
        Toast.makeText(getContext(), "Hello from Fragment", Toast.LENGTH_SHORT).show();
    }

}
