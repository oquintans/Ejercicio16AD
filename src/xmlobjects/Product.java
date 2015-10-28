/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package xmlobjects;

import java.io.Serializable;

/**
 *
 * @author oracle
 */
public class Product implements Serializable {

    private String cod;
    private String desc;
    private int price;

    public Product() {
    }

    public Product(String cod, String desc, int price) {
        this.cod = cod;
        this.desc = desc;
        this.price = price;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "cod=" + cod + ", desc=" + desc + ", price=" + price + '}';
    }

}
