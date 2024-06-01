data class Arret(private val idligne:String,private val zda:String,private val arid1:Int,private val arid2:Int?,private val mod : Mode){
    /**
     * Indice de la ligne qui correspond au quai (Exemple 7bis,3,8,...)
     */
    private val _idLigne : String = idligne
    var idLigne : String? = null
        get(){
            return field ?: _idLigne
        }
    /**
     * Identifiant de la zone d'arret sert a faire les requette pour les rer et toutes zone de trafique gere par la sncf
     */
    private val zdA : String = zda
    /**
     * Identifiant arId permettant de faire une requette pour un sens du quai
     */
    val arId1 : Int = arid1
    /**
     * Identifiant arId permettant de faire une requette pour un sens du quai
     */
    //private var _arId2 :Int? = arid2
    var arId2 : Int? = arid2
        get() = field ?: -1
        set(value){if(field==null){field=value}}

    /**
    * Mode de transport du quai (Tram,Metro,Bus,Rer)
    * */
    private val mode : Mode = mod
    /**
     *
     * @return Renvoie si le quai est un arret de tram
     */
    fun isTram():Boolean{
        return this.mode==Mode.TRAM
    }
    /**
     * @return true si la station est une station de metro et false sinon
     */
    fun isMetro():Boolean{
        return this.mode==Mode.METRO
    }
    /**
     * @return true si la station est une station de rer et false sinon
     */
    fun isRer():Boolean{
        return this.mode==Mode.RER
    }
}
