package Observer.EventImplementations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import Observer.Interfaces.AbstractObservable;

public class FileWatcher extends AbstractObservable {

	private Path mPath;
	private String mPatternToWatch;
	private String mLocal;
	private Integer mInterval = 10;
	
	public FileWatcher(String pathToFile, String patternToWatch) {
		super();
		mPath = Paths.get(pathToFile);
		mPatternToWatch = patternToWatch;
	}
	
	public FileWatcher(String pathToFile, String patternToWatch, Integer interval) {
		super();
		mPath = Paths.get(pathToFile);
		mPatternToWatch = patternToWatch;
		mInterval = interval;
	}
	
	public FileWatcher(Path pathToFile, String patternToWatch) {
		mPath = pathToFile;
		mPatternToWatch = patternToWatch;
	}
	
	public FileWatcher(Path pathToFile, String patternToWatch, Integer interval) {
		mPath = pathToFile;
		mPatternToWatch = patternToWatch;
		mInterval = interval;
	}
	
	public void InitializeWatching() throws IOException {
		System.out.println(String.format("Searching for %s in: %s -> lookup interval: %d seconds", mPatternToWatch, mPath, mInterval));
		while(true) {
			File folder = new File(mPath.toString());
			File[] listFiles = folder.listFiles();
			for(File file: listFiles) {
				String fileName = file.getName();
				if(fileName.contains(mPatternToWatch)) {
					mLocal = fileName;
					System.out.print("Rule violation! - going to remove: ");
					super.notifyObservers();
					file.delete();
				}
			}
			try {
				Thread.sleep(mInterval*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public String toString() {
		return mLocal;
	}
}
