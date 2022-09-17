package actions

import clocks.CollisionClock
import clocks.MovementClock
import gui.FontLoader
import gui.Gui
import player.RealPlayer

fun main(args: Array<String>) {
    RealPlayer()
    FontLoader()
    MovementClock().start()
    CollisionClock().start()
    Gui()
}