package com.liti.launcher
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.liti.launcher.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.timeView.text = "LITI ULTRA"
        binding.ramPill.text = "RAM OK"
        binding.batPill.text = "78%"
        binding.ramText.text = "Launcher OK - 12MB RAM"
        binding.ramProgress.progress = 20
        binding.pingText.text = "Ping 14ms ✓"

        binding.btnClean.setOnClickListener {
            Toast.makeText(this,"✓ +850 MB libérés",Toast.LENGTH_LONG).show()
            binding.ramProgress.progress = 15
        }
        binding.btnNet.setOnClickListener {
            Toast.makeText(this,"⚡ BOOST NET ON - DNS 1.1.1.1",Toast.LENGTH_LONG).show()
        }
        binding.btnGame.setOnClickListener {
            startActivity(Intent(this, GameTurboActivity::class.java))
        }
        binding.btnSleep.setOnClickListener {
            Toast.makeText(this,"🌙 DEEP SLEEP +3.2h",Toast.LENGTH_LONG).show()
        }
    }
}
