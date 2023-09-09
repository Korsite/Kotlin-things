package `Gandhi's projects`
import javax.swing.JOptionPane

// IA'S WAY
fun `romannumber` (roman_number : String) : Int{
    val values : Map<Char, Int>  = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )

    var preview_value : Int = 0
    var suma_decimal : Int = 0

    roman_number.reversed().forEach {
        val value = values[it] ?: throw IllegalArgumentException("Invalid character $it")

        if(value >= preview_value)
            suma_decimal += value
        else
            suma_decimal = preview_value - value

        preview_value = value
    }

    return suma_decimal
}
fun main() {
    var number = 100
    var result : Double = 1.0
    for(it in number downTo 1)
        result *= it
    println(result)
}

/* MY WAY
    fun romano_to_decimal(){

        val numero_decimal = mutableListOf<Int>()
        var numero_decimal_suma : Int = 0

            numero_romano.forEachIndexed{ index, numero_romano ->
                when(numero_romano){
                    'I' -> numero_decimal.add(index, 1)
                    'V' -> numero_decimal.add(index, 5)
                    'X' -> numero_decimal.add(index, 10)
                    'L' -> numero_decimal.add(index, 50)
                    'C' -> numero_decimal.add(index, 100)
                    'D' -> numero_decimal.add(index, 500)
                    'M' -> numero_decimal.add(index, 1000)
                }
            }

        println(numero_decimal)


        for(i in 0..numero_decimal.size - 1) {

            if ((i + 1) != numero_decimal.size) {

                if (numero_decimal.get(i) < numero_decimal.get(i + 1)) {


                    numero_decimal_suma += numero_decimal.get(i + 1) - numero_decimal.get(i)
                    numero_decimal.set(i + 1, 0)

                } else numero_decimal_suma += numero_decimal.get(i)

            }else numero_decimal_suma += numero_decimal.get(i)
        }

        println(numero_decimal_suma)
    }
}
 */