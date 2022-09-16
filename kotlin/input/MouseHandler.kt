package input

import player.RealPlayer
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.awt.event.MouseMotionListener

class MouseHandler : MouseListener, MouseMotionListener {

    override fun mouseDragged(e: MouseEvent) {
        if((e.x >= RealPlayer.x - 10 && e.x <= RealPlayer.x + 40) && (e.y >= RealPlayer.y + 20 && e.y <= RealPlayer.y + 70)) {
            RealPlayer.x = e.x - 12
            RealPlayer.y = e.y - 40
        }
    }

    override fun mouseClicked(e: MouseEvent) {}

    override fun mousePressed(e: MouseEvent) {}

    override fun mouseReleased(e: MouseEvent) {}

    override fun mouseEntered(e: MouseEvent) {}

    override fun mouseExited(e: MouseEvent) {}

    override fun mouseMoved(e: MouseEvent) {}

}