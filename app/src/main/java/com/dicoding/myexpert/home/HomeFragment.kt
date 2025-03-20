package com.dicoding.myexpert.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.core.myexpert.data.Resource
import com.dicoding.myexpert.R
import com.dicoding.myexpert.databinding.FragmentHomeBinding
import com.dicoding.myexpert.detail.DetailMovieActivity
import com.dicoding.core.myexpert.ui.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val movieAdapter = MovieAdapter("https://image.tmdb.org/t/p/w500")
            movieAdapter.onItemClick = { selectedData ->
                val intent = Intent(requireContext(), DetailMovieActivity::class.java)
                intent.putExtra(DetailMovieActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            homeViewModel.movie.observe(viewLifecycleOwner) { movie ->
                with(binding) {
                    when (movie) {
                        is Resource.Loading -> {
                            progressBar.visibility = View.VISIBLE
                        }

                        is Resource.Success -> {
                            progressBar.visibility = View.GONE
                            val movieList = movie.data ?: emptyList()
                            movieAdapter.submitList(movieList)
                        }

                        is Resource.Error -> {
                            progressBar.visibility = View.GONE
                            viewError.root.visibility = View.VISIBLE
                            viewError.tvError.text =
                                movie.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            }

            with(binding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

