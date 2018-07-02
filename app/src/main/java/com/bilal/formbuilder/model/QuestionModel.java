package com.bilal.formbuilder.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class QuestionModel {
    public int type;
    /* TYPE:
    * 1: MCQ with multiple possible answers, CheckBoxFragment
    * 2: A string as an answer, not MCQ, EditTextFragment
    * 3: MCQ with single possible answer, RadioButtonFragment
    * */
    public String text;
    public int id; // unique identifier for the question, could be the question number
    public List<String> choiceList; // answer choices that the question has
    public List<String> selectedAnswerList; // answer(s) selected by the user

    public QuestionModel() {
        choiceList = new ArrayList<>();
        selectedAnswerList = new LinkedList<>();
    }
}
