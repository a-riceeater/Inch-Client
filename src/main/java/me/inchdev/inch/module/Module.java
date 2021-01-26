package me.inchdev.inch.module;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import scala.Console;

public class Module {
    private final String name, description;
    private final Category category;
    private int key;

    private boolean toggled;

    public Module(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.key = 0;
        this.category = category;
        this.toggled = false;
    }

    // Getters
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getKey() { return key; }
    public Category getCategory() { return category; }
    public boolean isToggled() { return toggled; }

    // Setters
    public void setKey(int key) { this.key = key; }
    public void setToggled(boolean toggled) { this.toggled = toggled; }

    public void toggle() {
        toggled = !toggled;
        Console.println("toggling module");
        Minecraft.getMinecraft().player.sendChatMessage("toggling sprint");

        if(this.toggled)
            this.onEnable();
        else
            this.onDisable();
    }

    public void onEnable() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister(this);
    }
}
