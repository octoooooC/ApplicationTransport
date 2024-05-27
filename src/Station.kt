import java.awt.geom.Point2D
/**
 * Class station permettant d'acceder a toutes les valeurs necessaire d'une station
 * @param station nom de la station
 * @param id identifiant unique de la station pour differencier les stations (Peut etre amener a etre retirer)
 * @param mode mode de transport de la ligne (si ces un tram,metro , etc...)
 * @param zdc id de la zone de correspondance
 */
data class Station(private val station: String,private val id:Short,private val p:PointDouble,val mode :Mode,private val zdc:Int) {
    private val point : PointDouble = p
    private val idStation : Short = id
    private val nomStation: String = station
    private val listLigne: ArrayList<Quai> = ArrayList<Quai>()
    private val modeTransport :Mode = mode
    private val zdC:Int = zdc

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