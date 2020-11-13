package my.homeworks.hw06.atm.exception;

public class AmountNotAvailableException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Сумму выдать невозможно.";
    }
}
