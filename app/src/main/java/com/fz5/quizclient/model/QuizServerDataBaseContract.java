package com.fz5.quizclient.model;

/**
 * Created by Francis Ilechukwu 28/09/2017.
 */

class QuizServerDataBaseContract {

    static class Quizzes {
        static String TABLE_NAME = "quizzes";
        static String ID = "_id INTEGER PRIMARY KEY";
        static String TITLE = "title VARCHAR(50) NOT NULL";
        static String DURATION = "duration INTEGER NOT NULL";
        static String TIMES_TAKEN = "times_taken INTEGER";
        static String[] CONFIG = {ID, TITLE, DURATION, TIMES_TAKEN};
        static int ID_INDEX = 1;
        static int TITLE_INDEX = 2;
        static int DURATION_INDEX = 3;
        static int TIMES_TAKEN_ID = 4;
    }

    static class Questions {
        static String TABLE_NAME = "questions";
        static String ID = "_id INTEGER PRIMARY KEY";
        static String QUIZ_ID = "quiz_id INTEGER NOT NULL";
        static String QUESTION = "question TEXT NOT NULL";
        static String OPTIONS = "options TEXT NOT NULL";
        static String CORRECT_OPTION = "correct_option INTEGER NOT NULL";
        static String[] CONFIG = {ID, QUIZ_ID, QUESTION, OPTIONS, CORRECT_OPTION};
        static int ID_INDEX = 1;
        static int QUIZ_ID_INDEX = 2;
        static int QUESTION_ID = 3;
        static int OPTIONS_INDEX = 4;
        static int CORRECT_OPTION_INDEX = 5;
    }

    static class Results {
        static String TABLE_NAME = "results";
        static String ID = "_id INTEGER PRIMARY KEY";
        static String STUDENT_NAME = "student_name VARCHAR(50)";
        static String QUIZ_ID = "quiz_id INTEGER NOT NULL";
        static String SCORE = "score INTEGER NOT NULL";
        static String CONSTRAINTS = "FOREIGN KEY (quiz_id) REFERENCES quizzes(_id)";
        static String[] CONFIG = {ID, STUDENT_NAME, QUIZ_ID, SCORE};
        static int ID_INDEX = 1;
        static int STUDENT_NAME_INDEX = 2;
        static int QUIZ_ID_INDEX = 3;
        static int SCORE_INDEX = 4;
    }

    static class DBContract {
        static String createTable(String name, String[] configs, String constraints) {
            StringBuilder sql = new StringBuilder("CREATE TABLE ").append(name).append(" (");
            for (String column : configs) {
                sql.append(column).append(", ");
            }
            if (!constraints.equals("")) {
                sql.append(constraints);
            } else {
                sql.replace(sql.lastIndexOf(","), sql.lastIndexOf(",") + 2, "");
            }
            sql.append(");");
            return sql.toString();
        }
        /**
         * returns name part of column config
         *
         * @param config column config e.g. first_ name Varchar(15)
         * @return column name.
         */
        static String getName(String config) {
            return config.substring(0, config.indexOf(" "));
        }
    }

}
