package spielablauf

import gui.Draw
import player.Opponents

object Level {
    var level: Int = 0

    fun addOpponents(x: Int, y: Int, bewegungsSchritt: Int, richtungRechts: Boolean) {
        Draw.opponents.add(Opponents(x, y, bewegungsSchritt, richtungRechts))
    }

}