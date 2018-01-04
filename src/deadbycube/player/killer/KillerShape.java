package deadbycube.player.killer;

import deadbycube.DeadByCube;
import deadbycube.audio.WorldAudioManager;
import deadbycube.audio.SoundRegistry;
import deadbycube.player.killer.power.PowerRegistry;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;

public class KillerShape extends Killer {

    private byte breathTick = 0;

    public KillerShape(DeadByCube plugin, Player player) {
        super(plugin, player, "shape", PowerRegistry.EVIL_WITHIN_1);
    }

    @Override
    void update() {
        if (++breathTick == 65) {
            breathTick = 0;
            WorldAudioManager audioManager = plugin.getAudioManager();
            audioManager.playSound(SoundRegistry.KILLER_SHAPE_BREATH, SoundCategory.VOICE, player.getLocation(), .05f, 1);
        }
    }

}
