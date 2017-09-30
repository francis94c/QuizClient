package com.fz5.quizclient.model;

import android.content.ContentValues;
import android.text.TextUtils;

import com.fz5.quizserver.model.QuizServerDataBaseContract.*;

/**
 * Created by Francis Ilechukwu 26/09/2017.
 */

public class Question implements DataBaseObject {

    private QUESTION_TYPE questionType;
    private String question;
    private int quizId;
    private String[] options;
    private int correctOption;

    public Question(int quizId, String question, QUESTION_TYPE questionType) {
        this.questionType = questionType;
        this.question = question;
        this.quizId = quizId;
    }

    public enum QUESTION_TYPE {

        MULTI_CHOICE("multiChoice");

        String value;

        QUESTION_TYPE(String value) {
            this.value = value;
        }

        public String getTypeString() {
            return this.value;
        }

    }

    public QUESTION_TYPE getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QUESTION_TYPE questionType) {
        this.questionType = questionType;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(int correctOption) {
        this.correctOption = correctOption;
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues cv = new ContentValues();
        cv.put(DBContract.getName(Questions.QUIZ_ID), quizId);
        cv.put(DBContract.getName(Questions.QUESTION), question);
        cv.put(DBContract.getName(Questions.OPTIONS), TextUtils.join(",", options));
        cv.put(DBContract.getName(Questions.CORRECT_OPTION), correctOption);
        return cv;
    }

    @Override
    public String getTableName() {
        return Questions.TABLE_NAME;
    }

}
