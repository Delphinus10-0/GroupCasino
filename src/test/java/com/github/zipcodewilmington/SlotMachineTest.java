package com.github.zipcodewilmington;
import com.github.zipcodewilmington.casino.games.slots.SlotGame;
import com.github.zipcodewilmington.casino.games.slots.SlotGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class SlotMachineTest {
    @Test
    public void testCalculatePayoutJackpot() {
        int[] result = {1, 1, 1};
        assertEquals(100, SlotGame.calculatePayout(result));
    }
    @Test
    public void testCalculatePayoutMatchTwoSymbols() {
        int[] result = {1, 1, 2};
        assertEquals(10, SlotGame.calculatePayout(result));
    }
    @Test
    public void testCalculatePayoutNoMatch() {
        int[] result = {1, 2, 3};
        assertEquals(0, SlotGame.calculatePayout(result));
    }

}