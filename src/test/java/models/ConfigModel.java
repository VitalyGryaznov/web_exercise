package models;

import lombok.Data;

@Data
public class ConfigModel {
    private Boolean RUN_LOCALLY;
    private String BROWSER_NAME;
    private String BROWSER_VERSION;
    private String CHROMEDRIVER_PATH;
}
