package com.bilal.formbuilder.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bilal.formbuilder.R;
import com.bilal.formbuilder.activity.MainActivity;
import com.bilal.formbuilder.model.QuestionModel;

import java.util.LinkedList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditTextFragment extends Fragment {

    private static final String TAG = "EditTextFrag";

    TextView questionTextview;
    Button button;
    EditText editText;
    QuestionModel questionModel;

    public EditTextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_edit_text, container, false);
        int pos = getArguments().getInt("pos");
        questionModel = MainActivity.questionModelList.get(pos);
        questionTextview = v.findViewById(R.id.question_textview);
        editText = v.findViewById(R.id.edittext);
        button = v.findViewById(R.id.button);
        questionTextview.setText(questionModel.text);
        try {
            editText.setText(questionModel.selectedAnswerList.get(0));
        } catch (Exception e) {
            e.printStackTrace();
            editText.setText("");
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionModel.selectedAnswerList = new LinkedList<>();
                questionModel.selectedAnswerList.add(editText.getText().toString());
                // hide virtual keyboard
                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editText.getWindowToken(),
                        InputMethodManager.RESULT_UNCHANGED_SHOWN);
            }
        });
        return v;
    }
}

