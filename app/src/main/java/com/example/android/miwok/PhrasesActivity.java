package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(0,new Word("minto wuksus","Where are you going?"));
        words.add(1,new Word("tinnə oyaase'nə","What is your name?"));
        words.add(2,new Word("oyaaset ...","My name is ..."));
        words.add(3,new Word("michәksәs?","How are you feeling?"));
        words.add(4,new Word("kuchi achit","I’m feeling good."));
        words.add(5,new Word("әәnәs'aa?","Are you coming?"));
        words.add(6,new Word("hәә’ әәnәm","I’m coming."));
        words.add(7,new Word("yoowutis","Let’s go."));
        words.add(8,new Word("әnni'nem","Come here."));

        WordAdapter itemsAdapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
