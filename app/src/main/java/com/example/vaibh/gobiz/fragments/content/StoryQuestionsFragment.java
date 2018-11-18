package com.example.vaibh.gobiz.fragments.content;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vaibh.gobiz.R;

// todo: extract/create string resource for header strings' "Lesson", "Story", "Questions", etc.
public class StoryQuestionsFragment extends HeaderAndSubheaderFragment {

    public static final String Q1 = "Q1";
    public static final String Q2 = "Q2";
    public static final String Q3 = "Q3";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_story_questions, container, false);

        setHeaderStrings("Lesson " + String.valueOf(getLessonNumber()), "Story - Questions");
        setupHeaders(view);

        setupNextButton(view);
        setupQuestions(view);

        return view;
    }

    public void setQuestionStrings(String q1, String q2, String q3) {
        Bundle args = getArguments();
        if (args == null) {
            args = new Bundle();
        }

        args.putString(Q1, q1);
        args.putString(Q2, q2);
        args.putString(Q3, q3);

        this.setArguments(args);
    }

    private void setupQuestions(View view) {
        TextView q1View = view.findViewById(R.id.question_1);
        TextView q2View = view.findViewById(R.id.question_2);
        TextView q3View = view.findViewById(R.id.question_3);

        Bundle bundle = this.getArguments();
        assert bundle != null;

        q1View.setText(bundle.getString(Q1));
        q2View.setText(bundle.getString(Q2));
        q3View.setText(bundle.getString(Q3));
    }
}
