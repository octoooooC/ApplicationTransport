package view

import model.Arret
import javax.swing.*
class PanelLigne (numLigne_ : String ,listAr:ArrayList<Arret>,frame:FrameApp): JPanel() {
    val numLigne :String = numLigne_
    val listArret : ArrayList<Arret> = listAr
    val listBoutonArret : ArrayList<JButton> = ArrayList<JButton>()
    private val panelAffichage : JPanel = JPanel()
    val paneScroll : JScrollPane = JScrollPane(panelAffichage)
    //Un logo a rajouter pour affichage
    init{
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

        }
        listBoutonArret.forEach{
            arret -> panelAffichage.add(arret)
        }
    }
    private fun createPanelArret(arret: Arret):PanelArret = PanelArret(arret)
}