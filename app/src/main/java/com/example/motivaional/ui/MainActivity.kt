package com.example.motivaional.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.motivaional.infra.MotivationConstants
import com.example.motivaional.infra.Preferences
import com.example.motivaional.R
import com.example.motivaional.data.Mock
import com.example.motivaional.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var categoryId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        handleUserName()
        this.gerarFrase()

        binding.imgAll.setOnClickListener(this)
        binding.imgSun.setOnClickListener(this)
        binding.imgHappy.setOnClickListener(this)
        binding.bntFrase.setOnClickListener(this)
    }

    private fun handleUserName() {
        val name = Preferences(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.textSaudar.text = "ola $name!"
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.bnt_frase){
                this.gerarFrase()
        } else if (view?.id in listOf(R.id.img_all,R.id.img_happy ,R.id.img_sun)){
            if (view != null) {
                this.handleFilter(view.id)
            }
        }


    }

    private fun handleFilter(id:Int) {
        binding.imgAll.setColorFilter(ContextCompat.getColor(this,R.color.dark_purple))
        binding.imgSun.setColorFilter(ContextCompat.getColor(this,R.color.dark_purple))
        binding.imgHappy.setColorFilter(ContextCompat.getColor(this,R.color.dark_purple))

        if(id == R.id.img_all){
            binding.imgAll.setColorFilter(ContextCompat.getColor(this,R.color.white))
            MotivationConstants.FILTER.ALL
        }else if(id == R.id.img_happy){
            binding.imgHappy.setColorFilter(ContextCompat.getColor(this,R.color.white))
            MotivationConstants.FILTER.HAPPY
        }else{
            binding.imgSun.setColorFilter(ContextCompat.getColor(this,R.color.white))
            MotivationConstants.FILTER.SUNNY
        }
    }

    private fun gerarFrase() {
         binding.textPhrase.text = Mock().getPhrase(categoryId)
    }
}