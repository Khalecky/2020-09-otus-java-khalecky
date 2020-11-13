package my.homeworks.hw06.atm.output.strategy;

import my.homeworks.hw06.atm.BanknoteBatch;

public interface BanknoteOutputStrategy {
    public BanknoteBatch execute(int amount, BanknoteBatch banknoteBatch);
}
