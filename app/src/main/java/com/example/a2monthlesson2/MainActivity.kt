package com.example.a2monthlesson2

import android.net.DnsResolver.Callback
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.a2monthlesson2.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListener()
    }

    private fun initListener() {
        with(binding) {
            btnCalculate.setOnClickListener {
                LoveService().api.calculatePercentage(
                    firstName = firstEt.text.toString(),
                    secondName = secondEt.text.toString()
                ).enqueue(object :retrofit2.Callback<LoveModel>{
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if (response.isSuccessful){
                            Log.e("ololo", "onResponse: ${response.body()}", )
                        }
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("ololo", "onFailure: ${t.message}", )
                    }

                })
            }
        }
    }
}