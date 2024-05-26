import java.awt.geom.Point2D
import java.io.File
class Graph(fileGraph : String,fileLigne : String){
    private var mapStation : HashMap<String,Station> = HashMap<String,Station>()
    private var automateStation : StationAutomate
    init{
        initGraph(fileGraph)
        automateStation = StationAutomate(this)
    }
    private fun initGraph(filename:String){
        val listLines = File(filename).bufferedReader().readLines()
        listLines.forEachIndexed{ ind,line  ->
            if(ind==0){
                //On saute la premiere ligne
            }else {
                val split = line.split(";")
                val nom = split[7]
                val station = mapStation[nom]
                println(nom)
                if (station != null) {
                    station.addLigne(split[13], split[11])
                } else {
                    val pos = split[0].split(",")
                    mapStation[nom] = Station(
                        nom,
                        split[2].toShort(),split[12], PointDouble(pos[0].toDouble(), pos[1].trim().toDouble()), split[11], getMode(split[14])
                    )
                }
            }
        }
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

fun main() {
    val file = "gares.csv"
    val graph = Graph(file,"")
    //graph.values().forEach{station -> println(station.toString())}
    println()
    println(graph.search("Gagny"))
}