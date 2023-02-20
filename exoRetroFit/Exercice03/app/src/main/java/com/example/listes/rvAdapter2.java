package com.example.listes;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listes.transfert.objList;

import java.util.ArrayList;
import java.util.List;

public class rvAdapter2 extends RecyclerView.Adapter<rvAdapter2.MyViewHolder> {

    /**
     * Liste qui contient l'ensemble des éléments à afficher dans la liste
     */
    public List<objList> localDataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public final TextView tva;
        public final TextView tvb;
        public final TextView tvc;
        public MyViewHolder(LinearLayout v) {
            super(v);
            tva = v.findViewById(R.id.rv2tva);
            tvb = v.findViewById(R.id.rv2tvb);
            tvc = v.findViewById(R.id.rv2tvc);
        }

    }
    public rvAdapter2() {
        localDataSet = new ArrayList<>();
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.elementrv2, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        objList objCourant = localDataSet.get(position);
        if(objCourant != null){
            holder.tva.setText(objCourant.a.toString());
            holder.tvb.setText(objCourant.b);
            holder.tvc.setText(String.valueOf(objCourant.c.length));
        }
        else {
            Log.i("retrofit","oh no");
        }

    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
