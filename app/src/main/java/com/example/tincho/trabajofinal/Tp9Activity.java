package com.example.tincho.trabajofinal;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;


public class Tp9Activity extends AppCompatActivity {

    private ImageView imageViewObject;
    private ImageView imageViewOp2;
    private ImageView imageViewOp3;
    private ImageView imageViewOp4;
    private ImageView imageViewOp5;
    private ImageView imageViewOp1;
    private String question;
    private MediaPlayer mpCorrectChar;
    private MediaPlayer mpObject;

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


        question = generateQuestion();

        playQuestionSound(question);

        ArrayList<String> options = generateOptionsArray();

        configImages(options);



    }

    private ArrayList<String> generateOptionsArray() {

        ArrayList<String> aoptions = new ArrayList<>();

        Random r = new Random();

        String alphabet = "abcdefghijklmnopqrstuvwxyz";


        //opciones B,D y tres aleatorias
        if (question.startsWith("b")) {
            aoptions.add("b");
            aoptions.add("d");

        }
        //opciones C,U y tres aleatorias
        if (question.startsWith("c")) {
            aoptions.add("c");
            aoptions.add("u");
        }
        //opciones D,P y tres aleatorias
        if (question.startsWith("d")) {
            aoptions.add("d");
            aoptions.add("p");
        }
        //opciones F,E y tres aleatorias
        if (question.startsWith("f")) {
            aoptions.add("f");
            aoptions.add("e");
        }
        //opciones G,O y tres aleatorias
        if (question.startsWith("g")) {
            aoptions.add("g");
            aoptions.add("o");
        }
        //opciones J,L y tres aleatorias
        if (question.startsWith("j")) {
            aoptions.add("j");
            aoptions.add("l");
        }
        //opciones L,J y tres aleatorias
        if (question.startsWith("l")) {
            aoptions.add("l");
            aoptions.add("j");
        }
        //opciones M,A y tres aleatorias
        if (question.startsWith("m")) {
            aoptions.add("m");
            aoptions.add("a");
        }
        //opciones N,M y tres aleatorias
        if (question.startsWith("n")) {
            aoptions.add("n");
            aoptions.add("m");
        }
        //opciones P,D y tres aleatorias
        if (question.startsWith("p")) {
            aoptions.add("p");
            aoptions.add("d");
        }
        //opciones Q,O y tres aleatorias
        if (question.startsWith("q")) {
            aoptions.add("q");
            aoptions.add("o");
        }
        //opciones R,P y tres aleatorias
        if (question.startsWith("r")) {
            aoptions.add("r");
            aoptions.add("p");
        }
        //opciones S,Z y tres aleatorias
        if (question.startsWith("s")) {
            aoptions.add("s");
            aoptions.add("z");
        }
        //opciones T,L y tres aleatorias
        if (question.startsWith("t")) {
            aoptions.add("t");
            aoptions.add("l");
        }
        //opciones V,U y tres aleatorias
        if (question.startsWith("v")) {
            aoptions.add("v");
            aoptions.add("u");
        }
        //opciones Y,V y tres aleatorias
        if (question.startsWith("y")) {
            aoptions.add("y");
            aoptions.add("v");
        }
        //opciones Z,S y tres aleatorias
        if (question.startsWith("z")) {
            aoptions.add("z");
            aoptions.add("s");
        }


        //Agrego las tres opciones aleatorias------------------------------------
        String e1 = String.valueOf(alphabet.charAt(r.nextInt(alphabet.length())));
        aoptions.add(e1);

        String e2 = String.valueOf(alphabet.charAt(r.nextInt(alphabet.length())));
        aoptions.add(e2);

        String e3 = String.valueOf(alphabet.charAt(r.nextInt(alphabet.length())));
        aoptions.add(e3);
        //-----------------------------------------------------------------------



        Collections.shuffle(aoptions);


        Log.d("TAGGG", "La letra correcta es:" + question);
        //LOG
        Iterator itr = aoptions.iterator();
        while (itr.hasNext()) {
            String element = (String) itr.next();
            Log.d("TAGGG", element);
        }

        return aoptions;

    }

    private void configImages(ArrayList<String> options) {

        int i = 1;
        ImageView imgVw = null;

        Iterator itr = options.iterator();

        while (itr.hasNext()) {

            switch (i) {
                case 1:
                    imgVw = imageViewOp1;
                    break;
                case 2:
                    imgVw = imageViewOp2;
                    break;
                case 3:
                    imgVw = imageViewOp3;
                    break;
                case 4:
                    imgVw = imageViewOp4;
                    break;
                case 5:
                    imgVw = imageViewOp5;
                    break;

            }


        }


    }

    private void playQuestionSound(String question) {

        if (mpCorrectChar != null) {
            mpCorrectChar.release();
            mpCorrectChar = null;
        }
        if (mpObject != null) {
            mpObject.release();
            mpObject = null;
        }


        if (question.equals("bicicleta")) {

            //Faltan los audios de las letras
            //mpCorrectChar = MediaPlayer.create(this, R.raw.letra_b);

            mpObject = MediaPlayer.create(this, R.raw.bicicleta);

        }
        if (question.equals("botellas")) {
            mpObject = MediaPlayer.create(this, R.raw.botellas);
        }
        if (question.equals("burro")) {
            mpObject = MediaPlayer.create(this, R.raw.burro);
        }
        if (question.equals("casa")) {
            mpObject = MediaPlayer.create(this, R.raw.casa);
        }
        if (question.equals("cepillo")) {
            mpObject = MediaPlayer.create(this, R.raw.cepillo);
        }
        if (question.equals("cuna")) {
            mpObject = MediaPlayer.create(this, R.raw.cuna);
        }
        if (question.equals("dado")) {
            mpObject = MediaPlayer.create(this, R.raw.dado);
        }
        if (question.equals("dedo")) {
            mpObject = MediaPlayer.create(this, R.raw.dedo);
        }
        if (question.equals("domino")) {
            mpObject = MediaPlayer.create(this, R.raw.domino);
        }
        if (question.equals("foca")) {
            mpObject = MediaPlayer.create(this, R.raw.foca);
        }
        if (question.equals("gato")) {
            mpObject = MediaPlayer.create(this, R.raw.gato);
        }
        if (question.equals("gusano")) {
            mpObject = MediaPlayer.create(this, R.raw.gusano);
        }
        if (question.equals("jirafa")) {
            mpObject = MediaPlayer.create(this, R.raw.jirafa);
        }
        if (question.equals("lapiz")) {
            mpObject = MediaPlayer.create(this, R.raw.lapiz);
        }
        if (question.equals("leche")) {
            mpObject = MediaPlayer.create(this, R.raw.leche);
        }
        if (question.equals("loro")) {
            mpObject = MediaPlayer.create(this, R.raw.loro);
        }
        if (question.equals("luna")) {
            mpObject = MediaPlayer.create(this, R.raw.luna);
        }
        if (question.equals("mano")) {
            mpObject = MediaPlayer.create(this, R.raw.mano);
        }
        if (question.equals("mesa")) {
            mpObject = MediaPlayer.create(this, R.raw.mesa);
        }
        if (question.equals("mono")) {
            mpObject = MediaPlayer.create(this, R.raw.mono);
        }
        if (question.equals("muneca")) {
            mpObject = MediaPlayer.create(this, R.raw.muneca);
        }
        if (question.equals("nube")) {
            mpObject = MediaPlayer.create(this, R.raw.nube);
        }
        if (question.equals("pato")) {
            mpObject = MediaPlayer.create(this, R.raw.pato);
        }
        if (question.equals("pera")) {
            mpObject = MediaPlayer.create(this, R.raw.pera);
        }
        if (question.equals("puerta")) {
            mpObject = MediaPlayer.create(this, R.raw.puerta);
        }
        if (question.equals("raton")) {
            mpObject = MediaPlayer.create(this, R.raw.raton);
        }
        if (question.equals("reloj")) {
            mpObject = MediaPlayer.create(this, R.raw.reloj);
        }
        if (question.equals("rueda")) {
            mpObject = MediaPlayer.create(this, R.raw.rueda);
        }
        if (question.equals("silla")) {
            mpObject = MediaPlayer.create(this, R.raw.silla);
        }
        if (question.equals("tenedor")) {
            mpObject = MediaPlayer.create(this, R.raw.tenedor);
        }
        if (question.equals("tijera")) {
            mpObject = MediaPlayer.create(this, R.raw.tijera);
        }
        if (question.equals("toro")) {
            mpObject = MediaPlayer.create(this, R.raw.toro);
        }
        if (question.equals("vaso")) {
            mpObject = MediaPlayer.create(this, R.raw.vaso);
        }
        if (question.equals("queso")) {
            mpObject = MediaPlayer.create(this, R.raw.queso);
        }
        if (question.equals("yoyo")) {
            mpObject = MediaPlayer.create(this, R.raw.yoyo);
        }
        if (question.equals("zapato")) {
            mpObject = MediaPlayer.create(this, R.raw.zapato);
        }
        if (question.equals("zorro")) {
            mpObject = MediaPlayer.create(this, R.raw.zorro);
        }

        mpObject.start();
    }

    private String generateQuestion() {

        String[] list = new String[]{"bicicleta", "botellas", "burro", "casa", "cepillo", "cuna"
                , "dado", "dedo", "domino", "foca", "fuego", "gato", "gusano", "jirafa", "lapiz",
                "leche", "loro", "luna", "mano", "mesa", "mono", "muneca", "nube", "pato", "pera",
                "puerta", "raton", "reloj", "rueda", "silla", "tenedor", "tijera", "toro", "vaso",
                "queso", "yoyo", "zapato", "zorro"};

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
