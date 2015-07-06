package com.example.tincho.trabajofinal;

import android.media.Image;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by tincho on 22/06/15.
 */
public class ImageDragEventListener implements View.OnDragListener {
    @Override
    public boolean onDrag(View view, DragEvent dragEvent) {

        String tag = view.getTag().toString();

        switch (dragEvent.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                Log.d("TAGGG","ACTION_DRAG_STARTED"+tag);
                view.setVisibility(View.INVISIBLE);
                return true;

            case DragEvent.ACTION_DRAG_ENTERED:
                Log.d("TAGGG","ACTION_DRAG_ENTERED"+tag);
                return false;

            case DragEvent.ACTION_DRAG_LOCATION:

                // Ignore the event
                return true;

            case DragEvent.ACTION_DRAG_EXITED:
                Log.d("TAGGG", "ACTION_DRAG_EXITED" + tag);
                return true;

            case DragEvent.ACTION_DROP:
                Log.d("TAGGG","ACTION_DRAG_DROP"+tag);
                return false;

            case DragEvent.ACTION_DRAG_ENDED:
                Log.d("TAGGG","ACTION_DRAG_ENDED"+tag);
                view.setVisibility(View.VISIBLE);
                return true;
            default:
                break;
        }
        return false;
    }

}
