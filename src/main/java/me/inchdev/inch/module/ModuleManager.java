package me.inchdev.inch.module;

import me.inchdev.inch.module.modules.movement.Sprint;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    public ArrayList<Module> modules;

    public ModuleManager() {
        modules = new ArrayList<>();

        // init mods
        modules.add(new Sprint());
    }

    public ArrayList<Module> getModules() { return modules; }

    public Module getModule(String name) {
        for(Module m : this.modules)
            if(m.getName().equalsIgnoreCase(name))
                return m;

        return null;
    }

    public List<Module> getModulesByCategory(Category c) {
        List<Module> modules = new ArrayList<>();

        for(Module mod : getModules())
            if(mod.getCategory() == c)
                modules.add(mod);

        return modules;
    }
}
