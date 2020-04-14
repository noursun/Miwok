package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    MediaPlayer player;
    AudioManager audioManager;
    AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
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
        words.add(0,new Word("lutti","one", R.drawable.number_one, R.raw.number_one));
        words.add(1,new Word("otiiko","two",R.drawable.number_two, R.raw.number_two));
        words.add(2,new Word("tolookosu","tree",R.drawable.number_three, R.raw.number_three));
        words.add(3,new Word("oyyisa","four",R.drawable.number_four,R.raw.number_four));
        words.add(4,new Word("massokka","five",R.drawable.number_five,R.raw.number_five));
        words.add(5,new Word("temmokka","six",R.drawable.number_six,R.raw.number_six));
        words.add(6,new Word("kenekaku","seven",R.drawable.number_seven,R.raw.number_seven));
        words.add(7,new Word("kawinta","eight",R.drawable.number_eight,R.raw.number_eight));
        words.add(8,new Word("wo'e","nine",R.drawable.number_nine,R.raw.number_nine));
        words.add(9,new Word("na'aacha","ten",R.drawable.number_ten,R.raw.number_ten));

        WordAdapter itemsAdapter = new WordAdapter(this, words,getResources().getColor(R.color.category_numbers));

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
                    player = MediaPlayer.create(NumbersActivity.this, word.getmAudioId());
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
