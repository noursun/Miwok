package com.example.android.miwok;

import android.media.AudioManager;
import android.media.MediaPlayer;

    public class Utilities {

    public static void releaseMidiaPlayer(MediaPlayer player){
        if(player != null){
            player.release();
            player = null;
        }
    }

        public static void releaseMidiaPlayer(MediaPlayer player, AudioManager am, AudioManager.OnAudioFocusChangeListener focusChangeListener){
            if(player != null){
                player.release();
                if(am != null && focusChangeListener != null){
                    am.abandonAudioFocus(focusChangeListener);
                }
                player = null;
            }

        }
}
