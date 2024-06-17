package model

class Stop(name:String, nameLine:String, arid:String) {
    val numLine : String = nameLine
    val arId = arid
    val arName :String = name
    override fun toString() = "$arName , $arId , $numLine"
}