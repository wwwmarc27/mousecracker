package actions

import clocks.MovementClock
import gui.Gui
import player.RealPlayer

fun main(args: Array<String>) {
    RealPlayer()
    MovementClock().start()
    Gui()
}