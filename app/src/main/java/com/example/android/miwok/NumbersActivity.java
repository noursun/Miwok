package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(0,new Word("lutti","one", R.drawable.number_one));
        words.add(1,new Word("otiiko","two",R.drawable.number_two));
        words.add(2,new Word("tolookosu","tree",R.drawable.number_three));
        words.add(3,new Word("oyyisa","four",R.drawable.number_four));
        words.add(4,new Word("massokka","five",R.drawable.number_five));
        words.add(5,new Word("temmokka","six",R.drawable.number_six));
        words.add(6,new Word("kenekaku","seven",R.drawable.number_seven));
        words.add(7,new Word("kawinta","eight",R.drawable.number_eight));
        words.add(8,new Word("wo'e","nine",R.drawable.number_nine));
        words.add(9,new Word("na'aacha","ten",R.drawable.number_ten));

        WordAdapter itemsAdapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
