package com.bilal.formbuilder.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bilal.formbuilder.R;
import com.bilal.formbuilder.fragment.CheckBoxFragment;
import com.bilal.formbuilder.fragment.EditTextFragment;
import com.bilal.formbuilder.fragment.RadioButtonFragment;
import com.bilal.formbuilder.helper.QuestionHelper;
import com.bilal.formbuilder.model.QuestionModel;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";

    ViewPager viewPager;

    public static List<QuestionModel> questionModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSurveyQuestions();
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new ScreenSlidePagerAdapter(getSupportFragmentManager()));
    }

    void getSurveyQuestions() {
        questionModelList = QuestionHelper.createTestQuestions();
    }

    public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            QuestionModel questionModel = questionModelList.get(position);
            Bundle bundle = new Bundle();
            bundle.putInt("pos", position);
            if (questionModel.type == 0) {
                CheckBoxFragment fragment = new CheckBoxFragment();
                fragment.setArguments(bundle);
                return fragment;
            } else if (questionModel.type == 1) {
                EditTextFragment fragment = new EditTextFragment();
                fragment.setArguments(bundle);
                return fragment;
            } else if (questionModel.type == 2) {
                RadioButtonFragment fragment = new RadioButtonFragment();
                fragment.setArguments(bundle);
                return fragment;
            } else {
                Log.e(TAG, "ScreenSlidePagerAdapter, getItem(), returned null");
                return null;
            }
        }

        @Override
        public int getCount() {
            return questionModelList.size();
        }
    }
}
