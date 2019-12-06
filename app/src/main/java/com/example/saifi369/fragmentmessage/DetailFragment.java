package com.example.saifi369.fragmentmessage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {

    private static final String TAG = "MyTag";
    private EditText mEtFirstName, mEtLastName, mEtAge;
    private Button mBtnDone;

    private DetailFragmentListener mListener;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        mEtFirstName = rootView.findViewById(R.id.textFirstName);
        mEtLastName = rootView.findViewById(R.id.textLastName);
        mEtAge = rootView.findViewById(R.id.textAge);
        mBtnDone = rootView.findViewById(R.id.done_button);

        mBtnDone.setOnClickListener(view -> done());

        return rootView;
    }

    private void done() {
        Person person = new Person();
        person.setFirstName(mEtFirstName.getText().toString());
        person.setLastName(mEtLastName.getText().toString());
        person.setAge(Integer.valueOf(mEtAge.getText().toString()));

        mListener.onDetailFragmentFinish(person);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof DetailFragmentListener)
            mListener = (DetailFragmentListener) context;
    }

    public interface DetailFragmentListener {
        void onDetailFragmentFinish(Person person);
    }

}
