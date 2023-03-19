package org.mibe.tribute.trickster.problem

import org.mibe.tribute.trickster.trick.Trick

data class ProblemDefinition(
    val definition: String,
    val solution: String,
    val trick: Trick
) {

    fun isSolved(solution: String) = this.solution == solution
}