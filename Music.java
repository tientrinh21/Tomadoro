import java.io.IOException;
import javax.sound.sampled.*;

public class Music {
	Clip clip;
	BooleanControl volume;
	
	public Music(String filename) throws UnsupportedAudioFileException, IOException, LineUnavailableException  {
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(Main.class.getResource(filename));
		
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		clip.start();
		
		volume = (BooleanControl)clip.getControl(BooleanControl.Type.MUTE);
	}
	
	void mute() {
		volume.setValue(true);
	}
	
	void unmute() {
		volume.setValue(false);	
	}
	
	void stop() {
		clip.stop();
	}
}
