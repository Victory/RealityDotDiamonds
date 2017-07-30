package diamonds.reality.approutes;

import com.fizzed.rocker.RockerModel;
import diamonds.reality.RouteManager;
import diamonds.reality.viewmodels.home.HomeViewModel;
import diamonds.reality.views.home.Home;
import org.dfhu.sparkingrocks.config.PropertiesConfig;
import org.dfhu.sparkingrocks.routing.Route;
import org.dfhu.sparkingrocks.routing.TemplateRoute;
import org.dfhu.sparkingrocks.session.VicSession;
import spark.Request;
import spark.Response;

public class HomeRoute extends TemplateRoute implements Route {

  public HomeRoute(PropertiesConfig config) {
    super(config);
  }

  @Override
  public String getPath() {
    return RouteManager.home();
  }

  @Override
  public METHOD getMethod() {
    return METHOD.GET;
  }

  @Override
  public RockerModel getRockerModel(Request request, Response response, VicSession vicSession) {
    HomeViewModel homeViewModel = new HomeViewModel(vicSession);
    return Home.template(homeViewModel);
  }
}
