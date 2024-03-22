package com.github.zipcodewilmington.casino;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class CasinoAccountManager {
    /**
     * @param accountName     name of account.txt to be returned
     * @param accountPassword password of account.txt to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
     Set<CasinoAccount> casinoAccountSet;


    public CasinoAccount getAccount(String accountName, String accountPassword) {
//        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
//        String currentClassName = getClass().getName();
//        String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
//        throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));
        for(CasinoAccount account : casinoAccountSet) {
            if (account.getName().equals(accountName) && account.getPassWord().equals(accountPassword)) {
                return account;
            }
        }
        System.out.println("This account doesn't exist!");
        return null;

    }

    /**
     * logs & creates a new `ArcadeAccount`
     *
     * @param accountName     name of account.txt to be created
     * @param accountPassword password of account.txt to be created
     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount createAccount(String accountName, String accountPassword) {
        return new CasinoAccount(accountName, accountPassword);
//        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
//        String currentClassName = getClass().getName();
//        String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
//        throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));
    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     *
     * @param casinoAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(CasinoAccount casinoAccount) {
//        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
//        String currentClassName = getClass().getName();
//        String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
//        throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));
        casinoAccountSet.add(casinoAccount);
    }
    public void readFile(){
        try {
            String input;
            String[] element;
            String username;
            String password;
            int balance;
            casinoAccountSet = new HashSet<>();

            Scanner sc = new Scanner(new File("account.txt"));

            while (sc.hasNext()) {
                input = sc.nextLine();
                element = input.split(",");
                username = element[0];
                password = element[1];
                balance = Integer.parseInt(element[2]);

                CasinoAccount account = new CasinoAccount(username, password, balance);
                casinoAccountSet.add(account);

            }
        }catch (FileNotFoundException e){
            System.out.println("File not found!");
        }
    }
    public void saveFile(){
        try {
            PrintWriter file = new PrintWriter("account.txt");
            for (CasinoAccount casino: casinoAccountSet){
                file.println(casino.getName() + "," +casino.getPassWord() + "," + casino.getBalance());
            }
            file.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}
