package com.airmoll.easymap;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airmoll.easymap.models.DataModel;

import java.util.List;

public class MapsAdapter extends RecyclerView.Adapter<MapsAdapter.MapsViewHolder> {

    private List<DataModel> data;
    private RecyclerviewOnClick recyclerviewOnClick;
    View view;
    public MapsAdapter(List<DataModel> data, RecyclerviewOnClick recyclerviewOnClick) {
        this.data = data;
        this.recyclerviewOnClick = recyclerviewOnClick;
    }

    @NonNull
    @Override
    public MapsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new MapsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MapsViewHolder holder, int position) {
        DataModel current = data.get(position);
        holder.textView.setText(current.getName());

        view.setOnClickListener(v -> {
            recyclerviewOnClick.gotoImageActivity(current.getImage1(), current.getImage2());
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MapsViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;

        public MapsViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.phase_name);
            view = itemView;
        }
    }


    public interface RecyclerviewOnClick
    {
        void gotoImageActivity(int image1, int image2);
    }
}
