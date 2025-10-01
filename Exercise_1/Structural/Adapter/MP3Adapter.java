package Exercise_1.Structural.Adapter;

public class MP3Adapter implements MediaPlayer {
    private final MP3Player mp3Player;

    public MP3Adapter(MP3Player mp3Player) {
        this.mp3Player = mp3Player;
    }

    @Override
    public void play(String filename) {
        mp3Player.playMP3(filename);
    }
}