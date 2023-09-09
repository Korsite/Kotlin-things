package `Gandhi's projects`

class Person (val firstName: String = "Gandhi", val lastName: String = "Sanchez"){

    var nickName: String? = null

        get() {
            println("The returned value is $field")
            return field
        }

    fun printInfo(){
        val nickNamecheck = nickName ?: "No nickname"
        println("$firstName $nickNamecheck $lastName")
    }
}