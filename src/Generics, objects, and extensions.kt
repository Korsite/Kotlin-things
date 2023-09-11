data class Question <T>( // Generics allow data types to be passed as parameters to classes
    val question : String,
    val answer : T,
    val difficulty : Difficulty
)

enum class Difficulty{  //enum classes define a limited set of possible values,
    EASY, MEDIUM, HARD
}

interface ProgressPrintable{
    val progressText : String
    fun printProgressBard()
}

class Quiz : ProgressPrintable{

    override val progressText: String
        get() = "$answered of $total answered"

    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress{ //"companion" keyword makes the object addable to a class
        //"total" and "answered" properties of "StudentProgress" instance are now also part of Quiz class
        //this means <for example> that     println(Quiz.StudentProgress.progressText) = println(Quiz.progressText)
        val total : Int = 10
        val answered : Int = 3
    }

    override fun printProgressBard() {
        print("▓".repeat(answered))
        print("▒".repeat(total - answered))
        println()
        println(progressText)
    }


    fun printQuiz(){

        question1.let{
            println(it.question)
            println(it.answer)
            println(it.difficulty)
            println()

        }

        question2.let(){
            println(it.question)
            println(it.answer)
            println(it.difficulty)
            println()
        }


        question3.let{
            println(question3.question)
            println(question3.answer)
            println(question3.difficulty)
            println()
        }
    }



}

/*
val Quiz.StudentProgress.progressText: String // an extension property
    get() = "$answered of $total answered" // get() function is compulsory to initialize a value

fun Quiz.StudentProgress.printProgressBar(){
    print("▓".repeat(answered))
    print("▒".repeat(total - answered))
    println()
    println(Quiz)
}
*/

fun main(){
    // println(question.toString())
    /* this wouldn't have any sense if "Question" class is not of data type
    in order to make this println readable, add "date" before class keyword in Question class
    what a data class type makes is tell Kotlin that the class is only information, There are NO methods (functions)
    in a data class type, only information
    */
    Quiz().printProgressBard()
    Quiz().apply {
        printQuiz()
    }

}

