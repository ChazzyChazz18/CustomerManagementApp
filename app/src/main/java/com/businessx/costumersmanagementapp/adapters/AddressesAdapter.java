package com.businessx.costumersmanagementapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.businessx.costumersmanagementapp.R;
import com.businessx.costumersmanagementapp.models.Address;

import java.util.ArrayList;

public class AddressesAdapter extends RecyclerView.Adapter<AddressesAdapter.ViewHolder> {

    private final ArrayList<Address> dataset;
    private final Context context;

    public AddressesAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.address_layout_item,
                viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final Address address = dataset.get(i);
        viewHolder.addressText.setText(address.getFullAddress());

        viewHolder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, address.getFullAddress(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addAddressList (ArrayList<Address> addressList) {
        dataset.addAll(addressList);
        notifyDataSetChanged();
    }

    /*public void clearClientList () {
        if(dataset.size() > 0) {
            dataset.clear();
            notifyDataSetChanged();
        }
    }*/

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView addressText;

        ViewHolder(View itemView) {
            super(itemView);
            addressText = itemView.findViewById(R.id.address_layout_text);
        }
    }

}
