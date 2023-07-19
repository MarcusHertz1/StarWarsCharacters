package com.example.starwarscharacters.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.starwarscharacters.MAIN
import com.example.starwarscharacters.R
import com.example.starwarscharacters.databinding.CharacterLayoutBinding

class CharacterFragment : Fragment() {
    private lateinit var binding: CharacterLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CharacterLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.materialButton.setOnClickListener {
            //MAIN.navController.navigate(R.id.action_mainFragment_to_characterFragment)

        }
    }

}