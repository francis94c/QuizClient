package com.fz5.quizclient.model;

import android.content.ContentValues;
import android.text.TextUtils;

import java.util.ArrayList;

import com.fz5.quizserver.model.QuizServerDataBaseContract.*;

/**
 * Created by Francis Ilechukwu 28/09/2017.
 */

public class Quiz implements DataBaseObject {

    private String title;
    private int duration;
    private int id;
    private int timesTaken;
    private ArrayList<Question> questions;

    public Quiz(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public Quiz(int id, String title, int duration) {
        this.title = title;
        this.duration = duration;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public int getTimesTaken() {
        return timesTaken;
    }

    public void setTimesTaken(int timesTaken) {
        this.timesTaken = timesTaken;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues cv = new ContentValues();
        cv.put(DBContract.getName(Quizzes.TITLE), title);
        cv.put(DBContract.getName(Quizzes.DURATION), duration);
        cv.put(DBContract.getName(Quizzes.TIMES_TAKEN), timesTaken);
        return cv;
    }

    @Override
    public String getTableName() {
        return Quizzes.TABLE_NAME;
    }
}
