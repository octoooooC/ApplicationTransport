package view

import model.Graph
import java.awt.BorderLayout
import java.awt.CardLayout
import java.io.File
import java.util.*
import javax.swing.JFrame
import javax.swing.*

class FrameApp (fileStop:File ,fileArrets:File ):JFrame() {
    private val maxQueueSize : Int = 10
    private val graph : Graph = Graph(fileStop, fileArrets)
    private val card : CardLayout = CardLayout()
    private val queuePanel : Queue<Pair<String,JPanel>> = LinkedList<Pair<String,JPanel>>()
    private val panelCardLayout : JPanel = JPanel(card)
    private val panelMetro : PanelMetro = PanelMetro(this,14,graph)
    private val panelLayout : JPanel = JPanel(BorderLayout())
    private val panelBouton : JPanel = JPanel()
    //TODO CHANGEZ CA POUR AVOIR UN CALCUL DE LA PLU HAUTE VALEUR
    init{
        this.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        this.extendedState = JFrame.MAXIMIZED_BOTH
        this.isVisible = true
        this.isResizable = false
        this.layout = card
        this.setLocationRelativeTo(null)
        panelCardLayout.add(panelMetro,"PanelMetro")
        this.card.show(panelCardLayout,"PanelMetro")
        panelLayout.add(panelCardLayout,BorderLayout.CENTER)
        this.add(panelLayout)
        this.pack()
        this.validate()
        this.repaint()
    }

    /**
     * Pour verifier si un panel a déja été creer et est donc dans le memoire pour eviter les doublons
     */
    fun isInMemory(nom:String):Boolean {
        queuePanel.forEach{pair -> if(pair.first == nom){ return true}}
        return false
    }
    /**
     * Ajoute le panel a la queue en memoire et le show
     */
    fun ajoutPanel(panel:JPanel,nom:String){
        if(queuePanel.size>=maxQueueSize){
            removeOnePanel()
        }
        queuePanel.add(Pair(nom,panel))
        add(panel,nom)
        card.show(panelCardLayout,nom)
    }
    fun showPanel(nom:String){
        var pairPanel:Pair<String,JPanel>? = null
        queuePanel.forEach{
            pair -> if(pair.first == nom){
                pairPanel = pair
            }
        }
        if(pairPanel!=null){
            queuePanel.remove(pairPanel)
            queuePanel.add(pairPanel)
            card.show(panelCardLayout,pairPanel!!.first)
        }

    }
    private fun removeOnePanel(){
        val panel = queuePanel.remove().second
        remove(panel)
    }
    fun clearAll(){
        while(queuePanel.isNotEmpty()){
            removeOnePanel()
        }
    }
}