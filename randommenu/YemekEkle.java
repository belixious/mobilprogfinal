package com.example.randommenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;



public class YemekEkle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yemek_ekle);
        Intent intent= getIntent(); // MainActivity'den intent alındı.

        // Yemekleri rastgele çekebilmek için string listlere ihtiyaç duyduk.
        // Tekrar değiştirilememesi için final olarak ayarladık.
        // 3 farklı yemek türü olduğu için 3 farklı list oluşturduk.
        final ArrayList<String> anaYemek= new ArrayList<>();
        final ArrayList<String> araYemek= new ArrayList<>();
        final ArrayList<String> yanYemek= new ArrayList<>();

        // Ana, Ara ve Yan Yemek alanlarından yazılan yemek isimlerini
        // Çekebilmek için 3 farklı edittext değişkeni atadık.
        final EditText ana = (EditText) findViewById(R.id.editText_ana);
        final EditText ara = (EditText) findViewById(R.id.editText_ara);
        final EditText yan = (EditText) findViewById(R.id.editText_yan);

        // Edit texte yazılan değerleri button1 idli butona bastığımızda
        // Yukarıda oluşturduğumuz string listlere sırasıyla attık.
        ((Button) findViewById(R.id.button1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    anaYemek.add((ana.getText().toString()));
                    araYemek.add((ara.getText().toString()));
                    yanYemek.add((yan.getText().toString()));
            }
        });


        // Menü Oluştur activitysine geçerken rastgele yemek çekebilmek için
        // Intent kütüphanesinin "putStringArrayListExtra" methoduyla string
        // Array'lerini ilgili yerlerde kullanmak için çektik.
        ((Button) findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(YemekEkle.this, MenuOlustur.class);
                Intent mesaj1 = i.putStringArrayListExtra("mesaj1", anaYemek);
                Intent mesaj2 = i.putStringArrayListExtra("mesaj2", araYemek);
                Intent mesaj3 = i.putStringArrayListExtra("mesaj3", yanYemek);
                startActivity(i);
            }
        });
    }
}
