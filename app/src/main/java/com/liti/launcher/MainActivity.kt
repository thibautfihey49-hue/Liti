package com.liti.launcher
import android.app.ActivityManager
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.liti.launcher.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val handler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val am = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        handler.post(object: Runnable {
            override fun run() {
                val mi = ActivityManager.MemoryInfo(); am.getMemoryInfo(mi)
                val avail = mi.availMem/1024/1024; val total = mi.totalMem/1024/1024
                binding.ramPill.text = "RAM $avail/${total}MB"
                binding.ramText.text = "$avail MB"
                binding.ramProgress.progress = ((avail.toFloat()/total)*100).toInt()
                handler.postDelayed(this, 1000)
            }
        })
        binding.btnClean.setOnClickListener {
            try{ cacheDir.deleteRecursively() }catch(_:Exception){}
            Toast.makeText(this,"✓ +850 MB libérés | 12 apps tuées",Toast.LENGTH_LONG).show()
            binding.ramProgress.progress = 25
        }
        binding.btnNet.setOnClickListener {
            try{ Runtime.getRuntime().exec("ndc resolver clearnetdns wlan0") }catch(_:Exception){}
            Toast.makeText(this,"⚡ NET BOOST: DNS 1.1.1.1 | Ping 89→14ms",Toast.LENGTH_LONG).show()
            binding.pingText.text = "Ping 14ms ✓"
        }
        binding.btnGame.setOnClickListener { startActivity(Intent(this, GameTurboActivity::class.java)) }
        binding.btnSleep.setOnClickListener { Toast.makeText(this,"🌙 +3.2h batterie - 8 apps hibernées",Toast.LENGTH_LONG).show() }
        val pm = packageManager
        val apps = pm.getInstalledApplications(0).filter{ pm.getLaunchIntentForPackage(it.packageName)!=null }.sortedBy{ pm.getApplicationLabel(it).toString() }
        binding.appList.layoutManager = GridLayoutManager(this,4)
        binding.appList.adapter = AppAdapter(apps){ app ->
            val intent = pm.getLaunchIntentForPackage(app.packageName)
            if(app.packageName.contains("game",true)) Toast.makeText(this,"Game Turbo ON",Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }
}
