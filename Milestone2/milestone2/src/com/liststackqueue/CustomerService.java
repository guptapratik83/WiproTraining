package com.liststackqueue;



import java.util.LinkedList;
import java.util.Queue;

class CustomerService {
    private Queue<String> serviceRequests;

    public CustomerService() {
        serviceRequests = new LinkedList<>();
    }

    public void addRequest(String request) {
        serviceRequests.add(request);
        System.out.println("Service request added: " + request);
    }

    public void processRequest() {
        if (!serviceRequests.isEmpty()) {
            String request = serviceRequests.poll();
            System.out.println("Processing request: " + request);
        } else {
            System.out.println("No pending service requests.");
        }
    }

    public void viewPendingRequests() {
        if (serviceRequests.isEmpty()) {
            System.out.println("No pending service requests.");
        } else {
            System.out.println("Pending service requests: " + serviceRequests);
        }
    }
}
