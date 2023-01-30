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

public class harita1 extends AppCompatActivity {
    ImageView imageView;
    EditText editText;
    TextView textView;
    TextView textView2;
    Button button;
    int skor=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harita1);
        imageView=findViewById(R.id.imageView);
        editText=findViewById(R.id.editcevap);
        button=findViewById(R.id.btntikla);
        textView=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView6);


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
                Intent intent=new Intent(harita1.this,harita3.class);
                intent.putExtra("puan:",skor);
                startActivity(intent);
            }
        }.start();

        final String cevap ="ankara";
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().matches(cevap)){

                    Toast.makeText(harita1.this,"DOĞRU CEVAP",Toast.LENGTH_LONG).show();
                    skor=skor+10;
                    textView2.setText("puan:"+skor);
                    Intent intent=new Intent(harita1.this,harita3.class);
                    intent.putExtra("puan",skor);
                    startActivity(intent);

                }else{
                    Toast.makeText(harita1.this,"YANLIŞ CEVAP VERDİNİZ !!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
