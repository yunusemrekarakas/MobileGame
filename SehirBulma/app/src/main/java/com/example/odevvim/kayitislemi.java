package com.example.odevvim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class kayitislemi extends AppCompatActivity {
    EditText kayitmail;
    EditText kayitsifre;
    EditText kullanici;
    Button kayit;
    private FirebaseAuth kayitolma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayitislemi);
        kayitmail=findViewById(R.id.kayitmail);
        kayitsifre=findViewById(R.id.kayitsifre);
        kayit=findViewById(R.id.kayıt);
        kayitolma=FirebaseAuth.getInstance();

        kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mailkayit= kayitmail.getText().toString();
                String sifrekayit= kayitsifre.getText().toString();
                String kullanicikayit=kullanici.getText().toString();

                if(TextUtils.isEmpty(mailkayit)){
                    Toast.makeText( getApplicationContext(),"lütfen boş gecmeyin !",Toast.LENGTH_LONG).show();

                }else if(TextUtils.isEmpty(sifrekayit)){
                    Toast.makeText( getApplicationContext(),"lütfen boş gecmeyin !",Toast.LENGTH_LONG).show();

                }else{

                   kayitolma.createUserWithEmailAndPassword(mailkayit,sifrekayit).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {

                           if(task.isSuccessful()){

                               Toast.makeText( kayitislemi.this,"HESABINIZ OLUŞTURULDU",Toast.LENGTH_LONG).show();
                               Intent intent=new Intent(kayitislemi.this,MainActivity.class);
                               startActivity(intent);
                           }else{
                               Toast.makeText( kayitislemi.this,"BİR HATA OLUŞTU!",Toast.LENGTH_LONG).show();
                           }
                       }
                   });
                }
            }
        });
    }
}
