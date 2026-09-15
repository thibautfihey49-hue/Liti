package com.liti.launcher
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.liti.launcher.databinding.ActivityGameBinding

class GameTurboActivity: AppCompatActivity(){
    private lateinit var binding: ActivityGameBinding
    override fun onCreate(b: Bundle?){
        super.onCreate(b)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBack.setOnClickListener { finish() }
        binding.cardBalanced.setOnClickListener { Toast.makeText(this,"Balanced: 60Hz économie",Toast.LENGTH_SHORT).show() }
        binding.cardPerf.setOnClickListener { Toast.makeText(this,"Performance: 90Hz + Boost Net ON",Toast.LENGTH_SHORT).show() }
        binding.cardBeast.setOnClickListener { Toast.makeText(this,"BEAST MODE: Max CPU/GPU + Ping 0",Toast.LENGTH_SHORT).show() }
    }
}
