package model

import java.io.File
import view.*
fun main() {
    val fileStop = File("untitled/stop.csv")
    val fileArret = File("untitled/arrets.csv")
    //val graph = Graph(fileStop,fileArret)
    //println(graph.isStation("Gagny RER"))
    //println(graph.isStation("Chatelet"))
    javax.swing.SwingUtilities.invokeLater {
        FrameApp(fileStop,fileArret)
    }
}