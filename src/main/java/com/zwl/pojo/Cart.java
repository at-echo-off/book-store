package com.zwl.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private Integer totalCount;
    private BigDecimal totalPrice;
    private Map<Integer,CartItem> items = new LinkedHashMap<>();

    public void addItem(CartItem cartItem){

        CartItem item = items.get(cartItem.getId());
        if (item == null){
            items.put(cartItem.getId(),cartItem);
        }else {
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }

    }

    public void deleteCart(Integer id){
        items.remove(id);
    }

    public void clear(){
        items.clear();
    }

    public void updateCount(Integer id,Integer count){
        CartItem cartItem = items.get(id);
        if (cartItem != null){
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;

        for (CartItem item : items.values()) {
            totalCount += item.getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);

        for (CartItem item : items.values()){
            totalPrice = totalPrice.add(item.getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
