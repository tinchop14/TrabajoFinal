package com.example.tincho.trabajofinal;

import android.content.ClipData;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class ImageOnTouchListener implements View.OnTouchListener {


    private final String IMAGE_TAG_1 = "IMAGE_TAG_1";
    private final String IMAGE_TAG_2 = "IMAGE_TAG_2";
    private final String IMAGE_TAG_3 = "IMAGE_TAG_3";
    private final String IMAGE_TAG_4 = "IMAGE_TAG_4";
    private final String IMAGE_TAG_5 = "IMAGE_TAG_5";


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        String tag = view.getTag().toString();
        ClipData dragData = ClipData.newPlainText("TAG", tag);

        // Instantiates the drag shadow builder.
        View.DragShadowBuilder myShadow=null;


        switch (tag) {
            case IMAGE_TAG_1:
                myShadow = new View.DragShadowBuilder(view.findViewById(R.id.number1));
                break;
            case IMAGE_TAG_2:
                myShadow = new View.DragShadowBuilder(view.findViewById(R.id.number2));

                break;
            case IMAGE_TAG_3:
                myShadow = new View.DragShadowBuilder(view.findViewById(R.id.number3));

                break;
            case IMAGE_TAG_4:
                myShadow = new View.DragShadowBuilder(view.findViewById(R.id.number4));

                break;
            case IMAGE_TAG_5:
                myShadow = new View.DragShadowBuilder(view.findViewById(R.id.number5));

                break;
        }


        // Starts the drag
        view.startDrag(dragData, myShadow, null, 0);

        return true;
    }
}
