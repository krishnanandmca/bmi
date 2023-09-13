package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class PalindromeActivity extends AppCompatActivity implements View.OnClickListener{
    Button b,b2;
    EditText e1;
    TextView t1, t2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindrome);

        b = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        e1 = (EditText)findViewById(R.id.e1);
        t1 = (TextView)findViewById((R.id.t1));
        t2 = (TextView)findViewById((R.id.t2));




        b2.setOnClickListener(this);


        b.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 int rev = 0,sum=0, n = Integer.parseInt(e1.getText().toString());

                 while(n>0){
                     rev = n%10;
                     sum = sum*10+rev;
                     n = n/10;
                 }

                 t1.setText(String.valueOf(sum));

             }
    });
}

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.b2) {
            if(Integer.parseInt(e1.getText().toString()) == Integer.parseInt(t1.getText().toString())){
                t2.setText("Palindrome");
            }else{
                t2.setText("Not Palindrome");
            }
        }

    }
}