package com.android.customization.picker.smartisantools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EggActivity extends AppCompatActivity {
    private Button button7;
    private Button button8;
    private Button button9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egg);
        initView();
        eggListener();
    }

    private void eggListener() {
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComponentName componetName = new ComponentName(
                        "com.android.systemui",  //这个是另外一个应用程序的包名
                        "com.android.systemui.DessertCase");   //这个参数是要启动的Activity的全路径名

                try {
                    Intent intent = new Intent();
                    intent.setComponent(componetName);
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "可以在这里提示用户没有找到应用程序，或者是做其他的操作！",Toast.LENGTH_SHORT).show();
                }

            }

        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComponentName componetName = new ComponentName(
                        "com.android.systemui",  //这个是另外一个应用程序的包名
                        "com.android.systemui.egg.MLandActivity");   //这个参数是要启动的Activity的全路径名

                try {
                    Intent intent = new Intent();
                    intent.setComponent(componetName);
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "可以在这里提示用户没有找到应用程序，或者是做其他的操作！",Toast.LENGTH_SHORT).show();
                }

            }

        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComponentName componetName = new ComponentName(
                        "com.android.egg",  //这个是另外一个应用程序的包名
                        "com.android.egg.quares.QuaresActivity");   //这个参数是要启动的Activity的全路径名

                try {
                    Intent intent = new Intent();
                    intent.setComponent(componetName);
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "可以在这里提示用户没有找到应用程序，或者是做其他的操作！",Toast.LENGTH_SHORT).show();
                }

            }

        });
    }

    private void initView() {
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
    }
}