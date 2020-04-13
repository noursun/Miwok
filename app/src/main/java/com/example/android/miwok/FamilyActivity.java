package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_members);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(0,new Word("әpә","father",R.drawable.family_father, R.raw.family_father));
        words.add(1,new Word("әṭa","mother",R.drawable.family_mother,R.raw.family_mother));
        words.add(2,new Word("angsi","son",R.drawable.family_son,R.raw.family_son));
        words.add(3,new Word("tune","daughter",R.drawable.family_daughter,R.raw.family_daughter));
        words.add(4,new Word("taachi","older brother",R.drawable.family_older_brother,R.raw.family_older_brother));
        words.add(5,new Word("chalitti","younger brother",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        words.add(6,new Word("teṭe","older sister",R.drawable.family_older_sister,R.raw.family_older_sister));
        words.add(7,new Word("kolliti","younger sister",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        words.add(8,new Word("ama","grandmother",R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(9,new Word("paapa","grandfather",R.drawable.family_grandfather, R.raw.family_grandfather));

        WordAdapter itemsAdapter = new WordAdapter(this, words,getResources().getColor(R.color.category_family));

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WordAdapter wordAdapter = (WordAdapter) parent.getAdapter();
                Word word = wordAdapter.getItem(position);
                player = MediaPlayer.create(FamilyActivity.this, word.getmAudioId());
                player.start();
            }
        });
    }
}
