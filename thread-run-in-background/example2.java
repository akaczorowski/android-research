import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class Util {

  private static final ExecutorService executor = Executors.newFixedThreadPool(2);

  private Util() {
  }

  public static void runInBackground(Runnable r) {
    executor.execute(r);
  }
}