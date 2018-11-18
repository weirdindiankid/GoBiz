package com.example.vaibh.gobiz;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.vaibh.gobiz.adapters.LessonContentPagerAdapter;
import com.example.vaibh.gobiz.fragments.content.HeaderAndSubheaderFragment;
import com.example.vaibh.gobiz.fragments.content.LessonSplashIntroFragment;
import com.example.vaibh.gobiz.fragments.content.NextButtonFragment;
import com.example.vaibh.gobiz.fragments.content.StoryDialogueCenterFragment;
import com.example.vaibh.gobiz.fragments.content.StoryDialogueFragment;
import com.example.vaibh.gobiz.fragments.content.StoryDialogueLeftFragment;
import com.example.vaibh.gobiz.fragments.content.StoryDialogueMiddleLeft;
import com.example.vaibh.gobiz.fragments.content.StoryDialogueRightFragment;
import com.example.vaibh.gobiz.fragments.content.StoryQuestionsFragment;
import com.example.vaibh.gobiz.fragments.content.StoryIntroFragment;
import com.example.vaibh.gobiz.fragments.content.TheoryModelFragment;

import java.util.Arrays;

public class LessonActivity extends AppCompatActivity {

    private static final String TAG = "LessonActivity";
    private LessonContentPagerAdapter lessonContentPagerAdapter;
    private ViewPager fragmentContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        lessonContentPagerAdapter = new LessonContentPagerAdapter(getSupportFragmentManager());
        fragmentContainer = findViewById(R.id.fragment_container);

        setupViewPager(fragmentContainer, 1);
    }

    private void setupViewPager(ViewPager viewPager, int lessonNumber) {
        viewPager.setPageMargin(100);

        NextButtonFragment f1 = new LessonSplashIntroFragment();

        StoryIntroFragment f2 = new StoryIntroFragment();
        f2.setCaptionString(getResources().getString(R.string.lesson_1_story_intro_caption));
        f2.setStoryIntroString(getResources().getString(R.string.lesson_1_story_intro));

        StoryDialogueFragment f3 = new StoryDialogueRightFragment();
        f3.setDialogueString(R.string.lesson_1_dialogue_1, getResources());
        f3.setDialogueImageResource(R.drawable.dialogue_1);


        StoryDialogueLeftFragment f4 =  new StoryDialogueLeftFragment();
        f4.setDialogueString(R.string.lesson_1_dialogue_2, getResources());
        f4.setDialogueImageResource(R.drawable.dialogue_2);


        StoryDialogueFragment f5 = new StoryDialogueCenterFragment();
        f5.setDialogueString(R.string.lesson_1_dialogue_3, getResources());
        f5.setDialogueImageResource(R.drawable.dialogue_3);


        StoryDialogueFragment f6 =  new StoryDialogueMiddleLeft();
        f6.setDialogueString(R.string.lesson_1_dialogue_4, getResources());
        f6.setDialogueImageResource(R.drawable.dialogue_4);


        StoryDialogueFragment f7 = new StoryDialogueCenterFragment();
        f7.setDialogueString(R.string.lesson_1_dialogue_5, getResources());
        f7.setDialogueImageResource(R.drawable.dialogue_5);

        StoryQuestionsFragment f8 = new StoryQuestionsFragment();
        f8.setQuestionStrings(
                getResources().getString(R.string.lesson_1_story_question_1),
                getResources().getString(R.string.lesson_1_story_question_2),
                getResources().getString(R.string.lesson_1_story_question_3)
        );

        TheoryModelFragment f9 = new TheoryModelFragment();
        f9.setTheoryModelText(getResources().getString(R.string.lesson_1_theory_model));

        for (NextButtonFragment f: Arrays.asList(f8, f9, f1, f2, f3, f4, f5, f6, f7)) {
            if (f instanceof HeaderAndSubheaderFragment) {
                ((HeaderAndSubheaderFragment)f).setLessonNumber(lessonNumber);
            }
            lessonContentPagerAdapter.addFragment(f);
        }
        
        viewPager.setAdapter(lessonContentPagerAdapter);
    }

    public void setViewPager(int fragmentNumber) {
        fragmentContainer.setCurrentItem(fragmentNumber);
    }

    public void gotoNextPage() {
        if (fragmentContainer.getCurrentItem() + 1 >= lessonContentPagerAdapter.getCount()) {
            Toast.makeText(this, "No next page exists; index out of bounds", Toast.LENGTH_SHORT).show();
        }

        setViewPager(fragmentContainer.getCurrentItem() + 1);
    }
}
