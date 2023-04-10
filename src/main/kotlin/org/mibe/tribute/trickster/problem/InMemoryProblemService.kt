package org.mibe.tribute.trickster.problem

import org.mibe.tribute.trickster.topic.Topic
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class InMemoryProblemService(val topics: List<Topic>) : ProblemService {

    private val problemsIdGenerator = AtomicLong()
    private val problems: MutableList<Problem> = ArrayList()

    override fun get(): ProblemTask {
        val definition = topics.random().getTrickProblemProducers().values.random().getProblem()
        val problem = Problem(problemsIdGenerator.incrementAndGet(), definition)
        problems.add(problem)
        return ProblemTask(problem)
    }

    override fun randomProblem(): ProblemTask {
        TODO("Not yet implemented")
    }
}