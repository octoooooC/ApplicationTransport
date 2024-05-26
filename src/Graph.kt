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
        listLines.forEach { line  -> val split = line.split(";")
            val nom = split[7]
            val station = mapStation[nom]
            if(station!=null){
                station.addLigne(split[13].toInt(), split[11])
            }else{
                val pos = split[0].split(",")
                mapStation[nom] = Station(nom,
                    split[2].toInt(), pos[0].toDouble(), pos[1].trim().toDouble(), split[11],getMode(split[14]))
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
    fun keyValues():Set<String>{
        return mapStation.keys
    }
    fun values():MutableCollection<Station> = mapStation.values

}

fun main() {
    var file = "gares.csv"
    var graph = Graph(file,"")
    graph.values().forEach{station -> println(station.toString())}
}