package com.fz5.quizclient.model;

import android.content.ContentValues;

/**
 * Created by Francis Ilechukwu 30/09/2017.
 */

public class Result implements DataBaseObject {

    private String studentName;
    private int score;
    private int quizId;
    private int id;

    @Override
    public ContentValues getContentValues() {
        return null;
    }

    @Override
    public String getTableName() {
        return null;
    }
}
