package gui


import player.Destination
import player.Opponents
import javax.swing.JLabel
import player.RealPlayer
import java.awt.*

class Draw : JLabel() {

    companion object {
        var opponent: Array<Opponents> = arrayOf(
            Opponents(0, 225, 1, true),
            Opponents(Gui.WIDTH - 25, 180, 3, false),
            Opponents(0, 135, 2, true)
        )
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)

        val g2d: Graphics2D = g as Graphics2D
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)

        //draw Background
        g2d.color = Color.BLACK
        g2d.fillRect(0, 0, Gui.WIDTH, Gui.HEIGHT)

        //setting Font
        g2d.font = FontLoader.font.deriveFont(80f)

        //draw Destination (Ziel)
        g2d.color = Destination.color
        g2d.fillOval(Destination.x, Destination.y, 25, 25)

        //draw Opponents (Gegner)
        g2d.drawImage(opponent[0].opponentsImage, opponent[0].x, opponent[0].y, null)
        g2d.drawImage(opponent[1].opponentsImage, opponent[1].x, opponent[1].y, null)
        g2d.drawImage(opponent[2].opponentsImage, opponent[2].x, opponent[2].y, null)

        //draw Rectangle (Spieler)
        g2d.drawImage(RealPlayer.spielerImage, RealPlayer.x, RealPlayer.y, null)

        //draw breakmenu, if crashed or finished
        if(RealPlayer.crashed || RealPlayer.finish) {
            g2d.color = Color(240, 240, 240, 150)
            g2d.fillRect(0, 0, Gui.WIDTH, Gui.HEIGHT)

            //draw lost
            g2d.color = Color(255, 0 , 0)
            g2d.drawString("Verloren", ((Gui.WIDTH / 2) - 120), 80)
        }

        repaint()
    }
}