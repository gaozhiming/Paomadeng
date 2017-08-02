package com.example.administrator.day29_yuekaolianxiti;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    
    private FragmentManager fragmentManager;
    private RadioGroup radioGroup;
    private Fragment01 fragment01;
    private Fragment02 fragment02;
    private Fragment03 fragment03;
    private Banner banner;
    private List<Integer> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        banner = (Banner) findViewById(R.id.tvbanner);

        banner.setImageLoader(new ImagerLoaderBanner());

        mList = new ArrayList<>();


        mList.add(R.drawable.aa);
        mList.add(R.drawable.aaa);
        mList.add(R.drawable.aaaa);
        mList.add(R.drawable.ss);
        mList.add(R.drawable.sss);

        banner.setImages(mList);
        banner.start();

        fragment01 = new Fragment01();
        fragment02 = new Fragment02();
        fragment03 = new Fragment03();

        getfragment(fragment01);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.but01:
                        getfragment(fragment01);
                        break;
                    case R.id.but02:
                        getfragment(fragment02);
                        break;
                    case R.id.but03:
                        getfragment(fragment03);
                        break;

                    default:
                        break;
                }

            }
        });
    }



    //通过动态添加fragment
    public void getfragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment, fragment);
        transaction.commit();

    }

}