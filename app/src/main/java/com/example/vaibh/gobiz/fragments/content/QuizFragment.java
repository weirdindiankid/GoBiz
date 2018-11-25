package com.example.vaibh.gobiz.fragments.content;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vaibh.gobiz.R;
import com.example.vaibh.gobiz.adapters.QuizQuestionsAdapter;
import com.example.vaibh.gobiz.pojos.QuizQuestion;
import com.github.paolorotolo.expandableheightlistview.ExpandableHeightListView;

import java.util.ArrayList;

public class QuizFragment extends HeaderAndSubheaderFragment {

    private static final String CAPTION = "CAPTION";
    private static final String QUESTIONS = "QUESTIONS";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        setHeaderStrings(getString(R.string.lesson) + " " + getLessonNumber(), getString(R.string.quiz));
        setupHeaders(view);
        setupCaption(view);
        setupQuestions(view);
        setupNextButton(view);

        return view;
    }

    public void setQuestionsList(ArrayList<QuizQuestion> arr) {
        Bundle args = getArguments();
        if (args == null) {
            args = new Bundle();
        }

        args.putParcelableArrayList(QUESTIONS, arr);
        this.setArguments(args);
    }

    private void setupQuestions(View view) {
        ExpandableHeightListView listView = view.findViewById(R.id.quiz_questions_list);

        Bundle bundle = this.getArguments();
        assert bundle != null;

        Context context = getActivity();
        assert context != null;

        ArrayList<QuizQuestion> arr = bundle.getParcelableArrayList(QUESTIONS);
        assert arr != null;

        QuizQuestionsAdapter adapter = new QuizQuestionsAdapter(context, arr);
        listView.setAdapter(adapter);
        listView.setExpanded(true);
    }

    public void setCaptionString(String string) {
        Bundle args = getArguments();
        if (args == null) {
            args = new Bundle();
        }

        args.putString(CAPTION, string);
        this.setArguments(args);
    }

    private void setupCaption(View view) {
        TextView caption = view.findViewById(R.id.caption);

        Bundle bundle = this.getArguments();
        assert bundle != null;

        caption.setText(bundle.getString(CAPTION));
    }
}
