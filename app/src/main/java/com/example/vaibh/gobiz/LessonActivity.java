package com.example.vaibh.gobiz;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.vaibh.gobiz.adapters.LessonContentPagerAdapter;
import com.example.vaibh.gobiz.fragments.content.ExamplesFragment;
import com.example.vaibh.gobiz.fragments.content.ExerciseBringingItBackFragment;
import com.example.vaibh.gobiz.fragments.content.ExerciseContinuedFragment;
import com.example.vaibh.gobiz.fragments.content.ExerciseFragment;
import com.example.vaibh.gobiz.fragments.content.GenericHeaderImageCaptionScrollableBodyTextNextButtonFragment;
import com.example.vaibh.gobiz.fragments.content.HeaderAndSubheaderFragment;
import com.example.vaibh.gobiz.fragments.content.LessonSplashIntroFragment;
import com.example.vaibh.gobiz.fragments.content.NextButtonFragment;
import com.example.vaibh.gobiz.fragments.content.StoryDialogueCenterFragment;
import com.example.vaibh.gobiz.fragments.content.StoryDialogueFragment;
import com.example.vaibh.gobiz.fragments.content.StoryDialogueLeftFragment;
import com.example.vaibh.gobiz.fragments.content.StoryDialogueMiddleLeft;
import com.example.vaibh.gobiz.fragments.content.StoryDialogueRightFragment;
import com.example.vaibh.gobiz.fragments.content.StoryIntroFragment;
import com.example.vaibh.gobiz.fragments.content.StoryQuestionsFragment;
import com.example.vaibh.gobiz.fragments.content.TheoryModelFragment;
import com.example.vaibh.gobiz.pojos.UnmetNeedAndSolution;

import java.util.ArrayList;
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
        f2.setCaptionString(getString(R.string.lesson_1_story_intro_caption));
        f2.setStoryIntroString(getString(R.string.lesson_1_story_intro));

        StoryDialogueFragment f3 = new StoryDialogueRightFragment();
        f3.setDialogueString(getString(R.string.lesson_1_dialogue_1));
        f3.setDialogueImageResource(R.drawable.dialogue_1);


        StoryDialogueLeftFragment f4 = new StoryDialogueLeftFragment();
        f4.setDialogueString(getString(R.string.lesson_1_dialogue_2));
        f4.setDialogueImageResource(R.drawable.dialogue_2);


        StoryDialogueFragment f5 = new StoryDialogueCenterFragment();
        f5.setDialogueString(getString(R.string.lesson_1_dialogue_3));
        f5.setDialogueImageResource(R.drawable.dialogue_3);


        StoryDialogueFragment f6 = new StoryDialogueMiddleLeft();
        f6.setDialogueString(getString(R.string.lesson_1_dialogue_4));
        f6.setDialogueImageResource(R.drawable.dialogue_4);


        StoryDialogueFragment f7 = new StoryDialogueCenterFragment();
        f7.setDialogueString(getString(R.string.lesson_1_dialogue_5));
        f7.setDialogueImageResource(R.drawable.dialogue_5);

        StoryQuestionsFragment f8 = new StoryQuestionsFragment();
        f8.setQuestionStrings(
                getString(R.string.lesson_1_story_question_1),
                getString(R.string.lesson_1_story_question_2),
                getString(R.string.lesson_1_story_question_3)
        );

        TheoryModelFragment f9 = new TheoryModelFragment();
        f9.setTheoryModelText(getString(R.string.lesson_1_theory_model));

        ExamplesFragment f10 = new ExamplesFragment();
        f10.setCaptionString(getString(R.string.lesson_1_examples_caption));
        f10.setUnmetNeedsAndSolutionsArrayList(new ArrayList<>(Arrays.asList(
                new UnmetNeedAndSolution(getString(R.string.lesson_1_example_unmet_need_1), getString(R.string.lesson_1_example_solution_1)),
                new UnmetNeedAndSolution(getString(R.string.lesson_1_example_unmet_need_2), getString(R.string.lesson_1_example_solution_2)),
                new UnmetNeedAndSolution(getString(R.string.lesson_1_example_unmet_need_3), getString(R.string.lesson_1_example_solution_3)),
                new UnmetNeedAndSolution(getString(R.string.lesson_1_example_unmet_need_4), getString(R.string.lesson_1_example_solution_4)),
                new UnmetNeedAndSolution(getString(R.string.lesson_1_example_unmet_need_5), getString(R.string.lesson_1_example_solution_5)),
                new UnmetNeedAndSolution(getString(R.string.lesson_1_example_unmet_need_6), getString(R.string.lesson_1_example_solution_6))
        )));

        ExerciseFragment f11 = new ExerciseFragment();
        f11.setExerciseString(getString(R.string.lesson_1_exercise_part_1));
        f11.setInstructionsString(getString(R.string.lesson_1_exercise_instructions));

        ExerciseContinuedFragment f12 = new ExerciseContinuedFragment();
        f12.setExerciseString(getString(R.string.lesson_1_exercise_part_2));

        ExerciseBringingItBackFragment f13 = new ExerciseBringingItBackFragment();
        f13.setInstructionsString(getString(R.string.lesson_1_bringing_it_back_instructions));
        f13.setPromptString(getString(R.string.lesson_1_bringing_it_back_prompt));
        f13.setQuestion1String(getString(R.string.lesson_1_bringing_it_back_question_1));
        f13.setQuestion2String(getString(R.string.lesson_1_bringing_it_back_question_2));

        GenericHeaderImageCaptionScrollableBodyTextNextButtonFragment f14 = new GenericHeaderImageCaptionScrollableBodyTextNextButtonFragment();
        f14.setHeaderStrings(getString(R.string.lesson) + " " + lessonNumber, getString(R.string.success_story));
        f14.setImageResource(R.drawable.interview);
        f14.setBody(getString(R.string.lesson_1_success_story));
        f14.setCaptionString(getString(R.string.entrepreneurship_success_story));


        for (NextButtonFragment f : Arrays.asList(f14, f12, f13, f11, f10, f8, f9, f1, f2, f3, f4, f5, f6, f7)) {
            if (f instanceof HeaderAndSubheaderFragment) {
                ((HeaderAndSubheaderFragment) f).setLessonNumber(lessonNumber);
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
