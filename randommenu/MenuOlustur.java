package com.example.randommenu;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;



import java.util.ArrayList;

public class MenuOlustur extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_olustur);

        // 3 farklı alanı doldurmak için 3 farklı intent ve
        // Bu değerleri programın amacı olan rastgele seçmek için
        // 3 farklı rastgele integer değer atandı.
        // Alanlara değer girilmemesi durumunda hataya neden olan bir durum
        // Saptandı. Bunun çözümü için, eğer alanlar boşsa belirecek 3 adet
        // Mesaj belirlendi. Aşağıdan da erişilmesi için final olarak 3 farklı
        // Stringe atama yapıldı.
        final Intent intent1= getIntent();
        final Intent intent2= getIntent();
        final Intent intent3= getIntent();
        final Random i1= new Random();
        final Random i2= new Random();
        final Random i3= new Random();
        final String err1= new String("Ana Yemek Girilmedi");
        final String err2= new String("Ara Yemek Girilmedi");
        final String err3= new String("Yan Yemek Girilmedi");

        ((Button) findViewById(R.id.olustur_butonu)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Yemek Ekle Activity'sinden gelen string arrayleri teker teker alındı.
                // Textview'ların idleri çekildi.
                // Dizi boyutları maksimum alınarak rastgele sayılar oluşturuldu.
                // Text alanlarına string listlerden rastgele indisli değerler atandı.
                ArrayList<String> s1= intent1.getStringArrayListExtra("mesaj1");
                ArrayList<String> s2= intent2.getStringArrayListExtra("mesaj2");
                ArrayList<String> s3= intent3.getStringArrayListExtra("mesaj3");
                TextView t1= (TextView) findViewById(R.id.textView_ana);
                TextView t2= (TextView) findViewById(R.id.textView_ara);
                TextView t3= (TextView) findViewById(R.id.textView_yan);

                // Yemek ekle kısımlarında giriş yapılmadığı takdirde programın hata vermemesi
                // İçin bir if statement eklendi.
                if (s1!= null) {
                    int boyDizi1 = i1.nextInt(s1.size());
                    int boyDizi2 = i2.nextInt(s2.size());
                    int boyDizi3 = i3.nextInt(s3.size());

                    t1.setText(s1.get(boyDizi1));
                    t2.setText(s2.get(boyDizi2));
                    t3.setText(s3.get(boyDizi3));
                }
                else if (s1== null) {
                    t1.setText(err1);
                    t2.setText(err2);
                    t3.setText(err3);
                }



            }
        });

    }
}
