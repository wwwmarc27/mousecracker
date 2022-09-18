package sounds

import java.io.File

class MusicLoader {

    companion object {
        lateinit var soundCollision: File
        lateinit var soundLevelup: File
    }

    init {
        soundCollision = File("src/main/resources/collision.wav")
        soundLevelup = File("src/main/resources/levelup.wav")
    }
}