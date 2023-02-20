package com.example.listes;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listes.databinding.ActivityMainBinding;
import com.example.listes.http.RetrofitUtil;
import com.example.listes.http.Service;
import com.example.listes.transfert.objList;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public List<Long> listeLongRecuperer;
    ActivityMainBinding binding;

    RecyclerView rvLong;
    RecyclerView rvComplexe;
    rvAdapter1 adapter1;
    rvAdapter2 adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        try {
            initRecyclerLong();
            initRecyclerComplexe();
            remplirListeLongservice();
            remplirListeComplexeService();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }




    private void remplirListeLongservice() throws IOException {
        Service instanceService = RetrofitUtil.get();
        instanceService.getLongList().enqueue(new Callback<List<Long>>() {
            @Override
            public void onResponse(Call<List<Long>> call, Response<List<Long>> response) {
                if(response.isSuccessful()){
                    Log.i("RETROFIT" , "reponse liste succesfull");
                    adapter1.localDataSet.addAll(response.body());
                    adapter1.notifyDataSetChanged();
                }
                else {
                    Log.i("RETROFIT" , "reponse liste long unsuccesfull");
                }
            }

            @Override
            public void onFailure(Call<List<Long>> call, Throwable t) {
                Log.i("RETROFIT", t.getMessage());
            }
        });
    }

    private void remplirListeComplexeService() {
        Service instanceService = RetrofitUtil.get();
        instanceService.getComplexeList().enqueue(new Callback<List<objList>>() {
            @Override
            public void onResponse(Call<List<objList>> call, Response<List<objList>> response) {
                if(response.isSuccessful()){
                    Log.i("RETROFIT" , "reponse liste complexe succesfull");
                    adapter2.localDataSet.addAll(response.body());
                    adapter2.notifyDataSetChanged();
                }
                else {
                    Log.i("RETROFIT" , "reponse liste complexe unsuccesfull");
                }
            }

            @Override
            public void onFailure(Call<List<objList>> call, Throwable t) {
                Log.i("RETROFIT", t.getMessage());
            }
        });
    }

    private void initRecyclerLong() {
        rvLong = binding.rv1;
        rvLong.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvLong.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        adapter1 = new rvAdapter1();
        rvLong.setAdapter(adapter1);
        //essayer d'ajouter un line devider lors de l'initialisation de chaque vue du recycler
        //rv.addItemDecoration(new DividerItemDecoration(rv.getContext(), DividerItemDecoration.VERTICAL));
    }

    private void initRecyclerComplexe() {
        rvComplexe = binding.rv2;
        rvComplexe.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvComplexe.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        adapter2 = new rvAdapter2();
        rvComplexe.setAdapter(adapter2);
        //essayer d'ajouter un line devider lors de l'initialisation de chaque vue du recycler
        //rv.addItemDecoration(new DividerItemDecoration(rv.getContext(), DividerItemDecoration.VERTICAL));

    }
}