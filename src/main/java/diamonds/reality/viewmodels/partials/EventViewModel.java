package diamonds.reality.viewmodels.partials;

import org.dfhu.sparkingrocks.session.VicSession;
import org.dfhu.sparkingrocks.viewmodels.AbstractViewModel;

public class EventViewModel extends AbstractViewModel {
  private final String title;

  public EventViewModel(String title) {
    super(null);
    this.title = title;
  }

  public EventViewModel(VicSession vicSession, String title) {
    super(vicSession);
    this.title = title;
  }

  public String getTitle() {
    return title;
  }
}
