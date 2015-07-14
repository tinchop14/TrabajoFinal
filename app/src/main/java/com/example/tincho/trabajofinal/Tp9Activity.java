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
    private ArrayList<String> objects;

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
                    //No recibo más clicks porque más adelante voy a hacer una espera
                    //de 3 segundos
                    cancelClicks();
                    //----------------------------------------------------------------

                    Log.d("TAGGG", "CORRECTA");
                    imageViewOp1.setColorFilter(Color.parseColor("#00E676"), PorterDuff.Mode.MULTIPLY);
                    playCorrectAnswer();
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
                    cancelClicks();
                    Log.d("TAGGG", "CORRECTA");
                    imageViewOp2.setColorFilter(Color.parseColor("#00E676"), PorterDuff.Mode.MULTIPLY);
                    playCorrectAnswer();
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
                    cancelClicks();
                    Log.d("TAGGG", "CORRECTA");
                    imageViewOp3.setColorFilter(Color.parseColor("#00E676"), PorterDuff.Mode.MULTIPLY);
                    playCorrectAnswer();
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
                    cancelClicks();
                    Log.d("TAGGG", "CORRECTA");
                    imageViewOp4.setColorFilter(Color.parseColor("#00E676"), PorterDuff.Mode.MULTIPLY);
                    playCorrectAnswer();
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
                    cancelClicks();
                    Log.d("TAGGG", "CORRECTA");
                    imageViewOp5.setColorFilter(Color.parseColor("#00E676"), PorterDuff.Mode.MULTIPLY);
                    playCorrectAnswer();
                    startAgain();

                } else {
                    playWrongAnswer();
                }
            }
        });

        question = generateQuestion();
        ArrayList<String> options = generateOptionsArray();
        playQuestionSound(question);
        configImages(options);


    }

    private void cancelClicks() {
        imageViewOp1.setClickable(false);
        imageViewOp2.setClickable(false);
        imageViewOp3.setClickable(false);
        imageViewOp4.setClickable(false);
        imageViewOp5.setClickable(false);
    }


    private ArrayList<String> generateOptionsArray() {

        ArrayList<String> aoptions = new ArrayList<>();

        Random r = new Random();

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        //Reutilizo esta parte de código para generar el audio de la letra correcta
        if (mpCorrectChar != null) {
            mpCorrectChar.release();
            mpCorrectChar = null;
        }

        //opciones B,D y tres aleatorias
        if (question.startsWith("b")) {
            mpCorrectChar = MediaPlayer.create(this, R.raw.b);
            aoptions.add("b");
            aoptions.add("d");
        }
        //opciones C,U y tres aleatorias
        else if (question.startsWith("c")) {
            mpCorrectChar = MediaPlayer.create(this, R.raw.c);
            aoptions.add("c");
            aoptions.add("u");
        }
        //opciones D,P y tres aleatorias
        else if (question.startsWith("d")) {
            mpCorrectChar = MediaPlayer.create(this, R.raw.d);
            aoptions.add("d");
            aoptions.add("p");
        }
        //opciones F,E y tres aleatorias
        else if (question.startsWith("f")) {
            mpCorrectChar = MediaPlayer.create(this, R.raw.f);
            aoptions.add("f");
            aoptions.add("e");
        }
        //opciones G,O y tres aleatorias
        else if (question.startsWith("g")) {
            mpCorrectChar = MediaPlayer.create(this, R.raw.g);
            aoptions.add("g");
            aoptions.add("o");
        }
        //opciones J,L y tres aleatorias
        else if (question.startsWith("j")) {
            mpCorrectChar = MediaPlayer.create(this, R.raw.j);
            aoptions.add("j");
            aoptions.add("l");
        }
        //opciones L,J y tres aleatorias
        else if (question.startsWith("l")) {
            mpCorrectChar = MediaPlayer.create(this, R.raw.l);
            aoptions.add("l");
            aoptions.add("j");
        }
        //opciones M,A y tres aleatorias
        else if (question.startsWith("m")) {
            mpCorrectChar = MediaPlayer.create(this, R.raw.m);
            aoptions.add("m");
            aoptions.add("a");
        }
        //opciones N,M y tres aleatorias
        else if (question.startsWith("n")) {
            mpCorrectChar = MediaPlayer.create(this, R.raw.n);
            aoptions.add("n");
            aoptions.add("m");
        }
        //opciones P,D y tres aleatorias
        else if (question.startsWith("p")) {
            mpCorrectChar = MediaPlayer.create(this, R.raw.p);
            aoptions.add("p");
            aoptions.add("d");
        }
        //opciones Q,O y tres aleatorias
        else if (question.startsWith("q")) {
            mpCorrectChar = MediaPlayer.create(this, R.raw.q);
            aoptions.add("q");
            aoptions.add("o");
        }
        //opciones R,P y tres aleatorias
        else if (question.startsWith("r")) {
            mpCorrectChar = MediaPlayer.create(this, R.raw.r);
            aoptions.add("r");
            aoptions.add("p");
        }
        //opciones S,Z y tres aleatorias
        else if (question.startsWith("s")) {
            mpCorrectChar = MediaPlayer.create(this, R.raw.s);
            aoptions.add("s");
            aoptions.add("z");
        }
        //opciones T,L y tres aleatorias
        else if (question.startsWith("t")) {
            mpCorrectChar = MediaPlayer.create(this, R.raw.t);
            aoptions.add("t");
            aoptions.add("l");
        }
        //opciones V,U y tres aleatorias
        else if (question.startsWith("v")) {
            mpCorrectChar = MediaPlayer.create(this, R.raw.v);
            aoptions.add("v");
            aoptions.add("u");
        }
        //opciones Y,V y tres aleatorias
        else if (question.startsWith("y")) {
            mpCorrectChar = MediaPlayer.create(this, R.raw.y);
            aoptions.add("y");
            aoptions.add("v");
        }
        //opciones Z,S y tres aleatorias
        else if (question.startsWith("z")) {
            mpCorrectChar = MediaPlayer.create(this, R.raw.z);
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
            e3 = String.valueOf(alphabet.charAt(r.nextInt(alphabet.length())));
        }
        aoptions.add(e3);

        //-----------------------------------------------------------------------


        Collections.shuffle(aoptions);


        //Busco la ubicación de la letra correcta y le sumo 1
        correctAnswer = aoptions.indexOf(question.substring(0, 1)) + 1;

        Log.d("TAGGG", "El objeto es:" + question);
        Log.d("TAGGG", "La correcta es:" + correctAnswer);
        //LOG
        for (String element : aoptions) {
            Log.d("TAGGG", element);
        }

        return aoptions;

    }

    private void configImages(ArrayList<String> options) {


        //Primero configuro la imagen del objeto:
        switch (question) {
            case "bicicleta":
                imageViewObject.setImageResource(R.drawable.bicicleta);
                break;
            case "botellas":
                imageViewObject.setImageResource(R.drawable.botellas);
                break;
            case "burro":
                imageViewObject.setImageResource(R.drawable.burro);
                break;
            case "casa":
                imageViewObject.setImageResource(R.drawable.casa);
                break;
            case "cepillo":
                imageViewObject.setImageResource(R.drawable.cepillo);
                break;
            case "cuna":
                imageViewObject.setImageResource(R.drawable.cuna);
                break;
            case "dado":
                imageViewObject.setImageResource(R.drawable.dado);
                break;
            case "dedo":
                imageViewObject.setImageResource(R.drawable.dedo);
                break;
            case "domino":
                imageViewObject.setImageResource(R.drawable.domino);
                break;
            case "foca":
                imageViewObject.setImageResource(R.drawable.foca);
                break;
            case "fuego":
                imageViewObject.setImageResource(R.drawable.fuego);
                break;
            case "gato":
                imageViewObject.setImageResource(R.drawable.gato);
                break;
            case "gusano":
                imageViewObject.setImageResource(R.drawable.gusano);
                break;
            case "jirafa":
                imageViewObject.setImageResource(R.drawable.jirafa);
                break;
            case "lapiz":
                imageViewObject.setImageResource(R.drawable.lapiz);
                break;
            case "leche":
                imageViewObject.setImageResource(R.drawable.leche);
                break;
            case "loro":
                imageViewObject.setImageResource(R.drawable.loro);
                break;
            case "luna":
                imageViewObject.setImageResource(R.drawable.luna);
                break;
            case "mano":
                imageViewObject.setImageResource(R.drawable.mano);
                break;
            case "mesa":
                imageViewObject.setImageResource(R.drawable.mesa);
                break;
            case "mono":
                imageViewObject.setImageResource(R.drawable.mono);
                break;
            case "muneca":
                imageViewObject.setImageResource(R.drawable.mueca);
                break;
            case "nube":
                imageViewObject.setImageResource(R.drawable.nube);
                break;
            case "pato":
                imageViewObject.setImageResource(R.drawable.pato);
                break;
            case "pera":
                imageViewObject.setImageResource(R.drawable.pera);
                break;
            case "puerta":
                imageViewObject.setImageResource(R.drawable.puerta);
                break;
            case "raton":
                imageViewObject.setImageResource(R.drawable.raton);
                break;
            case "reloj":
                imageViewObject.setImageResource(R.drawable.reloj);
                break;
            case "rueda":
                imageViewObject.setImageResource(R.drawable.rueda);
                break;
            case "silla":
                imageViewObject.setImageResource(R.drawable.silla);
                break;
            case "tenedor":
                imageViewObject.setImageResource(R.drawable.tenedor);
                break;
            case "tijera":
                imageViewObject.setImageResource(R.drawable.tijera);
                break;
            case "toro":
                imageViewObject.setImageResource(R.drawable.toro);
                break;
            case "vaso":
                imageViewObject.setImageResource(R.drawable.vaso);
                break;
            case "queso":
                imageViewObject.setImageResource(R.drawable.queso);
                break;
            case "yoyo":
                imageViewObject.setImageResource(R.drawable.yoyo);
                break;
            case "zapato":
                imageViewObject.setImageResource(R.drawable.zapato);
                break;
        }
        if (question.equals("zorro")) {
            imageViewObject.setImageResource(R.drawable.zorro);
        }


        int i = 1;
        ImageView imgVw = null;

        for (String element : options) {

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

            switch (element) {
                case "a":
                    imgVw.setImageResource(R.drawable.a);
                    break;
                case "b":
                    imgVw.setImageResource(R.drawable.bb);
                    break;
                case "c":
                    imgVw.setImageResource(R.drawable.c);
                    break;
                case "d":
                    imgVw.setImageResource(R.drawable.d);
                    break;
                case "e":
                    imgVw.setImageResource(R.drawable.e);
                    break;
                case "f":
                    imgVw.setImageResource(R.drawable.f);
                    break;
                case "g":
                    imgVw.setImageResource(R.drawable.g);
                    break;
                case "h":
                    imgVw.setImageResource(R.drawable.h);
                    break;
                case "i":
                    imgVw.setImageResource(R.drawable.i);
                    break;
                case "j":
                    imgVw.setImageResource(R.drawable.j);
                    break;
                case "k":
                    imgVw.setImageResource(R.drawable.k);
                    break;
                case "l":
                    imgVw.setImageResource(R.drawable.l);
                    break;
                case "m":
                    imgVw.setImageResource(R.drawable.m);
                    break;
                case "n":
                    imgVw.setImageResource(R.drawable.n);
                    break;
                case "o":
                    imgVw.setImageResource(R.drawable.o);
                    break;
                case "p":
                    imgVw.setImageResource(R.drawable.p);
                    break;
                case "q":
                    imgVw.setImageResource(R.drawable.q);
                    break;
                case "r":
                    imgVw.setImageResource(R.drawable.r);
                    break;
                case "s":
                    imgVw.setImageResource(R.drawable.s);
                    break;
                case "t":
                    imgVw.setImageResource(R.drawable.t);
                    break;
                case "u":
                    imgVw.setImageResource(R.drawable.u);
                    break;
                case "v":
                    imgVw.setImageResource(R.drawable.v);
                    break;
                case "w":
                    imgVw.setImageResource(R.drawable.w);
                    break;
                case "x":
                    imgVw.setImageResource(R.drawable.x);
                    break;
                case "y":
                    imgVw.setImageResource(R.drawable.y);
                    break;
                case "z":
                    imgVw.setImageResource(R.drawable.z);
                    break;
            }

            i = i + 1;
        }


    }

    private void playQuestionSound(String question) {

        if (mpObject != null) {
            mpObject.release();
            mpObject = null;
        }

        switch (question) {
            case "bicicleta":
                mpObject = MediaPlayer.create(this, R.raw.bicicleta);
                break;
            case "botellas":
                mpObject = MediaPlayer.create(this, R.raw.botellas);
                break;
            case "burro":
                mpObject = MediaPlayer.create(this, R.raw.burro);
                break;
            case "casa":
                mpObject = MediaPlayer.create(this, R.raw.casa);
                break;
            case "cepillo":
                mpObject = MediaPlayer.create(this, R.raw.cepillo);
                break;
            case "cuna":
                mpObject = MediaPlayer.create(this, R.raw.cuna);
                break;
            case "dado":
                mpObject = MediaPlayer.create(this, R.raw.dado);
                break;
            case "dedo":
                mpObject = MediaPlayer.create(this, R.raw.dedo);
                break;
            case "domino":
                mpObject = MediaPlayer.create(this, R.raw.domino);
                break;
            case "foca":
                mpObject = MediaPlayer.create(this, R.raw.foca);
                break;
            case "fuego":
                mpObject = MediaPlayer.create(this, R.raw.fuego);
                break;
            case "gato":
                mpObject = MediaPlayer.create(this, R.raw.gato);
                break;
            case "gusano":
                mpObject = MediaPlayer.create(this, R.raw.gusano);
                break;
            case "jirafa":
                mpObject = MediaPlayer.create(this, R.raw.jirafa);
                break;
            case "lapiz":
                mpObject = MediaPlayer.create(this, R.raw.lapiz);
                break;
            case "leche":
                mpObject = MediaPlayer.create(this, R.raw.leche);
                break;
            case "loro":
                mpObject = MediaPlayer.create(this, R.raw.loro);
                break;
            case "luna":
                mpObject = MediaPlayer.create(this, R.raw.luna);
                break;
            case "mano":
                mpObject = MediaPlayer.create(this, R.raw.mano);
                break;
            case "mesa":
                mpObject = MediaPlayer.create(this, R.raw.mesa);
                break;
            case "mono":
                mpObject = MediaPlayer.create(this, R.raw.mono);
                break;
            case "muneca":
                mpObject = MediaPlayer.create(this, R.raw.muneca);
                break;
            case "nube":
                mpObject = MediaPlayer.create(this, R.raw.nube);
                break;
            case "pato":
                mpObject = MediaPlayer.create(this, R.raw.pato);
                break;
            case "pera":
                mpObject = MediaPlayer.create(this, R.raw.pera);
                break;
            case "puerta":
                mpObject = MediaPlayer.create(this, R.raw.puerta);
                break;
            case "raton":
                mpObject = MediaPlayer.create(this, R.raw.raton);
                break;
            case "reloj":
                mpObject = MediaPlayer.create(this, R.raw.reloj);
                break;
            case "rueda":
                mpObject = MediaPlayer.create(this, R.raw.rueda);
                break;
            case "silla":
                mpObject = MediaPlayer.create(this, R.raw.silla);
                break;
            case "tenedor":
                mpObject = MediaPlayer.create(this, R.raw.tenedor);
                break;
            case "tijera":
                mpObject = MediaPlayer.create(this, R.raw.tijera);
                break;
            case "toro":
                mpObject = MediaPlayer.create(this, R.raw.toro);
                break;
            case "vaso":
                mpObject = MediaPlayer.create(this, R.raw.vaso);
                break;
            case "queso":
                mpObject = MediaPlayer.create(this, R.raw.queso);
                break;
            case "yoyo":
                mpObject = MediaPlayer.create(this, R.raw.yoyo);
                break;
            case "zapato":
                mpObject = MediaPlayer.create(this, R.raw.zapato);
                break;
            case "zorro":
                mpObject = MediaPlayer.create(this, R.raw.zorro);
                break;
        }

        try {
            mpObject.start();
        } catch (Exception e) {
            Log.d("TAGGG", e.getMessage());
        }
    }

    private String generateQuestion() {

        if (objects == null) {
            String[] list = new String[]{"bicicleta", "botellas", "burro", "casa", "cepillo", "cuna"
                    , "dado", "dedo", "domino", "foca", "fuego", "gato", "gusano", "jirafa", "lapiz",
                    "leche", "loro", "luna", "mano", "mesa", "mono", "muneca", "nube", "pato", "pera",
                    "puerta", "raton", "reloj", "rueda", "silla", "tenedor", "tijera", "toro", "vaso",
                    "queso", "yoyo", "zapato", "zorro"};

            objects = new ArrayList<>();
            objects.addAll(Arrays.asList(list));
        }

        Random r = new Random();
        return objects.get(r.nextInt(37));

    }

    private void startAgain() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                question = generateQuestion();
                Handler r = new Handler();
                r.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        final ArrayList<String> options2 = generateOptionsArray();
                        playQuestionSound(question);
                        configImages(options2);
                        resetColorsAndClicks();
                    }
                }, 3000);

            }
        }).run();


    }

    private void resetColorsAndClicks() {
        //Reseteo los colores
        imageViewOp1.setColorFilter(null);
        imageViewOp2.setColorFilter(null);
        imageViewOp3.setColorFilter(null);
        imageViewOp4.setColorFilter(null);
        imageViewOp5.setColorFilter(null);

        imageViewOp1.setClickable(true);
        imageViewOp2.setClickable(true);
        imageViewOp3.setClickable(true);
        imageViewOp4.setClickable(true);
        imageViewOp5.setClickable(true);


    }

    private void playCorrectAnswer() {

        if (mpCorrectAnswer == null) {
            mpCorrectAnswer = MediaPlayer.create(this, R.raw.bien);
        }
        if (mpCorrectAnswer.isPlaying()) {
            mpCorrectAnswer.seekTo(0);
        } else {
            mpCorrectAnswer.start();
            Handler r = new Handler();
            r.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mpCorrectChar.start();
                }
            }, 200);

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
            Handler r = new Handler();
            r.postDelayed(new Runnable() {
                @Override
                public void run() {
                    playQuestionSound(question);
                }
            }, 200);
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
