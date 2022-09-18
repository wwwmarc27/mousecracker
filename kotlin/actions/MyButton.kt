package actions

import java.awt.Color

class MyButton(x: Int, y: Int, width: Int, height: Int, text: String, color: Color) {
    val x: Int = x
    val y: Int = y
    val width: Int = width
    val height: Int = height
    val text: String = text
    val basicColor: Color = color
    var hover: Boolean = false
}