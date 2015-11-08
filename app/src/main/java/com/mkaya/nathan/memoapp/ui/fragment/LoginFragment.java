package com.mkaya.nathan.memoapp.ui.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.mkaya.nathan.memoapp.R;
import com.mkaya.nathan.memoapp.data.DataManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    LoginData loginData;
    EditText login;
    EditText pass;

    public LoginFragment() {
        // Required empty public constructor
    }

    public interface LoginData{
        public void Credentials(String name, String pass);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        login = (EditText) view.findViewById(R.id.login_username);
        pass = (EditText) view.findViewById(R.id.login_pass);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


}
