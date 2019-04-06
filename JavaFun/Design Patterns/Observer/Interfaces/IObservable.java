package Observer.Interfaces;

public interface IObservable {
	
	public void attach(IObserver observer);
	public void notifyObservers();
	
}
