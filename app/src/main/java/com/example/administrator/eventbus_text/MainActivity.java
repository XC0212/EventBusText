package com.example.administrator.eventbus_text;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    Button mButton;
    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton= (Button) findViewById(R.id.main_btn);
        mTextView= (TextView) findViewById(R.id.main_text);
        EventBus.getDefault().register(this);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecontActivity.class);
                startActivity(intent);
            }
        });


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(MessageEvent event){
        String msg=event.getMessage();
        Toast.makeText(this, event.getMessage(), Toast.LENGTH_SHORT).show();
        mTextView.setText(msg);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
