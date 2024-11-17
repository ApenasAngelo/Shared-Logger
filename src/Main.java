public class Main {
    public static void main(String[] args) {
        LoggerSingleton logger = LoggerSingleton.getInstance();

        ConsoleLogger consoleLogger = new ConsoleLogger();
        FileLogger fileLogger = new FileLogger("logs.txt");

        logger.addObserver(consoleLogger);
        logger.addObserver(fileLogger);

        logger.addLog("Iniciando a aplicação...");
        logger.addLog("Erro: conexão perdida.");
        logger.addLog("Reiniciando sistema...");

        System.out.println("Todos os logs:");
        for (String log : logger.getLogs()) {
            System.out.println(log);
        }
    }
}
