package com.example.vaibh.gobiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.vaibh.gobiz.adapters.LessonContentPagerAdapter;
import com.example.vaibh.gobiz.fragments.content.AnswersFragment;
import com.example.vaibh.gobiz.fragments.content.ConclusionFragment;
import com.example.vaibh.gobiz.fragments.content.ExamplesFragment1;
import com.example.vaibh.gobiz.fragments.content.ExamplesFragment2;
import com.example.vaibh.gobiz.fragments.content.ExerciseBringingItBackFragment;
import com.example.vaibh.gobiz.fragments.content.ExerciseContinuedFragment;
import com.example.vaibh.gobiz.fragments.content.ExerciseFragment1;
import com.example.vaibh.gobiz.fragments.content.ExerciseFragment2;
import com.example.vaibh.gobiz.fragments.content.FactoidsFragment;
import com.example.vaibh.gobiz.fragments.content.GenericHeaderImageCaptionScrollableBodyTextNextButtonFragment;
import com.example.vaibh.gobiz.fragments.content.HeaderAndSubheaderFragment;
import com.example.vaibh.gobiz.fragments.content.LessonSplashIntroFragment;
import com.example.vaibh.gobiz.fragments.content.NextButtonFragment;
import com.example.vaibh.gobiz.fragments.content.QuizFragment;
import com.example.vaibh.gobiz.fragments.content.QuizIntroFragment;
import com.example.vaibh.gobiz.fragments.content.ReviewFragment1;
import com.example.vaibh.gobiz.fragments.content.ReviewFragment2;
import com.example.vaibh.gobiz.fragments.content.StoryDialogueCenterFragment;
import com.example.vaibh.gobiz.fragments.content.StoryDialogueFragment;
import com.example.vaibh.gobiz.fragments.content.StoryDialogueLeftFragment;
import com.example.vaibh.gobiz.fragments.content.StoryDialogueMiddleLeft;
import com.example.vaibh.gobiz.fragments.content.StoryDialogueRightFragment;
import com.example.vaibh.gobiz.fragments.content.StoryIntroFragment;
import com.example.vaibh.gobiz.fragments.content.StoryQuestionsFragment;
import com.example.vaibh.gobiz.fragments.content.TheoryModelFragment;
import com.example.vaibh.gobiz.pojos.Factoid;
import com.example.vaibh.gobiz.pojos.Module;
import com.example.vaibh.gobiz.pojos.QuizQuestion;
import com.example.vaibh.gobiz.pojos.TrueFalseQuestion;
import com.example.vaibh.gobiz.pojos.UnmetNeedAndSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static com.example.vaibh.gobiz.LessonsActivity.LESSON_NUMBER;
import static com.example.vaibh.gobiz.fragments.content.LessonSplashIntroFragment.IMAGE_RES_ID;
import static com.example.vaibh.gobiz.fragments.content.LessonSplashIntroFragment.LESSON_NUM_STRING;
import static com.example.vaibh.gobiz.fragments.content.LessonSplashIntroFragment.LESSON_TITLE;

public class LessonActivity extends AppCompatActivity {

    private static final String TAG = "LessonActivity";
    private LessonContentPagerAdapter lessonContentPagerAdapter;
    private ViewPager fragmentContainer;

    private int previousPage = 0;
    private int lessonNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        Intent intent = getIntent();
        lessonNumber = intent.getIntExtra(LESSON_NUMBER, -1);

        // todo: use this data to setup all of the content. Blocked by needing the content in the db to be partitioned to fit the fragments
        Module module = intent.getParcelableExtra(LessonsActivity.MODULE);


        lessonContentPagerAdapter = new LessonContentPagerAdapter(getSupportFragmentManager());
        fragmentContainer = findViewById(R.id.fragment_container);

        setupViewPager(fragmentContainer, lessonNumber);
    }

    @SuppressLint("DefaultLocale")
    private void addFragmentsToAdapter(int lessonNumber) {

        if (lessonNumber == 1) {
            NextButtonFragment f1 = new LessonSplashIntroFragment();
            Bundle bundle = new Bundle();
            bundle.putString(LessonSplashIntroFragment.LESSON_NUM_STRING, String.format("Lesson %d:", lessonNumber));
            bundle.putString(LessonSplashIntroFragment.LESSON_TITLE, getString(R.string.lesson_2_intro_title));
            bundle.putInt(LessonSplashIntroFragment.IMAGE_RES_ID, R.drawable.lesson_1_opener);
            f1.setArguments(bundle);

            StoryIntroFragment f2 = new StoryIntroFragment();
            bundle = new Bundle();
            bundle.putString(StoryIntroFragment.CAPTION, getString(R.string.lesson_2_story_intro_caption));
            bundle.putString(StoryIntroFragment.STORY_INTRO, getString(R.string.lesson_2_story_intro));
            bundle.putInt(StoryIntroFragment.IMAGE_RES_ID, R.drawable.story_intro);
            f2.setArguments(bundle);

            StoryDialogueFragment f3 = new StoryDialogueRightFragment();
            f3.setDialogueString(getString(R.string.lesson_2_dialogue_1));
            f3.setDialogueImageResource(R.drawable.dialogue_1);

            StoryDialogueFragment f4 = new StoryDialogueLeftFragment();
            f4.setDialogueString(getString(R.string.lesson_2_dialogue_2));
            f4.setDialogueImageResource(R.drawable.dialogue_2);

            StoryDialogueFragment f5 = new StoryDialogueCenterFragment();
            f5.setDialogueString(getString(R.string.lesson_2_dialogue_3));
            f5.setDialogueImageResource(R.drawable.dialogue_3);

            StoryDialogueFragment f6 = new StoryDialogueMiddleLeft();
            f6.setDialogueString(getString(R.string.lesson_2_dialogue_4));
            f6.setDialogueImageResource(R.drawable.dialogue_4);

            StoryDialogueFragment f7 = new StoryDialogueCenterFragment();
            f7.setDialogueString(getString(R.string.lesson_2_dialogue_5));
            f7.setDialogueImageResource(R.drawable.dialogue_5);

            StoryQuestionsFragment f8 = new StoryQuestionsFragment();
            f8.setQuestionStrings(
                    getString(R.string.lesson_2_story_question_1),
                    getString(R.string.lesson_2_story_question_2),
                    getString(R.string.lesson_2_story_question_3)
            );

            TheoryModelFragment f9 = new TheoryModelFragment();
            f9.setTheoryModelText(getString(R.string.lesson_2_theory_model));

            ExamplesFragment1 f10 = new ExamplesFragment1();
            f10.setCaptionString(getString(R.string.lesson_2_etrep_traits_label));

            ArrayList<String> examples = new ArrayList<>(Arrays.asList(
                    getString(R.string.lesson_2_etrep_trait_01),
                    getString(R.string.lesson_2_etrep_trait_02),
                    getString(R.string.lesson_2_etrep_trait_03),
                    getString(R.string.lesson_2_etrep_trait_04),
                    getString(R.string.lesson_2_etrep_trait_05),
                    getString(R.string.lesson_2_etrep_trait_06),
                    getString(R.string.lesson_2_etrep_trait_07),
                    getString(R.string.lesson_2_etrep_trait_08),
                    getString(R.string.lesson_2_etrep_trait_09),
                    getString(R.string.lesson_2_etrep_trait_10),
                    getString(R.string.lesson_2_etrep_trait_11),
                    getString(R.string.lesson_2_etrep_trait_12),
                    getString(R.string.lesson_2_etrep_trait_13),
                    getString(R.string.lesson_2_etrep_trait_14),
                    getString(R.string.lesson_2_etrep_trait_15)
            ));
            f10.setStringExamples(examples);

            ExerciseFragment1 f11 = new ExerciseFragment1();
            f11.setTag("11");       // settings different tags for both f11 and f13 since we don't want those answers to be synced
            bundle = new Bundle();
            bundle.putString(ExerciseFragment1.INSTRUCTIONS, getString(R.string.lesson_2_exercise_instructions));
            bundle.putString(ExerciseFragment1.PROMPT_1, getString(R.string.label_pros));
            bundle.putString(ExerciseFragment1.PROMPT_2, getString(R.string.label_cons));
            bundle.putString(ExerciseFragment1.FOLLOWUP, getString(R.string.lesson_2_review_followup));
            f11.setArguments(bundle);

            GenericHeaderImageCaptionScrollableBodyTextNextButtonFragment f12 = new GenericHeaderImageCaptionScrollableBodyTextNextButtonFragment();
            f12.setHeaderStrings(getString(R.string.label_lesson) + " " + lessonNumber, getString(R.string.label_success_story));
            f12.setImageResource(R.drawable.john_paul);
            f12.setCaptionString(getString(R.string.label_entrepreneurship_success_story));
            f12.setBody(getString(R.string.lesson_2_success_story) + "\n\n" + getString(R.string.label_source));
            f12.setSourceLink(getString(R.string.lesson_2_success_story_source));

            ReviewFragment1 f13 = new ReviewFragment1();
            f13.setTag("13");
            f13.setCaptionString(getString(R.string.lesson_2_review_caption));
            f13.setEndNoteString(getString(R.string.lesson_2_review_followup));
            f13.setQuestion1String(getString(R.string.lesson_2_review_prompt_1));
            f13.setQuestion2String(getString(R.string.lesson_2_review_prompt_2));

            FactoidsFragment f14 = new FactoidsFragment();
            f14.setCaptionString(getString(R.string.label_factoids));
            f14.setFactoidsList(new ArrayList<>(Arrays.asList(
                    new Factoid(getString(R.string.lesson_2_factoid_1), R.drawable.check),
                    new Factoid(getString(R.string.lesson_2_factoid_2), R.drawable.check),
                    new Factoid(getString(R.string.lesson_2_factoid_3), R.drawable.check)
            )));

            ConclusionFragment f15 = new ConclusionFragment();
            f15.setCaptionString(getString(R.string.label_conclusion));
            f15.setImageResource(R.drawable.student);
            f15.setHeaderStrings(getString(R.string.label_lesson) + " " + lessonNumber, getString(R.string.label_conclusion));
            f15.setBody(getString(R.string.lesson_2_conclusion));

            QuizIntroFragment f16 = new QuizIntroFragment();

            QuizFragment f17 = new QuizFragment();
            f17.setCaptionString(getString(R.string.label_quiz));
            f17.setQuestionsList(new ArrayList<>(Arrays.asList(
                    new QuizQuestion(
                            getString(R.string.lesson_2_quiz_question_1),
                            new ArrayList<>(Arrays.asList(
                                    getString(R.string.lesson_2_quiz_question_1_answer_1),
                                    getString(R.string.lesson_2_quiz_question_1_answer_2),
                                    getString(R.string.lesson_2_quiz_question_1_answer_3)
                            )),
                            1),
                    new QuizQuestion(
                            getString(R.string.lesson_2_quiz_question_2),
                            new ArrayList<>(Arrays.asList(
                                    getString(R.string.lesson_2_quiz_question_2_answer_1),
                                    getString(R.string.lesson_2_quiz_question_2_answer_2),
                                    getString(R.string.lesson_2_quiz_question_2_answer_3)
                            )),
                            0),
                    new QuizQuestion(
                            getString(R.string.lesson_2_quiz_question_3),
                            new ArrayList<>(Arrays.asList(
                                    getString(R.string.lesson_2_quiz_question_3_answer_1),
                                    getString(R.string.lesson_2_quiz_question_3_answer_2),
                                    getString(R.string.lesson_2_quiz_question_3_answer_3)
                            )),
                            1),
                    new QuizQuestion(
                            getString(R.string.lesson_2_quiz_question_4),
                            new ArrayList<>(Arrays.asList(
                                    getString(R.string.lesson_2_quiz_question_4_answer_1),
                                    getString(R.string.lesson_2_quiz_question_4_answer_2),
                                    getString(R.string.lesson_2_quiz_question_4_answer_3)
                            )),
                            1),
                    new QuizQuestion(
                            getString(R.string.lesson_2_quiz_question_5),
                            new ArrayList<>(Arrays.asList(
                                    getString(R.string.lesson_2_quiz_question_5_answer_1),
                                    getString(R.string.lesson_2_quiz_question_5_answer_2),
                                    getString(R.string.lesson_2_quiz_question_5_answer_3)
                            )),
                            0)
            )
            ));

            for (Fragment f : Arrays.asList(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17)) {
                if (f instanceof HeaderAndSubheaderFragment) {
                    ((HeaderAndSubheaderFragment) f).setLessonNumber(lessonNumber);
                }
                lessonContentPagerAdapter.addFragment(f);
            }

        } else if (lessonNumber == 2) {
            NextButtonFragment f1 = new LessonSplashIntroFragment();
            Bundle bundle = new Bundle();
            bundle.putString(LESSON_NUM_STRING, String.format("Lesson %d:", lessonNumber));
            bundle.putString(LESSON_TITLE, getString(R.string.lesson_1_intro_title));
            bundle.putInt(IMAGE_RES_ID, R.drawable.lesson_2_opener);
            f1.setArguments(bundle);

            StoryIntroFragment f2 = new StoryIntroFragment();
            bundle = new Bundle();
            bundle.putString(StoryIntroFragment.CAPTION, getString(R.string.lesson_1_story_intro_caption));
            bundle.putString(StoryIntroFragment.STORY_INTRO, getString(R.string.lesson_1_story_intro));
            bundle.putInt(StoryIntroFragment.IMAGE_RES_ID, R.drawable.story_intro);
            f2.setArguments(bundle);

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

            ExamplesFragment2 f10 = new ExamplesFragment2();
            f10.setCaptionString(getString(R.string.lesson_1_examples_caption));
            f10.setInstructions(getString(R.string.lesson_1_examples_instructions));
            f10.setUnmetNeedsAndSolutionsArrayList(new ArrayList<>(Arrays.asList(
                    new UnmetNeedAndSolution(getString(R.string.lesson_1_example_unmet_need_1), getString(R.string.lesson_1_example_solution_1)),
                    new UnmetNeedAndSolution(getString(R.string.lesson_1_example_unmet_need_2), getString(R.string.lesson_1_example_solution_2)),
                    new UnmetNeedAndSolution(getString(R.string.lesson_1_example_unmet_need_3), getString(R.string.lesson_1_example_solution_3)),
                    new UnmetNeedAndSolution(getString(R.string.lesson_1_example_unmet_need_4), getString(R.string.lesson_1_example_solution_4)),
                    new UnmetNeedAndSolution(getString(R.string.lesson_1_example_unmet_need_5), getString(R.string.lesson_1_example_solution_5)),
                    new UnmetNeedAndSolution(getString(R.string.lesson_1_example_unmet_need_6), getString(R.string.lesson_1_example_solution_6))
            )));

            ExerciseFragment2 f11 = new ExerciseFragment2();
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
            f14.setHeaderStrings(getString(R.string.label_lesson) + " " + lessonNumber, getString(R.string.label_success_story));
            f14.setImageResource(R.drawable.interview);
            f14.setBody(getString(R.string.lesson_1_success_story));
            f14.setCaptionString(getString(R.string.label_entrepreneurship_success_story));

            ReviewFragment2 f15 = new ReviewFragment2();
            f15.setCaptionString(getString(R.string.lesson_1_review_caption));
            f15.setEndNoteString(getString(R.string.lesson_1_review_end_note));
            f15.setPromptString(getString(R.string.lesson_1_review_prompt));
            f15.setQuestion1String(getString(R.string.lesson_1_bringing_it_back_question_1));
            f15.setQuestion2String(getString(R.string.lesson_1_bringing_it_back_question_2));
            f15.setReviewListStrings(new ArrayList<>(Arrays.asList(
                    getString(R.string.lesson_1_review_list_question_1),
                    getString(R.string.lesson_1_review_list_question_2),
                    getString(R.string.lesson_1_review_list_question_3),
                    getString(R.string.lesson_1_review_list_question_4),
                    getString(R.string.lesson_1_review_list_question_5),
                    getString(R.string.lesson_1_review_list_question_6)
            )));

            FactoidsFragment f16 = new FactoidsFragment();
            f16.setCaptionString(getString(R.string.label_factoids));
            f16.setFactoidsList(new ArrayList<>(Arrays.asList(
                    new Factoid(getString(R.string.lesson_1_factoid_1), R.drawable.check),
                    new Factoid(getString(R.string.lesson_1_factoid_2), R.drawable.check),
                    new Factoid(getString(R.string.lesson_1_factoid_3), R.drawable.check)
            )));

            ConclusionFragment f17 = new ConclusionFragment();
            f17.setCaptionString("Conclusion");
            f17.setImageResource(R.drawable.student);
            f17.setHeaderStrings(getString(R.string.label_lesson) + " " + lessonNumber, getString(R.string.label_conclusion));
            f17.setBody(getString(R.string.lesson_1_conclusion));

            QuizIntroFragment f18 = new QuizIntroFragment();

            QuizFragment f19 = new QuizFragment();
            f19.setCaptionString(getString(R.string.label_quiz));
            f19.setQuestionsList(new ArrayList<>(Arrays.asList(
                    new QuizQuestion(
                            getString(R.string.lesson_1_quiz_question_1),
                            new ArrayList<String>(Arrays.asList(
                                    getString(R.string.lesson_1_quiz_question_1_answer_1),
                                    getString(R.string.lesson_1_quiz_question_1_answer_2),
                                    getString(R.string.lesson_1_quiz_question_1_answer_3),
                                    getString(R.string.lesson_1_quiz_question_1_answer_4)
                            )),
                            0
                    ),
                    new TrueFalseQuestion(
                            getString(R.string.lesson_1_quiz_question_2),
                            true
                    ),
                    new QuizQuestion(
                            getString(R.string.lesson_1_quiz_question_3),
                            new ArrayList<String>(Arrays.asList(
                                    getString(R.string.lesson_1_quiz_question_3_answer_1),
                                    getString(R.string.lesson_1_quiz_question_3_answer_2),
                                    getString(R.string.lesson_1_quiz_question_3_answer_3),
                                    getString(R.string.lesson_1_quiz_question_3_answer_4)
                            )),
                            1
                    ),
                    new TrueFalseQuestion(
                            getString(R.string.lesson_1_quiz_question_4),
                            false
                    )
            )));


            for (Fragment f : Arrays.asList(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19)) {
                if (f instanceof HeaderAndSubheaderFragment) {
                    ((HeaderAndSubheaderFragment) f).setLessonNumber(lessonNumber);
                }
                lessonContentPagerAdapter.addFragment(f);
            }
        }
    }

    private void setupViewPager(final ViewPager viewPager, int lessonNumber) {
        viewPager.setPageMargin(100);

        addFragmentsToAdapter(lessonNumber);

        viewPager.setAdapter(lessonContentPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                Fragment f = ((LessonContentPagerAdapter) (Objects.requireNonNull(viewPager.getAdapter()))).getItem(i);
                if (f instanceof AnswersFragment) {
                    AnswersFragment t = (AnswersFragment) f;
                    t.refreshAnswers();
                } else {
                    // save answers if we're moving away from an answers fragment
                    boolean movedForward = i > previousPage;
                    if (movedForward) {
                        if (i > 0) {
                            Fragment prev = ((LessonContentPagerAdapter) (Objects.requireNonNull(viewPager.getAdapter()))).getItem(i - 1);
                            if (prev instanceof AnswersFragment) {
                                ((AnswersFragment) prev).saveAnswers();
                            }
                        }
                    } else {
                        if (i < viewPager.getAdapter().getCount() - 1) {
                            Fragment next = ((LessonContentPagerAdapter) (Objects.requireNonNull(viewPager.getAdapter()))).getItem(i + 1);
                            if (next instanceof AnswersFragment) {
                                ((AnswersFragment) next).saveAnswers();
                            }
                        }
                    }
                }

                previousPage = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });
    }

    public void setViewPagerPage(int fragmentNumber) {
        fragmentContainer.setCurrentItem(fragmentNumber);
    }

    public void gotoNextPage() {
        if (fragmentContainer.getCurrentItem() + 1 >= lessonContentPagerAdapter.getCount()) {
            Toast.makeText(this, "No next page exists; index out of bounds", Toast.LENGTH_SHORT).show();
        }

        setViewPagerPage(fragmentContainer.getCurrentItem() + 1);
    }

    public int getLessonNumber() {
        return lessonNumber;
    }
}
