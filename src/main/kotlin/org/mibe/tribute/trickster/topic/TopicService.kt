package org.mibe.tribute.trickster.topic

interface TopicService {

    fun getAll(): List<Topic>
    fun get(key: Topic.Key): Topic
}