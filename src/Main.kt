fun main() {
    val file = "gares.csv"
    val graph = Graph(file,"")
    //graph.values().forEach{station -> println(station.toString())}
    println()
    println(graph.search("Gagny"))
}