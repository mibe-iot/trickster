package org.mibe.tribute.trickster.trick

import org.mibe.tribute.trickster.topic.MathTopic

data class Trick(
    val id: String,
    val topic: MathTopic,
    val description: String,
    val example: String
)
