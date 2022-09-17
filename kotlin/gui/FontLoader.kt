package gui

import java.awt.Font
import java.io.File

class FontLoader()  {

    companion object {
        lateinit var font: Font
    }

    init {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, File("src/main/resources/aureola.regular.ttf"))
        } catch (e: Exception) {
            println(e.stackTrace)
        }
    }
}