package org.mibe.tribute.trickster.problem

import kotlin.random.Random

typealias IntValueSupplier = () -> Int

fun anyInt(from: Int = -100, until: Int = 100): IntValueSupplier = { Random.nextInt(from, until) }
fun positiveInt(from: Int = 1, until: Int = 100): IntValueSupplier = { Random.nextInt(from, until) }
fun negativeInt(from: Int = -100, until: Int = 0): IntValueSupplier = { Random.nextInt(from, until) }