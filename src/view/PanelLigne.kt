package view

import model.Arret
import javax.swing.*
//TODO REMPLACER L4ARRAYLIST PAR UN ITERATOR
class PanelLigne (numLigne_ : String ,listAr:ArrayList<Arret> ): JPanel() {
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
                ae -> val pArret = PanelArret(arret)
                //Ajoute le panelArret au show
                //Show le panel
                //TODO Ajouter tout les show
            }

        }
        listBoutonArret.forEach{
            arret -> panelAffichage.add(arret)
        }
    }
}