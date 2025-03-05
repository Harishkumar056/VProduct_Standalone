
package RemoveProduct;


public class RemovePojo 
{
    private int productId;
    private String productName;
    private String productBrand;
    private String productSize;
    private double productPrice;
    private byte[] productImage;
    
    public int getProductId() 
    {
        return productId;
    }

    public void setProductId(int productId) 
    {
        this.productId = productId;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getProductBrand() 
    {
        return productBrand;
    }

    public void setProductBrand(String productBrand) 
    {
        this.productBrand = productBrand;
    }

    public String getProductSize() 
    {
        return productSize;
    }

    public void setProductSize(String productSize) 
    {
        this.productSize = productSize;
    }

    public double getProductPrice()
    {
        return productPrice;
    }

    public void setProductPrice(double productPrice) 
    {
        this.productPrice = productPrice;
    }
    
    public void setProductImage(byte[] productImage)
    {
        this.productImage = productImage;
    }
    
    public byte[] getProductImage()
    {
        return productImage;
    }
}
