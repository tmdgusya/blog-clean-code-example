package controller;

import adapter.CommandSale;
import common.Response;
import model.User;
import repository.UserRepository;

public class Controller {

    private final UserRepository userRepository = new UserRepository();

    public Response<CommandSale.out> deductUserMoney(CommandSale.in saleRequestInfo) {
        User user = userRepository.findById(saleRequestInfo.getUserId());

        int productPrice = saleRequestInfo.getPrice();
        int userMoney = user.getMoney();

        user.setMoney(userMoney - productPrice);

        CommandSale.out responseData = new CommandSale.out(user.getUserId(), user.getMoney());

        return Response.Ok(responseData);
    }

}
