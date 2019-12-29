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

        // Yemekleri rastgele çekebilmesi için string listlere ihtiyaç duyuldu.
        // Tekrar değiştirilememesi için final olarak ayarlandı.
        // 3 farklı yemek türü olduğu için 3 farklı list oluşturuldu.
        final ArrayList<String> anaYemek= new ArrayList<>();
        final ArrayList<String> araYemek= new ArrayList<>();
        final ArrayList<String> yanYemek= new ArrayList<>();

        // Ana, Ara ve Yan Yemek alanlarından yazılan yemek isimlerini
        // Çekebilmek için 3 farklı edittext değişkeni atandı.
        final EditText ana = (EditText) findViewById(R.id.editText_ana);
        final EditText ara = (EditText) findViewById(R.id.editText_ara);
        final EditText yan = (EditText) findViewById(R.id.editText_yan);

        // Edit texte yazılan değerler button1 idli butona basıldığında
        // Yukarıda oluşturulan string listlere sırasıyla atandı.
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
        // Array'leri ilgili yerlerde kullanılmak için çekildi.
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
