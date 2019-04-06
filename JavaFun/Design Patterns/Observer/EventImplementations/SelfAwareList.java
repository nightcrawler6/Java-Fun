package Observer.EventImplementations;

import java.util.ArrayList;
import java.util.List;

import Observer.Interfaces.AbstractObservable;
import Observer.Interfaces.IObserver;

public class SelfAwareList extends AbstractObservable {

	private List<String> mItems;
	
	public SelfAwareList() {
		super();
		mItems = new ArrayList<String>();
	}
	
	public void addItem(String item) {
		mItems.add(item);
		notifyObservers();
	}
	
	@Override
	public String toString() {
		return mItems.toString();
	}
	
}
