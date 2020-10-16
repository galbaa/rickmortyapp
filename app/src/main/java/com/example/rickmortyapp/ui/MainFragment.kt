package com.example.rickmortyapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickmortyapp.R
import com.example.rickmortyapp.data.DataSource
import com.example.rickmortyapp.data.model.Character
import com.example.rickmortyapp.domain.RepoImpl
import com.example.rickmortyapp.ui.viewmodel.MainViewModel
import com.example.rickmortyapp.ui.viewmodel.VMFactory
import com.example.rickmortyapp.vo.Resource
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), MainAdapter.OnCharacterClickListener {

    private val model by viewModels<MainViewModel>{VMFactory(RepoImpl(DataSource()))}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        model.fetchCharactersList.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Loading -> {
                }
                is Resource.Success -> {
                    progressBar.visibility = View.GONE
                    rv_characters.adapter = MainAdapter(requireContext(), it.data, this)
                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(),"Error on getting the characters", Toast.LENGTH_SHORT)
                }
            }
        })
    }

    fun setupRecyclerView(){
        rv_characters.layoutManager = LinearLayoutManager(requireContext())
        rv_characters.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
    }

    override fun onCharacterClick(character: Character) {
        val bundle = Bundle()
        bundle.putParcelable("character", character)
        findNavController().navigate(R.id.characterDetailsFragment, bundle)
    }
}