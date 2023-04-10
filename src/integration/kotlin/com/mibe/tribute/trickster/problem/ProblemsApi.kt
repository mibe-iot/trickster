package com.mibe.tribute.trickster.problem

import io.kotest.core.spec.style.StringSpec
import io.kotest.extensions.spring.SpringExtension
import org.mibe.tribute.trickster.TricksterApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.restdocs.ManualRestDocumentation
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get
import org.springframework.restdocs.payload.JsonFieldType
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext


@SpringBootTest
@WebAppConfiguration
@ContextConfiguration(classes = [TricksterApplication::class])
class ProblemsApi(
    val webApplicationContext: WebApplicationContext
) : StringSpec({

    val restDocumentation = ManualRestDocumentation()

    lateinit var mockMvc: MockMvc

    beforeAny {
        mockMvc = MockMvcBuilders
            .webAppContextSetup(webApplicationContext)
            .apply<DefaultMockMvcBuilder>(MockMvcRestDocumentation.documentationConfiguration(restDocumentation))
            .build()
        restDocumentation.beforeTest(ProblemsApi::class.java, it.name.testName)
    }

    afterAny {
        restDocumentation.afterTest()
    }

    "GET /api/problems/any returns something" {
        mockMvc.perform(get("/api/problems/any").accept(APPLICATION_JSON))
            .andExpect(status().isOk)
            .andDo {

            }
            .andDo(document("{class-name}/smth"))
    }

    "GET /api/problems/any returns new problem" {
        mockMvc.get("/api/problems/any") {
            contentType = APPLICATION_JSON
            accept = APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content { contentType(APPLICATION_JSON) }
            jsonPath("$.id").exists()
            jsonPath("$.id").isNumber
            jsonPath("$.definition").exists()
            jsonPath("$.definition").isString
        }.andDo {
            handle(
                document(
                    "{class-name}/get-any",
                    responseFields(
                        fieldWithPath("id").type(JsonFieldType.STRING).description("Problem identifier as int"),
                        fieldWithPath("definition").type(JsonFieldType.STRING)
                            .description("The problem task as String")
                    )
                )
            )
        }
    }
}) {
    override fun extensions() = listOf(SpringExtension)
}
