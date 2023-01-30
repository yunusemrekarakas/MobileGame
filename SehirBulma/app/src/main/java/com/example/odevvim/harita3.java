package com.example.odevvim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class harita3 extends AppCompatActivity {
    ImageView imageView;
    EditText editText;
    TextView textView;
    Button button;
    TextView textView2;
    int skor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harita3);

        imageView=findViewById(R.id.imageView3);
        editText=findViewById(R.id.editText2);
        button=findViewById(R.id.button2);
        textView=findViewById(R.id.textView4);
         textView2=findViewById(R.id.textView10);

        final String cevap="istanbul";

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().matches(cevap)){

                    Toast.makeText(harita3.this,"DOĞRU CEVAP",Toast.LENGTH_LONG).show();
                    skor=skor+10;
                    textView2.setText("puan:"+skor);

                }else{
                    Toast.makeText(harita3.this,"YANLIŞ CEVAP VERDİNİZ !",Toast.LENGTH_LONG).show();
                }
            }
        });
        new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText("KALAN SÜRE:"+millisUntilFinished/1000);

            }
            @Override
            public void onFinish() {
                textView.setText("SÜRENİZ BİTTİ !");
                skor=skor-5;
                textView2.setText("puan:"+skor);

            }
        }.start();

    }
}


