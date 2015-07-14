package com.example.tincho.trabajofinal;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private final String IMAGE_TAG_1 = "IMAGE_TAG_1";
    private final String IMAGE_TAG_2 = "IMAGE_TAG_2";
    private final String IMAGE_TAG_3 = "IMAGE_TAG_3";
    private final String IMAGE_TAG_4 = "IMAGE_TAG_4";
    private final String IMAGE_TAG_5 = "IMAGE_TAG_5";

    private ImageView number1ImageView;
    private ImageView number2ImageView;
    private ImageView number3ImageView;
    private ImageView number4ImageView;
    private ImageView number5ImageView;

    private MediaPlayer mpCorrectNumber;
    private MediaPlayer mp1 = null;
    private MediaPlayer mp2 = null;
    private MediaPlayer mp3 = null;
    private MediaPlayer mp4 = null;
    private MediaPlayer mp5 = null;
    private MediaPlayer mp6 = null;
    private MediaPlayer mp7 = null;
    private MediaPlayer mp8 = null;
    private MediaPlayer mp9 = null;
    private MediaPlayer mp10 = null;
    private MediaPlayer mp11 = null;


    private int correctIndex;
    private MediaPlayer mpCorrect;
    private MediaPlayer mpWrong;
    int option;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        number1ImageView = (ImageView) findViewById(R.id.number1);
        number2ImageView = (ImageView) findViewById(R.id.number2);
        number3ImageView = (ImageView) findViewById(R.id.number3);
        number4ImageView = (ImageView) findViewById(R.id.number4);
        number5ImageView = (ImageView) findViewById(R.id.number5);

        number1ImageView.setTag(IMAGE_TAG_1);
        number2ImageView.setTag(IMAGE_TAG_2);
        number3ImageView.setTag(IMAGE_TAG_3);
        number4ImageView.setTag(IMAGE_TAG_4);
        number5ImageView.setTag(IMAGE_TAG_5);


        option = generateQuestion();

        //option=4;
        configImages(option);

        playQuestionSound(option);

        ImageView starImageView = (ImageView) findViewById(R.id.starImage);
        starImageView.setImageResource(R.drawable.estrella);

        //Drag listener
        starImageView.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                switch (dragEvent.getAction()) {

                    case DragEvent.ACTION_DRAG_STARTED:
                        break;

                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;

                    case DragEvent.ACTION_DRAG_EXITED:
                        break;

                    case DragEvent.ACTION_DROP:
                        boolean correct = false;
                        switch (correctIndex) {
                            case 1:
                                if (dragEvent.getClipData().getItemAt(0).getText().equals("IMAGE_TAG_1")) {
                                    correct = true;
                                    number1ImageView.setColorFilter(Color.parseColor("#00E676"), PorterDuff.Mode.MULTIPLY);
                                    Log.d("TAGGG", "CORRECTA");
                                } else {
                                    Log.d("TAGGG", "INCORRECTA");
                                }
                                break;
                            case 2:
                                if (dragEvent.getClipData().getItemAt(0).getText().equals("IMAGE_TAG_2")) {
                                    correct = true;
                                    number2ImageView.setColorFilter(Color.parseColor("#00E676"), PorterDuff.Mode.MULTIPLY);

                                    Log.d("TAGGG", "CORRECTA");
                                } else {
                                    Log.d("TAGGG", "INCORRECTA");
                                }
                                break;
                            case 3:
                                if (dragEvent.getClipData().getItemAt(0).getText().equals("IMAGE_TAG_3")) {
                                    correct = true;
                                    number3ImageView.setColorFilter(Color.parseColor("#00E676"), PorterDuff.Mode.MULTIPLY);

                                    Log.d("TAGGG", "CORRECTA");
                                } else {
                                    Log.d("TAGGG", "INCORRECTA");
                                }
                                break;
                            case 4:
                                if (dragEvent.getClipData().getItemAt(0).getText().equals("IMAGE_TAG_4")) {
                                    correct = true;
                                    number4ImageView.setColorFilter(Color.parseColor("#00E676"), PorterDuff.Mode.MULTIPLY);

                                    Log.d("TAGGG", "CORRECTA");
                                } else {
                                    Log.d("TAGGG", "INCORRECTA");
                                }
                                break;
                            case 5:
                                if (dragEvent.getClipData().getItemAt(0).getText().equals("IMAGE_TAG_5")) {
                                    correct = true;
                                    number5ImageView.setColorFilter(Color.parseColor("#00E676"), PorterDuff.Mode.MULTIPLY);

                                    Log.d("TAGGG", "CORRECTA");
                                } else {
                                    Log.d("TAGGG", "INCORRECTA");
                                }
                                break;
                        }

                        if (correct) {
                            if (mpCorrect == null) {
                                mpCorrect = MediaPlayer.create(view.getContext(), R.raw.bien);
                            }
                            mpCorrect.start();
                            mpCorrectNumber.start();

                            //Espero 3 segundos------------------
                            Runnable r = new Runnable() {
                                @Override
                                public void run() {
                                    //Reseteo los colores
                                    number1ImageView.setColorFilter(null);
                                    number2ImageView.setColorFilter(null);
                                    number3ImageView.setColorFilter(null);
                                    number4ImageView.setColorFilter(null);
                                    number5ImageView.setColorFilter(null);

                                    //Reconfiguro todos
                                    startAgain();
                                }
                            };

                            Handler h = new Handler();
                            h.postDelayed(r, 3000);
                            //-----------------------------------


                        } else {
                            if (mpWrong == null) {
                                mpWrong = MediaPlayer.create(view.getContext(), R.raw.error2);
                            }
                            mpWrong.start();
                            playQuestionSound(option);
                        }
                        break;
                    default:
                        break;
                }
                return true;
            }
        });


        number1ImageView.setOnTouchListener(new ImageOnTouchListener());
        number2ImageView.setOnTouchListener(new ImageOnTouchListener());
        number3ImageView.setOnTouchListener(new ImageOnTouchListener());
        number4ImageView.setOnTouchListener(new ImageOnTouchListener());
        number5ImageView.setOnTouchListener(new ImageOnTouchListener());


        number1ImageView.setOnDragListener(new ImageDragEventListener());
        number2ImageView.setOnDragListener(new ImageDragEventListener());
        number3ImageView.setOnDragListener(new ImageDragEventListener());
        number4ImageView.setOnDragListener(new ImageDragEventListener());
        number5ImageView.setOnDragListener(new ImageDragEventListener());


    }

    private void startAgain() {
        //Recargo los componentes
        option = generateQuestion();
        configImages(option);
        playQuestionSound(option);
    }


    private void configImages(int option) {
        ArrayList<Integer> aoptions = null;

        switch (option) {
            case 1:
                //Opciones: 5,6,7 y dos aleatorias
                aoptions = generateOptionsArray(5, 6, 7);
                //Guardo la posición de la correcta
                correctIndex = (aoptions.indexOf(5) + 1);
                Log.d("TAGGG", "UNICACION: " + String.valueOf(correctIndex));
                break;
            case 2:
                //Opciones: 6,7,8 y dos aleatorias
                aoptions = generateOptionsArray(6, 7, 8);
                correctIndex = aoptions.indexOf(6) + 1;
                break;
            case 3:
                //Opciones: 7,8,9 y dos aleatorias
                aoptions = generateOptionsArray(7, 8, 9);
                correctIndex = aoptions.indexOf(7) + 1;
                break;
            case 4:
                //Opciones: 8,9,10 y dos aleatorias
                aoptions = generateOptionsArray(8, 9, 10);
                correctIndex = aoptions.indexOf(8) + 1;
                break;
            case 5:
                //Opciones: 9,10,11 y dos aleatorias
                aoptions = generateOptionsArray(9, 10, 11);
                correctIndex = aoptions.indexOf(9) + 1;
                break;
            case 6:
                //Opciones: 10,11,12 y dos aleatorias
                aoptions = generateOptionsArray(10, 11, 12);
                correctIndex = aoptions.indexOf(10) + 1;
                break;
            case 7:
                //Opciones: 11,12,13 y dos aleatorias
                aoptions = generateOptionsArray(11, 12, 13);
                correctIndex = aoptions.indexOf(11) + 1;
                break;
            case 8:
                //Opciones: 12,13,14 y dos aleatorias
                aoptions = generateOptionsArray(12, 13, 14);
                correctIndex = aoptions.indexOf(12) + 1;
                break;
            case 9:
                //Opciones: 13,14,15 y dos aleatorias
                aoptions = generateOptionsArray(13, 14, 15);
                correctIndex = aoptions.indexOf(13) + 1;
                break;
            case 10:
                //Opciones: 14,15,13 y dos aleatorias
                aoptions = generateOptionsArray(14, 15, 13);
                correctIndex = aoptions.indexOf(14) + 1;
                break;
            case 11:
                //Opciones: 15,14,13 y dos aleatorias
                aoptions = generateOptionsArray(15, 14, 13);
                correctIndex = aoptions.indexOf(15) + 1;
                break;
        }

        Iterator itr = aoptions.iterator();
        int i = 1;

        while (itr.hasNext()) {

            Integer element = (Integer) itr.next();
            ImageView imgVw = null;

            Log.d("TAGGG", element.toString());

            switch (i) {
                case 1:
                    imgVw = number1ImageView;
                    break;
                case 2:
                    imgVw = number2ImageView;
                    break;
                case 3:
                    imgVw = number3ImageView;
                    break;
                case 4:
                    imgVw = number4ImageView;
                    break;
                case 5:
                    imgVw = number5ImageView;
                    break;

            }

            try {

                switch (element) {
                    case 0:
                        break;
                    case 1:
                        imgVw.setImageResource(R.drawable.uno);
                        break;
                    case 2:
                        imgVw.setImageResource(R.drawable.dos);
                        break;
                    case 3:
                        imgVw.setImageResource(R.drawable.tres);
                        break;
                    case 4:
                        imgVw.setImageResource(R.drawable.cuatro);
                        break;
                    case 5:
                        imgVw.setImageResource(R.drawable.cinco);
                        break;
                    case 6:
                        imgVw.setImageResource(R.drawable.seis);
                        break;
                    case 7:
                        imgVw.setImageResource(R.drawable.siete);
                        break;
                    case 8:
                        imgVw.setImageResource(R.drawable.ocho);
                        break;
                    case 9:
                        imgVw.setImageResource(R.drawable.nueve);
                        break;
                    case 10:
                        imgVw.setImageResource(R.drawable.diez);
                        break;
                    case 11:
                        imgVw.setImageResource(R.drawable.once);
                        break;
                    case 12:
                        imgVw.setImageResource(R.drawable.doce);
                        break;
                    case 13:
                        imgVw.setImageResource(R.drawable.trece);
                        break;
                    case 14:
                        imgVw.setImageResource(R.drawable.catorce);
                        break;
                    case 15:
                        imgVw.setImageResource(R.drawable.quince);
                        break;
                }
                i = i + 1;
            } catch (Exception e) {
                Log.d("TAGGG", e.getMessage());
            }
        }


    }

    private ArrayList<Integer> generateOptionsArray(int i, int i1, int i2) {

        ArrayList<Integer> aoptions = new ArrayList<>();

        //Agrego los 3 números relacionados
        aoptions.add(i);
        aoptions.add(i1);
        aoptions.add(i2);

        Log.d("TAGGG", "OPCIONES RELACIONADAS:---------------");
        Log.d("TAGGG", String.valueOf(i));
        Log.d("TAGGG", String.valueOf(i1));
        Log.d("TAGGG", String.valueOf(i2));
        Log.d("TAGGG", "-------------------------------------");


        Random r = new Random();

        //Declaro los dos que van a ser aleatorios
        int extra1 = 0;
        int extra2 = 0;

        //Hago que los aleatorios sean diferentes a los números de las relaciones
        while (extra1 == i || extra1 == i1 || extra1 == i2 || extra1 == 0) {
            extra1 = r.nextInt(14) + 1;
        }
        while (extra2 == i || extra2 == i1 || extra2 == i2 || extra2 == 0 || extra2 == extra1) {
            extra2 = r.nextInt(14) + 1;
        }

        //agrego los dos aleatorios
        aoptions.add(extra1);
        aoptions.add(extra2);

        //Mezclo los elementos de la colección
        Collections.shuffle(aoptions);

        return aoptions;
    }

    private int generateQuestion() {

        Random r = new Random();


        return r.nextInt(11) + 1;


    }

    private void playQuestionSound(int option) {

        if (mpCorrectNumber != null) {
            mpCorrectNumber.release();
            mpCorrectNumber = null;
        }

        switch (option) {
            case 1:
                mpCorrectNumber = MediaPlayer.create(this, R.raw.cinco);
                if (mp1 == null) {
                    mp1 = MediaPlayer.create(this, R.raw.a1234);
                }
                mp1.start();
                break;
            case 2:
                mpCorrectNumber = MediaPlayer.create(this, R.raw.seis);
                if (mp2 == null) {
                    mp2 = MediaPlayer.create(this, R.raw.a2345);
                }
                mp2.start();
                break;
            case 3:
                mpCorrectNumber = MediaPlayer.create(this, R.raw.siete);
                if (mp3 == null) {
                    mp3 = MediaPlayer.create(this, R.raw.a3456);
                }
                mp3.start();
                break;
            case 4:
                mpCorrectNumber = MediaPlayer.create(this, R.raw.ocho);
                if (mp4 == null) {
                    mp4 = MediaPlayer.create(this, R.raw.a4567);
                }
                mp4.start();
                break;
            case 5:
                mpCorrectNumber = MediaPlayer.create(this, R.raw.nueve);
                if (mp5 == null) {
                    mp5 = MediaPlayer.create(this, R.raw.a5678);
                }
                mp5.start();
                break;
            case 6:
                mpCorrectNumber = MediaPlayer.create(this, R.raw.diez);
                if (mp6 == null) {
                    mp6 = MediaPlayer.create(this, R.raw.a6789);
                }
                mp6.start();
                break;
            case 7:
                mpCorrectNumber = MediaPlayer.create(this, R.raw.once);
                if (mp7 == null) {
                    mp7 = MediaPlayer.create(this, R.raw.a78910);
                }

                mp7.start();
                break;
            case 8:
                mpCorrectNumber = MediaPlayer.create(this, R.raw.doce);
                if (mp8 == null) {
                    mp8 = MediaPlayer.create(this, R.raw.a891011);
                }

                mp8.start();
                break;
            case 9:
                mpCorrectNumber = MediaPlayer.create(this, R.raw.trece);
                if (mp9 == null) {
                    mp9 = MediaPlayer.create(this, R.raw.a9101112);
                }

                mp9.start();
                break;
            case 10:
                mpCorrectNumber = MediaPlayer.create(this, R.raw.catorce);
                if (mp10 == null) {
                    mp10 = MediaPlayer.create(this, R.raw.a10111213);
                }

                mp10.start();
                break;
            case 11:
                mpCorrectNumber = MediaPlayer.create(this, R.raw.quince);
                if (mp11 == null) {
                    mp11 = MediaPlayer.create(this, R.raw.a11121314);
                }
                mp11.start();
                break;

        }


    }


    @Override
    protected void onPause() {
        super.onPause();

        if (mp1 != null) {
            mp1.release();
            mp1 = null;
        }
        if (mp2 != null) {
            mp2.release();
            mp2 = null;
        }
        if (mp3 != null) {
            mp3.release();
            mp3 = null;
        }
        if (mp4 != null) {
            mp4.release();
            mp4 = null;
        }
        if (mp5 != null) {
            mp5.release();
            mp5 = null;
        }
        if (mp6 != null) {
            mp6.release();
            mp6 = null;
        }
        if (mp7 != null) {
            mp7.release();
            mp7 = null;
        }
        if (mp8 != null) {
            mp8.release();
            mp8 = null;
        }
        if (mp9 != null) {
            mp9.release();
            mp9 = null;
        }
        if (mp10 != null) {
            mp10.release();
            mp10 = null;
        }
        if (mp11 != null) {
            mp11.release();
            mp11 = null;
        }
        if (mpCorrect != null) {
            mpCorrect.release();
            mpCorrect = null;
        }
        if (mpWrong != null) {
            mpWrong.release();
            mpWrong = null;
        }
        if (mpCorrectNumber != null) {
            mpCorrectNumber.release();
            mpCorrectNumber = null;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        mpCorrect = MediaPlayer.create(this, R.raw.bien);
        mpWrong = MediaPlayer.create(this, R.raw.error2);
        playQuestionSound(option);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mp1 != null) {
            mp1.release();
            mp1 = null;
        }
        if (mp2 != null) {
            mp2.release();
            mp2 = null;
        }
        if (mp3 != null) {
            mp3.release();
            mp3 = null;
        }
        if (mp4 != null) {
            mp4.release();
            mp4 = null;
        }
        if (mp5 != null) {
            mp5.release();
            mp5 = null;
        }
        if (mp6 != null) {
            mp6.release();
            mp6 = null;
        }
        if (mp7 != null) {
            mp7.release();
            mp7 = null;
        }
        if (mp8 != null) {
            mp8.release();
            mp8 = null;
        }
        if (mp9 != null) {
            mp9.release();
            mp9 = null;
        }
        if (mp10 != null) {
            mp10.release();
            mp10 = null;
        }
        if (mp11 != null) {
            mp11.release();
            mp11 = null;
        }
        if (mpCorrect != null) {
            mpCorrect.release();
            mpCorrect = null;
        }
        if (mpWrong != null) {
            mpWrong.release();
            mpWrong = null;
        }
        if (mpCorrectNumber != null) {
            mpCorrectNumber.release();
            mpCorrectNumber = null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_tp9) {

            Intent i = new Intent(this, Tp9Activity.class);
            startActivity(i);
            this.finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
