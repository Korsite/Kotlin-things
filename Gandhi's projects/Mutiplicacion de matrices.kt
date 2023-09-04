package `Gandhi's projects`

fun possible_multiplicacion(matriz1 : Int, matriz2: Int) : Boolean{
    if(matriz1 != matriz2){
        return false
    }
    return true
}

fun multiplicacion (){
    println("Multplication can be done ")
}

fun main(){

    print("La primera matriz es de: ")
    val (matriz1_dimension_columna, matriz1_dimension_fila) = readln().split("x")

    print("La segunda matriz es de: ")
    val (matriz2_dimension_columna, matriz2_dimension_fila) = readln().split("x")

    if(possible_multiplicacion(matriz1 = matriz1_dimension_fila.toInt(),
            matriz2 = matriz2_dimension_columna.toInt())) {
        multiplicacion()
        println("The result of the matrix will be: $matriz1_dimension_columna x $matriz2_dimension_fila")
    }else
        println("Multiplicacion can't be done")


}