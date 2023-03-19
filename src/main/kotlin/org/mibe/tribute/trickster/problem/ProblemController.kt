package org.mibe.tribute.trickster.problem

import org.mibe.tribute.trickster.i18n.MessageService
import org.springframework.context.i18n.LocaleContextHolder.getLocale
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/problems")
@RestController
class ProblemController(private val messageService: MessageService) {

    @GetMapping("/hello")
    fun hello(): String {
        return messageService.get("hello", getLocale())
    }
}
