package Animals

import kotlin.math.absoluteValue

val todoslosperros = mutableListOf<String>()

open class owner (val name_owner : String) {

    val animals_owned = mapOf<String, MutableList<String>>(
        "dog" to mutableListOf<String>(),
        "cat" to mutableListOf<String>()
    )
    val animals_owned_doing_now = mutableMapOf<String, String>()

    val animals_age = mutableMapOf<String, Int>()

    fun pets_owned() {

        if (animals_owned.isEmpty())
            println("$name_owner has no pet")
        else {

            animals_owned["dog"]?.forEach { it ->
                println("$it is ${animals_owned_doing_now[it]}")
            }

            animals_owned["cat"]?.forEach { it ->
                println("$it is ${animals_owned_doing_now[it]}")
            }
        }
    }

    fun add_cat(animal_name: String, animal_age : Int) {
        animals_owned["cat"]?.add(animal_name) // red lines are for saving the data of each pet
        animals_owned_doing_now.put(animal_name, "doing nothing")
        animals_age.put(animal_name, animal_age)
        println("Now $name_owner has a cat named $animal_name")

        adddogs(animal_name)
    }

    fun add_dog(animal_name: String, animal_age: Int) {
        animals_owned["dog"]?.add(animal_name) // red lines are for saving the data of each pet
        animals_owned_doing_now.put(animal_name, "doing nothing")
        animals_age.put(animal_name, animal_age)
        println("Now $name_owner has a cat named $animal_name")

        adddogs(animal_name)
    }

    fun make_pets_eat() {
        animals_owned["dog"]?.forEach { it ->
            animals_owned_doing_now[it] = "eating"
        }
        animals_owned["cat"]?.forEach { it ->
            animals_owned_doing_now[it] = "eating"
        }
        pets_owned()
    }

    fun make_pets_sleep() {
        animals_owned["dog"]?.forEach { it ->
            animals_owned_doing_now[it] = "sleeping"
        }
        animals_owned["cat"]?.forEach { it ->
            animals_owned_doing_now[it] = "sleeping"
        }
        pets_owned()
    }
}

fun adddogs(name : String){
    todoslosperros.add(name)
}

fun main() {
    val todoslosperros = mutableListOf<String>()

    val owners: Map<String, owner> = mapOf(
        "elsy" to owner("Elsy"),
        "Gandhi" to owner("Gandhi"),
        "Gilberto" to owner("Gilberto")
    )


    owners["elsy"]?.add_dog("Yama", 5)
    owners["elsy"]?.add_dog("Pinwinaso", 5)
    owners["elsy"]?.add_cat("Manchas", 5)
    owners["Gandhi"]?.add_cat("Pepe", 15)
    owners["Gandhi"]?.make_pets_sleep()

    // variable not necessary // var total_animals = (owners.mapNotNull { it.value.animals_owned.values.flatMap {it}}).flatMap { it }

    /* what this makes is create an instance for every pet added according to the animal
    for example, if a cat has been created with an "x" name, then the instance for that object with "x" name is for cat() class
    the instances will be storaged in a maplist<String, cat or dog> where String is the "x" name, and deppending in the animal
    its instance will be in cat() class or dog() class
    */
    var total_dogs =  (owners.mapNotNull { it.value.animals_owned["dog"]}).flatMap { it } //the list of every dog created is generated here
    var total_cats =  (owners.mapNotNull { it.value.animals_owned["cat"]}).flatMap { it } //the list of every cat created is generated here

    val total_ages_helper  = owners.mapNotNull { it.value.animals_age.ifEmpty { null }}
    val total_ages = mutableMapOf<String, Int>()
    total_ages_helper.forEach{ it ->
        for((name, age) in it){
            total_ages.put(name, age)
        }
    }

    val dogs_instance = mutableMapOf<String, dog>() // here the instances are storaged for dogs
    val cats_instance = mutableMapOf<String, cat>() // here the instances are storaged for cats

    total_dogs.forEachIndexed { index, animals ->
        dogs_instance.put(total_dogs[index], dog(animal_name = animals, animal_age = total_ages[animals], owner = owners["elsy"]))
    }

    total_cats.forEachIndexed { index, animals ->
        cats_instance.put(total_cats[index], cat(animal_name = animals, animal_age = total_ages[animals], owner = owners["elsy"]))
    }

    dogs_instance["Yama"]?.indroduce()
    println(todoslosperros)
}
