package com.example.vaibh.gobiz.fragments.content;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vaibh.gobiz.R;

public class StoryIntroFragment extends HeaderAndSubheaderFragment {

    public static final String CAPTION = "CAPTION";
    public static final String STORY_INTRO = "STORY_INTRO";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_story_intro, container, false);
        setHeaderStrings("Lesson " + String.valueOf(getLessonNumber()), "Story");
        setupHeaders(view);
        setupCaption(view);
        setupStoryIntro(view);
        setupNextButton(view);
        return view;
    }

    public void setCaptionString(String caption) {
        Bundle args = getArguments();
        if (args == null) {
            args = new Bundle();
        }

        args.putString(CAPTION, caption);
        this.setArguments(args);
    }

    public void setStoryIntroString(String intro) {
        Bundle args = getArguments();
        if (args == null) {
            args = new Bundle();
        }

        args.putString(STORY_INTRO, intro);
        this.setArguments(args);
    }

    private void setupCaption(View view) {
        TextView captionView = view.findViewById(R.id.caption);

        Bundle bundle = this.getArguments();
        assert bundle != null;

        String captionText = bundle.getString(CAPTION);
        captionView.setText(captionText);
    }

    private void setupStoryIntro(View view) {
        TextView storyIntroView = view.findViewById(R.id.story_intro);

        Bundle bundle = this.getArguments();
        assert bundle != null;

        String introText = bundle.getString(STORY_INTRO);
        storyIntroView.setText(introText);
    }

}
