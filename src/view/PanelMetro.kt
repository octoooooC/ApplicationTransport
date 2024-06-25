package view

import javax.swing.*
import model.Graph
import java.awt.GridLayout

class PanelMetro(frameApp: FrameApp,maxLigne:Int,graph:Graph) : JPanel() {
    private val frame = frameApp
    private val gra = graph
    private val listBouton : ArrayList<JButton> = ArrayList<JButton>()
    private val panelLayout = JPanel()
    init{
        val rows = (maxLigne+ DIVISEGRIDHEIGH-1)/ DIVISEGRIDHEIGH
        val cols = (maxLigne+ DIVISEGRIDWITH-1)/ DIVISEGRIDWITH
        print("$rows $cols")
        panelLayout.layout = GridLayout(rows,cols)
        for(i in 1..maxLigne){
            val numLigne ="$i"
            val button = JButton("Ligne $numLigne")
            button.isOpaque=true
            button.addActionListener{
                if(frame.isInMemory("Metro $numLigne")){
                    println("Affichage du panel")
                    frame.showPanel("Metro $numLigne")
                }else{
                    println("Creation du panel")
                    frame.ajoutPanel(createPanel("Metro $numLigne"),"Metro $numLigne")
                }
            }
            listBouton.add(button)
            panelLayout.add(button)
        }
        add(panelLayout)
    }
    companion object{
        const val DIVISEGRIDHEIGH = 3
        const val DIVISEGRIDWITH = 5
    }

    private fun createPanel(nomLigne: String):PanelLigne = PanelLigne(nomLigne,gra.getArretLigne(nomLigne),frame)
}