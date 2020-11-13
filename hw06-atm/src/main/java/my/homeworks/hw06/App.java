package my.homeworks.hw06;

import my.homeworks.hw06.atm.Atm;
import my.homeworks.hw06.atm.AtmBuilder;
import my.homeworks.hw06.atm.BanknoteBatch;
import my.homeworks.hw06.atm.output.strategy.MinBanknotesCountOutputStrategy;

public class App {

    private final Atm atm;

    public static void main(String[] args) {
        int amount = 12450;
        int badAmount = 124500;
        new App()
                .getMoney(amount)
                .inputMoney()
                .getMoney(badAmount);
    }

    App() {
        atm = AtmBuilder.create()
                .loadBanknotes(500, 10)
                .loadBanknotes(1000, 10)
                .loadBanknotes(100, 10)
                .loadBanknotes(50, 10)
                .setBanknoteOutputStrategy(new MinBanknotesCountOutputStrategy())
                .build();
    }

    private App getMoney(int amount) {
        System.out.println("Запрошена сумма " + amount);
        try {
            atm.output(amount).printBatch();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return this;
    }

    private App inputMoney() {
        BanknoteBatch banknoteBatch = new BanknoteBatch()
                .append(500, 3)
                .append(200, 5);

        System.out.println("Прием пачки банкнот");
        banknoteBatch.printBatch();
        atm.inputBatch(banknoteBatch);
        System.out.println("---- Сейчас в банкомате ----");
        atm.getAllBanknotes().printBatch();
        return this;
    }
}
