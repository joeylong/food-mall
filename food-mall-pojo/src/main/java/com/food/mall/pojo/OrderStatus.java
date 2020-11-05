package com.food.mall.pojo;

import java.util.Date;

public class OrderStatus {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_status.order_id
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    private String orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_status.order_status
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    private Integer orderStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_status.created_time
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    private Date createdTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_status.pay_time
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    private Date payTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_status.deliver_time
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    private Date deliverTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_status.success_time
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    private Date successTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_status.close_time
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    private Date closeTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_status.comment_time
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    private Date commentTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_status.order_id
     *
     * @return the value of order_status.order_id
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_status.order_id
     *
     * @param orderId the value for order_status.order_id
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_status.order_status
     *
     * @return the value of order_status.order_status
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_status.order_status
     *
     * @param orderStatus the value for order_status.order_status
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_status.created_time
     *
     * @return the value of order_status.created_time
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_status.created_time
     *
     * @param createdTime the value for order_status.created_time
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_status.pay_time
     *
     * @return the value of order_status.pay_time
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_status.pay_time
     *
     * @param payTime the value for order_status.pay_time
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_status.deliver_time
     *
     * @return the value of order_status.deliver_time
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public Date getDeliverTime() {
        return deliverTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_status.deliver_time
     *
     * @param deliverTime the value for order_status.deliver_time
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_status.success_time
     *
     * @return the value of order_status.success_time
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public Date getSuccessTime() {
        return successTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_status.success_time
     *
     * @param successTime the value for order_status.success_time
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public void setSuccessTime(Date successTime) {
        this.successTime = successTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_status.close_time
     *
     * @return the value of order_status.close_time
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public Date getCloseTime() {
        return closeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_status.close_time
     *
     * @param closeTime the value for order_status.close_time
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_status.comment_time
     *
     * @return the value of order_status.comment_time
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public Date getCommentTime() {
        return commentTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_status.comment_time
     *
     * @param commentTime the value for order_status.comment_time
     *
     * @mbggenerated Wed Oct 14 22:42:35 CST 2020
     */
    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }
}