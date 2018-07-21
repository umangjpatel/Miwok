package io.github.umangjpatel.miwok;

import java.util.ArrayList;
import java.util.List;

public class WordRepository {

    private static WordRepository sWordRepository;

    private List<Word> mNumbersWords, mFamilyWords, mColorWords, mPhrasesWords;

    public static WordRepository getInstance() {
        if (sWordRepository == null) {
            synchronized (WordRepository.class) {
                if (sWordRepository == null)
                    sWordRepository = new WordRepository();
            }
        }
        return sWordRepository;
    }

    private WordRepository() {
        setUpNumberWords();
        setUpFamilyWords();
        setUpColorsWords();
        setUpPhrasesWords();
    }

    private void setUpNumberWords() {
        mNumbersWords = new ArrayList<>();
        mNumbersWords.add(new Word(R.string.number_one_miwok, R.string.number_one_normal, R.color.category_numbers, R.drawable.number_one, R.raw.number_one));
        mNumbersWords.add(new Word(R.string.number_two_miwok, R.string.number_two_normal, R.color.category_numbers, R.drawable.number_two, R.raw.number_two));
        mNumbersWords.add(new Word(R.string.number_three_miwok, R.string.number_three_normal, R.color.category_numbers, R.drawable.number_three, R.raw.number_three));
        mNumbersWords.add(new Word(R.string.number_four_miwok, R.string.number_four_normal, R.color.category_numbers, R.drawable.number_four, R.raw.number_four));
        mNumbersWords.add(new Word(R.string.number_five_miwok, R.string.number_five_normal, R.color.category_numbers, R.drawable.number_five, R.raw.number_five));
        mNumbersWords.add(new Word(R.string.number_six_miwok, R.string.number_seven_normal, R.color.category_numbers, R.drawable.number_six, R.raw.number_six));
        mNumbersWords.add(new Word(R.string.number_seven_miwok, R.string.number_seven_normal, R.color.category_numbers, R.drawable.number_seven, R.raw.number_seven));
        mNumbersWords.add(new Word(R.string.number_eight_miwok, R.string.number_eight_normal, R.color.category_numbers, R.drawable.number_eight, R.raw.number_eight));
        mNumbersWords.add(new Word(R.string.number_nine_miwok, R.string.number_nine_normal, R.color.category_numbers, R.drawable.number_nine, R.raw.number_nine));
        mNumbersWords.add(new Word(R.string.number_ten_miwok, R.string.number_ten_normal, R.color.category_numbers, R.drawable.number_ten, R.raw.number_ten));
    }

    private void setUpFamilyWords() {
        mFamilyWords = new ArrayList<>();
        mFamilyWords.add(new Word(R.string.family_father_miwok, R.string.family_father_normal, R.color.category_family, R.drawable.family_father, R.raw.family_father));
        mFamilyWords.add(new Word(R.string.family_mother_miwok, R.string.family_mother_normal, R.color.category_family, R.drawable.family_mother, R.raw.family_mother));
        mFamilyWords.add(new Word(R.string.family_son_miwok, R.string.family_son_normal, R.color.category_family, R.drawable.family_son, R.raw.family_son));
        mFamilyWords.add(new Word(R.string.family_daughter_miwok, R.string.family_daughter_normal, R.color.category_family, R.drawable.family_daughter, R.raw.family_daughter));
        mFamilyWords.add(new Word(R.string.family_older_brother_miwok, R.string.family_older_brother_normal, R.color.category_family, R.drawable.family_older_brother, R.raw.family_older_brother));
        mFamilyWords.add(new Word(R.string.family_younger_brother_miwok, R.string.family_younger_brother_normal, R.color.category_family, R.drawable.family_younger_brother, R.raw.family_younger_brother));
        mFamilyWords.add(new Word(R.string.family_older_sister_miwok, R.string.family_older_sister_normal, R.color.category_family, R.drawable.family_older_sister, R.raw.family_older_sister));
        mFamilyWords.add(new Word(R.string.family_younger_sister_miwok, R.string.family_younger_sister_normal, R.color.category_family, R.drawable.family_younger_sister, R.raw.family_younger_sister));
        mFamilyWords.add(new Word(R.string.family_grandfather_miwok, R.string.family_grandfather_normal, R.color.category_family, R.drawable.family_grandfather, R.raw.family_grandfather));
        mFamilyWords.add(new Word(R.string.family_grandmother_miwok, R.string.family_grandmother_normal, R.color.category_family, R.drawable.family_grandmother, R.raw.family_grandmother));
    }

    private void setUpColorsWords() {
        mColorWords = new ArrayList<>();
        mColorWords.add(new Word(R.string.color_red_miwok, R.string.color_red_normal, R.color.category_colors, R.drawable.color_red, R.raw.color_red));
        mColorWords.add(new Word(R.string.color_green_miwok, R.string.color_green_normal, R.color.category_colors, R.drawable.color_green, R.raw.color_green));
        mColorWords.add(new Word(R.string.color_brown_miwok, R.string.color_brown_normal, R.color.category_colors, R.drawable.color_brown, R.raw.color_brown));
        mColorWords.add(new Word(R.string.color_gray_miwok, R.string.color_gray_normal, R.color.category_colors, R.drawable.color_gray, R.raw.color_gray));
        mColorWords.add(new Word(R.string.color_black_miwok, R.string.color_black_normal, R.color.category_colors, R.drawable.color_black, R.raw.color_black));
        mColorWords.add(new Word(R.string.color_white_miwok, R.string.color_white_normal, R.color.category_colors, R.drawable.color_white, R.raw.color_white));
        mColorWords.add(new Word(R.string.color_dusty_yellow_miwok, R.string.color_dusty_yellow_normal, R.color.category_colors, R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        mColorWords.add(new Word(R.string.color_mustard_yellow_miwok, R.string.color_mustard_yellow_normal, R.color.category_colors, R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
    }

    private void setUpPhrasesWords() {
        mPhrasesWords = new ArrayList<>();
        mPhrasesWords.add(new Word(R.string.where_are_you_going_miwok, R.string.where_are_you_going_normal, R.color.category_phrases, R.raw.phrase_where_are_you_going));
        mPhrasesWords.add(new Word(R.string.what_is_your_name_miwok, R.string.what_is_your_name_normal, R.color.category_phrases, R.raw.phrase_what_is_your_name));
        mPhrasesWords.add(new Word(R.string.my_name_is_miwok, R.string.my_name_is_normal, R.color.category_phrases, R.raw.phrase_my_name_is));
        mPhrasesWords.add(new Word(R.string.how_are_you_feeling_miwok, R.string.how_are_you_feeling_normal, R.color.category_phrases, R.raw.phrase_how_are_you_feeling));
        mPhrasesWords.add(new Word(R.string.i_m_feeling_good_miwok, R.string.i_m_feeling_good_normal, R.color.category_phrases, R.raw.phrase_im_feeling_good));
        mPhrasesWords.add(new Word(R.string.are_you_coming_miwok, R.string.are_you_coming_normal, R.color.category_phrases, R.raw.phrase_are_you_coming));
        mPhrasesWords.add(new Word(R.string.yes_i_m_coming_miwok, R.string.yes_i_m_coming_normal, R.color.category_phrases, R.raw.phrase_yes_im_coming));
        mPhrasesWords.add(new Word(R.string.i_m_coming_miwok, R.string.i_m_coming_normal, R.color.category_phrases, R.raw.phrase_im_coming));
        mPhrasesWords.add(new Word(R.string.lets_go_miwok, R.string.lets_go_normal, R.color.category_phrases, R.raw.phrase_lets_go));
        mPhrasesWords.add(new Word(R.string.come_here_miwok, R.string.come_here_normal, R.color.category_phrases, R.raw.phrase_come_here));
    }

    public List<Word> getColorWords() {
        return mColorWords;
    }

    public List<Word> getFamilyWords() {
        return mFamilyWords;
    }

    public List<Word> getNumbersWords() {
        return mNumbersWords;
    }

    public List<Word> getPhrasesWords() {
        return mPhrasesWords;
    }
}
