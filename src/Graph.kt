import java.awt.geom.Point2D
import java.io.File
class Graph(fileGraph : String,fileLigne : String){
    private var mapStation : HashMap<String,Station> = HashMap<String,Station>()
    private var automateStation : StationAutomate
    init{
        val mapId = initArId(fileLigne)
        initGraph(fileGraph,mapId)
        automateStation = StationAutomate(this)
    }
    private fun initGraph(filename:String,mapId:HashMap<String,ArrayList<String>>){
        val listLines = File(filename).bufferedReader().readLines()
        listLines.forEachIndexed{ ind,line  ->
            if(ind==0){
                //On saute la premiere ligne
            }else {
                val split = line.split(";")
                val nom = split[7]
                val station = mapStation[nom]
                println(nom)
                try {
                    if(station == null){
                        val pos = split[0].split(",")
                        mapStation[nom] = Station(
                            nom,
                            split[2].toShort(),
                            PointDouble(pos[0].toDouble(), pos[1].trim().toDouble()),
                            split[6].toInt()
                        )
                    }
                    val arret = Arret(
                        split[13],
                        split[11],
                        mapId[split[11]]?.get(0)!!.toInt(),
                        mapId[split[11]]?.get(1)!!.toInt(),
                        getMode(split[14])
                    )
                    mapStation[nom]?.addArret(arret)
                }catch (nul : NullPointerException){
                    nul.printStackTrace()
                    println("Erreur a tel ligne , $nom , ${mapId[split[8]]}, ${split[8]}")
                }
            }
        }
    }
    private fun initArId(fileId:String):HashMap<String,ArrayList<String>>{
        val mapId = HashMap<String,ArrayList<String>>()
        File(fileId).forEachLine {
            line -> val split = line.split(";")
            if(mapId.contains(split[9])){
                mapId[split[9]]?.add(split[0])
            }else{
                val list = ArrayList<String>()
                list.add(split[0])
                mapId[split[9]] = list
            }
            println(split[9])
        }
        return mapId
    }
    private fun getMode(mode:String):Mode =
        when(mode){
            "BUS" -> Mode.BUS
            "TRAMWAY"->Mode.TRAM
            "METRO"->Mode.METRO
            "RER"->Mode.RER
            else -> Mode.ERROR
        }
    fun search(search:String):Boolean = automateStation.isStation(search)
    fun keyValues():Set<String>{
        return mapStation.keys
    }
    fun values():MutableCollection<Station> = mapStation.values

}
