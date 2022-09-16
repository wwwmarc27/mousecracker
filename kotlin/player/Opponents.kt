//Destination (Ziel)

package player

import java.awt.image.BufferedImage
import java.io.File
import java.lang.Exception
import javax.imageio.ImageIO

class Opponents(x: Int, y: Int, bewegungsSchritt: Int, richtungRechts: Boolean) {
    var x: Int = x
    var y: Int = y
    val bewegungsSchritt: Int = bewegungsSchritt
    var richtungRechts: Boolean = richtungRechts
    lateinit var opponentsImage: BufferedImage

    init {
        try {
            opponentsImage = ImageIO.read(File("src/main/resources/opponent.png"))
        } catch (e: Exception) {
            println(e.stackTrace)
        }
    }
}