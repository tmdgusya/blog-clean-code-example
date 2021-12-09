package adapter;

public final class CommandSale {

    final static public class in {
        private Long userId;
        private int price;

        public Long getUserId() {
            return userId;
        }

        public int getPrice() {
            return price;
        }
    }

    final static public class out {
        private Long userId;
        private int userMoney;

        public out(Long userId, int userMoney) {
            this.userId = userId;
            this.userMoney = userMoney;
        }

        public Long getUserId() {
            return userId;
        }

        public int getUserMoney() {
            return userMoney;
        }
    }

}
