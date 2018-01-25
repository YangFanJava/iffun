package xin.iffun.entity.vo;

import xin.iffun.entity.Product;
import xin.iffun.entity.ProductPrice;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By YangF
 * Date: 2018/1/24
 * Time: 17:37
 */
public class ProductVo  extends Product implements Serializable{

//    private Product product;

    private List<ProductPrice> prices;

//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }

    public List<ProductPrice> getPrices() {
        return prices;
    }

    public void setPrices(List<ProductPrice> prices) {
        this.prices = prices;
    }


    //    //全名
//    private String versionName;
//    //最大回收价格
//    private String maxRecoverPrice;
//    //版本图片  用于替代版本图
//    private String versionImg;
//
//
//    public String getVersionName() {
//        return versionName;
//    }
//
//    public void setVersionName(String versionName) {
//        this.versionName = versionName;
//    }
//
//    public String getMaxRecoverPrice() {
//        return maxRecoverPrice;
//    }
//
//    public void setMaxRecoverPrice(String maxRecoverPrice) {
//        this.maxRecoverPrice = maxRecoverPrice;
//    }
//
//    public String getVersionImg() {
//        return versionImg;
//    }
//
//    public void setVersionImg(String versionImg) {
//        this.versionImg = versionImg;
//    }
}
