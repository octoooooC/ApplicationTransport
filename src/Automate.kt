class Automate(state:Boolean ){
    private val final : Boolean = state
    private val mapTransition : HashMap<Char,Automate> = HashMap<Char,Automate>()

    fun getAutomateTransition (c:Char): Automate?{
        return mapTransition[c]
    }

    fun addTransition(c:Char,automate:Automate){
        mapTransition[c] = automate
    }
    fun isFinal():Boolean = final

}