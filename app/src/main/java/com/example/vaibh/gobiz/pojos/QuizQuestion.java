package com.example.vaibh.gobiz.pojos;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class QuizQuestion implements Parcelable {

    private ArrayList<String> options;
    private String question;
    private int answerIndex;

    public QuizQuestion(String question, ArrayList<String> options, int answerIndex) {
        assert question != null;
        assert options != null;

        this.options = options;
        this.answerIndex = answerIndex;
        setQuestion(question);
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }


    public String getQuestion() {
        return question;
    }

    protected void setQuestion(String question) {
        this.question = question;
    }

    protected QuizQuestion(Parcel in) {
        if (in.readByte() == 0x01) {
            options = new ArrayList<String>();
            in.readList(options, String.class.getClassLoader());
        } else {
            options = null;
        }
        question = in.readString();
        answerIndex = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (options == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(options);
        }
        dest.writeString(question);
        dest.writeInt(answerIndex);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<QuizQuestion> CREATOR = new Parcelable.Creator<QuizQuestion>() {
        @Override
        public QuizQuestion createFromParcel(Parcel in) {
            return new QuizQuestion(in);
        }

        @Override
        public QuizQuestion[] newArray(int size) {
            return new QuizQuestion[size];
        }
    };
}