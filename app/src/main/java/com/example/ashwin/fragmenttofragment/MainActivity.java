package com.example.ashwin.fragmenttofragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToMainFragment(View view) {
        Fragment mainFragment = new MainFragment();
        //Bundle bundle = getIntent().getExtras();
        //mainFragment.setArguments(bundle);
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, mainFragment);
        //fragmentTransaction.addToBackStack(this.getClass().getName());
        fragmentTransaction.commit();

    }

}
