package sounds

import java.io.File
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.Clip
import javax.sound.sampled.FloatControl

class Sound {
    var volume: Float = 0f

    fun playSound(sound: File) {
        val clip: Clip = AudioSystem.getClip()
        clip.open(AudioSystem.getAudioInputStream(sound))

        val gaincontrol: FloatControl = clip.getControl(FloatControl.Type.MASTER_GAIN) as FloatControl
        gaincontrol.value = volume

        clip.start()
    }
}