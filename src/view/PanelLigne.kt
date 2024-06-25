package view

import model.Arret
import java.awt.BorderLayout
import java.awt.GridBagLayout
import java.awt.GridLayout
import javax.swing.*
class PanelLigne (numLigne_ : String ,listAr:ArrayList<Arret>,frame:FrameApp): JPanel() {
    private val numLigne :String = numLigne_
    private val listArret : ArrayList<Arret> = listAr
    private val listBoutonArret : ArrayList<JButton> = ArrayList<JButton>()
    private val panelAffichage : JPanel = JPanel()
    private val paneScroll : JScrollPane = JScrollPane(panelAffichage)
    private val panelLayout:JPanel = JPanel()
    //Un logo a rajouter pour affichage
    init{
        print(listArret.size)
        val panelGrid = JPanel(GridBagLayout())
        val panelVert = JPanel(GridLayout(2,1))
        val panelCenter = JPanel(BorderLayout())

        panelVert.add(Box.createVerticalBox())
        panelVert.add(paneScroll)
        panelAffichage.layout = BoxLayout(panelAffichage,BoxLayout.PAGE_AXIS)
        listArret.forEach {
            arret ->
            val bouton = JButton(arret.arName)
            bouton.addActionListener {
                val showStr = "${arret.arName}_${numLigne}"
                if(frame.isInMemory(showStr)){
                    frame.showPanel(showStr)
                }else{
                    frame.ajoutPanel(createPanelArret(arret),showStr)
                }
            }
            listBoutonArret.add(bouton)
        }
        listBoutonArret.forEach{
            arret -> panelAffichage.add(arret)
        }
        panelLayout.add(Box.createVerticalBox())
        panelLayout.add(paneScroll)
        panelGrid.add(panelLayout)
        panelCenter.add(panelGrid)
        add(panelCenter)
    }
    private fun createPanelArret(arret: Arret):PanelArret = PanelArret(arret)
}