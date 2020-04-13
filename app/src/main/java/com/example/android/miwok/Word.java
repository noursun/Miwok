package com.example.android.miwok;

public class Word {
    private String mMiwokWork;
    private String mDefaultWord;
    private int mImageSourceId;
    private int mAudioId;


    public Word(String mMiwokWork, String mDefaultWord, int mAudioId) {
        this.mMiwokWork = mMiwokWork;
        this.mDefaultWord = mDefaultWord;
        this.mImageSourceId = 0;
        this.mAudioId = mAudioId;
    }

    public Word(String mMiwokWork, String mDefaultWord, int mImageSourceId, int mAudioId) {
        this.mMiwokWork = mMiwokWork;
        this.mDefaultWord = mDefaultWord;
        this.mImageSourceId = mImageSourceId;
        this.mAudioId = mAudioId;
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

    public int getmAudioId() {
        return mAudioId;
    }
}
