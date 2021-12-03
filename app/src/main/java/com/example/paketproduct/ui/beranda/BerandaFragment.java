package com.example.paketproduct.ui.beranda;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paketproduct.R;
import com.example.paketproduct.adapter.RuleAdapter;
import com.example.paketproduct.databinding.FragmentBerandaBinding;
import com.example.paketproduct.model.Rule;
import com.example.paketproduct.model.RuleCreator;

import java.util.ArrayList;
import java.util.List;

public class BerandaFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentBerandaBinding binding;


    String[] items = {"Normal Key", "Lever Handle", "Swing Lockcase", "Push & Pull Handle", "Accessories","Handle Set", "Roller Lockcase", "Shelves", "Brackets", "Hinges", "Computer Key", "Cylindrical Handle", "Screws", "Nuts, Bolts & Spacer"};

    AutoCompleteTextView autoCompleteText;
    ArrayAdapter<String> adapterItem;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentBerandaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        autoCompleteText = binding.autoCompleteText;
        adapterItem = new ArrayAdapter<>(getContext(), R.layout.list_item, items);
        autoCompleteText.setAdapter(adapterItem);

        binding.rvRule.setVisibility(View.INVISIBLE);
        binding.tvHasil.setVisibility(View.INVISIBLE);
        autoCompleteText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                binding.rvRule.setVisibility(View.VISIBLE);
                binding.tvHasil.setVisibility(View.VISIBLE);
                setUpRv(item);
            }
        });

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setUpRv(String selectedItem){
        LinearLayoutManager layoutManager =new LinearLayoutManager(getContext());
        RuleAdapter adapter = new RuleAdapter(RuleCreator.getRules(selectedItem));
        RecyclerView recyclerView = binding.rvRule;
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


}