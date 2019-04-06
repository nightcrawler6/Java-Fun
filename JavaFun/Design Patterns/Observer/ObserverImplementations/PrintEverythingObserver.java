package Observer.ObserverImplementations;

import Observer.Interfaces.AbstractObserver;
import Observer.Interfaces.IObservable;

public class PrintEverythingObserver extends AbstractObserver {

	public PrintEverythingObserver(IObservable observable) {
		super(observable);
	}
	
	@Override
	public void update() {
		System.out.println(super.getObservable());
	}

}
