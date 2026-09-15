package com.liti.launcher
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.liti.launcher.databinding.ActivityGameBinding
class GameTurboActivity: AppCompatActivity(){
    private lateinit var binding: ActivityGameBinding
    override fun onCreate(b: Bundle?){ super.onCreate(b); binding = ActivityGameBinding.inflate(layoutInflater); setContentView(binding.root) }
}
