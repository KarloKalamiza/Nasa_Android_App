package hr.algebra.nasa.model

data class Planet(
    val title:String,
    val logo:Int,
    val desc: String,
    var isExpandable: Boolean = false
)
