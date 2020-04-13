package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(0,new Word("minto wuksus","Where are you going?", R.raw.phrase_where_are_you_going));
        words.add(1,new Word("tinnə oyaase'nə","What is your name?", R.raw.phrase_what_is_your_name));
        words.add(2,new Word("oyaaset ...","My name is ...", R.raw.phrase_my_name_is));
        words.add(3,new Word("michәksәs?","How are you feeling?", R.raw.phrase_how_are_you_feeling));
        words.add(4,new Word("kuchi achit","I’m feeling good.", R.raw.phrase_im_feeling_good));
        words.add(5,new Word("әәnәs'aa?","Are you coming?", R.raw.phrase_are_you_coming));
        words.add(6,new Word("hәә’ әәnәm","I’m coming.", R.raw.phrase_im_coming));
        words.add(7,new Word("yoowutis","Let’s go.", R.raw.phrase_lets_go));
        words.add(8,new Word("әnni'nem","Come here.", R.raw.phrase_come_here));

        WordAdapter itemsAdapter = new WordAdapter(this, words,getResources().getColor(R.color.category_phrases));

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WordAdapter wordAdapter = (WordAdapter) parent.getAdapter();
                Word word = wordAdapter.getItem(position);
                player = MediaPlayer.create(PhrasesActivity.this, word.getmAudioId());
                player.start();
            }
        });

    }
}
