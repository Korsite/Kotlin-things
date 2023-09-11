package `Kotline exercises`

fun main() {
    val morningNotification = 135
    val eveningNotification = 91

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}


fun printNotificationSummary(numberOfMessages: Int) {
    if(numberOfMessages <= 99){
        println("You have 51 notifications")
    }else{
        println("Your phone is blowing up! You have 99+ notificacions. ")
    }
}