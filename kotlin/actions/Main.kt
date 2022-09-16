package actions

import clocks.Clock
import gui.Gui
import player.RealPlayer

fun main(args: Array<String>) {
    RealPlayer()
    Clock().start()
    Gui()
}