/*
Typically, a phone screen turns on and off when the power button is pressed. In contrast,
if a foldable phone is folded, the main inner screen on a foldable phone doesn't turn on when the power button
is pressed.

In the initial code provided in the following code snippet, write a FoldablePhone class that inherits
from the Phone class. It should contain the following:

A property that indicates whether the phone is folded.
A different switchOn() function behavior than the Phone class so that it only turns the screen on
when the phone isn't folded.
Methods to change the folding state.
 */

package `Kotline exercises`

open class Phone(var isScreenLightOn: Boolean){
    open fun switchOn() {
        isScreenLightOn = true
    }

    open fun switchOff() {
        isScreenLightOn = false
    }

    open fun checkPhoneScreenLight(){
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(var PhoneFolded : Boolean = true) : Phone(){
    var checkPhoneFolded : String = if(PhoneFolded) "Cellphone is folded" else "Cellphone is not folded"

    override fun switchOn() {
        isScreenLightOn = !PhoneFolded
    }

    fun fold(){
        PhoneFolded = true
    }

    fun unfold(){
        PhoneFolded = false
    }
}

fun main (){
    val newFoldablePhone = FoldablePhone()

    newFoldablePhone.fold()
    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()
}