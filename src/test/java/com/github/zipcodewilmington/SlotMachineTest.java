package com.github.zipcodewilmington;
import com.github.zipcodewilmington.casino.games.slots.SlotMachine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class SlotMachineTest {
    @Test
    public void testCalculatePayoutJackpot() {
        int[] result = {1, 1, 1};
        assertEquals(100, SlotMachine.calculatePayout(result));
    }
    @Test
    public void testCalculatePayoutMatchTwoSymbols() {
        int[] result = {1, 1, 2};
        assertEquals(10, SlotMachine.calculatePayout(result));
    }
    @Test
    public void testCalculatePayoutNoMatch() {
        int[] result = {1, 2, 3};
        assertEquals(0, SlotMachine.calculatePayout(result));
    }

}