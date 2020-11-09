package com.example.wwmillionaire;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
public class QuestionBank {
    // declare list of Question objects
    List<Question> list = new ArrayList<>();
    MyDataBaseHelper myDataBaseHelper;

    // method returns number of questions in list
    public int getLength() {
        return list.size();
    }

    // method returns question from list based on list index
    public String getQuestion(int a) {
        return list.get(a).getQuestion();
    }

    // method return a single multiple choice item for question based on list index,


    public String getChoice(int index, int num) {
        return list.get(index).getChoice(num - 1);
    }

    // method returns correct answer for the question based on list index
    public String getCorrectAnswer(int a) {
        return list.get(a).getAnswer();
    }

    public void initQuestions(Context context) {
        myDataBaseHelper = new MyDataBaseHelper(context);
        list = myDataBaseHelper.getAllQuestionsList();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestion(new Question("When did Google acquire Android ?",
                    new String[]{"2001", "2003", "2004", "2005"}, "2005"));
            myDataBaseHelper.addInitialQuestion(new Question("What is the name of build toolkit for Android Studio?",
                    new String[]{"JVM", "Gradle", "Dalvik", "HAXM"}, "Gradle"));
            myDataBaseHelper.addInitialQuestion(new Question("What widget can replace any use of radio buttons?",
                    new String[]{"Toggle Button", "Spinner", "Switch Button", "ImageButton"}, "Spinner"));
            myDataBaseHelper.addInitialQuestion(new Question("What is a widget in Android app?",
                    new String[]{"reusable GUI element", "Layout for Activity", "device placed in cans of beer", "build toolkit"}, "reusable GUI element"));
            myDataBaseHelper.addInitialQuestion(new Question("What is the capital of New Jeresey?",
                    new String[]{"Trenton", "Albany", "Jamestown", "Jersey City"}, "Trenton"));
            myDataBaseHelper.addInitialQuestion(new Question("When was Intel Founded?",
                    new String[]{"1987", "1995", "1943", "1968"}, "1968"));
            myDataBaseHelper.addInitialQuestion(new Question("Who is the creator of Nintendo?",
                    new String[]{"Jamie Alexander", "Frank Ocean", "Yamauchi", "Robinson"}, "Yamauchi"));
            myDataBaseHelper.addInitialQuestion(new Question("Who is the current CEO of Apple?",
                    new String[]{"James McFry", "Daniel Owens", "Jim Bean", "Tim Cook"}, "Tim Cook"));
            myDataBaseHelper.addInitialQuestion(new Question("Who is the new president of USA?",
                    new String[]{"James Adams", "Donald Trump", "Hilary Clinton", "Joe Biden"}, "Joe Biden"));
            myDataBaseHelper.addInitialQuestion(new Question("Who hosted Kitchen Nightmares?",
                    new String[]{"Gordon Ramsey", "Rachel Ray", "Chef Blake", "Tim Ranjan"}, "Gordon Ramsey"));

            list = myDataBaseHelper.getAllQuestionsList();//get list from database again


        }
    }
}