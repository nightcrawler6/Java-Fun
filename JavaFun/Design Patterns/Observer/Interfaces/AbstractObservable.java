package Observer.Interfaces;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractObservable implements IObservable {
	private List<IObserver> mObservers;
	
	public AbstractObservable() {
		mObservers = new ArrayList<>();
	}

	public void attach(IObserver observer) {
		mObservers.add(observer);
	}
	
	public void notifyObservers() {
		for(IObserver observer: mObservers) {
			observer.update();
		}
	}
	
	public List<IObserver> getObservers() {
		return mObservers;
	}
}
