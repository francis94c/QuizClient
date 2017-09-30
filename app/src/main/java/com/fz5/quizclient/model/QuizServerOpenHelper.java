package com.fz5.quizclient.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.fz5.quizserver.model.QuizServerDataBaseContract.*;

/**
 * Created by Francis Ilechukwu 28/09/2017.
 */

public class QuizServerOpenHelper extends SQLiteOpenHelper {

    private static final int database_version = 1;

    public QuizServerOpenHelper(Context context) {
        super(context, "athena.db", null, database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Quizzes
        sqLiteDatabase.execSQL(DBContract.createTable(Quizzes.TABLE_NAME, Quizzes.CONFIG, ""));
        // Questions
        sqLiteDatabase.execSQL(DBContract.createTable(Questions.TABLE_NAME, Questions.CONFIG, ""));
        // Results
        sqLiteDatabase.execSQL(DBContract.createTable(Results.TABLE_NAME, Results.CONFIG, Results.CONSTRAINTS));
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Quizzes.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Questions.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Results.TABLE_NAME);
    }
}
