package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_members);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(0,new Word("әpә","father",R.drawable.family_father));
        words.add(1,new Word("әṭa","mother",R.drawable.family_mother));
        words.add(2,new Word("angsi","son",R.drawable.family_son));
        words.add(3,new Word("tune","daughter",R.drawable.family_daughter));
        words.add(4,new Word("taachi","older brother",R.drawable.family_older_brother));
        words.add(5,new Word("chalitti","younger brother",R.drawable.family_younger_brother));
        words.add(6,new Word("teṭe","older sister",R.drawable.family_older_sister));
        words.add(7,new Word("kolliti","younger sister",R.drawable.family_younger_sister));
        words.add(8,new Word("ama","grandmother",R.drawable.family_grandmother));
        words.add(9,new Word("paapa","grandfather",R.drawable.family_grandfather));

        WordAdapter itemsAdapter = new WordAdapter(this, words,getResources().getColor(R.color.category_family));

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
