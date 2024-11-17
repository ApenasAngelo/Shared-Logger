import java.util.ArrayList;
import java.util.List;

public class LoggerSingleton {
    private static LoggerSingleton instance;
    private List<String> logs = new ArrayList<>();
    private List<LogObserver> observers = new ArrayList<>();

    private LoggerSingleton() {
        // Construtor privado para evitar instanciação direta
    }

    public static LoggerSingleton getInstance() {
        if (instance == null) {
            instance = new LoggerSingleton();
        }
        return instance;
    }

    public void addLog(String message) {
        logs.add(message);
        notifyObservers(message);
    }

    public List<String> getLogs() {
        return logs;
    }

    public void addObserver(LogObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(LogObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String message) {
        for (LogObserver observer : observers) {
            observer.update(message);
        }
    }
}