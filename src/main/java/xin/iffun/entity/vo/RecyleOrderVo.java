package xin.iffun.entity.vo;

import xin.iffun.entity.Product;
import xin.iffun.entity.ProductPrice;
import xin.iffun.entity.RecyleOrder;

/**
 * Created with IntelliJ IDEA
 * Created By YangF
 * Date: 2018/2/26
 * Time: 16:54
 */
public class RecyleOrderVo extends RecyleOrder {

    private Product product;
    private ProductPrice price;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductPrice getPrice() {
        return price;
    }

    public void setPrice(ProductPrice price) {
        this.price = price;
    }
}
