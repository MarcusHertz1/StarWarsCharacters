package com.example.starwarscharacters.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starwarscharacters.SharedPreferences
import com.example.starwarscharacters.adapter.Adapter
import com.example.starwarscharacters.adapter.AdapterItem
import com.example.starwarscharacters.databinding.MainLayoutBinding

class FavoriteFragment : Fragment() {
    private lateinit var binding: MainLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btBack.visibility = View.VISIBLE
        binding.btBack.setOnClickListener {
            activity?.onBackPressedDispatcher?.onBackPressed()
        }
        binding.myBt.visibility = View.INVISIBLE

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        SharedPreferences.getFavorite()?.apply {
            val favoriteIdArray = this.split(",")
            val adapterList = mutableListOf<AdapterItem>()
            favoriteIdArray.forEach {id ->
                // тут должен быть запрос типа https://swapi.dev/api/people/$id/
                // adapterList.add
                val adapterItem = AdapterItem()
                adapterItem.id = id
                adapterItem.name = "name" // TODO заменить на нужное
                adapterItem.subInfo = "subInfo" // TODO заменить на нужное
                adapterList.add(adapterItem)
            }
            val adapter = Adapter(adapterList){id->
                SharedPreferences.addOrRemoveFavorite(id.toString())
            }
            binding.recyclerView.adapter = adapter
        }
    }

}