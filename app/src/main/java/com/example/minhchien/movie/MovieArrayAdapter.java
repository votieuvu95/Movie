package com.example.minhchien.movie;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.List;

/**
 * Created by anandsingh on 29/12/16.
 */

public class MovieArrayAdapter extends RecyclerView.Adapter<MovieArrayAdapter.NumberViewHolder> {

    private List<MovieDetails> movieDetailsList;
    private Context mContext;



    public MovieArrayAdapter(Context mContext,  List<MovieDetails> movieDetailsList) {
        this.mContext = mContext;
        this.movieDetailsList = movieDetailsList;

    }


    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movie_list, viewGroup, false);

        return new NumberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NumberViewHolder holder, int i) {

        holder.title.setText(movieDetailsList.get(i).getOriginal_title());

        Glide.with(mContext)
                .load("https://image.tmdb.org/t/p/w500" + movieDetailsList.get(i).getPoster_path())
                .into(holder.poster);


    }

    @Override
    public int getItemCount() {
        return movieDetailsList.size();
    }

    public class NumberViewHolder extends RecyclerView.ViewHolder {
        public TextView title, rating, date,overview;
        public ImageView poster;

        public NumberViewHolder(View view) {
            super(view);
            poster=(ImageView)view.findViewById(R.id.imageView);
            title=(TextView)view.findViewById(R.id.textView) ;



            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        MovieDetails clickedDataItem = movieDetailsList.get(pos);
                        Intent intent = new Intent(mContext, MovieDetailActivity.class);
                        intent.putExtra("movies", clickedDataItem);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                        Toast.makeText(v.getContext(), "You clicked " + clickedDataItem.getOriginal_title(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
