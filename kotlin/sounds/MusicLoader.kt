package sounds

import java.io.File

class MusicLoader {
    lateinit var sound: File

    fun loadSound(sound: File) {
        try {
            this.sound = sound
        } catch (e: Exception) {
            println(e.stackTrace)
        }
    }
}