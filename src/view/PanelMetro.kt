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
        panelLayout.layout = GridLayout(maxLigne+ DIVISEGRIDHEIGH-1/ DIVISEGRIDHEIGH,maxLigne+ DIVISEGRIDWITH-1/ DIVISEGRIDWITH)
        for(i in 1..maxLigne){
            val numLigne ="$i"
            val button = JButton("Ligne $numLigne")
            button.isOpaque=false
            button.addActionListener{
                if(frame.isInMemory(numLigne)){
                    frame.showPanel(numLigne)
                }else{
                    frame.ajoutPanel(createPanel(numLigne),numLigne)
                }
            }
            listBouton.add(button)
        }
    }
    companion object{
        const val DIVISEGRIDHEIGH = 3
        const val DIVISEGRIDWITH = 5
    }

    private fun createPanel(nomLigne: String):PanelLigne = PanelLigne(nomLigne,gra.getArretLigne(nomLigne))
}