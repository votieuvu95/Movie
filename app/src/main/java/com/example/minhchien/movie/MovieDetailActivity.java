package com.example.minhchien.movie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView image;

    private TextView title, date, rating, overview,poster_path,original_language,original_title,backdrop_path;
    private Double vote_count,popularity;
    private  int id;
    private boolean video,adult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        image = (ImageView) findViewById(R.id.poster);

        title = (TextView) findViewById(R.id.titlle);

        date = (TextView)findViewById(R.id.date);

        rating = (TextView)findViewById(R.id.rating);

        overview = (TextView) findViewById(R.id.overview);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        MovieDetails details = (MovieDetails) getIntent().getExtras().getSerializable("movies");


        if(details !=null)
        {

            Glide.with(this).load("https://image.tmdb.org/t/p/w500/"+ details.getPoster_path()).into(image);
            title.setText(details.getOriginal_title());
            date.setText(details.getRelease_date());
            rating.setText(Double.toString(details.getVote_average()));
            overview.setText(details.getOverview());
        }
    }
}
