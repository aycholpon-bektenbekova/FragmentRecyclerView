package com.example.fragmentrecyclerview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.fragmentrecyclerview.databinding.FragmentFirstBinding;

import java.util.ArrayList;

public class FirstFragment extends Fragment implements OnItemClick{

    private FragmentFirstBinding binding;
    private ArrayList<Continent> continentList = new ArrayList<>();
    private ContinentAdapter adapter;
    public final static String KEY_FOR_BUNDLE = "Continent";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadData();
        adapter = new ContinentAdapter(continentList, this);
        binding.rvContinent.setAdapter(adapter);

    }

    private void loadData() {
        continentList.add(new Continent("North America", "https://myfewlittlethingsdotcom.files.wordpress.com/2019/11/north-america.png"));
        continentList.add(new Continent("Africa", "https://i0.wp.com/guesthollow.com/wp-content/uploads/2020/04/africa.jpg.png"));
        continentList.add(new Continent("Europe", "https://images.template.net/87159/free-europe-map-vector-design-5ghqa.jpg.png"));
        continentList.add(new Continent("Asia", "https://www.conceptdraw.com/How-To-Guide/picture/Geo-Map-of-Asia.png"));
        continentList.add(new Continent("South America", "https://upload.wikimedia.org/wikipedia/commons/4/49/Flag_map_of_South_America.png"));

    }

    @Override
    public void onItemClick(int position) {
      Continent continent = adapter.getContinent(position);
      Bundle bundle = new Bundle();
      bundle.putSerializable(KEY_FOR_BUNDLE, continent);
      Fragment fragment = new SecondFragment();
      fragment.setArguments(bundle);
      requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }
}