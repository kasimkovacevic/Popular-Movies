package info.kasimkovacevic.popularmovies.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.kasimkovacevic.popularmovies.R;
import info.kasimkovacevic.popularmovies.models.Movie;
import info.kasimkovacevic.popularmovies.utils.NetworkUtils;

public class MovieDetailsActivity extends AppCompatActivity {

    public static final String POPULAR_MOVIES_MOVIE_EXTRA = "info.kasimkovacevic.popularmovies.MOVIE_EXTRA";
    private Movie movie;
    @BindView(R.id.tv_movie_title)
    TextView movieTitleTextView;
    @BindView(R.id.tv_movie_overview)
    TextView movieOverviewTextView;
    @BindView(R.id.tv_user_rating)
    TextView movieRatingTextView;
    @BindView(R.id.tv_release_date)
    TextView movieReleaseDateTextView;
    @BindView(R.id.iv_movie_poster)
    ImageView moviePosterImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        if (intent.getExtras() != null && intent.hasExtra(POPULAR_MOVIES_MOVIE_EXTRA)) {
            movie = intent.getParcelableExtra(POPULAR_MOVIES_MOVIE_EXTRA);
            configureUI();
        }
    }

    private void configureUI() {
        movieTitleTextView.setText(movie.getOriginalTitle());
        movieOverviewTextView.setText(movie.getOverview());
        movieRatingTextView.setText(String.valueOf(movie.getVoteAverage()));
        movieReleaseDateTextView.setText(movie.getReleaseDate());
        Picasso.with(MovieDetailsActivity.this).load(NetworkUtils.buildPhotoUrl(movie.getPosterPath())).into(moviePosterImageView);
    }
}
