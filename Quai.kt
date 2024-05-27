data class Quai(private val idligne:String,private val zda:String,private val arid1:Int,private val arid2:Int,private val mod : Mode){
    /**
     * Indice de la ligne qui correspond au quai (Exemple 7bis,3,8,...)
     */
    private val idLigne : String = idligne
    /**
     * Identifiant de la zone d'arret sert a faire les requette pour les rer et toutes zone de trafique gere par la sncf
     */
    private val zdA : String = zda
    /**
     * Identifiant arId permettant de faire une requette pour un sens du quai
     */
    private val arId1 :Int= arid1
    /**
     * Identifiant arId permettant de faire une requette pour un sens du quai
     */
    private val arId2 :Int = arid2
    /**
    * Mode de transport du quai (Tram,Metro,Bus,Rer)
    *
    * */
    private val mode : Mode = mode
}
