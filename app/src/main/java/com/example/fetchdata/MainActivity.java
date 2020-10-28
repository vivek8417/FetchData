package com.example.fetchdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=findViewById(R.id.listView);
        TextView textView=findViewById(R.id.textView);
        Retrofit retrofit=new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        Api api=retrofit.create(Api.class);
        Call<List<Data>> call=api.getData();
        call.enqueue(new Callback<List<Data>>() {
            @Override
            public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                List<Data> data=response.body();
                String[] datas=new String[data.size()];
                datas[0]=data.get(0).getSubject();
                datas[1]=data.get(1).getType();
                datas[2]=data.get(2).getStats();
                datas[3]=data.get(3).getReported_by();
                datas[4]=data.get(4).getMobile_no();
                datas[5]=data.get(5).getEmail_id();
                datas[6]=data.get(6).getProject();
                datas[7]=data.get(7).getAssigned_to();
               /* for (int i=0;i<7;i++)
                {
                    datas[0]=data.get(0).getSubject()+"\n"+data.get(1).getType()+"\n"+data.get(2).getStats()+"\n"+data.get(3).getReported_by()
                            +"\n"+data.get(4).getMobile_no()+"\n"+data.get(5).getEmail_id()+"\n"+data.get(6).getProject()+"\n"+data.get(7).getAssigned_to();
                }*/
              textView.setText(datas[0]+"\n"+datas[1]+"\n"+datas[2]+"\n"+datas[3]+"\n"+datas[4]+"\n"+datas[5]+"\n"+datas[6]+"\n"+datas[7]);
              //listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,datas));

            }

            @Override
            public void onFailure(Call<List<Data>> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
}