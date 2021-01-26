package me.inchdev.inch.module;

public enum Category {
    COMBAT("Combat"), RENDER("Render"), MOVEMENT("Movement"), PLAYER("Player"), EXPLOITS("Exploits"), CLIENT("Client");

    public String name;
    public int moduleIndex;
    Category(String name) {
        this.name = name;
    }
}
