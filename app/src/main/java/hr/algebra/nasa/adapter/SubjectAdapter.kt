package hr.algebra.nasa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.algebra.nasa.R
import hr.algebra.nasa.model.Subject

class SubjectAdapter(private var mList: List<Subject>) :
    RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder>() {
    inner class SubjectViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val name : TextView = itemView.findViewById(R.id.nameTv)
        val subjectDesc : TextView = itemView.findViewById(R.id.esubjectDesc)
        val linearLayout : LinearLayout = itemView.findViewById(R.id.LinearLayout)

        fun collapseExpandedView(){
            subjectDesc.visibility = View.GONE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_subject, parent, false
        )
        return SubjectViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        val subjectData = mList[position]
        holder.name.text = subjectData.name
        holder.subjectDesc.text = subjectData.subjectDesc

        val isExpandable : Boolean = subjectData.isExpandable
        holder.subjectDesc.visibility = if (isExpandable) View.VISIBLE else View.GONE

        holder.linearLayout.setOnClickListener {
            isAnyItemExpanded(position)
            subjectData.isExpandable = !subjectData.isExpandable
            notifyItemChanged(position, Unit)
        }
    }

    private fun isAnyItemExpanded(position: Int) {
        val temp = mList.indexOfFirst { it.isExpandable }
        if (temp >= 0 && temp != position){
            mList[temp].isExpandable = false
            notifyItemChanged(temp, 0)
        }
    }

    override fun onBindViewHolder(
        holder: SubjectViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isNotEmpty() && payloads[0] == 0){
            holder.collapseExpandedView()
        } else {
            super.onBindViewHolder(holder, position, payloads)
        }
    }

    override fun getItemCount() = mList.size
}