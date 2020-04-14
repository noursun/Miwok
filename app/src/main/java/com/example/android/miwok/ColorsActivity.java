package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    MediaPlayer player;
    AudioManager audioManager;
    AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
            @Override
            public void onAudioFocusChange(int focusChange) {
                if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                    player.pause();
                    player.seekTo(0);
                }else if (focusChange == AudioManager.AUDIOFOCUS_GAIN){
                    player.start();
                }else if (focusChange == AudioManager.AUDIOFOCUS_LOSS){
                    Utilities.releaseMidiaPlayer(player, audioManager, onAudioFocusChangeListener);
                }
            }
        };

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(0,new Word("wetetti","red",R.drawable.color_red, R.raw.color_red));
        words.add(1,new Word("chokokki","green",R.drawable.color_green, R.raw.color_green));
        words.add(2,new Word("takakki","brown",R.drawable.color_brown, R.raw.color_brown));
        words.add(3,new Word("topoppi","gray",R.drawable.color_gray, R.raw.color_gray));
        words.add(4,new Word("kulluli","black",R.drawable.color_black, R.raw.color_black));
        words.add(5,new Word("kelelli","white",R.drawable.color_white, R.raw.color_white));
        words.add(6,new Word("topiisa","dusty yellow",R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(7,new Word("chiwiita","mustard yellow",R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        WordAdapter itemsAdapter = new WordAdapter(this, words,getResources().getColor(R.color.category_colors));

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        final MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Utilities.releaseMidiaPlayer(mp, audioManager, onAudioFocusChangeListener);
            }
        };
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WordAdapter wordAdapter = (WordAdapter) parent.getAdapter();
                Word word = wordAdapter.getItem(position);
                Utilities.releaseMidiaPlayer(player, audioManager, onAudioFocusChangeListener);

                int result = audioManager.requestAudioFocus(onAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    //audioManager.unregisterMediaButtonEventReceiver(rcr);
                    player = MediaPlayer.create(ColorsActivity.this, word.getmAudioId());
                    player.start();
                    player.setOnCompletionListener(completionListener);

                }
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        Utilities.releaseMidiaPlayer(player, audioManager, onAudioFocusChangeListener);
    }
}
