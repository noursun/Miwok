package com.example.android.miwok;

public class Word {
    private String mMiwokWork;
    private String mDefaultWord;
    private int mImageSourceId;



    public Word(String mMiwokWork, String mDefaultWord) {
        this.mMiwokWork = mMiwokWork;
        this.mDefaultWord = mDefaultWord;
        this.mImageSourceId = 0;
    }

    public Word(String mMiwokWork, String mDefaultWord, int mImageSourceId) {
        this.mMiwokWork = mMiwokWork;
        this.mDefaultWord = mDefaultWord;
        this.mImageSourceId = mImageSourceId;
    }

    public String getmMiwokWork() {
        return mMiwokWork;
    }

    public String getmDefaultWord() {
        return mDefaultWord;
    }

    public int getmImageSourceId() {
        return mImageSourceId;
    }
}
