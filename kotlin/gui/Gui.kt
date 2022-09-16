package gui

import javax.swing.JFrame
import input.MouseHandler
import input.KeyHandler

class Gui  {
    val frame: JFrame = JFrame("MouseCracker")
    val draw: Draw = Draw()

    companion object {
        const val WIDTH = 400
        const val HEIGHT = 400
    }

    init {
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.setBounds(0, 0, WIDTH, HEIGHT)
        frame.setLocationRelativeTo(null)
        frame.isResizable = false
        frame.isFocusable = true
        frame.layout = null

        draw.setBounds(0, 0, WIDTH, HEIGHT)
        frame.add(draw)


        frame.addMouseListener(MouseHandler())
        frame.addMouseMotionListener(MouseHandler())
        frame.addKeyListener(KeyHandler())
        frame.isVisible = true
    }
}