package org.mibe.tribute.trickster.problem

import org.springframework.stereotype.Service
import java.util.UUID
import kotlin.random.Random

@Service
class RandomProblemService(
    private val problems: MutableMap<String, Problem> = HashMap<String, Problem>()
) : ProblemService {

    private val operators = listOf<String>("*", "+", "-")

    override fun getProblem(): Problem {
        val problem = buildProblem()
        problems[problem.id] = problem
        return problem
    }

    override fun solve(id: String, solution: String): Boolean {
        return problems.containsKey(id) && problems[id]!!.isSolved(solution)
    }

    private fun buildProblem() : Problem {
        val firstArgument: Int = Random.nextInt();
        val secondArgument: Int = Random.nextInt();
        val operator = operators.random()
        val solution = evaluate(firstArgument, operator, secondArgument)
        val definition = "$firstArgument $operator $secondArgument"

        return Problem(UUID.randomUUID().toString(), definition, solution.toString())
    }

    private fun evaluate(firstArgument: Int, operator: String, secondArgument: Int) : Int {
        return when (operator) {
            "*" -> firstArgument * secondArgument
            "+" -> firstArgument + secondArgument
            else -> firstArgument - secondArgument
        }
    }
}