package io.github.umangjpatel.miwok;

public class Word {

    private int mMiwokResId, mNormalResId, mColorResId, mImageResId, mSoundResId;

    Word(int miwokResId, int normalResId, int colorResId, int imageResId, int soundResId) {
        mMiwokResId = miwokResId;
        mNormalResId = normalResId;
        mColorResId = colorResId;
        mImageResId = imageResId;
        mSoundResId = soundResId;
    }

    Word(int miwokResId, int normalResId, int colorResId, int soundResId) {
        mMiwokResId = miwokResId;
        mNormalResId = normalResId;
        mColorResId = colorResId;
        mImageResId = 0;
        mSoundResId = soundResId;
    }

    public int getMiwokResId() {
        return mMiwokResId;
    }

    public int getNormalResId() {
        return mNormalResId;
    }

    public int getColorResId() {
        return mColorResId;
    }

    public int getImageResId() {
        return mImageResId;
    }

    public int getSoundResId() {
        return mSoundResId;
    }

}
