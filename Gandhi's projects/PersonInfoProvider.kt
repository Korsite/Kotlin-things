package `Gandhi's projects`

interface PersonInfoProvider{

    fun prueba123(){}

}


class BasicInfoProvider{

    fun printInfo(person : Person){
        person.printInfo()
        println("PrintInfo")

    }

}

fun main(){
    val provider =  BasicInfoProvider()
    provider.printInfo(Person())
}