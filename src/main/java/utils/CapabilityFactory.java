package utils;

import org.openqa.selenium.Capabilities;

public class CapabilityFactory {

    private Capabilities capabilities;

    public Capabilities getCapabilities(String browser) {
        if (browser.equals("opera")) {
            capabilities = OptionsManager.getOperaOptions();
        } else {
            capabilities = OptionsManager.getChromeOptions();
        }
        return capabilities;
    }
}
