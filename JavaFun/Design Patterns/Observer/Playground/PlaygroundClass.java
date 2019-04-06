package Observer.Playground;

import java.io.IOException;

import Observer.EventImplementations.FileWatcher;
import Observer.EventImplementations.SelfAwareList;
import Observer.ObserverImplementations.PrintEverythingObserver;

public class PlaygroundClass {
	public static void main(String[] args) {
		String path = args[0];
		String pattern = args[1];
		FileWatcher myList;
		if(args.length == 3) {
			myList = new FileWatcher(path, pattern, Integer.parseInt(args[2]));
		} else {
			myList = new FileWatcher(path, pattern);
		}
		PrintEverythingObserver Pobserver = new PrintEverythingObserver(myList);
		try {
			myList.InitializeWatching();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
