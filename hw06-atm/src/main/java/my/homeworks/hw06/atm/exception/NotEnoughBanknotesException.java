package my.homeworks.hw06.atm.exception;

public class NotEnoughBanknotesException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Количество банкнот недоступно";
    }
}
