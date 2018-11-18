package com.example.vaibh.gobiz.fragments.content;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.vaibh.gobiz.R;
import com.example.vaibh.gobiz.adapters.UnmetNeedsAndSolutionsAdapter;
import com.example.vaibh.gobiz.pojos.UnmetNeedAndSolution;

import java.util.ArrayList;

public class ExamplesFragment extends HeaderAndSubheaderFragment {

    public static final String CAPTION = "CAPTION";
    public static final String UNMET_NEEDS_AND_SOLUTIONS = "UNMET_NEEDS_AND_SOLUTIONS";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_examples, container, false);

        setHeaderStrings("Lesson " + String.valueOf(getLessonNumber()), "Examples");
        setupHeaders(view);

        setupNextButton(view);
        setupCaption(view);
        setupExamplesList(view);

        return view;
    }

    public void setUnmetNeedsAndSolutionsArrayList(ArrayList<UnmetNeedAndSolution> unmetNeedsAndSolutions) {
        Bundle args = getArguments();
        if (args == null) {
            args = new Bundle();
        }

        args.putParcelableArrayList(UNMET_NEEDS_AND_SOLUTIONS, unmetNeedsAndSolutions);
        this.setArguments(args);
    }
     private void setupExamplesList(View view) {
         Bundle bundle = this.getArguments();
         assert bundle != null;

         ArrayList<UnmetNeedAndSolution> unmetNeedAndSolutions = bundle.getParcelableArrayList(UNMET_NEEDS_AND_SOLUTIONS);

         UnmetNeedsAndSolutionsAdapter adapter = new UnmetNeedsAndSolutionsAdapter(getContext(), unmetNeedAndSolutions);
         ((ListView) view.findViewById(R.id.examples_list)).setAdapter(adapter);
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
