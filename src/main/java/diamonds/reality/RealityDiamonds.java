package diamonds.reality;

import com.fizzed.rocker.runtime.RockerRuntime;
import org.dfhu.sparkingrocks.config.PropertiesConfig;
import org.dfhu.sparkingrocks.config.ReadSystemProperties;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

import static spark.Spark.staticFiles;

public class RealityDiamonds {
  public static void main(String[] args) throws IOException {

    ClassLoader classLoader = RealityDiamonds.class.getClassLoader();
// or use:
// ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
// depending on what's appropriate in your case.
    Enumeration<URL> roots = classLoader.getResources(".");
    while (roots.hasMoreElements()) {
      final URL url = roots.nextElement();
      System.out.println(url);
    }

    PropertiesConfig config = ReadSystemProperties.read();

    setupDevelopmentEnvironment(config.isDevelopment());
    Application.init(config);
  }

  private static void setupDevelopmentEnvironment(boolean isDev) {
    if (isDev) {
      // DEBUGING
      RockerRuntime.getInstance().setReloading(true);
      String publicDir = System.getProperty("user.dir") + "/src/main/resources/public";
      staticFiles.externalLocation(publicDir);

      Logger logger = Logger.getLogger("class org.mongodb.morphia.DatastoreImpl");
      logger.setLevel(Level.FINER);
    } else {
      // PRODUCTION
      staticFiles.location("/public");
      RockerRuntime.getInstance().setReloading(false);
    }
  }
}
