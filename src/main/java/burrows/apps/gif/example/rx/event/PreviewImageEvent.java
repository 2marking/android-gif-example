package burrows.apps.gif.example.rx.event;

/**
 * Eventbus event for sending ImageInfo.
 *
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 */
public final class PreviewImageEvent {
  private final String url;

  public PreviewImageEvent(final String url) {
    this.url = url;
  }

  /**
   * Get the url from the event.
   *
   * @return Url from the event.
   */
  public String getUrl() {
    return url;
  }
}
