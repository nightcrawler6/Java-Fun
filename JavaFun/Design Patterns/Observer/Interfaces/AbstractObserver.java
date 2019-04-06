package Observer.Interfaces;

public abstract class AbstractObserver implements IObserver{
	
	private IObservable mObservable;
	
	public AbstractObserver(IObservable observable) {
		mObservable = observable;
		observable.attach(this);
	}

	public IObservable getObservable() {
		return mObservable;
	}
	
}
