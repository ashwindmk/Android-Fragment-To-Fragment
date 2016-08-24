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
public class Fragment1 extends android.support.v4.app.Fragment implements View.OnClickListener {

    private Button mGoToActivity, mGoBackToMainFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_1, container, false);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toast.makeText(getContext(), "Yippie fragment 1 created", Toast.LENGTH_SHORT).show();

        mGoToActivity = (Button) view.findViewById(R.id.goToActivity);
        mGoToActivity.setOnClickListener(this);

        mGoBackToMainFragment = (Button) view.findViewById(R.id.goBackToMainFragment);
        mGoBackToMainFragment.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id) {

            case R.id.goToActivity:
                getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                break;

            case R.id.goBackToMainFragment:
                Fragment mainFragment = new MainFragment();
                //Bundle bundle = getIntent().getExtras();
                //mainFragment.setArguments(bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, mainFragment);
                //fragmentTransaction.addToBackStack(this.getClass().getName());
                fragmentTransaction.commit();
                break;

        }
    }
}
