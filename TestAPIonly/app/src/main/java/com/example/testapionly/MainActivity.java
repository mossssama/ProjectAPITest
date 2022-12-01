package com.example.testapionly;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.testapionly.Graph.AllNodes;
import com.example.testapionly.Graph.Route;
import com.example.testapionly.Graph.ShortestPathInfo;
import com.example.testapionly.Graph.Station;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> stations=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView=findViewById(R.id.    textView1);
        Button btn=findViewById(R.id.btn);

        RetrofitClient.getInstance().getApi().getShortestPath("صلاح سالم","شيراتون").enqueue(new Callback<ShortestPathInfo>() {
            @Override
            public void onResponse(Call<ShortestPathInfo> call, Response<ShortestPathInfo> response) {
                ShortestPathInfo shortestPathInfo = response.body();
                List<List<Route>> routeList=shortestPathInfo.getRoutes();
                List<Route> route = routeList.get(0);
                Route firstRouteMember = route.get(1);
                textView.setText(firstRouteMember.getName());

                /*btn.setOnClickListener((View view) ->{
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                });*/
            }

            @Override
            public void onFailure(Call<ShortestPathInfo> call, Throwable t) {
                Log.i("5555555555555555555555555555555555555555555","Hi");
            }
        });


        /*[1] GET Request */
/*        RetrofitClient.getInstance().getApi().getAllNodes().enqueue(new Callback<AllNodes>() {
            @Override
            public void onResponse(Call<AllNodes> call, Response<AllNodes> response) {
                AllNodes allNodes = response.body();
                ArrayList<Station>nodes =allNodes.getAllNodes();

                for (Station n : nodes) { stations.add(n.getStationName()); }

                textView.setText(stations.get(3));

                btn.setOnClickListener((View view) ->{
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                });
            }

            @Override
            public void onFailure(Call call, Throwable t) { textView.setText("Wrong");  Log.d("ahhhhhhhhhhhhhhhhhhh", ""); }

        });*/

    }
}
