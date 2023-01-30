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

public class MainActivity<FirebaseAut> extends AppCompatActivity {
    EditText editkullanici;
    EditText editsifre;
    Button btngiris;
    Button kayitolma;
    private FirebaseAuth login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btngiris=findViewById(R.id.btngiris);
        editkullanici=findViewById(R.id.editkullanici);
        editsifre=findViewById(R.id.editsifre);
        kayitolma=findViewById(R.id.btnkayitişlemi);
        login=FirebaseAuth.getInstance();
        kayitolma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,kayitislemi.class);
                startActivity(intent);
            }
        });
        btngiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                girisislemi();
            }
            private void girisislemi() {
                String email=editsifre.getText().toString();
                String kullanici=editkullanici.getText().toString();
                if(TextUtils.isEmpty(email)){
                    Toast.makeText( getApplicationContext(),"lütfen boş gecmeyin !",Toast.LENGTH_LONG).show();
                }else if (TextUtils.isEmpty(kullanici)){
                    Toast.makeText( getApplicationContext(),"lütfen boş gecmeyin !",Toast.LENGTH_LONG).show();
                }else  {
                    login.createUserWithEmailAndPassword(email,kullanici).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                         if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"GİRİŞ BAŞARILI",Toast.LENGTH_LONG).show();
                             Intent intent=new Intent(MainActivity.this,harita1.class);
                             startActivity(intent);
                         }else{
                             Toast.makeText(MainActivity.this,"YANLIŞ GİRİŞ YAPTINIZ",Toast.LENGTH_LONG).show();
                         }
                        }
                    });
                }
            }
        });
    }
}