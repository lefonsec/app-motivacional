package com.example.motivaional.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivaional.infra.MotivationConstants
import com.example.motivaional.infra.Preferences
import com.example.motivaional.R
import com.example.motivaional.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        binding.btnSave.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
            if (view?.id == R.id.btn_save){
                this.savar()
            }

    }

    private fun savar() {
        val nome = binding.editNome.text.toString()
        if (nome == "" || nome == null){
            Toast.makeText(this, R.string.validation_mandatory_name,Toast.LENGTH_LONG).show()
        }else{

            Preferences(this).storeString(MotivationConstants.KEY.USER_NAME,nome)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

    }
}