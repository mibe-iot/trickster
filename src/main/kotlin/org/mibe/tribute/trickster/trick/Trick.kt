package org.mibe.tribute.trickster.trick

import org.mibe.tribute.trickster.topic.Topic

data class Trick(
    val id: String,
    val topic: Topic.Key,
    val descriptionKey: String,
    val example: String
)
