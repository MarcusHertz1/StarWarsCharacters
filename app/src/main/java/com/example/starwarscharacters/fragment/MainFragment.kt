package com.example.starwarscharacters.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.starwarscharacters.ElementModel
import com.example.starwarscharacters.SharedPreferences
import com.example.starwarscharacters.adapter.Adapter
import com.example.starwarscharacters.databinding.MainLayoutBinding
import org.json.JSONObject

class MainFragment : Fragment() {
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

        binding.myBt.setOnClickListener {
            //MAIN.navController.navigate(R.id.action_mainFragment_to_characterFragment)
            getResult()
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = Adapter(listOf()){id-> //TODO закинуть сюда нужные данные вместо listOf()
         SharedPreferences.addOrRemoveFavorite(id.toString())
        }
        binding.recyclerView.adapter = adapter
    }

    private fun getResult(){
        val url = "https://swapi.dev/api/people/1/"
        val queue = Volley.newRequestQueue(context)
        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            {
                    result-> parseData(result)
                //Log.d("LOGINOUT","Res: $result")
            },
            {
                error->
                Log.d("LOGINOUT","Err: $error")
            }
        )
        queue.add(stringRequest)
    }

    private fun parseData (result: String) {
        val mainObject = JSONObject(result)
        val item = ElementModel(
            mainObject.getString("name"),
            mainObject.getString("gender"),
        )
        Log.d("LOGINOUT","Res: ${item.peopleName}")
        Log.d("LOGINOUT","Res: ${item.peopleGender}")
    }
}