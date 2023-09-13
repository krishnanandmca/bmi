package com.example.bmi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Locale;

public class SpeechActivity extends AppCompatActivity {

    EditText t;
    Button b;
    TextToSpeech ts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech);
        t=findViewById(R.id.t1);
        b=findViewById(R.id.button);




        ts= new TextToSpeech(getApplicationContext(),new TextToSpeech.OnInitListener(){
            public void onInit(int i){
                if(i!=TextToSpeech.ERROR){
                    ts.setLanguage(Locale.UK);
                }
            }
        });
    }

    public void textspeak(View view) {
        ts.speak(t.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
    }
}