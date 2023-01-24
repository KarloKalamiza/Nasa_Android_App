package hr.algebra.nasa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.algebra.nasa.R
import hr.algebra.nasa.model.Employee

class EmployeeAdapter(private var mList: List<Employee>) :
    RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {
    inner class EmployeeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val logo : ImageView = itemView.findViewById(R.id.logoIv)
        val name : TextView = itemView.findViewById(R.id.nameTv)
        val title : TextView = itemView.findViewById(R.id.proffesionTv)
        val employeeBio : TextView = itemView.findViewById(R.id.employeeBio)
        val linearLayout : LinearLayout = itemView.findViewById(R.id.LinearLayout)

        fun collapseExpandedView(){
            employeeBio.visibility = View.GONE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_employee, parent, false
        )
        return EmployeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employeeData = mList[position]
        holder.logo.setImageResource(employeeData.logo)
        holder.name.text = employeeData.name
        holder.title.text = employeeData.title
        holder.employeeBio.text = employeeData.biography

        val isExpandable : Boolean = employeeData.isExpandable
        holder.employeeBio.visibility = if (isExpandable) View.VISIBLE else View.GONE

        holder.linearLayout.setOnClickListener {
            isAnyItemExpanded(position)
            employeeData.isExpandable = !employeeData.isExpandable
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
        holder: EmployeeViewHolder,
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