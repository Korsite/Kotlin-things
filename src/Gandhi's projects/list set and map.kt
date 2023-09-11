package `Gandhi's projects`

import java.awt.Robot

fun main(){

    println("<-----------------List---------------------->")
    /*
    you can access any elements using indices as shown in example below
     */
    val aList = listOf<String>(
        "Strawberry", // 0
        "Banana", // 1
        "Cherry" // 2
    )
    println("aList is: $aList")

    println("<-----------------Set---------------------->")
    /*
    as difference to list, in a set collection, values repeated are not allowed
    There is not a syntax error when compiled, but the 2nd value which is repeated
    will not be shown
     */
    val emotions : Set<String> = setOf(
        "Happy",
        "Sad",
        "Angry",
        "Surprised",
        "Sad",
        "Happy",
        "Hungry"
    )

    println("set emotions: $emotions")

    println("<-----------------Map---------------------->")

    val toppings : Map<Int, String> = mapOf(
        5 to "Hola",
        10 to "Toridio",
        15 to "Confirmation"
    )




    println("<-----------------Map function---------------------->")

    /*
    There is map function "map.{it | "it" is the element in the list}"
    which has nothing to see with the map collection "mapof(...)"
    This map function works either any collection type (list, set, map)
    */

    println()
    // Example 1 ----------------------------------------------
    println("Example 1")
    val inverse_aList : List<String> = aList.map {
        it.reversed()
    }
    val inverse_aList2 : List<String> = aList.reversed()

    println(inverse_aList) // map function used, reverse method used obviously
    println(inverse_aList2) // reversed method used as an expression (map no used)

    println()
    //Example 2 ----------------------------------------------
    println("Example 2")
    val strs : List<String> = listOf(
        "1",
        "2",
        "Three",
        "4",
        "V"
    )

    val nums : List<Int> = strs.mapNotNull {
        it.toIntOrNull()
    }
    println(nums)

    println()
    //Example 3 ----------------------------------------------
    println("Example 3")
    val rank : List<String> = listOf(
        "Gold",
        "Silver",
        "Bronze"
    )

    val rank_indexed :List<String> = rank.mapIndexed { index, ranks ->
        "$ranks ($index)"
    }

    println(rank_indexed)

    println()
    //Example 4, personally, very interesting ----------------------------------------------
    println("Example 4")
    val person = listOf(
        somepersons("Pinwinaso", 10),
        somepersons("Rene", 30),
        somepersons("Pepe", 18),
        somepersons("Jose", 17),
        somepersons("Ana", 20),
        robot("Pepe")
    )

    val person_upto18 = person.filter {
        it.age >= 18
    }

    val person_downto18 = person.filter{
        it.age < 18
    }

    // here, as a partition, we have to declare the variable which the partition 1 is going to
    // be stored, same to the partition 2; in this example, we see that val "upto18" is going to
    // store the partition 1, and the other the val "downto18"
    val (upto18, downto18) = person.partition {
        it.age >= 18
    }

    println("Persons in total: ")
    person.forEach{
        it.printInfo()
    }

    println()
    println("Persons up to 18: ")
    person_upto18.forEach{
        it.printInfo()
    }

    println()
    println("Persons down to 18: ")
    person_downto18.forEach{
        it.printInfo()
    }

    println()
    println("Partition 1 (up to 18): ")
    upto18.forEach{
        it.printInfo()
    }

    println()
    println("Partition 2 (down to 18): ")
    downto18.forEach{
        it.printInfo()
    }

    println()
    //Example 5, personally, very interesting ----------------------------------------------
    println("Example 5")

    val person2 = listOf(
        somepersons("Pinwinaso", 10),
        null,
        somepersons("Rene", 30),
        null,
        somepersons("Pepe", 18),
        somepersons("Jose", 17),
        null,
        somepersons("Ana", 20),
        robot("Pepe")
    )

    val actual_people = person2.filterNotNull()
    val robot = person2.filterIsInstance<robot>()

    //Persons who exist, I use "for" by the way, same shit with "foreach" just to remember old times jaja
    println("Persons who exist: ")
    for (actual_people1 in actual_people) {
        actual_people1.printInfo()
    }

    println()
    println("Persons who has instance with \"Robot\" class: ")
    for (robot1 in robot) {
        robot1.printInfo()
    }

    println()
    println("----Some interesting methods for lists----")

    val objects : List<String> = listOf(
        "Caca",
        "Pipi",
        "Popo",
        "Toridio",
        "Sky"
    )

    println("I take the first 3 of my list: ${objects.take(3)}")
    println("I drop the first 2 and print the rest: ${objects.drop(2)}")
    println("In case a drop more than elements had in the list\n" +
            "This will occur: ${objects.drop(10)}, in other words, an empty list")

    println()

    val randomNumbers : List<Int> = listOf(
        1,2,3,4,5,6,7,8,9,10
    )
    println("The average is: ${randomNumbers.average()}")
    println("The addition is: ${randomNumbers.sum()}")

    println()

    val randomNames : List<String> = listOf(
        "Dalas", "Fer", "Paola", "Panfilo", "Gandhi"
    )

    println("The addition of all of the lenght elements: ${randomNames.sumOf { it.length }}")
    println("The biggest element: ${randomNames.maxOf { it.length }}")
    println("The smalllest element: ${randomNames.minOf { it.length }}")
    println("The number of elements of my list: ${randomNames.count()}")
    println("The number of elements which \n" +
            "have up to 5 characters: ${randomNames.count{ it.length >= 5 }} ")

    println()

    println("This is an example of how powerful .joinToString method is: \n" +
            randomNumbers.joinToString(
                separator = "-",
                prefix = "Me como mi kk: ",
                limit = 5
            ) {
                "[$it}"
            }
    )

}
// part of the example 4
open class somepersons(val name : String,val age : Int){
    open fun printInfo(){
        println("$name $age")
    }
}

class robot(name : String) : somepersons(name,99){
    override fun printInfo() {
        super.printInfo()
    }
}