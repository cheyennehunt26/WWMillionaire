package com.example.wwmillionaire;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MyDataBaseHelper extends SQLiteOpenHelper {
    // Database name
    public static String DATABASE_QUESTION = "questionBank.db";
    // Current version of database
    private static final int DATABASE_VERSION = 1;
    // Database table name
    private static final String TABLE_QUESTION = "QuestionBank";
    // All fields used in database table
    private static final String KEY_ID = "id";
    private static final String QUESTION = "question";
    private static final String CHOICE1 = "choice1";
    private static final String CHOICE2 = "choice2";
    private static final String CHOICE3 = "choice3";
    private static final String CHOICE4 = "choice4";
    private static final String CHOICE5 = "choice5";
    private static final String CHOICE6 = "choice6";
    private static final String CHOICE7 = "choice7";
    private static final String CHOICE8 = "choice8";
    private static final String CHOICE9 = "choice9";
    private static final String CHOICE10 = "choice10";
    private static final String ANSWER = "answer";
    // Question Table Create Query in this string
    private static final String CREATE_TABLE_QUESTION = "CREATE TABLE "
            + TABLE_QUESTION + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + QUESTION + " TEXT,"
            + CHOICE1 + " TEXT, " + CHOICE2 + " TEXT, " + CHOICE3 + " TEXT, "
            + CHOICE4 + " TEXT," + CHOICE5 +"TEXT," + CHOICE6 +"TEXT,"
            + CHOICE7 +"TEXT,"+ CHOICE8 +"TEXT,"+ CHOICE9 +"TEXT,"+ CHOICE10 +"TEXT,"
            + ANSWER + " TEXT);";

    public MyDataBaseHelper(Context context) {
        super(context, DATABASE_QUESTION, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_QUESTION); // create question table
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_QUESTION); // drop table if exists
        onCreate(db);
    }

    /**
     * This method is used to add question detail in question Table
     */
    public long addInitialQuestion(Question question) {
        SQLiteDatabase db = this.getWritableDatabase();
// Creating content values
        ContentValues values = new ContentValues();
        values.put(QUESTION, question.getQuestion());
        values.put(CHOICE1, question.getChoice(0));
        values.put(CHOICE2, question.getChoice(1));
        values.put(CHOICE3, question.getChoice(2));
        values.put(CHOICE4, question.getChoice(3));
        values.put(CHOICE5, question.getChoice(4));
        values.put(CHOICE6, question.getChoice(5));
        values.put(CHOICE7, question.getChoice(6));
        values.put(CHOICE8, question.getChoice(7));
        values.put(CHOICE9, question.getChoice(8));
        values.put(CHOICE10, question.getChoice(9));
        values.put(ANSWER, question.getAnswer());
// insert row in question table
        long insert = db.insert(TABLE_QUESTION, null, values);
        return insert;
    }

    public List<Question> getAllQuestionsList() {
        List<Question> questionArrayList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_QUESTION;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

// looping through all records and adding to the list
        if (c.moveToFirst()) {
            do {
                Question question = new Question();

                String questText = c.getString(c.getColumnIndex(QUESTION));
                question.setQuestion(questText);

                String choice1Text = c.getString(c.getColumnIndex(CHOICE1));
                question.setChoice(0, choice1Text);

                String choice2Text = c.getString(c.getColumnIndex(CHOICE2));
                question.setChoice(1, choice2Text);

                String choice3Text = c.getString(c.getColumnIndex(CHOICE3));
                question.setChoice(2, choice3Text);

                String choice4Text = c.getString(c.getColumnIndex(CHOICE4));
                question.setChoice(3, choice4Text);

                String choice5Text = c.getString(c.getColumnIndex(CHOICE4));
                question.setChoice(4, choice5Text);

                String choice6Text = c.getString(c.getColumnIndex(CHOICE4));
                question.setChoice(5, choice6Text);

                String choice7Text = c.getString(c.getColumnIndex(CHOICE4));
                question.setChoice(6, choice7Text);

                String choice8Text = c.getString(c.getColumnIndex(CHOICE4));
                question.setChoice(7, choice8Text);

                String choice9Text = c.getString(c.getColumnIndex(CHOICE4));
                question.setChoice(8, choice9Text);

                String choice10Text = c.getString(c.getColumnIndex(CHOICE4));
                question.setChoice(9, choice10Text);

                String answerText = c.getString(c.getColumnIndex(ANSWER));
                question.setAnswer(answerText);

// adding to Questions list
                questionArrayList.add(question);
            } while (c.moveToNext());

        }
        return questionArrayList;
    }
}
