package diamonds.reality;

import diamonds.reality.approutes.HomeRoute;
import org.dfhu.sparkingrocks.config.PropertiesConfig;
import org.dfhu.sparkingrocks.model.DataProvider;
import org.dfhu.sparkingrocks.routing.Route;
import org.mongodb.morphia.Datastore;

import java.util.Arrays;

public class Application {

  public static void init(PropertiesConfig config) {
    Datastore datastore = DataProvider
      .create(Arrays.asList("diamonds.reality.morphs"), config);

    addRoute(new HomeRoute(config));
  }

  private static void addRoute(Route route) {
    route.addRoute();
  }
}
