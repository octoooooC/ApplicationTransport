package view

import model.Graph
import java.awt.CardLayout
import java.io.File
import java.util.*
import javax.swing.JFrame
import javax.swing.*

class FrameApp (fileStop:File ,fileArrets:File ):JFrame() {
    private val graph : Graph = Graph(fileStop, fileArrets)
    private val card : CardLayout = CardLayout()
    private val queuePanel : Queue<Pair<String,JPanel>> = LinkedList<Pair<String,JPanel>>()
    private val panelMetro : PanelMetro = PanelMetro(this,14,graph)
    //TODO CHANGEZ CA POUR AVOIR UN CALCUL DE LA PLU HAUTE VALEUR
    init{
        this.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        this.extendedState = JFrame.MAXIMIZED_BOTH
        this.isVisible = true
        this.isResizable = false
        this.setLocationRelativeTo(null)
        this.pack()
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
        queuePanel.add(Pair(nom,panel))
        card.show(panel,nom)
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
            card.show(pairPanel!!.second,pairPanel!!.first)
        }

    }
}