package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RedirectPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redirect_page);
    }

    public void redirect(View v1){
        int viewId = v1.getId();
        Intent intent=new Intent(Intent.ACTION_VIEW);
        if(viewId == R.id.sce){
            intent.setData(Uri.parse("https://saintgits.org/saintgits-college-of-engineering/"));
            startActivity(intent);
        }else if(viewId == R.id.scas){
            intent.setData(Uri.parse("https://saintgits.org/saintgits-college-of-applied-sciences/"));
            startActivity(intent);
        }else if(viewId == R.id.sims){
            intent.setData(Uri.parse("https://saintgits.org/saintgits-institute-of-management/"));
            startActivity(intent);
        }else if(viewId == R.id.sics){
            intent.setData(Uri.parse("https://saintgits.org/saintgits-institute-of-computer-applications/"));
            startActivity(intent);
        }
    }

    public void next(View v1)
    {
        Intent intent = new Intent(this, VisitCard.class);
        startActivity(intent);
    }

}

