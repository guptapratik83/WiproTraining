package com.liststackqueue;



public class ShoppingApp {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        PurchaseHistory history = new PurchaseHistory();
        CustomerService service = new CustomerService();

        // Shopping cart operations
        cart.addItem("Egg");
        cart.addItem("Milk");
        cart.viewItems();
        cart.removeItem("Egg");
        cart.viewItems();

        // Purchase history operations
        history.savePurchase(cart.getCartItems());
        cart.addItem("Orange");
        history.savePurchase(cart.getCartItems());
        history.viewPurchaseHistory();
        history.undoLastPurchase();
        history.viewPurchaseHistory();

        // Customer service operations
        service.addRequest("Refund for order #1111");
        service.addRequest("Inquiry about product #1468");
        service.viewPendingRequests();
        service.processRequest();
        service.viewPendingRequests();
    }
}
