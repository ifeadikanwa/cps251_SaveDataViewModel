package com.ifyezedev.cps251_savedataviewmodel.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.ifyezedev.cps251_savedataviewmodel.R
import com.ifyezedev.cps251_savedataviewmodel.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.namesTextView.text = viewModel.getAllNames()

        binding.addButton.setOnClickListener {
            val name = binding.editText.editableText.toString()
            if(!name.isEmpty()){
                viewModel.addName(name)
                binding.namesTextView.text = viewModel.getAllNames()
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}