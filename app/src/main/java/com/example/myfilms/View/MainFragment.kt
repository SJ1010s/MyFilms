package com.example.myfilms.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.myfilms.Model.FilmList
import com.example.myfilms.R
import com.example.myfilms.ViewModel.AppStateFilmList
import com.example.myfilms.ViewModel.MainViewModel
import com.example.myfilms.databinding.FragmentMainBinding
import com.google.android.material.snackbar.Snackbar

private const val ARG_PARAM1 = "arg_main_fragment_1"
private const val ARG_PARAM2 = "arg_main_fragment_2"

class MainFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, true)
        return binding.getRoot()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) })
        viewModel.getFilmFromLocalSource()

    }


    private fun renderData(appState: AppStateFilmList) {
        when (appState) {
            is AppStateFilmList.Success -> {
                val filmList = appState.filmList
                binding.loadingLayout.visibility = View.GONE
                setData(filmList)
            }
            is AppStateFilmList.Loading -> {
                binding.loadingLayout.visibility = View.VISIBLE
            }
            is AppStateFilmList.Error -> {
                binding.loadingLayout.visibility = View.GONE
                Snackbar
                    .make(binding.mainView, getString(R.string.error), Snackbar.LENGTH_INDEFINITE)
                    .setAction(getString(R.string.reload)) { viewModel.getFilmFromLocalSource()}
                    .show()
            }
        }
    }

    private fun setData(filmData: FilmList) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic fun newInstance(param1: String, param2: String) =
                MainFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}