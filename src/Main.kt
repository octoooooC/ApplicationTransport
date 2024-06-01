fun main() {
    val file = "untitled/gares.csv"
    val file2 = "untitled/arrets.csv"
    val graph = Graph(file,file2)
    graph.values().forEach{station -> println(station.toString())}
    println()
    println(graph.search("Gagny"))
    //val list = HashMap<String ,ArrayList<String>>()
    //val test = ArrayList<String>()
    //test.add("2")
    //list["Test"]=test
    //print(list["Test"]?.get(0))
    //print(list["Test"]?.get(0))

}