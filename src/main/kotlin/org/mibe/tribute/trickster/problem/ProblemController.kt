package org.mibe.tribute.trickster.problem

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/problems")
@RestController
class ProblemController(private val problemService: ProblemService) {

    @GetMapping
    fun getProblem(): Problem {
        return problemService.getProblem()
    }

    @PostMapping("/{id}")
    fun getProblem(@PathVariable("id") problemId: String, @RequestParam("solution") solution: String): Boolean {
        return problemService.solve(problemId, solution)
    }
}
