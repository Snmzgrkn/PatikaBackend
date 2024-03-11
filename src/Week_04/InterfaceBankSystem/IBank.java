package Week_04.InterfaceBankSystem;

public interface IBank {
    final String hostIpAdress = "127.0.0.1";
     boolean connect(String ip);
     boolean payment(double price,String cardNumber,String expiredDate,String CVC);
}
