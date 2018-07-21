package io.github.umangjpatel.miwok;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.github.umangjpatel.miwok.databinding.ActivityMainBinding;
import io.github.umangjpatel.miwok.databinding.WordListItemBinding;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_ITEM_ID = MainActivity.class.getSimpleName() + ".key_item_id";

    private ActivityMainBinding mBinding;
    private WordViewModel mWordViewModel;
    private WordAdapter mWordAdapter;

    private int mItemId;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            mItemId = item.getItemId();
            switch (mItemId) {
                case R.id.navigation_numbers:
                    mWordViewModel.getWords(0);
                    return true;
                case R.id.navigation_family:
                    mWordViewModel.getWords(1);
                    return true;
                case R.id.navigation_colors:
                    mWordViewModel.getWords(2);
                    return true;
                case R.id.navigation_phrases:
                    mWordViewModel.getWords(3);
                    return true;
                default:
                    return false;
            }
        }
    };

    @NonNull
    public static Intent newIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    private void setUpRecyclerView() {
        mBinding.wordsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.wordsRecyclerView.setHasFixedSize(true);
        mBinding.wordsRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
    }

    private void setUpAdapter() {
        if (mWordAdapter == null) {
            mWordAdapter = new WordAdapter(mWordViewModel.getWordsLiveData().getValue());
            mBinding.wordsRecyclerView.setAdapter(mWordAdapter);
        } else
            mWordAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setLifecycleOwner(this);
        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);
        setUpRecyclerView();
        setUpAdapter();
        mBinding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mItemId = savedInstanceState != null ? savedInstanceState.getInt(KEY_ITEM_ID) : R.id.navigation_numbers;
        mBinding.navigation.setSelectedItemId(mItemId);
        mWordViewModel.getWordsLiveData().observe(this, words -> {
            mWordAdapter.setWords(words);
            mWordAdapter.notifyDataSetChanged();
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_ITEM_ID, mItemId);
    }

    private class WordHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private WordListItemBinding mWordListItemBinding;

        private Word mWord;

        WordHolder(WordListItemBinding wordListItemBinding) {
            super(wordListItemBinding.getRoot());
            mWordListItemBinding = wordListItemBinding;
        }

        public void bind(Word word) {
            mWord = word;
            mWordListItemBinding.wordListItem.setBackgroundColor(Color.parseColor(getResources().getString(mWord.getColorResId())));
            mWordListItemBinding.miwokTextView.setText(mWord.getMiwokResId());
            mWordListItemBinding.normalTextView.setText(mWord.getNormalResId());
            if (mWord.getImageResId() == 0)
                mWordListItemBinding.wordImageView.setVisibility(View.GONE);
            else {
                mWordListItemBinding.wordImageView.setVisibility(View.VISIBLE);
                mWordListItemBinding.wordImageView.setImageResource(mWord.getImageResId());
            }
            itemView.setOnClickListener(this);
            mWordListItemBinding.executePendingBindings();
        }

        @Override
        public void onClick(View v) {
            final MediaPlayer player = MediaPlayer.create(MainActivity.this, mWord.getSoundResId());
            player.start();
            player.setOnCompletionListener(mp -> {
                mp.stop();
                mp.release();
                player.release();
            });
        }

    }

    private class WordAdapter extends RecyclerView.Adapter<WordHolder> {

        private List<Word> mWords;

        WordAdapter(List<Word> words) {
            mWords = words;
        }

        @NonNull
        @Override
        public WordHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            WordListItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.word_list_item, parent, false);
            return new WordHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull WordHolder holder, int position) {
            Word word = mWords.get(position);
            holder.bind(word);
        }

        @Override
        public int getItemCount() {
            return mWords.size();
        }

        void setWords(List<Word> words) {
            mWords = words;
        }

    }

    private class SimpleDividerItemDecoration extends RecyclerView.ItemDecoration {

        private Drawable mDivider;

        SimpleDividerItemDecoration(Context context) {
            mDivider = ContextCompat.getDrawable(context, R.drawable.line_divider);
        }

        @Override
        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();

            int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = parent.getChildAt(i);

                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

                int top = child.getBottom() + params.bottomMargin;
                int bottom = top + mDivider.getIntrinsicHeight();

                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }

    }
}
