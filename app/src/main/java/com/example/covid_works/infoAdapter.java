package com.example.covid_works;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/*Class that loads the base object that will be displayed by the android app */

public class infoAdapter extends RecyclerView.Adapter<infoAdapter.ViewHolder> {

    private Context context;
    private List<locationInfo> list;
    private Object locationInfo;

    public infoAdapter(Context context, List<locationInfo> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        locationInfo locationInfo = list.get(position);

        holder.textProvider.setText(locationInfo.getProvider());
        holder.textAddress.setText(String.valueOf(locationInfo.getAddress()));
        holder.textUrl.setText(String.valueOf(locationInfo.getURL()));

    }

    @Override
    public int getItemCount() {
        System.out.println(list.size());
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textProvider, textAddress, textUrl;

        public ViewHolder(View itemView) {
            super(itemView);

            textProvider = itemView.findViewById(R.id.main_provider);
            textAddress = itemView.findViewById(R.id.main_address);
            textUrl = itemView.findViewById(R.id.main_url);
        }
    }

}