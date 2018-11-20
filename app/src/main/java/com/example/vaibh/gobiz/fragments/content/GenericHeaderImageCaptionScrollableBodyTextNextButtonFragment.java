package com.example.vaibh.gobiz.fragments.content;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vaibh.gobiz.R;

public class GenericHeaderImageCaptionScrollableBodyTextNextButtonFragment extends HeaderAndSubheaderFragment {

    private static final String IMAGE = "IMAGE";
    private static final String CAPTION = "CAPTION";
    private static final String BODY = "BODY";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conclusion, container, false);
        setupFragment(view);
        return view;
    }

    protected void setupFragment(View view) {
        setupHeaders(view);
        setupImage(view);
        setupCaption(view);
        setupBody(view);
        setupNextButton(view);
    }

    public void setImageResource(int imageResource) {
        Bundle args = getArguments();
        if (args == null) {
            args = new Bundle();
        }

        args.putInt(IMAGE, imageResource);

        this.setArguments(args);
    }

    public void setCaptionString(String caption) {
        Bundle args = getArguments();
        if (args == null) {
            args = new Bundle();
        }

        args.putString(CAPTION, caption);
        this.setArguments(args);
    }

    public void setBody(String body) {
        Bundle args = getArguments();
        if (args == null) {
            args = new Bundle();
        }

        args.putString(BODY, body);
        this.setArguments(args);
    }

    private void setupBody(View view) {
        TextView bodyView = view.findViewById(R.id.body);

        Bundle bundle = this.getArguments();
        assert bundle != null;

        bodyView.setText(bundle.getString(BODY));
    }

    private void setupCaption(View view) {
        TextView captionView = view.findViewById(R.id.caption);

        Bundle bundle = this.getArguments();
        assert bundle != null;

        captionView.setText(bundle.getString(CAPTION));
    }

    private void setupImage(View view) {
        ImageView imageView = view.findViewById(R.id.banner_image);

        Bundle bundle = this.getArguments();
        assert bundle != null;

        imageView.setImageResource(bundle.getInt(IMAGE));
    }
}
