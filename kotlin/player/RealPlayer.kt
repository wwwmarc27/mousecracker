//player (Spieler)

package player

import gui.Gui
import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import java.lang.Exception
import javax.imageio.ImageIO

class RealPlayer {

    companion object {
        var color: Color = Color.LIGHT_GRAY
        var x: Int = Gui.WIDTH / 2 - 12
        var y: Int = Gui.HEIGHT - 60
        lateinit var spielerImage: BufferedImage
        var crashed: Boolean = false
        var finish: Boolean = false
    }

    init {
        try {
            spielerImage = ImageIO.read(File("src/main/resources/earth.png"))
        } catch (e: Exception) {
            println(e.stackTrace)
        }
    }
}