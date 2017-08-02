package com.example.administrator.day29_yuekaolianxiti;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import xListView.XListView;

/**
 * Created by Administrator on 2017/7/26 0026.
 */
public class Fragment01 extends Fragment implements XListView.IXListViewListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment01, container, false);

        final XListView xListView = (XListView) view.findViewById(R.id.tvxlist);
        xListView.setXListViewListener(this);

        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                try {
                    URL url = new URL("http://huixinguiyu.cn/Assets/js/newsnew.js");
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(8000);
                    httpURLConnection.setReadTimeout(8000);
                    int code = httpURLConnection.getResponseCode();
                    if (code == 200) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        ByteArrayOutputStream outputstream = new ByteArrayOutputStream();
                        int len = 0;
                        byte[] buffer = new byte[1024];
                        while ((len = inputStream.read(buffer)) != -1) {
                            outputstream.write(buffer, 0, len);

                        }
                        return outputstream.toString();
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                List<myBean.NewslistBean.NewsBean> list=new ArrayList<myBean.NewslistBean.NewsBean>();
                Gson gson=new Gson();
                myBean myBean = gson.fromJson(s, myBean.class);
                list=myBean.newslist.news;

                myBaseAdapter adapter=new myBaseAdapter(list,getActivity());
                xListView.setAdapter(adapter);


            }
        }.execute();


        return view;
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
