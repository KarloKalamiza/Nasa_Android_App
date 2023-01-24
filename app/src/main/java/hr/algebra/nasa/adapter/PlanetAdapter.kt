package hr.algebra.nasa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.algebra.nasa.R
import hr.algebra.nasa.model.Planet

class PlanetAdapter(private var mlist: List<Planet>) : RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder>(){
    inner class PlanetViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val logo : ImageView = itemView.findViewById(R.id.logoIv)
        val title : TextView = itemView.findViewById(R.id.titleTv)
        val planetDesc : TextView = itemView.findViewById(R.id.planetDesc)
        val linearLayout : LinearLayout = itemView.findViewById(R.id.LinearLayout)

        fun collapseExpandedView(){
            planetDesc.visibility = View.GONE
        }
    }

    fun setFilteredList(mList : List<Planet>){
        this.mlist = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_planet, parent, false
        )

        return PlanetViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        val planetData = mlist[position]
        holder.logo.setImageResource(planetData.logo)
        holder.title.text = planetData.title
        holder.planetDesc.text = planetData.desc

        val isExpandable : Boolean = planetData.isExpandable
        holder.planetDesc.visibility = if (isExpandable) View.VISIBLE else View.GONE

        holder.linearLayout.setOnClickListener {
            isAnyItemExpanded(position)
            planetData.isExpandable = !planetData.isExpandable
            notifyItemChanged(position, Unit)
        }
    }

    private fun isAnyItemExpanded(position: Int) {
        val temp = mlist.indexOfFirst { it.isExpandable }
        if (temp >= 0 && temp != position){
            mlist[temp].isExpandable = false
            notifyItemChanged(temp, 0)
        }
    }

    override fun onBindViewHolder(
        holder: PlanetViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isNotEmpty() && payloads[0] == 0){
            holder.collapseExpandedView()
        } else {
            super.onBindViewHolder(holder, position, payloads)
        }
    }

    override fun getItemCount() = mlist.size
}