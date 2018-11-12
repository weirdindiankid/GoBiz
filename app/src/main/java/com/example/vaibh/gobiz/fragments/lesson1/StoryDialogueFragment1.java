package com.example.vaibh.gobiz.fragments.lesson1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vaibh.gobiz.LessonActivity;
import com.example.vaibh.gobiz.R;

import java.util.Objects;

// TODO: make the dialogue fragment class more modular so that we don't need a distinct one for every dialogue screen
public class StoryDialogueFragment1 extends Fragment {
    private static final String TAG = "StoryDialogueFragment1";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_story_dialogue_1, container, false);

        view.findViewById(R.id.next_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((LessonActivity)Objects.requireNonNull(getActivity())).gotoNextPage();
            }
        });

        return view;
    }
}
