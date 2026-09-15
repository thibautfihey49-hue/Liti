package com.liti.launcher
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.parseColor("#F7F7F8"))
            setPadding(40,80,40,40)
        }
        val title = TextView(this).apply {
            text = "LITI ULTRA\nLauncher OK ✅"
            textSize = 26f
            setTextColor(Color.parseColor("#0F172A"))
        }
        val status = TextView(this).apply {
            text = "SAFE BUILD v5 - 0 XML - No RecyclerView"
            textSize = 13f
            setTextColor(Color.GRAY)
            setPadding(0,20,0,30)
        }
        fun makeBtn(label: String, col: String, action: ()->Unit): LinearLayout {
            return LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                setBackgroundColor(Color.parseColor(col))
                setPadding(30,30,30,30)
                addView(TextView(this@MainActivity).apply{
                    text = label
                    textSize = 15f
                    setTextColor(Color.BLACK)
                    gravity = Gravity.CENTER
                })
                setOnClickListener { action() }
                val p = LinearLayout.LayoutParams(0, 200, 1f)
                p.setMargins(10,10,10,10)
                layoutParams = p
            }
        }
        val row1 = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            addView(makeBtn("🧹 CLEAN RAM", "#E0F2FE") {
                Toast.makeText(this@MainActivity,"✓ +850 MB",Toast.LENGTH_SHORT).show()
            })
            addView(makeBtn("⚡ BOOST NET", "#EDE9FE") {
                Toast.makeText(this@MainActivity,"⚡ BOOST 14ms",Toast.LENGTH_SHORT).show()
            })
        }
        val row2 = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            addView(makeBtn("🎮 GAME TURBO", "#FEF3C7") {
                startActivity(Intent(this@MainActivity, GameTurboActivity::class.java))
            })
            addView(makeBtn("🌙 DEEP SLEEP", "#DCFCE7") {
                Toast.makeText(this@MainActivity,"🌙 +3.2h",Toast.LENGTH_SHORT).show()
            })
        }
        val btnLauncher = Button(this).apply {
            text = "DEFINIR COMME LAUNCHER"
            setOnClickListener {
                val i = Intent(Intent.ACTION_MAIN)
                i.addCategory(Intent.CATEGORY_HOME)
                startActivity(Intent.createChooser(i,"Choisir Liti"))
            }
        }
        root.addView(title)
        root.addView(status)
        root.addView(row1)
        root.addView(row2)
        root.addView(btnLauncher)
        setContentView(root)
    }
}
