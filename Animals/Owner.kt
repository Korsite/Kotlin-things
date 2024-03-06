package Animals

import Animals.TotalOfAnimals.addAnAnimal

/**
 * Simple program to explain interfaces
 * []
 */
class Owner(val name_owner: String) {
    val animalsOwned = mutableSetOf<Animal>()

    init {
        TotalOfAnimals.owners.add(this)
        println("Hi! my name is $name_owner and I currently have no animals")
    }
}

object TotalOfAnimals {
    val owners = mutableListOf<Owner>()
    fun Owner.addAnAnimal() {
        animalsOwned.add(
            Animal(
                name = readln(),
                age = readln().toInt(),
                typeOfAnimal = TypeOfAnimal.Cat
            )
        )

        owners[owners.indexOf(this)] = this // replace the instance with new attributes
        println("$name_owner has ${animalsOwned.size} animals")
    }
}

fun main() {
    val owner1 = Owner("Gandhi")
    owner1.addAnAnimal()
    owner1.addAnAnimal()

    val owner2 = Owner("Maria")
    println(
        "There in total ${TotalOfAnimals.owners.size} owners"
    )
}