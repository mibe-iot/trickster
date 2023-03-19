package org.mibe.tribute.trickster.problem

data class ProblemTask (
    val id: String,
    val definition: String
) {
    constructor(problem: Problem) : this(problem.id, problem.definition)
}