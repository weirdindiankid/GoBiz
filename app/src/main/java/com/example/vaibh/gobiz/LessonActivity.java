package com.example.vaibh.gobiz;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.vaibh.gobiz.adapters.LessonContentPagerAdapter;
import com.example.vaibh.gobiz.fragments.content.LessonFragment;
import com.example.vaibh.gobiz.fragments.content.LessonIntroFragment;
import com.example.vaibh.gobiz.fragments.content.StoryDialogueCenterFragment;
import com.example.vaibh.gobiz.fragments.content.StoryDialogueFragment;
import com.example.vaibh.gobiz.fragments.content.StoryDialogueLeftFragment;
import com.example.vaibh.gobiz.fragments.content.StoryDialogueMiddleLeft;
import com.example.vaibh.gobiz.fragments.content.StoryDialogueRightFragment;
import com.example.vaibh.gobiz.fragments.content.StoryIntroFragment;

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

        setupViewPager(fragmentContainer);
    }

    private void setupViewPager(ViewPager viewPager) {
        viewPager.setPageMargin(100);

        LessonFragment f1 = new LessonIntroFragment();
        lessonContentPagerAdapter.addFragment(f1);

        LessonFragment f2 = new StoryIntroFragment();
        lessonContentPagerAdapter.addFragment(f2);

        StoryDialogueFragment f3 = new StoryDialogueRightFragment();
        f3.setDialogueString(R.string.lesson_1_dialogue_1, getResources());
        lessonContentPagerAdapter.addFragment(f3);


        StoryDialogueLeftFragment f4 =  new StoryDialogueLeftFragment();
        f4.setDialogueString(R.string.lesson_1_dialogue_2, getResources());
        lessonContentPagerAdapter.addFragment(f4);


        StoryDialogueFragment f5 = new StoryDialogueCenterFragment();
        f5.setDialogueString(R.string.lesson_1_dialogue_3, getResources());
        lessonContentPagerAdapter.addFragment(f5);


        StoryDialogueFragment f6 =  new StoryDialogueMiddleLeft();
        f6.setDialogueString(R.string.lesson_1_dialogue_4, getResources());
        lessonContentPagerAdapter.addFragment(f6);


        StoryDialogueFragment f7 = new StoryDialogueCenterFragment();
        f7.setDialogueString(R.string.lesson_1_dialogue_5, getResources());
        lessonContentPagerAdapter.addFragment(f7);

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
