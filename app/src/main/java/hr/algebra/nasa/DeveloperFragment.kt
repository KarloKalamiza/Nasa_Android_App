package hr.algebra.nasa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hr.algebra.nasa.adapter.ParentAdapter

class DeveloperFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private val parentList = ArrayList<ParentItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_developer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.parentRecyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        addDataToList()
        val adapter = ParentAdapter(parentList)
        recyclerView.adapter = adapter
    }

    private fun addDataToList() {
        val childItems1 = ArrayList<ChildItem>()
        childItems1.add(ChildItem("C", R.drawable.c))
        childItems1.add(ChildItem("C#", R.drawable.csharp))
        childItems1.add(ChildItem("Java", R.drawable.java))
        childItems1.add(ChildItem("C++", R.drawable.cplusplus))

        parentList.add(ParentItem("Game Development", R.drawable.console, childItems1))

        val childItem2 = ArrayList<ChildItem>()
        childItem2.add(ChildItem("Kotlin", R.drawable.kotlin))
        childItem2.add(ChildItem("XML", R.drawable.xml))
        childItem2.add(ChildItem("Java", R.drawable.java))
        parentList.add(
            ParentItem(
                "Android Development",
                R.drawable.android,
                childItem2
            )
        )
        val childItem3 = ArrayList<ChildItem>()
        childItem3.add(ChildItem("JavaScript", R.drawable.javascript))
        childItem3.add(ChildItem("HTML", R.drawable.html))
        childItem3.add(ChildItem("CSS", R.drawable.css))
        parentList.add(
            ParentItem(
                "Front End Web",
                R.drawable.front_end,
                childItem3
            )
        )
        val childItem4 = ArrayList<ChildItem>()
        childItem4.add(ChildItem("Julia", R.drawable.julia))
        childItem4.add(ChildItem("Python", R.drawable.python))
        childItem4.add(ChildItem("R", R.drawable.r))
        parentList.add(
            ParentItem(
                "Artificial Intelligence",
                R.drawable.ai,
                childItem4
            )
        )
        val childItem5 = ArrayList<ChildItem>()
        childItem5.add(ChildItem("Java", R.drawable.java))
        childItem5.add(ChildItem("Python", R.drawable.python))
        childItem5.add(ChildItem("PHP", R.drawable.php))
        childItem5.add(ChildItem("JavaScript", R.drawable.javascript))
        parentList.add(
            ParentItem(
                "Back End Web",
                R.drawable.backend,
                childItem5
            )
        )
    }
}