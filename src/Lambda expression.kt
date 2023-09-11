
fun main(){

    val treatFunction = trickOrTreat(false) { "$it quarters" }
    val trickFunction = trickOrTreat(true, null)
    repeat(4){
        treatFunction()
    }
    trickFunction()
}

fun trickOrTreat(isTrick : Boolean, extraTreat : ((Int) -> String)?) : () -> Unit{
    // the 2nd parameter is converted to nullable, so at the moment of invoking the function, 2nd parameter
    // doesn't have to be declared and instead, simply write "null" as argument, as we can see in
    // val trickFunction of () -> Unit type, (in other words, a function itself type)
    return if(isTrick)
        trick
    else{
        if(extraTreat != null)
            println(extraTreat(5))
        treat
    }
}
val trick : () -> Unit = {
    println("No treats!")
}
val treat : () -> Unit = {
    println("have a treat!")
}