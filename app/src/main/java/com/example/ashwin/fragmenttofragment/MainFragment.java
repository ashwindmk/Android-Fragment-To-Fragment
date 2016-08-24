package com.example.ashwin.fragmenttofragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by ashwin on 24/8/16.
 */
public class MainFragment extends android.support.v4.app.Fragment implements View.OnClickListener{

    private Button mGoToFragment1, mGoBackToActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_main, container, false);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toast.makeText(getContext(), "Yippie main fragment created", Toast.LENGTH_SHORT).show();

        mGoToFragment1 = (Button) view.findViewById(R.id.goToFragment1);
        mGoToFragment1.setOnClickListener(this);

        mGoBackToActivity = (Button) view.findViewById(R.id.goBackToActivity);
        mGoBackToActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id) {

            case R.id.goToFragment1:
                Fragment fragment1 = new Fragment1();
                //Bundle bundle = getIntent().getExtras();
                //mainFragment.setArguments(bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container,fragment1);
                //fragmentTransaction.addToBackStack(this.getClass().getName());
                fragmentTransaction.commit();
                break;

            case R.id.goBackToActivity:
                getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                break;

        }
    }

}
