import java.awt.geom.Point2D
/**
 * Class station permettant d'acceder a toutes les valeurs necessaire d'une station
 * @param station nom de la station
 * @param id identifiant unique de la station pour differencier les stations (Peut etre amener a etre retirer)
 * @param numLigne numero de la ligne
 * @param mode mode de transport de la ligne (si ces un tram,metro , etc...)
 */
data class Station(private val station: String,private val id:Short,private val numLigne:String,private val p:PointDouble,val idConnection: String ,val mode :Mode) {
    private val point : PointDouble = p
    private val idStation : Short = id
    private val nomStation: String = station
    private val listLigne: ArrayList<Pair<String, String>> = ArrayList<Pair<String, String>>()
    private val modeTransport :Mode = mode
    init {
        listLigne.add(Pair<String, String>(numLigne, idConnection))
        // Ajout de la ligne sings que de son id pour demander une connection
    }
    /**
     * Ajout d'une ligne avec son numéro et son identifiant de connection
     * @param indLigne l'indice de la ligne pour la representer
     * @param idConnec la valeur pour faire une requette et avoir les info
     */
    fun addLigne(indLigne: String, idConnec: String) {
        listLigne.add(Pair<String, String>(indLigne, idConnec))
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

    override fun toString():String= "Nom de la station $station , ces coordonnes $point.getCoordX() , $point.coordY() , son type de transport $mode "
}