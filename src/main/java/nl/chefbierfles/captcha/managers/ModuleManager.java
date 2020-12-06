package nl.chefbierfles.captcha.managers;

import nl.chefbierfles.captcha.interfaces.IModuleManager;
import nl.chefbierfles.captcha.modules.CaptchaModule;
import nl.chefbierfles.captcha.modules.DatabaseModule;
import nl.chefbierfles.captcha.modules.base.BaseModule;

import java.util.*;

public final class ModuleManager implements IModuleManager {

    protected Collection<BaseModule> modules = new ArrayList<>();

    public ModuleManager() {}

    public void registerModule(BaseModule baseModule) {
        modules.add(baseModule);
    }

    public BaseModule[] getModules() {
        return this.modules.toArray(new BaseModule[this.modules.size()]);
    }

    public BaseModule getModule(String moduleName) {
        return modules.stream().filter(module -> module.getName() == moduleName).findFirst().get();
    }

    public CaptchaModule getCaptchaModule() {
        return (CaptchaModule) modules.stream().filter(module -> module.getName() == "ICaptchaModule").findFirst().get();
    }

    public DatabaseModule getDatabaseModule() {
        return (DatabaseModule) modules.stream().filter(module -> module.getName() == "IDatabaseModule").findFirst().get();
    }

}