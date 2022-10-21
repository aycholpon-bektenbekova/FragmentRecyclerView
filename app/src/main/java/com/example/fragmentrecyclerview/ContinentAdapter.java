package com.example.fragmentrecyclerview;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fragmentrecyclerview.databinding.ItemContinentBinding;

import java.util.ArrayList;

public class ContinentAdapter extends RecyclerView.Adapter<ContinentAdapter.ContinentViewHolder> {

    private ArrayList<Continent> continentList;


    public ContinentAdapter(ArrayList<Continent> continentList, OnItemClick onItemClick) {
        this.continentList = continentList;
        this.onItemClick = onItemClick;
    }
    private OnItemClick onItemClick;

    @NonNull
    @Override
    public ContinentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContinentViewHolder(ItemContinentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.bind(continentList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.onItemClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return continentList.size();
    }

    public Continent getContinent(int position) {
        return continentList.get(position);
    }

    class ContinentViewHolder extends RecyclerView.ViewHolder{

        private ItemContinentBinding binding;

        public ContinentViewHolder(@NonNull ItemContinentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(Continent continent){

            binding.tvContinent.setText(continent.getName());
            Glide.with(binding.imgContinent).load(continent.getCard()).into(binding.imgContinent);

        }
    }
}
