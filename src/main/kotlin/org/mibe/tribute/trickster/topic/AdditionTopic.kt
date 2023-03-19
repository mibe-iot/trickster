package org.mibe.tribute.trickster.topic

import org.mibe.tribute.trickster.problem.ProblemGenerator
import org.mibe.tribute.trickster.problem.`a+b`
import org.mibe.tribute.trickster.problem.anyInt
import org.mibe.tribute.trickster.trick.Trick
import org.springframework.stereotype.Component

typealias GeneratorsSupplier = (Trick) -> List<ProblemGenerator>

@Component
class AdditionTopic : Topic(Key.ADDITION) {

    override fun listTricks(trick: (String, String, String, GeneratorsSupplier) -> Unit) {
        trick("aPlusB", "trick.description.aPlusB", "12 + 4 = 16") {
            listOf(`a+b`(anyInt(), anyInt(), it))
        }
    }

}