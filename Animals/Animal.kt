package Animals

class Animal(
    val name: String,
    val age: Int,
    val typeOfAnimal: TypeOfAnimal
): Actions, properties {

    override fun eat() {
        println("Your $typeOfAnimal named $name is eating!")
    }

    override fun sleep() {
        println("Your $typeOfAnimal is sleeping")
    }

    override fun indroduce() {
        println("Hello! my name is $name and I am a $typeOfAnimal")
    }

    override var animalName: String = name
    override var animalAge: Int = age
}

enum class TypeOfAnimal{
    Cat, Dog
}