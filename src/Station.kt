/**
 * Class station permettant d'acceder a toutes les valeurs necessaire d'une station
 */
data class Station(private val station: String,private val numId: Int,private val x: Double,private val y: Double,val idConnection: String ,val mode :Mode) {
    private val indStation = numId
    private val coordX: Double = x
    private val coordY: Double = y
    private val nomStation: String = station
    private val listLigne: ArrayList<Pair<Int, String>> = ArrayList<Pair<Int, String>>()
    private val modeTransport :Mode = mode
    init {
        listLigne.add(Pair<Int, String>(numId, idConnection))
        // Ajout de la ligne ainsi que de son id pour demander une connection
    }
    /**
     * Ajout d'une ligne avec son numéro et son identifiant de connection
     * @param indLigne l'indice de la ligne pour la representer
     * @param idConnec la valeur pour faire une requette et avoir les info
     */
    fun addLigne(indLigne: Int, idConnec: String) {
        listLigne.add(Pair<Int, String>(indLigne, idConnec))
    }
    /**
     *
     * @return Renvoie si la station contient des tram
     */
    fun isTram():Boolean{
        return this.modeTransport==Mode.TRAM
    }
    /**
     * @return true si la station est une station de metro et false sinon
     */
    fun isMetro():Boolean{
        return this.modeTransport==Mode.METRO
    }
    /**
     * @return true si la station est une station de rer et false sinon
     */
    fun isRer():Boolean{
        return this.modeTransport==Mode.RER
    }

    override fun toString():String= "Nom de la station $station , ces coordonnes $coordX , $coordY , son type de transport $mode "
}