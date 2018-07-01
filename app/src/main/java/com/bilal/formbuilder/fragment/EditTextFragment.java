package com.bilal.formbuilder.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bilal.formbuilder.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditTextFragment extends Fragment {

    private static final String TAG = "EditTextFrag";

    TextView questionTextview;
    RecyclerView recyclerView;
    MyRecyclerViewAdapter adapter;

    public EditTextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_edit_text, container, false);
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
            EditText editText;


            public MyViewHolder(View view) {
                super(view);
                editText = view.findViewById(R.id.edittext);
            }
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_edittext, parent, false);

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

