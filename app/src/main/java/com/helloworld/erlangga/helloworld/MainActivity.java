package com.helloworld.erlangga.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String API_KEY = "57feb34772514a83a03e713498ae2070";
    RecyclerView mainrecyclerview;
    GridView gv, gv1;
    CryptAdapter ca;
    InfoAdapter ia;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainrecyclerview = findViewById(R.id.recyclerview1);
        mainrecyclerview.setHasFixedSize(true);
        gv = findViewById(R.id.gridview);
        gv1 = findViewById(R.id.gridview2);
        toolbar = findViewById(R.id.toolbar1);
        toolbar.inflateMenu(R.menu.menu);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();

                if(id == R.id.signin){
                    Toast.makeText(getApplicationContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                }else if(id == R.id.about){
                    Toast.makeText(getApplicationContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                }else if(id == R.id.help){
                    Toast.makeText(getApplicationContext(),"Coming Soon",Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        mainrecyclerview.setLayoutManager(layoutManager);
        mainrecyclerview.setItemAnimator(new DefaultItemAnimator());

        final ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<ResponseModel> call = apiInterface.getLatestNews("bitcoin", "publishedAt", API_KEY);

        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if(response.body().getStatus().equals("ok")){
                    List<Article> articleList = response.body().getArticles();
                    if(articleList.size()>0){
                        final NewsAdapter newsAdapter = new NewsAdapter(MainActivity.this, articleList);
                        mainrecyclerview.setAdapter(newsAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

                Log.e("out", t.toString());
            }
        });

        ca = new CryptAdapter(this, getDataCrypt());
        gv.setAdapter(ca);

        ia = new InfoAdapter(this, getDataInfo());
        gv1.setAdapter(ia);
    }

    private ArrayList getDataCrypt(){
        ArrayList<titleicon> geometries = new ArrayList<>();

        titleicon s=new titleicon();
        s.setName("Indodax");
//        s.setImage(R.drawable.kbs);
        geometries.add(s);

        s=new titleicon();
        s.setName("Binance");
//        s.setImage(R.drawable.blk);
        geometries.add(s);

        s=new titleicon();
        s.setName("Bittrex");
//        s.setImage(R.drawable.prs3);
        geometries.add(s);

        s=new titleicon();
        s.setName("Short-Mid");
//        s.setImage(R.drawable.lms3);
        geometries.add(s);

        s=new titleicon();
        s.setName("Favorite");
//        s.setImage(R.drawable.lsm4);
        geometries.add(s);

        s=new titleicon();
        s.setName("ICO NEWS");
//        s.setImage(R.drawable.tabung);
        geometries.add(s);


        return geometries;
    }

    private ArrayList getDataInfo(){
        ArrayList<titleicon> geometries = new ArrayList<>();

        titleicon s=new titleicon();
        s.setName("Flash News");
//        s.setImage(R.drawable.kbs);
        geometries.add(s);

        s=new titleicon();
        s.setName("Crypto News");
//        s.setImage(R.drawable.blk);
        geometries.add(s);

        s=new titleicon();
        s.setName("Calendar");
//        s.setImage(R.drawable.prs3);
        geometries.add(s);

        s=new titleicon();
        s.setName("Portofolio");
//        s.setImage(R.drawable.lms3);
        geometries.add(s);

        s=new titleicon();
        s.setName("My Order");
//        s.setImage(R.drawable.lsm4);
        geometries.add(s);

        s=new titleicon();
        s.setName("FAQs");
//        s.setImage(R.drawable.tabung);
        geometries.add(s);


        return geometries;
    }
}
