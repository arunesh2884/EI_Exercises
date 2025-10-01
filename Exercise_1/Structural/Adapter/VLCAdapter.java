package Exercise_1.Structural.Adapter;

public class VLCAdapter implements MediaPlayer {
    private final VLCPlayer vlcPlayer;

    public VLCAdapter(VLCPlayer vlcPlayer) {
        this.vlcPlayer = vlcPlayer;
    }

    @Override
    public void play(String filename) {
        vlcPlayer.playVLC(filename);
    }
}