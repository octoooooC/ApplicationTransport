package model

class StationAutomate(private val arretNames:Set<String>){
    private var start : Automate = Automate(true)
    init{
    createStationAutomate(arretNames)
    }

    private fun createStationAutomate(arretNames:Set<String>){
        arretNames.forEach{str -> createAutomate(start,str,0)}
    }

    private fun createAutomate(auto: Automate, str:String, indStart:Int){
        val final = indStart==str.length-1
        val autoTransition = auto.getAutomateTransition(str[indStart])
        val char = str[indStart]
        if(autoTransition==null){
            val automate = Automate(final)
            auto.addTransition(char, automate)
            if(!final){
                createAutomate(automate, str, indStart+1)
            }
        }else{
            if(!final){
                createAutomate(autoTransition, str, indStart+1)
            }
        }

    }
    private fun isInGraph(str:String,ind:Int,auto: Automate):Boolean {
        val automateTransition = auto.getAutomateTransition(str[ind])
        val final = str.length-1==ind
        return if(automateTransition!=null){
            if(final){
                automateTransition.isFinal()
            }else {
                isInGraph(str,ind+1,automateTransition)
            }
        }else{
            false
        }

    }
    fun isStation(str:String):Boolean = if (str=="") false else isInGraph(str, 0,start)

}