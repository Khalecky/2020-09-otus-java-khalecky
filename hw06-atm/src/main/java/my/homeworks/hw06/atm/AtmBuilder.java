package my.homeworks.hw06.atm;

import my.homeworks.hw06.atm.output.strategy.BanknoteOutputStrategy;

public class AtmBuilder {

    private final AtmCellsRepository atmCellsRepository = new AtmCellsRepository();
    private BanknoteOutputStrategy banknoteOutputStrategy;

    private AtmBuilder() {}

    public static AtmBuilder create() {
        return new AtmBuilder();
    }

    public AtmBuilder loadBanknotes(int banknote, int count) {
        atmCellsRepository.insertBanknotes(banknote, count);
        return this;
    }

    public AtmBuilder setBanknoteOutputStrategy(BanknoteOutputStrategy banknoteOutputStrategy) {
        this.banknoteOutputStrategy = banknoteOutputStrategy;
        return this;
    }

    public Atm build() {

        var atm = new Atm(atmCellsRepository);
        if (banknoteOutputStrategy != null) {
            atm.setBanknoteOutputStrategy(banknoteOutputStrategy);
        }
        return atm;
    }
}
