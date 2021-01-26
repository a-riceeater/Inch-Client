package me.inchdev.inch.ui;

import me.inchdev.inch.InchMod;
import me.inchdev.inch.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;

public class Hud extends Gui {
    private final Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void renderOverlay(RenderGameOverlayEvent event) {
        ScaledResolution sr = new ScaledResolution(mc);
        FontRenderer fr = mc.fontRenderer;

        if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            fr.drawStringWithShadow(InchMod.NAME + " v" + InchMod.VERSION, 2, 1, 0xffffff);

            int y = 2;
            final int[] counter = {1};

            for(Module mod : InchMod.moduleManager.getModules()) {
                if(!mod.getName().equalsIgnoreCase("") && mod.isToggled()) {
                    fr.drawStringWithShadow(mod.getName(), sr.getScaledWidth() - fr.getStringWidth(mod.getName())*2, y, rainbow(counter[0] * 300));
                    y += fr.FONT_HEIGHT;
                    counter[0]++;
                }
            }
        }
    }

    private static int rainbow(int delay) {
        double rainbowState = Math.ceil(System.currentTimeMillis() + delay) / 20.0 % 360;
        return Color.getHSBColor((float) rainbowState / 360.0f, 0.5f, 1f).getRGB();
    }
}
