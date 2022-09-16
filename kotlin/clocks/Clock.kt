package clocks

import gui.Draw
import gui.Gui
import player.RealPlayer

class Clock : Thread() {

    override fun run() {
        super.run()

        while(!RealPlayer.crashed) {
            // Movement
            for (element in Draw.opponent) {
                if(element.richtungRechts) {
                    element.x += element.bewegungsSchritt
                } else {
                    element.x -= element.bewegungsSchritt
                }
            }

            //Collision
            for (element in Draw.opponent) {

                //Prüfen ob Gegner an Fensterrand anstoßen
                //wenn ja, Richtung ändern
                if(element.richtungRechts && element.x >= Gui.WIDTH - 25) {
                    element.richtungRechts = false
                } else if (!element.richtungRechts && element.x <= 0) {
                    element.richtungRechts = true
                }

                if(element in Draw.opponent) {
                    if(element.x  + 25 >= RealPlayer.x + 5 && element.x <= RealPlayer.x + 20 && element.y  + 24 >= RealPlayer.y + 5 && element.y <= RealPlayer.y + 30) {
                        RealPlayer.crashed = true
                    }
                }

            }

            sleep(10)

        }
    }
}