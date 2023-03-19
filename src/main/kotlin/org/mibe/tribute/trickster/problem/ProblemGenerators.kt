package org.mibe.tribute.trickster.problem

import org.mibe.tribute.trickster.trick.Trick

typealias ProblemGenerator = () -> ProblemDefinition

fun `a+b`(aSupplier: IntValueSupplier, bSupplier: IntValueSupplier, trick: Trick): ProblemGenerator {
    return {
        val a = aSupplier()
        val b = bSupplier()
        val solution = a + b
        ProblemDefinition("$a + $b = ?", solution.toString(), trick)
    }
}
fun `a+b`(a: Int, bSupplier: IntValueSupplier, trick: Trick): ProblemGenerator = `a+b`({a}, bSupplier, trick)
fun `a+b`(aSupplier: IntValueSupplier, b: Int, trick: Trick): ProblemGenerator = `a+b`(aSupplier, {b}, trick)
fun `a+b`(a: Int, b: Int, trick: Trick): ProblemGenerator = `a+b`({a}, {b}, trick)