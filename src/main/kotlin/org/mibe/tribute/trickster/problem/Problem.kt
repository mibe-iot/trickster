package org.mibe.tribute.trickster.problem

data class Problem (
    val id: String,
    val definition: String,
    val trickId: String,
    val solution: String
) {
    constructor(id: Long, problemDefinition: ProblemDefinition) : this(
        id.toString(),
        problemDefinition.definition,
        problemDefinition.trick.id,
        problemDefinition.solution
    )
}