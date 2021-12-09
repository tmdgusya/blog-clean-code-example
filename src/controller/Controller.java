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

        int productPrice = saleRequestInfo.getPrice();
        int userMoney = user.getMoney();
        int deductedMoney = productPrice;

        if (user.getGrade() == Grade.A) {
            deductedMoney -= 500;
        }
        user.setMoney(userMoney - deductedMoney);
        bank.deposit(deductedMoney / 10);

        CommandSale.out responseData = new CommandSale.out(user.getUserId(), user.getMoney());

        return Response.Ok(responseData);
    }

}
