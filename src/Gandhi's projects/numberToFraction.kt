package `Gandhi's projects`

import java.math.BigDecimal
import kotlin.math.roundToInt

fun decimalAFraccion(numeroDecimal: BigDecimal): Pair<Int, Int> {
    val precision = 1000000
    val entero = numeroDecimal.toInt()
    val decimal = numeroDecimal.remainder(BigDecimal.ONE)
    val denominador = BigDecimal(precision).toBigInteger()
    val numerador = (decimal * denominador.toBigDecimal()).toBigInteger()
    val gcd = numerador.gcd(denominador)
    println(entero)
    println(decimal)
    println(denominador)
    println(numerador)
    println(gcd)

    return Pair(
        entero * denominador.toInt() + numerador.divide(gcd).toInt(),
        denominador.divide(gcd).toInt()
    )
}

fun main() {
    println(
        (decimalAFraccion(
            BigDecimal(0.33333333333333)
        ).first.toDouble()
                /
                decimalAFraccion(
                    BigDecimal(0.33333333333333)
                ).second.toDouble()
        * 300 - 100).roundToInt()
    )
}
