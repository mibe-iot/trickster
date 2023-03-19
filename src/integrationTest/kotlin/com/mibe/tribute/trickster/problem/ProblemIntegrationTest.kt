package com.mibe.tribute.trickster.problem

import io.kotest.core.spec.style.StringSpec
import io.kotest.extensions.spring.SpringExtension
import org.mibe.tribute.trickster.TricksterApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.restdocs.ManualRestDocumentation
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext


@SpringBootTest
@WebAppConfiguration
@ContextConfiguration(classes = [TricksterApplication::class])
class ProblemIntegrationTest(
    val webApplicationContext: WebApplicationContext
) : StringSpec({

    val restDocumentation = ManualRestDocumentation()

    lateinit var mockMvc: MockMvc

    beforeAny {
        mockMvc = MockMvcBuilders
            .webAppContextSetup(webApplicationContext)
            .apply<DefaultMockMvcBuilder>(MockMvcRestDocumentation.documentationConfiguration(restDocumentation))
            .build()
        restDocumentation.beforeTest(ProblemIntegrationTest::class.java, it.name.toString())
    }

    "GET /api/problems/ returns new problem" {
        mockMvc.perform(get("/api/problems").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andDo(document("index"))
    }

}) {
    override fun extensions() = listOf(SpringExtension)
}
