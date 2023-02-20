package com.example.listes;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.LoggingMXBean;

public class rvAdapter1 extends RecyclerView.Adapter<rvAdapter1.MyViewHolder> {

    /**
     * Liste qui contient l'ensemble des éléments à afficher dans la liste
     */
    public List<Long> localDataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public final TextView tvLong;
        public MyViewHolder(LinearLayout v) {
            super(v);
            tvLong = v.findViewById(R.id.rv1tv);
        }

    }
    public rvAdapter1() {
        localDataSet = new ArrayList<>();
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.elementrv1, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Long tacheCourante = localDataSet.get(position);
        holder.tvLong.setText(tacheCourante.toString());
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
