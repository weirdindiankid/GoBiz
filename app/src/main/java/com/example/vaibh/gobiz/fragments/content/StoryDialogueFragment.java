package com.example.vaibh.gobiz.fragments.content;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.vaibh.gobiz.R;

public class StoryDialogueFragment extends LessonFragment {

    public static final String DIALOGUE_STRING = "DIALOGUE_STRING";

    public void setDialogueString(String text) {
        Bundle bundle = new Bundle();
        bundle.putString(StoryDialogueLeftFragment.DIALOGUE_STRING, text);
        this.setArguments(bundle);
    }

    public void setDialogueString(int strResource, Resources resources) {
        Bundle bundle = new Bundle();
        bundle.putString(StoryDialogueLeftFragment.DIALOGUE_STRING, resources.getString(strResource));
        this.setArguments(bundle);
    }

    protected void setupDialogue(View view) {
        TextView dialogueView = view.findViewById(R.id.dialogue);

        Bundle bundle = this.getArguments();
        assert bundle != null;

        String dialogueText = bundle.getString(DIALOGUE_STRING);
        dialogueView.setText(dialogueText);
    }
}
