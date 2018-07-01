package com.bilal.formbuilder.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bilal.formbuilder.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CheckBoxFragment extends Fragment {

    private static final String TAG = "CheckBoxFrag";

    TextView questionTextview;
    RecyclerView recyclerView;
    MyRecyclerViewAdapter adapter;

    public CheckBoxFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_question, container, false);
        questionTextview = v.findViewById(R.id.question_textview);
        recyclerView = v.findViewById(R.id.recyclerview);
        adapter = new MyRecyclerViewAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        return v;
    }

    public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView textView;
            CheckBox checkBox;


            public MyViewHolder(View view) {
                super(view);
                textView = view.findViewById(R.id.textview);
                checkBox = view.findViewById(R.id.checkbox);
            }
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_checkbox, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            //holder.title.setText(movie.getTitle());
        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }
}

