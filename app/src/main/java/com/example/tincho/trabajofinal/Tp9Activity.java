package com.example.tincho.trabajofinal;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
    private MediaPlayer mpCorrectAnswer;
    private MediaPlayer mpWrongAnswer;
    private int correctAnswer;

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


        imageViewOp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (correctAnswer == 1) {
                    //Es correcta
                    Log.d("TAGGG", "CORRECTA");
                    playCorrectAnswer();
                    imageViewOp1.setColorFilter(Color.parseColor("#00E676"), PorterDuff.Mode.MULTIPLY);
                    startAgain();

                } else {
                    playWrongAnswer();
                }
            }
        });
        imageViewOp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (correctAnswer == 2) {
                    //Es correcta
                    Log.d("TAGGG", "CORRECTA");
                    playCorrectAnswer();
                    imageViewOp2.setColorFilter(Color.parseColor("#00E676"), PorterDuff.Mode.MULTIPLY);
                    startAgain();
                } else {
                    playWrongAnswer();
                }
            }
        });
        imageViewOp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (correctAnswer == 3) {
                    //Es correcta
                    Log.d("TAGGG", "CORRECTA");
                    playCorrectAnswer();
                    imageViewOp3.setColorFilter(Color.parseColor("#00E676"), PorterDuff.Mode.MULTIPLY);
                    startAgain();
                } else {
                    playWrongAnswer();
                }
            }
        });
        imageViewOp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (correctAnswer == 4) {
                    //Es correcta
                    Log.d("TAGGG", "CORRECTA");
                    playCorrectAnswer();
                    imageViewOp4.setColorFilter(Color.parseColor("#00E676"), PorterDuff.Mode.MULTIPLY);
                    startAgain();
                } else {
                    playWrongAnswer();
                }
            }
        });
        imageViewOp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (correctAnswer == 5) {
                    //Es correcta
                    Log.d("TAGGG", "CORRECTA");
                    playCorrectAnswer();
                    imageViewOp5.setColorFilter(Color.parseColor("#00E676"), PorterDuff.Mode.MULTIPLY);
                    startAgain();
                } else {
                    playWrongAnswer();
                }
            }
        });

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
        //y si ya están contenidas en el array las vuelvo a generar
        //para que no se repitan
        String e1 = String.valueOf(alphabet.charAt(r.nextInt(alphabet.length())));
        String e2 = String.valueOf(alphabet.charAt(r.nextInt(alphabet.length())));
        String e3 = String.valueOf(alphabet.charAt(r.nextInt(alphabet.length())));

        while (aoptions.contains(e1)) {
            e1 = String.valueOf(alphabet.charAt(r.nextInt(alphabet.length())));
        }
        aoptions.add(e1);
        while (aoptions.contains(e2)) {
            e2 = String.valueOf(alphabet.charAt(r.nextInt(alphabet.length())));
        }
        aoptions.add(e2);
        while (aoptions.contains(e3)) {
            e1 = String.valueOf(alphabet.charAt(r.nextInt(alphabet.length())));
        }
        aoptions.add(e3);

        //-----------------------------------------------------------------------



        Collections.shuffle(aoptions);


        //Busco la ubicación de la letra correcta y le sumo 1
        correctAnswer = aoptions.indexOf(question.substring(0, 1)) + 1;

        Log.d("TAGGG", "El objeto es:" + question);
        Log.d("TAGGG", "La correcta es:" + correctAnswer);
        //LOG
        Iterator itr = aoptions.iterator();
        while (itr.hasNext()) {
            String element = (String) itr.next();
            Log.d("TAGGG", element);
        }

        return aoptions;

    }

    private void configImages(ArrayList<String> options) {


        //Primero configuro la imagen del objeto:
        if (question.equals("bicicleta")) {
            imageViewObject.setImageResource(R.drawable.bicicleta);
        }
        if (question.equals("botellas")) {
            imageViewObject.setImageResource(R.drawable.botellas);
        }
        if (question.equals("burro")) {
            imageViewObject.setImageResource(R.drawable.burro);
        }
        if (question.equals("casa")) {
            imageViewObject.setImageResource(R.drawable.casa);
        }
        if (question.equals("cepillo")) {
            imageViewObject.setImageResource(R.drawable.cepillo);
        }
        if (question.equals("cuna")) {
            imageViewObject.setImageResource(R.drawable.cuna);
        }
        if (question.equals("dado")) {
            imageViewObject.setImageResource(R.drawable.dado);
        }
        if (question.equals("dedo")) {
            imageViewObject.setImageResource(R.drawable.dedo);
        }
        if (question.equals("domino")) {
            imageViewObject.setImageResource(R.drawable.domino);
        }
        if (question.equals("foca")) {
            imageViewObject.setImageResource(R.drawable.foca);
        }
        if (question.equals("fuego")) {
            imageViewObject.setImageResource(R.drawable.fuego);
        }
        if (question.equals("gato")) {
            imageViewObject.setImageResource(R.drawable.gato);
        }
        if (question.equals("gusano")) {
            imageViewObject.setImageResource(R.drawable.gusano);
        }
        if (question.equals("jirafa")) {
            imageViewObject.setImageResource(R.drawable.jirafa);
        }
        if (question.equals("lapiz")) {
            imageViewObject.setImageResource(R.drawable.lapiz);
        }
        if (question.equals("leche")) {
            imageViewObject.setImageResource(R.drawable.leche);
        }
        if (question.equals("loro")) {
            imageViewObject.setImageResource(R.drawable.loro);
        }
        if (question.equals("luna")) {
            imageViewObject.setImageResource(R.drawable.luna);
        }
        if (question.equals("mano")) {
            imageViewObject.setImageResource(R.drawable.mano);
        }
        if (question.equals("mesa")) {
            imageViewObject.setImageResource(R.drawable.mesa);
        }
        if (question.equals("mono")) {
            imageViewObject.setImageResource(R.drawable.mono);
        }
        if (question.equals("muneca")) {
            imageViewObject.setImageResource(R.drawable.mueca);
        }
        if (question.equals("nube")) {
            imageViewObject.setImageResource(R.drawable.nube);
        }
        if (question.equals("pato")) {
            imageViewObject.setImageResource(R.drawable.pato);
        }
        if (question.equals("pera")) {
            imageViewObject.setImageResource(R.drawable.pera);
        }
        if (question.equals("puerta")) {
            imageViewObject.setImageResource(R.drawable.puerta);
        }
        if (question.equals("raton")) {
            imageViewObject.setImageResource(R.drawable.raton);
        }
        if (question.equals("reloj")) {
            imageViewObject.setImageResource(R.drawable.reloj);
        }
        if (question.equals("rueda")) {
            imageViewObject.setImageResource(R.drawable.rueda);
        }
        if (question.equals("silla")) {
            imageViewObject.setImageResource(R.drawable.silla);
        }
        if (question.equals("tenedor")) {
            imageViewObject.setImageResource(R.drawable.tenedor);
        }
        if (question.equals("tijera")) {
            imageViewObject.setImageResource(R.drawable.tijera);
        }
        if (question.equals("toro")) {
            imageViewObject.setImageResource(R.drawable.toro);
        }
        if (question.equals("vaso")) {
            imageViewObject.setImageResource(R.drawable.vaso);
        }
        if (question.equals("queso")) {
            imageViewObject.setImageResource(R.drawable.queso);
        }
        if (question.equals("yoyo")) {
            imageViewObject.setImageResource(R.drawable.yoyo);
        }
        if (question.equals("zapato")) {
            imageViewObject.setImageResource(R.drawable.zapato);
        }
        if (question.equals("zorro")) {
            imageViewObject.setImageResource(R.drawable.zorro);
        }



        int i = 1;
        ImageView imgVw = null;

        Iterator itr = options.iterator();

        while (itr.hasNext()) {
            String element = (String) itr.next();

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

            if (element.equals("a")) {
                imgVw.setImageResource(R.drawable.a);
            }
            if (element.equals("b")) {
                imgVw.setImageResource(R.drawable.bb);
            }
            if (element.equals("c")) {
                imgVw.setImageResource(R.drawable.c);
            }
            if (element.equals("d")) {
                imgVw.setImageResource(R.drawable.d);
            }
            if (element.equals("e")) {
                imgVw.setImageResource(R.drawable.e);
            }
            if (element.equals("f")) {
                imgVw.setImageResource(R.drawable.f);
            }
            if (element.equals("g")) {
                imgVw.setImageResource(R.drawable.g);
            }
            if (element.equals("h")) {
                imgVw.setImageResource(R.drawable.h);
            }
            if (element.equals("i")) {
                imgVw.setImageResource(R.drawable.i);
            }
            if (element.equals("j")) {
                imgVw.setImageResource(R.drawable.j);
            }
            if (element.equals("k")) {
                imgVw.setImageResource(R.drawable.k);
            }
            if (element.equals("l")) {
                imgVw.setImageResource(R.drawable.l);
            }
            if (element.equals("m")) {
                imgVw.setImageResource(R.drawable.m);
            }
            if (element.equals("n")) {
                imgVw.setImageResource(R.drawable.n);
            }
            if (element.equals("o")) {
                imgVw.setImageResource(R.drawable.o);
            }
            if (element.equals("p")) {
                imgVw.setImageResource(R.drawable.p);
            }
            if (element.equals("q")) {
                imgVw.setImageResource(R.drawable.q);
            }
            if (element.equals("r")) {
                imgVw.setImageResource(R.drawable.r);
            }
            if (element.equals("s")) {
                imgVw.setImageResource(R.drawable.s);
            }
            if (element.equals("t")) {
                imgVw.setImageResource(R.drawable.t);
            }
            if (element.equals("u")) {
                imgVw.setImageResource(R.drawable.u);
            }
            if (element.equals("v")) {
                imgVw.setImageResource(R.drawable.v);
            }
            if (element.equals("w")) {
                imgVw.setImageResource(R.drawable.w);
            }
            if (element.equals("x")) {
                imgVw.setImageResource(R.drawable.x);
            }
            if (element.equals("y")) {
                imgVw.setImageResource(R.drawable.y);
            }
            if (element.equals("z")) {
                imgVw.setImageResource(R.drawable.z);
            }

            i = i + 1;
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
        if (question.equals("fuego")) {
            mpObject = MediaPlayer.create(this, R.raw.fuego);
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

    private void startAgain() {

        //Espero 3 segundos------------------
        Runnable r = new Runnable() {
            @Override
            public void run() {
                //Reseteo los colores
                imageViewOp1.setColorFilter(null);
                imageViewOp2.setColorFilter(null);
                imageViewOp3.setColorFilter(null);
                imageViewOp4.setColorFilter(null);
                imageViewOp5.setColorFilter(null);

                //Recargo los componentes
                question = generateQuestion();

                playQuestionSound(question);

                ArrayList<String> options = generateOptionsArray();

                configImages(options);

            }
        };

        Handler h = new Handler();
        h.postDelayed(r, 3000);
        //-----------------------------------


    }

    private void playCorrectAnswer() {


        if (mpCorrectAnswer == null) {
            mpCorrectAnswer = MediaPlayer.create(this, R.raw.bien);
        }
        if (mpCorrectAnswer.isPlaying()) {
            mpCorrectAnswer.seekTo(0);
        } else {
            mpCorrectAnswer.start();
        }
    }

    private void playWrongAnswer() {
        if (mpWrongAnswer == null) {
            mpWrongAnswer = MediaPlayer.create(this, R.raw.error2);
        }
        if (mpWrongAnswer.isPlaying()) {
            mpWrongAnswer.seekTo(0);
        } else {
            mpWrongAnswer.start();
        }

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

    @Override
    protected void onPause() {
        super.onPause();
        if (mpCorrectAnswer != null) {
            mpCorrectAnswer.release();
            mpCorrectAnswer = null;
        }
        if (mpWrongAnswer != null) {
            mpWrongAnswer.release();
            mpWrongAnswer = null;
        }
        if (mpObject != null) {
            mpObject.release();
            mpObject = null;
        }

        if (mpCorrectChar != null) {
            mpCorrectChar.release();
            mpCorrectChar = null;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        playQuestionSound(question);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mpCorrectAnswer != null) {
            mpCorrectAnswer.release();
            mpCorrectAnswer = null;
        }
        if (mpWrongAnswer != null) {
            mpWrongAnswer.release();
            mpWrongAnswer = null;
        }
        if (mpObject != null) {
            mpObject.release();
            mpObject = null;
        }

        if (mpCorrectChar != null) {
            mpCorrectChar.release();
            mpCorrectChar = null;
        }


    }
}
