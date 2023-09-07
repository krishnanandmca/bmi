package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    TextView t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText)findViewById(R.id.e1);
        e2 = (EditText)findViewById(R.id.e2);
        t2 = (TextView)findViewById(R.id.t2);

    }

    public void onUserClick(View v1){

        float h,w,res=0;
        h = Float.parseFloat(e1.getText().toString());
        w = Float.parseFloat(e2.getText().toString());

        h = h/100;
        res = w/(h*h);


        if(res < 18.5){
            t2.setText("Underweight");
        }else if(res >= 18.5 && res <=24.9){
            t2.setText("Normal");
        }else if(res >=25.0 && res <=29.9){
            t2.setText("Overweight");
        }else{
            t2.setText("Obese");
        }

    }

    public void go(View v1){
        Intent intent = new Intent(this, RedirectPage.class);
        startActivity(intent);
    }
}