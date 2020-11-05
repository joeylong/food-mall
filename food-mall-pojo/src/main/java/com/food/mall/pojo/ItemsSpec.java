package com.food.mall.pojo;



import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

public class ItemsSpec {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column items_spec.id
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    @Id
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column items_spec.item_id
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    private String itemId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column items_spec.name
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column items_spec.stock
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    private Integer stock;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column items_spec.discounts
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    private BigDecimal discounts;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column items_spec.price_discount
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    private Integer priceDiscount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column items_spec.price_normal
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    private Integer priceNormal;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column items_spec.created_time
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    private Date createdTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column items_spec.updated_time
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    private Date updatedTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column items_spec.id
     *
     * @return the value of items_spec.id
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column items_spec.id
     *
     * @param id the value for items_spec.id
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column items_spec.item_id
     *
     * @return the value of items_spec.item_id
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column items_spec.item_id
     *
     * @param itemId the value for items_spec.item_id
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column items_spec.name
     *
     * @return the value of items_spec.name
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column items_spec.name
     *
     * @param name the value for items_spec.name
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column items_spec.stock
     *
     * @return the value of items_spec.stock
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column items_spec.stock
     *
     * @param stock the value for items_spec.stock
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column items_spec.discounts
     *
     * @return the value of items_spec.discounts
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public BigDecimal getDiscounts() {
        return discounts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column items_spec.discounts
     *
     * @param discounts the value for items_spec.discounts
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public void setDiscounts(BigDecimal discounts) {
        this.discounts = discounts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column items_spec.price_discount
     *
     * @return the value of items_spec.price_discount
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public Integer getPriceDiscount() {
        return priceDiscount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column items_spec.price_discount
     *
     * @param priceDiscount the value for items_spec.price_discount
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public void setPriceDiscount(Integer priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column items_spec.price_normal
     *
     * @return the value of items_spec.price_normal
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public Integer getPriceNormal() {
        return priceNormal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column items_spec.price_normal
     *
     * @param priceNormal the value for items_spec.price_normal
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public void setPriceNormal(Integer priceNormal) {
        this.priceNormal = priceNormal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column items_spec.created_time
     *
     * @return the value of items_spec.created_time
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column items_spec.created_time
     *
     * @param createdTime the value for items_spec.created_time
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column items_spec.updated_time
     *
     * @return the value of items_spec.updated_time
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column items_spec.updated_time
     *
     * @param updatedTime the value for items_spec.updated_time
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}