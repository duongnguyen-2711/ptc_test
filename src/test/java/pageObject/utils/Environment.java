package pageObject.utils;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

public class Environment {

    public static EnvironmentSpecificConfiguration getEnvironmentConfigs(){
        EnvironmentVariables environmentVariables = Injectors.getInjector()
                .getInstance(EnvironmentVariables.class);
        return EnvironmentSpecificConfiguration.from(environmentVariables);
    }
}
