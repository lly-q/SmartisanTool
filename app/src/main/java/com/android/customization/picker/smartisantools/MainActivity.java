package com.android.customization.picker.smartisantools;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.ComponentName;

import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;

import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import android.widget.Button;
import android.widget.Toast;

import com.vlstr.blurdialog.BlurDialog;




public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private View dialogView;
    private AlertDialog alertDialog;

    private BlurDialog blurDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        ClickListener();
        blurDialog.create(getWindow().getDecorView(), 20);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof BlurDialog) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    if (blurDialog.isVisibleToUser()) {
                        //Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
                        blurDialog.hide();
                    }
                }
            }
        }
        if (event.getAction() == MotionEvent.ACTION_CANCEL) {
                    if (blurDialog.isVisibleToUser()) {
                        //Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
                        blurDialog.hide();
                    }
        }

        return super.dispatchTouchEvent(event);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if (blurDialog.isVisibleToUser()) {
                //Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
                blurDialog.hide();
            }else {
                Toast.makeText(this,"再按一次退出程序",Toast.LENGTH_SHORT).show();
                onDestroy();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
        private void TextClick() {
        Uri uri = Uri.parse("http://hub.fastgit.org/loserq");//要跳转的网址
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
            }

    private void showAuthor() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        this.alertDialog = builder.create();
        dialogView = View.inflate(MainActivity.this,R.layout.author,null);
        alertDialog.setView(dialogView);
        alertDialog.show();
        alertDialog.getWindow().findViewById(R.id.github).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextClick();
            }
        });
    }

    private void ClickListener() {

        Intent intent1 = this.getPackageManager().getLaunchIntentForPackage("com.goodix.fingerprint.setting");

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComponentName componetName = new ComponentName(
                        "com.goodix.fingerprint.setting",  //这个是另外一个应用程序的包名
                        "com.goodix.fingerprint.setting.MainActivity");   //这个参数是要启动的Activity的全路径名

                try {
                    Intent intent = new Intent();
                    intent.setComponent(componetName);
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "可以在这里提示用户没有找到应用程序，或者是做其他的操作！",Toast.LENGTH_SHORT).show();
                }

            }

        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComponentName componetName = new ComponentName(
                        "com.android.settings",  //这个是另外一个应用程序的包名
                        "com.android.settings.Settings$PowerUsageSummaryActivity2");   //这个参数是要启动的Activity的全路径名

                try {
                    Intent intent = new Intent();
                    intent.setComponent(componetName);
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "可以在这里提示用户没有找到应用程序，或者是做其他的操作！",Toast.LENGTH_SHORT).show();
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComponentName componetName = new ComponentName(
                        "com.smartisanos.updater",  //这个是另外一个应用程序的包名
                        "com.smartisanos.updater.UpdatesCheck");   //这个参数是要启动的Activity的全路径名

                try {
                    Intent intent = new Intent();
                    intent.setComponent(componetName);
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "可以在这里提示用户没有找到应用程序，或者是做其他的操作！",Toast.LENGTH_SHORT).show();
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComponentName componetName = new ComponentName(
                        "com.bytedance.deltammi",  //这个是另外一个应用程序的包名
                        "com.bytedance.deltammi.framework.StartPhoneMMIActivity");   //这个参数是要启动的Activity的全路径名

                try {
                    Intent intent = new Intent();
                    intent.setComponent(componetName);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "启动成功，系统强制使用虚拟键，手势将禁用，请前往设置，多任务/到桌面/回上一级重新启用",Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "可以在这里提示用户没有找到应用程序，或者是做其他的操作！",Toast.LENGTH_SHORT).show();
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComponentName componetName = new ComponentName(
                        "com.android.customization.picker.smartisantools",  //这个是另外一个应用程序的包名
                        "com.android.customization.picker.smartisantools.EggActivity");   //这个参数是要启动的Activity的全路径名

                try {
                    Intent intent = new Intent();
                    intent.setComponent(componetName);
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "可以在这里提示用户没有找到应用程序，或者是做其他的操作！",Toast.LENGTH_SHORT).show();
                }
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComponentName componetName = new ComponentName(
                        "com.smartisanos.whiteboard",  //这个是另外一个应用程序的包名
                        "com.smartisanos.whiteboard.MainActivity");   //这个参数是要启动的Activity的全路径名

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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Setting:
                Intent intent = new Intent(this, AboutApp.class);
                startActivity(intent);
                break;
            case R.id.Author:
                blurDialog.show();
                blurDialog.requestFocus();
                break;


        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        blurDialog = findViewById(R.id.blurView);
    }
}