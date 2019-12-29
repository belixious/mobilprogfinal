package com.example.randommenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Options menüsünden seçim yapıldıktan sonra intent kullanarak
    // İstenilen activity'ye geçiş sağlandı.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_ekle:
                Intent intent= new Intent(MainActivity.this, YemekEkle.class);
                        startActivity(intent);
                return true;
            case R.id.option_olustur:
                Intent intent1= new Intent(MainActivity.this, MenuOlustur.class);
                        startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
