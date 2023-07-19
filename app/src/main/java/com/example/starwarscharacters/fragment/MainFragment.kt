package com.example.starwarscharacters.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.starwarscharacters.MAIN
import com.example.starwarscharacters.R
import com.example.starwarscharacters.databinding.MainLayoutBinding

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

    }

    private fun getResult(){
        val url = "http https://swapi.dev/api/people/1/"
        val queue = Volley.newRequestQueue(context)
        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            {
                    response->
                Log.d("LOGINOUT","Res: $response")
            },
            {
                Log.d("LOGINOUT","Err: $it")
            }
        )
        queue.add(stringRequest)
    }
}