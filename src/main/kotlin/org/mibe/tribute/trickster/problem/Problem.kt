package org.mibe.tribute.trickster.problem

data class Problem(val id: String, val definition: String, val solution: String) {
    fun isSolved(solution: String) = this.solution == solution
}