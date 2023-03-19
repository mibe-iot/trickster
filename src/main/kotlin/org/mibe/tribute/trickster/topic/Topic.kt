package org.mibe.tribute.trickster.topic

import org.mibe.tribute.trickster.trick.Trick

abstract class Topic(val topicKey: Key){

    enum class Key {
        ADDITION,
        MULTIPLICATION
    }

    private val tricks: List<Trick>
    private val trickProblemProducers: Map<String, TrickProblemProducer>

    init {
        val (tricks, trickProblemProducers) = createTricks()
        this.tricks = tricks
        this.trickProblemProducers = trickProblemProducers
    }

    abstract fun listTricks(trick: (String, String, String, GeneratorsSupplier) -> Unit)

    private fun createTricks(): Pair<List<Trick>, Map<String, TrickProblemProducer>> {
        val allTricks: MutableList<Trick> = ArrayList()
        val allTrickProblemProducers: MutableMap<String, TrickProblemProducer> = HashMap()

        val func = { id: String, descriptionKey: String, example: String, generatorsSupplier: GeneratorsSupplier ->
            val trick = Trick(id, topicKey, descriptionKey, example)
            allTricks.add(trick)
            allTrickProblemProducers[id] = TrickProblemProducer(trick, generatorsSupplier(trick))
        }

        listTricks(func)

        return Pair(allTricks, allTrickProblemProducers)
    }

    fun getTricks(): List<Trick> = tricks

    fun getTrickProblemProducers(): Map<String, TrickProblemProducer> = trickProblemProducers
}