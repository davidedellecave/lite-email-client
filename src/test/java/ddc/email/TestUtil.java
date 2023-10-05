package ddc.email;

import ddc.email.LiteMailConfig;
import ddc.support.jack.JsonConf;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestUtil {
    public static LiteMailConfig loadSecret(String prefix) {
        Path path = Paths.get("/Users/davide/gir2/lite-email-client/" + prefix+ "-secret-params.json");
        try {
            return JsonConf.loadConfiguration(path, LiteMailConfig.class);
        } catch (Exception e) {
            try {
                JsonConf.storeConfiguration(path, new LiteMailConfig());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        return null;
    }
}
