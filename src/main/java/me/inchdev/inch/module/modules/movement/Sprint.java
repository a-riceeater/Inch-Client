package me.inchdev.inch.module.modules.movement;

import me.inchdev.inch.module.Category;
import me.inchdev.inch.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class Sprint extends Module {

    public Sprint() {
        super("Sprint", "Automatically sprints when you move", Category.MOVEMENT);
        setKey(Keyboard.KEY_Q);
    }

    @SubscribeEvent
    public void onPlayerUpdate(PlayerEvent e) {
        Minecraft mc = Minecraft.getMinecraft();
        if(mc.player.movementInput.forwardKeyDown) {
            mc.player.setSprinting(true);
        }
    }
}
