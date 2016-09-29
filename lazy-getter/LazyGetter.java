import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public abstract class LazyGetter<T>{

  private final AtomicReference<Optional<T>> mCachedValue =
      new AtomicReference<>(Optional.<T>empty());

  public final T get(){
    Optional<T> value = mCachedValue.get();
    if(!value.isPresent()){
      synchronized (mCachedValue){
        value = mCachedValue.get();
        if(!value.isPresent()){
          mCachedValue.set(Optional.ofNullable(initialValue()));
        }
      }
    }
    return mCachedValue.get().get();
  }

  protected abstract T initialValue();
}