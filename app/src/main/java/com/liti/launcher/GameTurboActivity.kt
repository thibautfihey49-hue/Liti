package com.liti.launcher
import android.graphics.Color
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
class GameTurboActivity: AppCompatActivity(){
    override fun onCreate(b: Bundle?){
        super.onCreate(b)
        val root = LinearLayout(this).apply{
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.parseColor("#F7F7F8"))
            setPadding(40,80,40,40)
        }
        root.addView(TextView(this).apply{ text="GAME TURBO"; textSize=24f; setTextColor(Color.BLACK) })
        root.addView(Button(this).apply{ text="Retour"; setOnClickListener{ finish() } })
        setContentView(root)
    }
}
