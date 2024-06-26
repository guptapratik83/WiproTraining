package com.liststackqueue;



import java.util.LinkedList;
import java.util.Stack;

class PurchaseHistory {
    private Stack<LinkedList<String>> history;

    public PurchaseHistory() {
        history = new Stack<>();
    }

    public void savePurchase(LinkedList<String> cart) {
        history.push(new LinkedList<>(cart));
        System.out.println("Purchase saved: " + cart);
    }

    public void undoLastPurchase() {
        if (!history.isEmpty()) {
            LinkedList<String> lastPurchase = history.pop();
            System.out.println("Last purchase undone: " + lastPurchase);
        } else {
            System.out.println("No purchase history to undo.");
        }
    }

    public void viewPurchaseHistory() {
        if (history.isEmpty()) {
            System.out.println("No purchase history.");
        } else {
            System.out.println("Purchase history: " + history);
        }
    }
}
