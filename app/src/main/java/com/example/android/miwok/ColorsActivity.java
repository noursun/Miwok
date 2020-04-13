package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WordAdapter wordAdapter = (WordAdapter) parent.getAdapter();
                Word word = wordAdapter.getItem(position);
                player = MediaPlayer.create(ColorsActivity.this, word.getmAudioId());
                player.start();
            }
        });

    }
}
