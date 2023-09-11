/*
    z  V1  V2  Vn   S1   S2  Sn  Answer
S1                              =

S2

Sn

Z
 */

fun main() {
    val S1 = listOf(0, 2, 3, 1, 0, 0, 1500)
    val S2 = listOf(0, 3, 2, 0, 1, 0, 1500)
    val S3 = listOf(0, 1, 1, 0, 0, 1, 500)
    val Z = listOf(1, -10, -12, 0, 0, 0, 600)

    val indexPivotElement = Z.indexOf(checkTheBiggestNegativeNumber(Z))
    val rows = listOf(
        S1,
        S2,
        S3,
        Z
    )
    val pivotColumn = getPivotColumn(
        rows,
        indexPivotElement
    )

    val pivotRow = getPivotRow(
        rows,
        pivotColumn
    )

    println(
        "$pivotColumn \n$pivotRow"
    )

    println(
        convertPivotElementIntoOne(
            pivotRow,
            indexPivotElement
        )
    )


}

fun checkTheBiggestNegativeNumber(zList: List<Int>): Int {
    return if (zList.any { it < 0 }) zList.filter { it < 0 }.min()
    else 0
}

/**
 *
 */
fun getPivotColumn(
    rows: List<List<Int>>,
    biggestNegativeNumber: Int
): List<Int> {
    val list = mutableListOf<Int>()

    fun checkTheBiggestNegativeNumber(zList: List<Int>): Int {
        return if (zList.any { it < 0 }) zList.filter { it < 0 }.min()
        else 0
    }

    rows.forEach {
        list.add(it[biggestNegativeNumber])
    }
    return list
}

/** We need first the pivot column
 * Once found it, the second parameter of this function
 * is useful to divide by the results (the last entry of every list)
 */

/*
for example, given an interaction of the next table

    z  V1  V2  V3   S1   S2   Answer
S1  0   1   3   5   1    0  =  100

S2  0   3   4   1   0    1  =  160

Z   10 -3  -4  -1   0    0  =  160

My pivot Column would be here [3, 4, -4], because -4 is the most minimum among the Z entries
My row column would the lowest number dividing the answer by the number found in the pivot column

For S1 -> Answer / elementFoundInPivotColumn = 100 / 3 = 33.33
For S2 -> 160 / 4 = 40

We check which is the most minimum number

kkkk
 */

fun getPivotRow(
    rows: List<List<Int>>,
    numbersWhichWillDivide: List<Int>
): List<Int> {
    val numbersDivided = mutableListOf<Int>()

    // until, because I don't want to take Z objective function
    for (i in 0 until rows.size - 1) {
        numbersDivided.add(
            rows[i].last() / numbersWhichWillDivide[i]
        )   
    }

    return rows[
        numbersDivided.indexOf(numbersDivided.min())
    ]
}

/*
 this function makes this
    Example:
        [10, 5, 8, 10, 12] let's say pivot Element is [2] = 8
        in order to convert the number 8 into one, it has to be multiplied by 1/8
        but the other elements also have to be multiplied by 1/8
        so my list would be like this -> [10/8, 2/8, 1, 10/8, 12/8]


 */
fun convertPivotElementIntoOne(
    pivotRow: List<Int>,
    pivotElement: Int
): List<Double> {
    return pivotRow.map {
        (1 / pivotElement.toDouble()) * it
    }
}
