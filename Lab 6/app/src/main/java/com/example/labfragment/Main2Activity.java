package com.example.labfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity{

    FragmentManager fragmentManager;
    RightFragment rightFragment;
    LogOutListener logOutListener;
    static Context context;
//    static SharedPreferences sharedPreferences;
//    SelectedElem selectedElem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
//        Mail mail = getIntent().getParcelableExtra("mail");
        setContentView(R.layout.activity_main2);
        fragmentManager = getSupportFragmentManager();
        rightFragment = new RightFragment();
        fragmentManager.beginTransaction()
                .add(R.id.left_container , new MainFragment())
                .add(R.id.right_container , rightFragment).commit();
    }

    public void logOut(View v){
        Log.e("my" , "Log out");
        logOutListener = (LogOutListener)MainActivity.context;
        logOutListener.out();
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
        finish();
    }



    public interface LogOutListener{
        void out();
    }
}
