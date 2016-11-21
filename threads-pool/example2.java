private static final ExecutorService executor;

  static {
    executor = Executors.newFixedThreadPool(4);
  }

  public static void startWork() {
    Runnable task = new Runnable() {
      @Override
      public void run() {
        work();
      }
    };
    executor.execute(task);

  }