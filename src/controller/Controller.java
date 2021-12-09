package controller;

import adapter.CommandSale;
import common.Response;
import model.Bank;
import model.Grade;
import model.User;
import repository.UserRepository;

public class Controller {

    private final UserRepository userRepository = new UserRepository();
    private final Bank bank = new Bank();

    public Response<CommandSale.out> deductUserMoney(CommandSale.in saleRequestInfo) {
        User user = userRepository.findById(saleRequestInfo.getUserId());
        int deductedMoney = getDeductedMoney(saleRequestInfo, user);
        bank.deposit(deductedMoney / 10);

        CommandSale.out responseData = new CommandSale.out(user.getUserId(), user.getMoney());

        return Response.Ok(responseData);
    }

    public int ALogic(CommandSale.in saleRequestInfo) {
        User user = userRepository.findById(saleRequestInfo.getUserId());
        int deductedMoney = getDeductedMoney(saleRequestInfo, user);

        return deductedMoney;
    }

    private int getDeductedMoney(CommandSale.in saleRequestInfo, User user) {
        int productPrice = saleRequestInfo.getPrice();
        int deductedMoney = productPrice;

        if (user.getGrade() == Grade.A) {
            deductedMoney -= 500;
        }

        user.setMoney(user.getMoney() - deductedMoney);
        return deductedMoney;
    }

}
