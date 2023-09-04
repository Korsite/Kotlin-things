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

fun getPivotColumn(
    rows: List<List<Int>>,
    biggestNegativeNumber: Int
): List<Int> {
    val list = mutableListOf<Int>()
    rows.forEach {
        list.add(it[biggestNegativeNumber])
    }
    return list
}

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
        [10, 2, 8, 10, 12] let's say pivot Element is [2] = 8
        in order to convert the number 8 into one, it has to be multiplied by 1/8
        but the other elements also have to be multiplied but 1/8
        so my list would be like this -> [10/8, 2/8, 1, 10/8, 12/8]


 */
fun convertPivotElementIntoOne(
    pivotRow: List<Int>,
    pivotElement: Int
): List<Int> {
    return pivotRow.map {
        it * (1 / 3)
    }
}