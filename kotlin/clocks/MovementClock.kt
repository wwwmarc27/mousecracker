package clocks

import gui.Draw
import player.RealPlayer

class MovementClock : Thread() {

    override fun run() {
        super.run()

        while((!RealPlayer.crashed) && (!RealPlayer.finish)) {
            // Movement
            for (element in Draw.opponent) {
                if(element.richtungRechts) {
                    element.x += element.bewegungsSchritt
                } else {
                    element.x -= element.bewegungsSchritt
                }
            }

            sleep(10)

        }
    }
}