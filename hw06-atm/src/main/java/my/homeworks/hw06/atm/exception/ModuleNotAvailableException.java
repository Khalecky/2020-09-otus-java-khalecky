package my.homeworks.hw06.atm.exception;

public class ModuleNotAvailableException extends RuntimeException {

    public ModuleNotAvailableException(String moduleName) {
        super("Модуль " + moduleName + " не работает");
    }
}
