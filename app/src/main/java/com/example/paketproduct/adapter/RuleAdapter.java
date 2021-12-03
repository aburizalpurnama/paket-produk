package com.example.paketproduct.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paketproduct.databinding.ItemRuleBinding;
import com.example.paketproduct.model.Rule;

import java.util.List;

public class RuleAdapter extends RecyclerView.Adapter<RuleAdapter.ViewHolder>{

    private List<Rule> ruleList;

    public RuleAdapter(List<Rule> ruleList) {
        this.ruleList = ruleList;
    }

    public void setRuleList(List<Rule> ruleList) {
        this.ruleList = ruleList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemRuleBinding binding =ItemRuleBinding.inflate(inflater, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Rule rule = ruleList.get(position);
        holder.bind(rule);
    }

    @Override
    public int getItemCount() {
        if (ruleList != null){
            return ruleList.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemRuleBinding binding;

        public ViewHolder(@NonNull ItemRuleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Rule rule){
            binding.tvPremise1.setText(rule.getPremise1());
            binding.tvPremise2.setText(rule.getPremise2());
            binding.tvConclusion.setText(rule.getConclusion());
            binding.tvDescription.setText(rule.getDescription());
        }
    }
}
