package com.liti.launcher
import android.content.pm.ApplicationInfo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class AppAdapter(private val apps: List<ApplicationInfo>, private val onClick: (ApplicationInfo)->Unit): RecyclerView.Adapter<AppAdapter.VH>(){
    class VH(v: View): RecyclerView.ViewHolder(v){ val icon: ImageView = v.findViewById(R.id.icon); val name: TextView = v.findViewById(R.id.name) }
    override fun onCreateViewHolder(p: ViewGroup, t: Int): VH { return VH(LayoutInflater.from(p.context).inflate(R.layout.item_app,p,false)) }
    override fun getItemCount() = apps.size
    override fun onBindViewHolder(h: VH, pos: Int){
        val app = apps[pos]
        h.icon.setImageDrawable(h.itemView.context.packageManager.getApplicationIcon(app))
        h.name.text = h.itemView.context.packageManager.getApplicationLabel(app)
        h.itemView.setOnClickListener{ onClick(app) }
    }
}
