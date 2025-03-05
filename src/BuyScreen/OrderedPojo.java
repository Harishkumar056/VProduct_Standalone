
package BuyScreen;


public class OrderedPojo 
{
    private String customerName;
    private long customerPhno;
    private String customerAddress;
    private boolean paymentCod;
    
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getCustomerPhno() {
        return customerPhno;
    }

    public void setCustomerPhno(long customerPhno) {
        this.customerPhno = customerPhno;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public boolean isPaymentCod() {
        return paymentCod;
    }

    public void setPaymentCod(boolean paymentCod) {
        this.paymentCod = paymentCod;
    }
}
