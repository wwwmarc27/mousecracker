package actions

import clocks.CollisionClock
import clocks.MovementClock
import gui.Gui
import player.RealPlayer

fun main(args: Array<String>) {
    RealPlayer()
    MovementClock().start()
    CollisionClock().start()
    Gui()
}