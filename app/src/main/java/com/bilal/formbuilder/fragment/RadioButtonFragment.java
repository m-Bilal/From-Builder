package com.bilal.formbuilder.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bilal.formbuilder.R;
import com.bilal.formbuilder.activity.MainActivity;
import com.bilal.formbuilder.model.QuestionModel;

import java.util.LinkedList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RadioButtonFragment extends Fragment {

    private static final String TAG = "RadioButtonFrag";

    TextView questionTextview;
    RecyclerView recyclerView;
    MyRecyclerViewAdapter adapter;
    QuestionModel questionModel;

    public RadioButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_radio_button, container, false);
        int pos = getArguments().getInt("pos");
        questionModel = MainActivity.questionModelList.get(pos);
        questionTextview = v.findViewById(R.id.question_textview);
        recyclerView = v.findViewById(R.id.recyclerview);
        adapter = new MyRecyclerViewAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        questionTextview.setText(questionModel.text);
        adapter.notifyDataSetChanged();
        return v;
    }

    public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView textView;
            RadioButton radioButton;
            LinearLayout linearLayout;


            public MyViewHolder(View view) {
                super(view);
                textView = view.findViewById(R.id.textview);
                radioButton = view.findViewById(R.id.radiobutton);
                linearLayout = view.findViewById(R.id.linear_layout);
                View.OnClickListener onClickListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String answer = questionModel.choiceList.get(getAdapterPosition());
                        if(radioButton.isChecked()) {
                            removeAnswers();
                        } else {
                            removeAnswers();
                            addAnswer(answer);
                        }
                        notifyDataSetChanged();
                    }
                };
                linearLayout.setOnClickListener(onClickListener);
                radioButton.setOnClickListener(onClickListener);
            }

            void addAnswer(String answer) {
                questionModel.selectedAnswerList.add(answer);
            }

            void removeAnswers() {
                questionModel.selectedAnswerList= new LinkedList<>();
            }
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_radiobutton, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
            final String answer = questionModel.choiceList.get(position);
            holder.textView.setText(answer);
            if (questionModel.selectedAnswerList.contains(answer)) {
                holder.radioButton.setChecked(true);
            } else {
                holder.radioButton.setChecked(false);
            }

        }

        @Override
        public int getItemCount() {
            return questionModel.choiceList.size();
        }
    }
}
