package nl.chefbierfles.captcha.managers;

import nl.chefbierfles.captcha.Plugin;
import nl.chefbierfles.captcha.module.CaptchaModule;
import nl.chefbierfles.captcha.module.DatabaseModule;
import nl.chefbierfles.captcha.module.base.BaseModule;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class ModuleManager {

    protected Collection<BaseModule> modules = new ArrayList<>();

    private CaptchaModule captchaModule;
    private DatabaseModule databaseModule;

    public ModuleManager() {
        captchaModule = JavaPlugin.getPlugin(Plugin.class).moduleManager.captchaModule;
        databaseModule = JavaPlugin.getPlugin(Plugin.class).moduleManager.databaseModule;
    }

    public void registerModule(BaseModule baseModule) {
        modules.add(baseModule);
    }

    public CaptchaModule getCaptchaModule() {
        return (CaptchaModule) modules.stream().filter(module -> module.getName() == CaptchaModule.class.getName()).findFirst().get();
    }

    public DatabaseModule getDatabaseModule() {
        return (DatabaseModule) modules.stream().filter(module -> module.getName() == DatabaseModule.class.getName()).findFirst().get();
    }

}