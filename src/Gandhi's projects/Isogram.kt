package `Gandhi's projects`

fun isogram_ornot(palabra : String){
    val palabra2 = palabra
    var contador : Int = 0
    var special_character : Int = 0
        palabra.forEach {palabra ->

            if(palabra == '-'){
                special_character++
            } //aqui sumamos todos los caracteres especailes
            // para despues sumarlos al comparar si la palabra es isomorfa


            palabra2.forEach { palabra2->

                // println("$palabra ($index)     $palabra2 ($index2)?") esto sirve para saber que se esta comparando


                if(palabra == palabra2 && palabra2 != '-'){  // pongo "!= porque no quiero que se cuente los caracteres especiales
                    //println ("$palabra es igual a $palabra2")
                    contador++

                }
            }
        }


    if(contador + special_character == palabra.length)
        println("The word $palabra is isogram")
    else
        println("The word $palabra is not isogram")

    //println(contador)
    //println(special_character)

}

fun main(){
    val palabra1 : String = "pencil"
    val palabra2 : String = "background"
    val palabra3 : String = "downstream"
    val palabra4 : String = "six-year-old"
    val palabra5 : String = "pizarron"
    isogram_ornot(palabra1)
    isogram_ornot(palabra2)
    isogram_ornot(palabra3)
    isogram_ornot(palabra4)
    isogram_ornot(palabra5)
}