import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.roundToInt
import kotlin.math.roundToLong

/*
    z  V1  V2  Vn   S1   S2  Sn  Answer
S1                              =

S2

Sn

Z
 */

fun main() {

    val S1 = listOf(0, 80, 92.5, 29, 38, 1, 0, 0, 0, 800).map { it.toDouble() }
    val S2 = listOf(0, 0,   0,    1, 1,  0, 1, 0, 0, 5).map { it.toDouble() }
    val S3 = listOf(0, 0,   0,   29, 38, 0, 0, 1, 0, 180).map { it.toDouble() }
    val S4 = listOf(0, 25,  34,   0, 0,  0, 0, 0, 1, 80).map { it.toDouble() }
    val Z = listOf( 1, -5, -85, -24,-28, 0, 0, 0, 0, 0).map { it.toDouble() }

    var rows = listOf(
        S1,
        S2,
        S3,
        S4,
        Z
    )
    var indexPivotElement = rows.last()
        .indexOf(
            checkTheBiggestNegativeNumber(rows.last())
        )


    while(rows.last()[indexPivotElement] < 0){

        /*
        this variable stores the index where the minus negative number in
        my object function is, example:
        having a list of (1, -3, -4 , -5), this stores the index 3
        because [3] = -5
        */

        indexPivotElement = rows.last()
            .indexOf(checkTheBiggestNegativeNumber(rows.last()))

        val pivotColumn = getPivotColumn(
            rows,
            indexPivotElement
        )

        println()
        println("pivto Colummn: $pivotColumn")

        val pivotRow = getPivotRow(
            rows,
            pivotColumn
        )

        println()
        println("pivto row: $pivotRow")
        println()

        rows = rows.map {
            val newRowWherePivotElementIsOne = convertPivotElementIntoOne(
                pivotRow,
                pivotRow[indexPivotElement]
            )

            if (it == pivotRow)
                newRowWherePivotElementIsOne
            else
                convertElementIntoZero(
                    newRowWherePivotElementIsOne,
                    it,
                    indexPivotElement
                )
        }

        indexPivotElement = rows.last()
            .indexOf(checkTheBiggestNegativeNumber(rows.last()))

        rows.forEach {
            println(it)
        }
        println(indexPivotElement)
    }
}

fun checkTheBiggestNegativeNumber(zList: List<Double>): Double {
    return if (zList.any { it < 0 }) zList.filter { it < 0 }.min()
    else 0.0
}

/**
 * Returns a list of elements of every list at index
 * where the major negativity is found
 *
 * major negativity is given by the checkTheBiggestNegativeNumber()
 * used in objective function
 */

/*
for example, given an interaction of the next table

    z  V1   V2  V3   S1   S2   Answer
S1  0   1   >3   5   1    0  =  100

S2  0   3   >4   1   0    1  =  160

Z   10 -3   -4  -1   0    0  =  160

My pivot Column would be [3, 4], because -4 is the most minimum among the Z entries
 */
fun getPivotColumn(
    rows: List<List<Double>>,
    indexWhereBiggestNegativeNumber: Int
): List<Double> {
    val list = mutableListOf<Double>()

    /*
     I only need elements from the pivot column which do not belong to the Z function
     and since Z function is the last element in the pivot Element then I can
     create a sublist where I don't take last list
     */
    for (listOfRestrictions in rows.subList(0, rows.lastIndex))
        list.add(listOfRestrictions[indexWhereBiggestNegativeNumber])

    return list
}

/**
 * pivot column is a must to apply this function
 * This returns the list where the lowest number of dividing
 * Answer / element found in the pivot column (in the same row) is found
 *
 * this also gives us which the pivot Element is,
 * Where the pivot column and pivot row intersects is where I have my pivot element
 */

/*
for example, given an interaction of the next table

    z  V1  V2  V3   S1   S2   Answer
S1  0   1   3   5   1    0  =  >100

S2  0   3   4   1   0    1  =  >160

Z   10 -3  -4  -1   0    0  =  160

My pivot Column = [3, 4]
My pivot Row would be the row with the lowest number dividing the answer by the number
found in the pivot column

For S1 -> Answer / elementFoundInPivotColumn = 100 / 3 = 33.33
For S2 -> 160 / 4 = 40

We check which is the major negative number, and in this case is for S1, because 33.33 < 40
So my pivot row would be [0, 1, 3, 5, 1, 0, 100], that list of elements
is what this function returns

And my pivot element is where pivot row and column intersects
[0, 1, [3], 5, 1, 0, 100]
       [4]
       pivot element is 3!
 */

fun getPivotRow(
    rows: List<List<Double>>,
    numbersWhichWillDivide: List<Double>
): List<Double> {

    // last because that is the result ( = x ) / divided by the element found in the pivot column
    var lowestNumberWhenDivided = rows[0].last() / numbersWhichWillDivide[0]
    var indexWhereLowestNumberWhenDivided = 0

    numbersWhichWillDivide.forEachIndexed { index, numberToDivide ->
        val resultDividedByTheElementFoundInPivotColumn = rows[index].last() / numberToDivide
// uncomment this        println("${rows[index].last()} / $numberToDivide = $resultDividedByTheElementFoundInPivotColumn")


        if (resultDividedByTheElementFoundInPivotColumn < lowestNumberWhenDivided){
            lowestNumberWhenDivided = resultDividedByTheElementFoundInPivotColumn
            indexWhereLowestNumberWhenDivided = index
        }
    }
    return rows[indexWhereLowestNumberWhenDivided]
}

/**
 * Pivot Row is a must to make this function works,
 * returns the same Pivot Row but multiplied by 1/x,
 * where x is the pivotElement.
 * Check comments in getPivotRow() function to know about pivotElement
 */
/*
 this function makes this
    Example:
        [10, 5, 8, 10, 12] let's say pivot Element is [2] = 8
        in order to convert the number 8 into one, it has to be multiplied by 1/8
        but the other elements also have to be multiplied by 1/8
        so my list would end up like this -> [10/8, 2/8, 1, 10/8, 12/8]
 */
fun convertPivotElementIntoOne(
    pivotRow: List<Double>,
    pivotElement: Double
): List<Double> {
    val formatTheBigNumbers: (Double) -> Double = { numberToRound ->
        BigDecimal(numberToRound).setScale(4, RoundingMode.DOWN).toDouble()
    }
    return pivotRow.map {
        formatTheBigNumbers(1 / pivotElement * it)
    }
}

/**
 * This is applied to every list which is NOT the pivot Row
 * Returns the same list but turning the element at index where pivot element is 0
 */

/*
for example, given an interaction of the next table
where pivotElement is converted into one in pivotRow

    z    V1   V2   V3    S1    S2   Answer
S1  0   1/3   1   5/3   1/3    0  =  100/3

S2  0     3   >4     1     0    1  =  160

Z   10   -3  >-4    -1     0    0  =  160

S2 at index 2 = 4
We have to convert that 4 in 0, so we multiply S1 * -4, and then
we add to S2, so the formula would be S1 * -4 + S2, I am lazy to do the
operation, but I know that if 1 * -4 + 4 = 0, then what I want is right so
this function would return [?, ?, 0, ?, ?, ?, ?]

so in order to do Z at index 2 = 0
we have to S1 * 4 + Z
 */
fun convertElementIntoZero(
    listWherePivotElementIsConvertedIntoOne: List<Double>,
    listToConvert0AtIndexOfPivotElement: List<Double>,
    indexWherePivotElement: Int
): List<Double> {
    val numberToMultiplyTheListWherePivotElementConvertedIntoOne =
        listToConvert0AtIndexOfPivotElement[indexWherePivotElement] * -1

    val formatTheBigNumbers: (Double) -> Double = { numberToRound ->
        BigDecimal(numberToRound).setScale(6, RoundingMode.DOWN).toDouble()
    }

    return listWherePivotElementIsConvertedIntoOne.mapIndexed { index, i ->

        // aqui me quede, tengo que encontrar la manera de redondear los numeros
        /*
        println("$i * $numberToMultiplyTheListWherePivotElementConvertedIntoOne + ${listToConvert0AtIndexOfPivotElement[index]} = " +
                "${i* numberToMultiplyTheListWherePivotElementConvertedIntoOne + listToConvert0AtIndexOfPivotElement[index]}"
        )
        println("$i * $numberToMultiplyTheListWherePivotElementConvertedIntoOne + ${listToConvert0AtIndexOfPivotElement[index]} = (rounded) " +
                "${
                    formatTheBigNumbers(i* numberToMultiplyTheListWherePivotElementConvertedIntoOne + listToConvert0AtIndexOfPivotElement[index])
                }"
        )
        println()

         */


        formatTheBigNumbers(i * numberToMultiplyTheListWherePivotElementConvertedIntoOne +
                listToConvert0AtIndexOfPivotElement[index])
    }
}