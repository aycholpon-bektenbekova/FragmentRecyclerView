package com.example.fragmentrecyclerview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.fragmentrecyclerview.databinding.FragmentSecondBinding;

import java.util.ArrayList;

public class SecondFragment extends Fragment {

    private ArrayList<Country> countryList = new ArrayList<>();
    private CountryAdapter adapter;
    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        adapter = new CountryAdapter(countryList);
        binding.rvCountry.setAdapter(adapter);
        if (getArguments() != null) {
            Country country = (Country) getArguments().getSerializable(FirstFragment.KEY_FOR_BUNDLE);

        }
    }

    private void loadData() {

        countryList.add(new Country("USA", "", "Washington"));
        countryList.add(new Country("Canada", "", "Ottawa"));
        countryList.add(new Country("Mexico", "", "Mexico"));
        countryList.add(new Country("Cuba", "", "Havana"));
        countryList.add(new Country("Panama", "", "Panama"));
    }
}