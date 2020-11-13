package my.homeworks.testing;

import my.homeworks.hw06.atm.Atm;
import my.homeworks.hw06.atm.AtmBuilder;
import my.homeworks.hw06.atm.BanknoteBatch;
import my.homeworks.hw06.atm.output.strategy.MinBanknotesCountOutputStrategy;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AtmTest {

    private Atm atm;

    @BeforeEach
    void setUp() {
        atm = AtmBuilder.create()
                .loadBanknotes(500, 10)
                .loadBanknotes(1000, 10)
                .loadBanknotes(100, 10)
                .loadBanknotes(50, 10)
                .setBanknoteOutputStrategy(new MinBanknotesCountOutputStrategy())
                .build();
    }

    @Test
    void OutputBanknotesTest() {
        int amount = 12450;
        System.out.println("Проверка состава банкнот на сумму " + amount);
        BanknoteBatch batch = atm.output(amount);

        assertEquals(1, batch.banknoteCount(50));
        assertEquals(4, batch.banknoteCount(500));
        assertEquals(4, batch.banknoteCount(100));
        assertEquals(10, batch.banknoteCount(1000));
    }

    @Test
    void InputBanknotesTest() {
        var batch = new BanknoteBatch()
                .append(500, 3)
                .append(200, 5);
        System.out.println("Проверка внесения пачки банкнот:");
        batch.printBatch();

        atm.inputBatch(batch);
        BanknoteBatch atmBatch = atm.getAllBanknotes();

        assertEquals(13, atmBatch.banknoteCount(500));
        assertEquals(5, atmBatch.banknoteCount(200));
        assertEquals(10, atmBatch.banknoteCount(100));
        assertEquals(10, atmBatch.banknoteCount(1000));
    }

}
