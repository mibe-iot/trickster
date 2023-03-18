package org.mibe.tribute.trickster.problem

interface ProblemService {
    fun getProblem(): Problem
    fun solve(id: String, solution: String): Boolean
}