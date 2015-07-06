package com.example.tincho.trabajofinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class Tp9Activity extends AppCompatActivity {

    private ImageView imageViewObject;
    private ImageView imageViewOp2;
    private ImageView imageViewOp3;
    private ImageView imageViewOp4;
    private ImageView imageViewOp5;
    private ImageView imageViewOp1;
    private String option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp9);

        imageViewObject = (ImageView) findViewById(R.id.imageObject);

        imageViewOp1 = (ImageView) findViewById(R.id.imageL1);
        imageViewOp2 = (ImageView) findViewById(R.id.imageL2);
        imageViewOp3 = (ImageView) findViewById(R.id.imageL3);
        imageViewOp4 = (ImageView) findViewById(R.id.imageL4);
        imageViewOp5 = (ImageView) findViewById(R.id.imageL5);

        option = generateQuestion();



    }

    private String generateQuestion() {

        String[] list = new String[]{"bicicleta", "botellas", "burro", "casa", "cepillo", "cuna"
                , "dado", "dedo", "domino", "foca", "fuego", "gato", "gusano", "jirafa", "lapiz",
                "leche", "loro", "luna", "mano", "mesa", "mono", "muneca", "nube", "pato", "pera",
                "puerta", "raton", "reloj", "rueda", "silla", "tenedor", "tijera", "toro", "vaso",
                "Queso", "yoyo", "zapato", "zorro"};

        ArrayList<String> objects = new ArrayList<>();
        objects.addAll(Arrays.asList(list));

        Random r = new Random();

        return objects.get(r.nextInt(37));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tp9, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_tp5) {

            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            this.finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
