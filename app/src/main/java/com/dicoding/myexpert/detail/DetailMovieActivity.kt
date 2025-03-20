package com.dicoding.myexpert.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.dicoding.core.myexpert.domain.model.Movie
import com.dicoding.myexpert.R
import com.dicoding.myexpert.databinding.ActivityDetailMovieBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailMovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMovieBinding
    private val detailMovieViewModel: DetailMovieViewModel by viewModels()
    private var statusFavorite: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val detailMovie = intent.getParcelableExtra<Movie>(EXTRA_DATA)
        if (detailMovie != null) {
            showDetailMovie(detailMovie)
        } else {
            finish()
        }

        // Handle klik tombol favorite
        binding.fab.setOnClickListener {
            detailMovie?.let {
                statusFavorite = !statusFavorite
                detailMovieViewModel.setFavoriteMovie(it, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun showDetailMovie(detailMovie: Movie) {
        supportActionBar?.title = detailMovie.title
        binding.contentDetailMovie.tvDetailDescription.text = detailMovie.overview

        val baseImageUrl = "https://image.tmdb.org/t/p/w500"
        Glide.with(this)
            .load(baseImageUrl + detailMovie.posterPath)
            .into(binding.ivDetailImage)

        statusFavorite = detailMovie.isFavorite
        setStatusFavorite(statusFavorite)
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        val iconRes = if (statusFavorite) {
            R.drawable.ic_favorite_white
        } else {
            R.drawable.ic_not_favorite_white
        }
        binding.fab.setImageDrawable(ContextCompat.getDrawable(this, iconRes))
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}
