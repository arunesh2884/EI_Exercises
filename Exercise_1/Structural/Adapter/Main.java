package Exercise_1.Structural.Adapter;

public class Main {
    public static void main(String[] args) {
        MediaPlayer mp3 = new MP3Adapter(new MP3Player());
        mp3.play("song.mp3");

        MediaPlayer vlc = new VLCAdapter(new VLCPlayer());
        vlc.play("video.vlc");
    }
}