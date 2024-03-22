package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.utils.IOConsole;

import java.io.Console;

public interface GameHigher {
    IOConsole  console = new IOConsole();
    int playerScore =0;
    int houseScore =0;
    boolean winner = false;
}
