package coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() =
    runBlocking {
        repeat(10){
            coroutineScope {
                launch {
                    delay(1000)
                    println(it + 1)
                }
                print("This is the time ")
            }
        }
    }


