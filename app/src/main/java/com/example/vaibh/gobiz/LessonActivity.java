package com.example.vaibh.gobiz;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.vaibh.gobiz.adapters.LessonContentPagerAdapter;
import com.example.vaibh.gobiz.fragments.lesson1.LessonIntroFragment;
import com.example.vaibh.gobiz.fragments.lesson1.StoryDialogueFragment1;
import com.example.vaibh.gobiz.fragments.lesson1.StoryDialogueFragment2;
import com.example.vaibh.gobiz.fragments.lesson1.StoryIntroFragment;

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

        lessonContentPagerAdapter.addFragment(new LessonIntroFragment());
        lessonContentPagerAdapter.addFragment(new StoryIntroFragment());
        lessonContentPagerAdapter.addFragment(new StoryDialogueFragment1());
        lessonContentPagerAdapter.addFragment(new StoryDialogueFragment2());

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
