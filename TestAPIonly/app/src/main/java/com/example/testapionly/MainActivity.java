package com.example.testapionly;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.example.testapionly.Graph.AllNodes;
import com.example.testapionly.Graph.Station;

import java.lang.reflect.Array;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> stations=new ArrayList<String>();
        TextView textView=findViewById(R.id.textView);

        Call<AllNodes> callConstantValue = SingletonRetrofitClient.getInstance().getApi().getConstantValue();

        callConstantValue.enqueue(new Callback<AllNodes>() {
            @Override
            public void onResponse(Call<AllNodes> call, Response<AllNodes> response) {
                AllNodes allNodes = response.body();
                ArrayList<Station>nodes =allNodes.getAllNodes();

                for (Station n : nodes) { stations.add(n.getStationName()); }

                accessArrayList(stations);
                textView.setText(accessArrayList(stations).get(1));

            }

            @Override
            public void onFailure(Call call, Throwable t) { textView.setText("Wrong");  /*Log.d("ahhhhhhhhhhhhhhhhhhh", "");*/ }

        });

    }

    ArrayList<String> accessArrayList(ArrayList<String> st){
        ArrayList<String> tempStations=new ArrayList<String>();
        for (String s : st){ tempStations.add(s);}
        return tempStations;
    }

}
