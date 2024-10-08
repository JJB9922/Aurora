package processing

import kotlin.random.Random

val <T> List<T>.sample: T
        get() = this[Random.nextInt(this.size)]

val <T> MutableSet<T>.sample: T
        get() = this.elementAt(Random.nextInt(this.size))

val Int.f: Float
        get() = this.toFloat()

val Float.i: Int
        get() = this.toInt()

val <T> List<T>.pairwise: List<Pair<T,T>>
    get() {
        if(this.size > 1) {
            var pairs = mutableListOf<Pair<T,T>>()
            for(i in 0 .. (this.size - 2)) {
                pairs.add(this[i] to this[i + 1])
            }
            return pairs
        } else {
            return listOf()
        }
    }
