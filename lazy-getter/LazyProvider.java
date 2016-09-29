public class LazyProvider extends ContentProvider {

  private static final int MODEL = 101;
  private static final int MODEL_ID = 102;

  private static final LazyGetter<UriMatcher> URI_MATCHER = new LazyGetter<UriMatcher>() {
    @Override
    protected UriMatcher initialValue() {
      final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
      uriMatcher.addURI(...);

      return uriMatcher;
    }
  };

  // ...
}