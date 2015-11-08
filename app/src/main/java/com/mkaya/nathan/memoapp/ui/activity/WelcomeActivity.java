package com.mkaya.nathan.memoapp.ui.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.mkaya.nathan.memoapp.R;
import com.mkaya.nathan.memoapp.data.DataManager;
import com.mkaya.nathan.memoapp.data.model.Message;
import com.mkaya.nathan.memoapp.ui.fragment.LoginFragment;
import com.mkaya.nathan.memoapp.ui.fragment.RegisterFragment;
import com.mkaya.nathan.memoapp.ui.fragment.WelcomeActivityFragment;


public class WelcomeActivity extends AppCompatActivity {
    DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Fragment welcome = new WelcomeActivityFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment, welcome).commit();

        dataManager = new DataManager();
    }

    public void register(View view) {
        // startActivity(new Intent(this, SignupActivity.class));
        Fragment register = new RegisterFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment, register).addToBackStack(null).commit();
    }

    public void login(View view) {
        // startActivity(new Intent(this, LoginActivity.class));

        Fragment login = new LoginFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment, login).addToBackStack(null).commit();
        //dataManager.RxtryAuth();
        dataManager.tryAuth();
    }

    public void trylog(Message message){
        try {
            if (message.message!=null){
                Log.i("Message: ", message.toString());
            }
        }finally {
            Log.i("Message: ", message.Error);
        }
    }
}
