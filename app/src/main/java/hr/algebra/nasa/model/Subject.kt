package hr.algebra.nasa.model

data class Subject(
    val name: String,
    val subjectDesc: String,
    var isExpandable : Boolean = false
)
