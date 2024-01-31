import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class  SmartDevice(val name : String, val category : String){

    var deviceStatus = "online"

    open val deviceType = "unknown"

    open fun turnOn(){
        deviceStatus = "on"
    }

    open fun turnOff(){
        deviceStatus = "off"
    }

    fun printDeviceInfo(){
        println("Device name: $name, category: $category, type: $deviceType")
    }

}

class SmartTvDevice (deviceName : String, deviceCategory : String)
    : SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType: String = "Smart TV"
    private var channelNumber by
    RangeRegulator(
        initialValue = 1,
        minValue = 1,
        maxValue = 200,
    )
        // we become it private because we don't want external code to modify it
        //we only want this property to be changed from nextChannel() method
        //same shit goes for speaker volume property and brightnessLevel property from
        //SmartLightDevice subclass

    private var speakerVolume by
    RangeRegulator(
        initialValue = 0,
        minValue = 0,
        maxValue = 100,
    )

    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                    "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }

    fun increaseSpeakerVolume(){
        speakerVolume++
        println("Speaker volume: $speakerVolume")
    }

    fun decreaseSpeakerVolume(){
        speakerVolume--
        println("Speaker volume: $speakerVolume")
    }

    fun nextChannel(){
        channelNumber++
        println("Channel number increased to $channelNumber")
    }

    fun previousChannel(){
        channelNumber--
        println("Channel number decreased to $channelNumber")
    }

}

class SmartLightDevice(deviceName : String, deviceCategory : String)
    : SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType: String
        get() = "Smart Light"

    private var brightnessLevel by
    RangeRegulator(
        initialValue = 2,
        minValue = 0,
        maxValue = 100,
    )

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }

    fun increaseBrightness(){
        brightnessLevel++
        println("Brightness increased to $brightnessLevel")
    }

    fun decreaseBrightness(){
        brightnessLevel--
        println("Brightness decreased to $brightnessLevel")
    }
}

class SmartHome(
    val smartTvDevice : SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {
    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        smartTvDevice.turnOn()
        deviceTurnOnCount++
    }

    fun turnOffTv() {
        smartTvDevice.turnOff()
        deviceTurnOnCount--
    }

    fun increaseTvVolume() {
        if(smartTvDevice.deviceStatus == "on")
            smartTvDevice.increaseSpeakerVolume()
        else
            println("Unable to change volume, tv off")
    }

    fun decreaseTvVolume(){
        if(smartTvDevice.deviceStatus == "on")
            smartTvDevice.decreaseSpeakerVolume()
        else
            println("Unable to change volume, tv off")
    }

    fun changeTvChannelToNext() {
        if(smartTvDevice.deviceStatus == "on")
            smartTvDevice.nextChannel()
        else
            println("Unable to change channel, Tv off")
    }

    fun changeTvChannelToPrevious(){
        if(smartTvDevice.deviceStatus == "on")
            smartTvDevice.previousChannel()
        else
            println("Unable to change channel, Tv off")
    }

    fun printSmartTvInfo(){
        println(
                "${smartTvDevice.deviceStatus}, " +
                "${smartTvDevice.category}, " +
                "${smartTvDevice.name}, " +
                "${smartTvDevice.deviceType}"
        )
    }

    fun increaseLightBrightness() {
        if(smartLightDevice.deviceStatus == "on")
            smartLightDevice.increaseBrightness()
        else
            println("Unable to increased Brightness, device off")
    }

    fun decreaseLightBrightness(){
        if(smartLightDevice.deviceStatus == "on")
            smartLightDevice.decreaseBrightness()
        else
            println("Unable to decrease Brightness, device off")
    }

    fun printSmartLightInfo(){
        println(
            "${smartLightDevice.deviceStatus}, " +
                    "${smartLightDevice.name}, " +
                    "${smartLightDevice.category}, " +
                    smartLightDevice.deviceType
        )
    }



    fun turnOnLight() {
        smartLightDevice.turnOn()
        deviceTurnOnCount++
    }

    fun turnOffLight() {
        smartLightDevice.turnOff()
        deviceTurnOnCount--
    }

    fun turnOffAllDevices(){
        turnOffTv()
        turnOffLight()
    }
}

class RangeRegulator(
    initialValue : Int,
    private val minValue : Int,
    private val maxValue : Int,
) : ReadWriteProperty<Any?, Int> {
    var fielData = initialValue
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fielData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if(value in minValue..maxValue){
            fielData = value
        }
    }

}
fun main() {
    val smartHome = SmartHome(
        SmartTvDevice(deviceName = "Android TV", deviceCategory = "Entertainment"),
        SmartLightDevice(deviceName = "Google light", deviceCategory = "Utility")
    )

    smartHome.printSmartTvInfo()



}