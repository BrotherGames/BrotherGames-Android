package com.cosw.eci.brothergames_android.brothergames_android.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cosw.eci.brothergames_android.brothergames_android.R;
import com.cosw.eci.brothergames_android.brothergames_android.data.entity.Team;
import com.squareup.picasso.Picasso;


import java.util.List;



public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder>{
    private final List<Team> teams;
    private Context context;

    public TeamsAdapter(List<Team> response) {
        this.teams = response;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.team_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Team team = teams.get(position);
        holder.name.setText(team.getName());
        holder.description.setText(team.getDescription());
        holder.rate.setText(team.getRate());
        Picasso.with(context).load(team.getPhoto()).into(holder.logo);
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, description, rate;
        ImageView logo;

        public ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            description = (TextView) view.findViewById(R.id.description);
            rate = (TextView) view.findViewById(R.id.rate);
            logo = (ImageView) view.findViewById(R.id.logo);

        }
    }
}
