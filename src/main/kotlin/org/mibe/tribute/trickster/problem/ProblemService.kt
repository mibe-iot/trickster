package org.mibe.tribute.trickster.problem

interface ProblemService {
    fun getProblem(): ProblemDefinition
    fun solve(id: String, solution: String): Boolean
}