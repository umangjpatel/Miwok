package io.github.umangjpatel.miwok;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

public class WordViewModel extends ViewModel {

    private MutableLiveData<List<Word>> mWordsLiveData = new MutableLiveData<>();
    private WordRepository mWordRepository;

    public WordViewModel() {
        mWordRepository = WordRepository.getInstance();
        getWords(0);
    }

    public void getWords(int category) {
        switch (category) {
            case 0:
                mWordsLiveData.setValue(mWordRepository.getNumbersWords());
                break;
            case 1:
                mWordsLiveData.setValue(mWordRepository.getFamilyWords());
                break;
            case 2:
                mWordsLiveData.setValue(mWordRepository.getColorWords());
                break;
            case 3:
                mWordsLiveData.setValue(mWordRepository.getPhrasesWords());
                break;
        }
    }

    public MutableLiveData<List<Word>> getWordsLiveData() {
        return mWordsLiveData;
    }
}
