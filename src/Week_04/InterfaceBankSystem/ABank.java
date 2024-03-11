package Week_04.InterfaceBankSystem;

public class ABank implements IBank{
    private String bankName;
    private String terminalID;
    private String password;

    public ABank(String bankName, String terminalID, String password) {
        this.bankName = bankName;
        this.terminalID = terminalID;
        this.password = password;
    }

    @Override
    public boolean connect(String ip) {
        System.out.println("User ip : "+ip);
        System.out.println("Machine IP :" +this.hostIpAdress);
        System.out.println(this.bankName+ "Successfull");
        return true;
    }

    public boolean payment(double price, String cardNumber, String expiredDate, String CVC){
        System.out.println("Connecting Bank...");
        System.out.println("Successfull!");
        return true;
    }
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getTerminalID() {
        return terminalID;
    }

    public void setTerminalID(String terminalID) {
        this.terminalID = terminalID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
