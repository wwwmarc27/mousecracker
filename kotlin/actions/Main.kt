package actions

import clocks.CollisionClock
import clocks.MovementClock
import gui.FontLoader
import gui.Gui
import player.RealPlayer
import sounds.MusicLoader

fun main(args: Array<String>) {
    RealPlayer()
    FontLoader()
    MusicLoader()
    MovementClock().start()
    CollisionClock().start()
    Gui()
}