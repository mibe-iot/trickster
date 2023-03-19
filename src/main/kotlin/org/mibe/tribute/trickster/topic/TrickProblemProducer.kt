package org.mibe.tribute.trickster.topic

import org.mibe.tribute.trickster.problem.ProblemGenerator
import org.mibe.tribute.trickster.trick.Trick

class TrickProblemProducer(val trick: Trick, private val generators: List<ProblemGenerator>) {
    fun getProblem() = generators.random().invoke()
}