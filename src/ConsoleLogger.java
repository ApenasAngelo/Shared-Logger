public class ConsoleLogger implements LogObserver {
    @Override
    public void update(String message) {
        System.out.println("ConsoleLogger: " + message);
    }
}
