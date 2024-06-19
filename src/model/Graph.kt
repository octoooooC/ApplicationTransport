package model

import java.io.File

class Graph(fileStop: File,fileArret:File){
    /**
     * HashMap de tout les arrets avec comme keys le nom de l 'arret
     */
    private val mapArret : HashMap<String, Arret> = HashMap<String, Arret>()
    /**
     * Map avec comme cle l'identifiant d'une ligne et en valeur l'identifiant a utilisée pour faire une requette
     */
    private val mapLigne : HashMap<String,String> = HashMap<String,String>()
    private var automate : StationAutomate
    /**
     * Map de toutes les lignes avec comme cle leur identifiant et en valeur toutes les stations sur cette ligne
     */
    private var mapLigneArret : HashMap<String,ArrayList<Arret>> = HashMap<String,ArrayList<Arret>>()
    init{
        //Map de ligne avec comme clé les identifiant de ligne et comme id
        val map = initNumLigne(fileStop)
        initArret(fileArret,map)
        automate = StationAutomate(mapArret.keys)
    }

    private fun initNumLigne(fileStop: File):HashMap<String,ArrayList<String>>{
        //On cree une map avec comme cle les arId et comme valeur une liste de tout les numLigne
        val mapId : HashMap<String,ArrayList<String>> = HashMap<String,ArrayList<String>>()
        fileStop.readLines().forEachIndexed{
            index, s ->
            if(index!=0){
                val split = s.split(";")
                val arId = split[0].split(":")[3]
                if(mapId.containsKey(arId)){
                    mapId[arId] = ArrayList<String>()
                }
                mapId[arId]?.add(split[3])
                mapLigne[split[2].split(":")[3]]=split[3]
            }
        }
        return mapId
    }
    private fun initArret(fileArret:File,map:HashMap<String,ArrayList<String>>){
        fileArret.readLines().forEachIndexed { index, s ->
            val split = s.split(";")
            if(index!=0){
                if(!mapArret.containsKey(split[4])){
                    mapArret[split[4]] = Arret(split[4],split[15],getMode(split[13]),split[10],split[11],split[12])
                }
                map[split[0]]?.forEach {
                    str -> val stop = Stop(split[4],str,split[0])
                    if(!mapLigneArret.containsKey(stop.numLine)){
                        mapLigneArret[stop.numLine]=ArrayList<Arret>()
                    }
                    mapLigneArret[stop.numLine]?.add(mapArret[split[4]]!!)
                    mapArret[split[4]]?.addStop(stop)
                    

                }
            }
        }
    }
    private fun getMode(s:String): Mode =
        when(s){
            "metro" -> Mode.METRO
            "bus" -> Mode.BUS
            "tram" -> Mode.TRAM
            "rail" -> Mode.RER
            else -> Mode.ERROR
        }
    fun getArretLigne(idLigne:String):ArrayList<Arret> = mapLigneArret[idLigne]!!
    fun isStation(str:String):Boolean = automate.isStation(str)
}