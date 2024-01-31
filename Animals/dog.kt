package Animals

class dog(
    val type: String = "bdog",
    override var animal_name: String,
    override var animal_age: Int?,
    var owner: owner?): actions, properties{

    override fun eat() {
        println("$animal_name is eating")
    }

    override fun sleep() {
        println("$animal_name is sleeping")
    }

    override fun indroduce() {
        println("Hi, my name is $animal_name, I am $animal_age, " +
                "and I am ${owner?.animals_owned_doing_now?.get(animal_name)}")
    }

}