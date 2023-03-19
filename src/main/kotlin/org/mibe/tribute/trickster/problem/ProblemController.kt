package org.mibe.tribute.trickster.problem

import org.mibe.tribute.trickster.i18n.MessageService
import org.springframework.context.i18n.LocaleContextHolder.getLocale
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/problems")
@RestController
class ProblemController(private val problemService: ProblemService, private val messageService: MessageService) {

    @GetMapping
    fun getProblem(): Problem {
        return problemService.getProblem()
    }

    @GetMapping("/hello")
    fun hello(): String {
        return messageService.get("hello", getLocale())
    }

    @PostMapping("/{id}")
    fun getProblem(@PathVariable("id") problemId: String, @RequestParam("solution") solution: String): Boolean {
        return problemService.solve(problemId, solution)
    }
}
