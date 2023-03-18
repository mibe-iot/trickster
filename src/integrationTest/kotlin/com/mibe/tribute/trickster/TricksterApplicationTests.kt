package com.mibe.tribute.trickster

import io.kotest.core.spec.style.StringSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.beBlank
import org.mibe.tribute.trickster.TricksterApplication
import org.mibe.tribute.trickster.problem.ProblemController
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [TricksterApplication::class])
class TricksterApplicationTests(val problemController: ProblemController) : StringSpec({
    "problem controller create" {
        problemController shouldNotBe null
    }
    "ProblemController.getProblem() returns valid object" {
        val problem = problemController.getProblem()
        problem shouldNotBe null
        problem.run {
            id shouldNotBe beBlank()
            definition shouldNotBe beBlank()
            solution shouldNotBe beBlank()
        }
    }

}) {
    override fun extensions() = listOf(SpringExtension)
}
