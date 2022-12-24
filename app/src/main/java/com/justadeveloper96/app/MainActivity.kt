package com.justadeveloper96.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.justadeveloper96.app.databinding.ActivityMainBinding
import com.justadeveloper96.feature_auth.ExistingUser
import com.justadeveloper96.feature_auth.NewUser

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val newUser = NewUser("1", "new@gmail.com")
        val existingUser = ExistingUser("1")
        binding.newUser.text = "$newUser"
        binding.existingUser.text = "$existingUser"

    }
}