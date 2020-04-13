package com.example.android.miwok;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {

    protected int color;

    public WordAdapter(@NonNull Context context, @NonNull ArrayList<Word> words,@NonNull int color) {
        super(context, 0, words);
        this.color = color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Word word =getItem(position);

        TextView wordMiwok = listItemView.findViewById(R.id.miwok_textView);
        wordMiwok.setText(word.getmMiwokWork());
        TextView wordDefault = listItemView.findViewById(R.id.default_textView);
        wordDefault.setText(word.getmDefaultWord());
        ImageView image = (ImageView) listItemView.findViewById(R.id.img);

        if(word.getmImageSourceId() != 0){
            image.setImageResource(word.getmImageSourceId());
        }else{
            image.setVisibility(View.INVISIBLE);
            image.setLayoutParams(new LayoutParams(0,0));
        }

        LinearLayout textLayout = (LinearLayout) listItemView.findViewById(R.id.text_layout);
        textLayout.setBackgroundColor(color);

        return listItemView;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
