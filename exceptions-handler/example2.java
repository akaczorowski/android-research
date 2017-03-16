public class Example extends Activity implements java.lang.Thread.UncaughtExceptionHandler{
  
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));

        setContentView(R.layout.main);
    }

    public void uncaughtException(Thread thread, Throwable exception) {

		StringWriter stackTrace = new StringWriter();
        exception.printStackTrace(new PrintWriter(stackTrace));
        StringBuilder errorReport = new StringBuilder();
        errorReport.append("************ CAUSE OF ERROR ************\n\n");
        errorReport.append(stackTrace.toString());


      	//android.os.Process.killProcess(android.os.Process.myPid());
    	//System.exit(10);
    }
}