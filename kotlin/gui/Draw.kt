package gui


import actions.MyButton
import player.Destination
import player.Opponents
import javax.swing.JLabel
import player.RealPlayer
import java.awt.*

class Draw : JLabel() {

    companion object {
        val opponents: MutableList<Opponents> = mutableListOf()
        val buttonNewGame: MyButton = MyButton(Gui.WIDTH / 2 - 75, 130, 150, 25, "Neues Spiel", Color.LIGHT_GRAY)
    }

    init {
        opponents.add(Opponents(0, 255, 1, true))
        opponents.add(Opponents(Gui.WIDTH - 25, 180, 3, false))
        opponents.add(Opponents(0, 135, 2, true))
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)

        val g2d: Graphics2D = g as Graphics2D
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)

        //setting Font
        g2d.font = FontLoader.font.deriveFont(80f)

        //draw Background
        g2d.color = Color.BLACK
        g2d.fillRect(0, 0, Gui.WIDTH, Gui.HEIGHT)

        //draw Destination (Ziel)
        g2d.color = Destination.color
        g2d.fillOval(Destination.x, Destination.y, 25, 25)

        //draw Opponents (Gegner)
        for (element in opponents) {
            g2d.drawImage(element.opponentsImage, element.x, element.y, null)
        }

        //draw RealPlayer (Spieler)
        g2d.drawImage(RealPlayer.spielerImage, RealPlayer.x, RealPlayer.y, null)

        //draw breakmenu, if crashed
        if(RealPlayer.crashed) {
            // draw Foreground
            g2d.color = Color(240, 240, 240, 150)
            g2d.fillRect(0, 0, Gui.WIDTH, Gui.HEIGHT)

            //draw String: Verlorem
            g2d.color = Color(255, 0 , 0)
            g2d.drawString("Verloren", ((Gui.WIDTH / 2) - 110), 80)

            //Stringwidth in pixel
            g2d.font = FontLoader.font.deriveFont(15f)
            val fontmetrics: FontMetrics = g2d.fontMetrics
            val stringwidth: Int = fontmetrics.stringWidth(buttonNewGame.text)

            //draw button new game
            g2d.color = buttonNewGame.basicColor
            g2d.fillRect(buttonNewGame.x, buttonNewGame.y, buttonNewGame.width, buttonNewGame.height)
            g2d.color = Color.BLACK
            g2d.drawString(buttonNewGame.text, (buttonNewGame.x + 75) - (stringwidth / 2), buttonNewGame.y + 17)
        }

        //draw breakmenu, if finished
        if(RealPlayer.finish) {
            // draw Foreground
            g2d.color = Color(240, 240, 240, 150)
            g2d.fillRect(0, 0, Gui.WIDTH, Gui.HEIGHT)

            //draw String: Gewonnen
            g2d.color = Color(0, 255 , 0)
            g2d.drawString("Gewonnen", ((Gui.WIDTH / 2) - 135), 80)
        }

        repaint()
    }
}