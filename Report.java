package com.vignesh;
import java.util.*;

public class Report {
    ArrayList<product> p;
    ArrayList<User> u;
    ArrayList<bill> bi;
    
    public Report(ArrayList<product> p, ArrayList<User> u, ArrayList<bill> bi) {
        this.p = p;
        this.u = u;
        this.bi = bi;
    }
    
    // Report A - Low Stock
    public void stockproducts(int threshold) {
        boolean stock = false;
        System.out.println("=== Low Stock Products ===");
        for(product pr : p) {
            if(pr.getQuan() < threshold) {
                pr.display();
                stock = true;
            }
        }
        if(!stock) {
            System.out.println("All products are well stocked!");
        }
    }
    
    // Report B - Never Bought
    public void neverBoughtProducts() {
        System.out.println("=== Products Never Bought ===");
        boolean found = false;
        for(product pr : p) {
            boolean bought = false;
            for(bill b : bi) {
                for(cart ca : b.ca) {
                    if(ca.getProduct().getID() == pr.getID()) {
                        bought = true;
                        break;
                    }
                }
            }
            if(!bought) {
                pr.display();
                found = true;
            }
        }
        if(!found) {
            System.out.println("All products have been bought!");
        }
    }
    public void topCustomers() {
        System.out.println("=== Top Spending Customers ===");
        
        
        HashMap<String, Double> spending = new HashMap<>();
        
        // calculate total spent per customer
        for(bill b : bi) {
            String email = b.getcustomeremail();
            if(spending.containsKey(email)) {
                spending.put(email, spending.get(email) + b.getTotal());
            } else {
                spending.put(email, b.getTotal());
            }
        }
        
        // sort by value (highest first)
        List<Map.Entry<String, Double>> list = new ArrayList<>(spending.entrySet());
        Collections.sort(list, (a, b) -> Double.compare(b.getValue(), a.getValue()));
        
        // print sorted
        for(Map.Entry<String, Double> entry : list) {
            System.out.println("Customer: " + entry.getKey() + 
                             " -> Rs." + entry.getValue());
        }
    }
    public void topAdmins() {
        System.out.println("=== Top Admins ===");
        
        
        HashMap<String, Integer> adminCount = new HashMap<>();
        
       
        for(User us : u) {
            if(us.getRole().equals("customer")) {
                String addedBy = us.getaddBy();
                if(adminCount.containsKey(addedBy)) {
                    adminCount.put(addedBy, adminCount.get(addedBy) + 1);
                } else {
                    adminCount.put(addedBy, 1);
                }
            }
        }
        
        // sort by value (highest first)
        List<Map.Entry<String, Integer>> list = new ArrayList<>(adminCount.entrySet());
        Collections.sort(list, (a, b) -> Integer.compare(b.getValue(), a.getValue()));
        
        // print sorted
        for(Map.Entry<String, Integer> entry : list) {
            System.out.println("Admin: " + entry.getKey() + 
                             " -> Customers Added: " + entry.getValue());
        }
    }
}