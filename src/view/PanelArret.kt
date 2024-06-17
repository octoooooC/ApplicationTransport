package view

import model.Arret
import javax.swing.*
class PanelArret(aR: Arret) : JPanel() {
    private val labelTexte : JLabel = JLabel(aR.arName)
    init{
        labelTexte.text=aR.arName
        add(labelTexte)

    }
}