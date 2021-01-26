package me.inchdev.inch;

import me.inchdev.inch.module.Module;
import me.inchdev.inch.module.ModuleManager;
import me.inchdev.inch.proxy.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

@Mod(modid = InchMod.MODID, name = InchMod.NAME, version = InchMod.VERSION)
public class InchMod
{
    public static final String MODID = "inchmod";
    public static final String NAME = "Inch Client";
    public static final String VERSION = "1.0";

    public static final String CLIENT_PROXY_CLASS = "me.inchdev.inch.proxy.ClientProxy";
    public static final String COMMON_PROXY_CLASS = "me.inchdev.inch.proxy.CommonProxy";

    private static Logger logger;

    public ModuleManager moduleManager;

    @Mod.Instance
    public InchMod instance;

    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(instance);
        moduleManager = new ModuleManager();
    }

    @EventHandler
    public void PostInit (FMLPostInitializationEvent event) {

    }

    @SubscribeEvent
    public void key(InputEvent.KeyInputEvent e) {
        if(Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null) return;
        try {
            if(Keyboard.isCreated()) {
                if(Keyboard.getEventKeyState()) {
                    int keyCode = Keyboard.getEventKey();
                    if(keyCode <= 0)
                        return;
                    for(Module mod : moduleManager.modules) {
                        if(mod.getKey() == keyCode) {
                            mod.toggle();
                        }
                    }
                }
            }
        } catch (Exception q) {
            q.printStackTrace();
        }
    }
}
