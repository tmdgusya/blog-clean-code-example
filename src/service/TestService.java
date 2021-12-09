package service;

import model.Bank;

public class TestService {

    private final Bank bank = new Bank();

    public void aLogic(int input) {
        //PROGRESS... A Logic
        input = input * 10;
        bank.deposit(input);
    }

    public void bLogic(int input) {
        //PROGRESS... B Logic
        input = input * 10;
        bank.deposit(input);
    }


}
