package com.bilal.formbuilder.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bilal.formbuilder.R;
import com.bilal.formbuilder.activity.MainActivity;
import com.bilal.formbuilder.model.QuestionModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class CheckBoxFragment extends Fragment {

    private static final String TAG = "CheckBoxFrag";

    TextView questionTextview;
    RecyclerView recyclerView;
    MyRecyclerViewAdapter adapter;
    QuestionModel questionModel;

    public CheckBoxFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_check_box, container, false);
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
            CheckBox checkBox;
            LinearLayout linearLayout;


            public MyViewHolder(View view) {
                super(view);
                textView = view.findViewById(R.id.textview);
                checkBox = view.findViewById(R.id.checkbox);
                linearLayout = view.findViewById(R.id.linear_layout);
            }
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_checkbox, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
            final String answer = questionModel.choiceList.get(position);
            holder.textView.setText(answer);
            if (questionModel.selectedAnswerList.contains(answer)) {
                holder.checkBox.setChecked(true);
            } else {
                holder.checkBox.setChecked(false);
            }
            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(holder.checkBox.isChecked()) {
                        holder.checkBox.setChecked(false);
                        removeAnswer(answer);
                    } else {
                        holder.checkBox.setChecked(true);
                        addAnswer(answer);
                    }
                }
            });
            holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b) {
                        addAnswer(answer);
                    } else {
                        removeAnswer(answer);
                    }
                }
            });
        }

        void addAnswer(String answer) {
            questionModel.selectedAnswerList.add(answer);
        }

        void removeAnswer(String answer) {
            questionModel.selectedAnswerList.remove(answer);
        }

        @Override
        public int getItemCount() {
            return questionModel.choiceList.size();
        }
    }
}

