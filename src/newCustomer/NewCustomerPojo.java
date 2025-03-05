
package newCustomer;


public class NewCustomerPojo 
{
    private String userName;
    private long userPhoneNumber;
    private String userPassWord;
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public void setUserPhoneNumber(long userPhoneNumber)
    {
        this.userPhoneNumber = userPhoneNumber;
    }
    
    public void setUserPassWord(String userPassWord)
    {
        this.userPassWord = userPassWord;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public long getUserPhoneNumber()
    {
        return userPhoneNumber;
    }
    
    public String getUserPassWord()
    {
        return userPassWord;
    }
}
