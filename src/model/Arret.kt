package model

data class Arret(val arname:String, val zda:String, val mod : Mode, val arAcess:String="unknowkn", val arAudibale:String = "unknowkn", val arVisu:String="unknown"){
    /**
     * Nom de l'arret 
     */
    val arName : String = arname
    private val mapStop : HashMap<String, Stop> = HashMap<String, Stop>()
    /**
     * Identifiant de la zone d'arret sert a faire les requette pour les rer et toutes zone de trafique gere par la sncf
     */
    private val zdA : String = zda
    /**
    * model.Mode de transport du quai (Tram,Metro,Bus,Rer)
    * */
    private val mode : Mode = mod
    val arAccesibilty : String = arAcess
    val arAudibaleSignals : String = arAudibale
    val arVisualSignals : String = arVisu
    /**
     *
     * @return Renvoie si le quai est un arret de tram
     */
    fun isTram():Boolean{
        return this.mode== Mode.TRAM
    }
    /**
     * @return true si la station est une station de metro et false sinon
     */
    fun isMetro():Boolean{
        return this.mode== Mode.METRO
    }
    /**
     * @return true si la station est une station de rer et false sinon
     */
    fun isRer():Boolean{
        return this.mode== Mode.RER
    }
    fun addStop(stop: Stop) = mapStop.put(stop.arName,stop)

}
