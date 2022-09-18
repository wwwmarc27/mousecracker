package input

import clocks.CollisionClock
import clocks.MovementClock
import gui.Draw
import gui.Gui
import player.RealPlayer
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.awt.event.MouseMotionListener

class MouseHandler : MouseListener, MouseMotionListener {

    override fun mouseDragged(e: MouseEvent) {
        //dragged playerImage
        if(((e.x >= RealPlayer.x - 10 && e.x <= RealPlayer.x + 40) && (e.y >= RealPlayer.y + 20 && e.y <= RealPlayer.y + 70)) && ((!RealPlayer.crashed) && (!RealPlayer.finish))) {
            RealPlayer.x = e.x - 12
            RealPlayer.y = e.y - 40
        }
    }

    override fun mouseClicked(e: MouseEvent) {
        //Hitbox button New Game
        if((e.x >= Draw.buttonNewGame.x && e.x <= Draw.buttonNewGame.x + 150 && e.y >= Draw.buttonNewGame.y + 20 && e.y <= (Draw.buttonNewGame.y + 45)) && (RealPlayer.crashed)) {
            RealPlayer.crashed = false
            RealPlayer.x = Gui.WIDTH / 2 - 12
            RealPlayer.y = Gui.HEIGHT - 60
            MovementClock().start()
            CollisionClock().start()
        }
    }

    override fun mousePressed(e: MouseEvent) {}

    override fun mouseReleased(e: MouseEvent) {}

    override fun mouseEntered(e: MouseEvent) {}

    override fun mouseExited(e: MouseEvent) {}

    override fun mouseMoved(e: MouseEvent) {}

}