package com.mibe.tribute.trickster

import io.kotest.core.spec.style.StringSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldNotBe
import org.mibe.tribute.trickster.TricksterApplication
import org.mibe.tribute.trickster.problem.ProblemController
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [TricksterApplication::class])
class TricksterApplicationTests(val problemController: ProblemController) : StringSpec({
    "problem controller create" {
        problemController shouldNotBe null
    }
}) {
    override fun extensions() = listOf(SpringExtension)
}
