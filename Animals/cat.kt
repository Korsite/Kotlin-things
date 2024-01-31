package Animals

class cat (val type : String = "cat",
           override var animal_name: String,
           override var animal_age: Int?,
           var owner : owner?) : actions, properties{
    override fun eat() {

    }

    override fun sleep() {

    }

    override fun indroduce() {
        println("Hi, my name is $animal_name, I am $animal_age years old\n" +
                "and I am ${owner?.animals_owned_doing_now?.get(animal_name)}")
    }


}


