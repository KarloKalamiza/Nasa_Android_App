package hr.algebra.nasa.model

data class Employee(
    val name:String,
    val logo: Int,
    val title : String,
    val biography: String,
    var isExpandable: Boolean = false
)
