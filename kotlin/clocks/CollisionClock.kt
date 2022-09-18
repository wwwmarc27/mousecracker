package clocks

import gui.Draw
import gui.Gui
import player.Destination
import player.RealPlayer
import sounds.MusicLoader
import sounds.Sound
import java.io.File

class CollisionClock : Thread() {

    override fun run() {
        super.run()

        while(!RealPlayer.finish && !RealPlayer.crashed) {
            //Collision
            for (element in Draw.opponents) {

                //Prüfen ob Gegner an Fensterrand anstoßen
                //wenn ja, Richtung ändern
                if(element.richtungRechts && element.x >= Gui.WIDTH - 25) {
                    element.richtungRechts = false
                } else if (!element.richtungRechts && element.x <= 0) {
                    element.richtungRechts = true
                }

                //Gegnerkollision
                if(element in Draw.opponents) {
                    if(element.x  + 25 >= RealPlayer.x + 5 && element.x <= RealPlayer.x + 20 && element.y  + 24 >= RealPlayer.y + 5 && element.y <= RealPlayer.y + 30) {
                        RealPlayer.crashed = true
                        Sound.playSound(MusicLoader.soundCollision)
                    }
                }
            }

            //Spielerziel -> nächstes Level
            if(RealPlayer.x + 10 >= Destination.x && RealPlayer.x <= Destination.x + 10 && RealPlayer.y + 15 >= Destination.y && RealPlayer.y <= Destination.y) {
                RealPlayer.finish = true
                Sound.playSound(MusicLoader.soundLevelup)
            }
            sleep(5)
        }
    }
}