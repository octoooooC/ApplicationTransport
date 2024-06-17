package model

/**
 * Class station permettant d'acceder a toutes les valeurs necessaire d'une station
 * @param station nom de la station
 * @param id identifiant unique de la station pour differencier les stations (Peut etre amener a etre retirer)
 * @param zdc id de la zone de correspondance
 */
data class Station(private val station: String, private val id:Short, private val p: PointDouble, private val zdc:Int) {
    private val point : PointDouble = p
    private val idStation : Short = id
    private val nomStation: String = station
    private val listArret: ArrayList<Arret> = ArrayList<Arret>()
    private val zdC:Int = zdc

    /**
     * Ajout un quai a la liste des quai de la zone de correspondance de la station
     * @param a l'arret a ajoute a la liste des arret dans la station
     */
    fun addArret(a: Arret) {
        listArret.add(a)
    }
    override fun toString():String= "Nom de la station $station , ces coordonnes $point.getCoordX() , $point.coordY() "
}