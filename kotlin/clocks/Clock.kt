package clocks

import gui.Draw
import gui.Gui

class Clock : Thread() {

    override fun run() {
        super.run()

        while(true) {
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
                if(element.richtungRechts && element.x >= Gui.WIDTH - 25) {
                    element.richtungRechts = false
                } else if (!element.richtungRechts && element.x <= 0) {
                    element.richtungRechts = true
                }
            }

            sleep(10)

        }
    }
}