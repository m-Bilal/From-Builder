package com.bilal.formbuilder.helper;

import android.util.Log;

import com.bilal.formbuilder.model.QuestionModel;

import java.util.ArrayList;
import java.util.List;

public class QuestionHelper {

    private final static String TAG = "QuestionHelper";

    public static List<QuestionModel> createTestQuestions() {
        // This method randomly generates all types of questions
        int max = 10;
        int min = 7;
        List<QuestionModel> questionModelList = new ArrayList<>();
        int size = (int)(Math.random()*((max-min)+1))+min;
        for(int i = 0; i < size; i++) {
            int type = (int)(Math.random()*((2-0)+1))+0;
            QuestionModel questionModel = new QuestionModel();
            questionModel.type = type;
            questionModel.id = i;
            if (type == 0) {
                questionModel.text = "This is question number " + (i+1)+ ". Select all options that are true";
                int answers = (int)(Math.random()*((max-min)+1))+min;
                for(int j = 0; j < answers; j++) {
                    questionModel.choiceList.add("Option " + (j+1));
                }
            } else if (type == 1) {
                questionModel.text = "This is question number " + (i+1)+ ". Enter the correct answer";
            } else {
                questionModel.text = "This is question number " + (i+1)+ ". Select the option that is true";
                int answers = (int)(Math.random()*((max-min)+1))+min;
                for(int j = 0; j < answers; j++) {
                    questionModel.choiceList.add("Option " + (j+1));
                }
            }
            questionModelList.add(questionModel);
        }
        return questionModelList;
    }
}
