package org.example.MidtermPreparation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MidtermPreparation {
}

interface Billable{
    double applyDiscount(double discountRate);
    String getDescription();
}

abstract class MenuItem implements Billable{
    private String code;
    private String name;
    private double price;

    public MenuItem(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double applyDiscount(double disscountRate) {
        return price - (price * disscountRate/100.0);
    }

    @Override
    public String getDescription(){
        return code + " " + name + " " + price;
    }
}

class Dish extends MenuItem{
    private CuisineType cuisineType;
    private String mainIngredient;

    public Dish(String code, String name, double price,CuisineType cuisineType, String mainIngredient){
        super(code, name, price);
        this.cuisineType = cuisineType;
        this.mainIngredient = mainIngredient;
    }

    public CuisineType getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(CuisineType cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getMainIngredient() {
        return mainIngredient;
    }

    public void setMainIngredient(String mainIngredient) {
        this.mainIngredient = mainIngredient;
    }

    @Override
    public String getDescription(){
        return cuisineType + " " + mainIngredient;
    }
}

class Drink extends MenuItem{
    private double volume;

    public Drink(String code, String name, double price, double volume){
        super(code, name, price);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String getDescription() {
        return "They are represented in milliliters: " + volume;
    }
}

class TableReservation <T extends MenuItem & Billable>{
    private String reservationId;
    private Date reservationDate;
    private HashMap<T, Integer> orderedItems;
    private int tableNumber;

    public TableReservation(String reservationId, Date reservationDate, HashMap<T, Integer> orderedItems, int tableNumber){
        this.reservationId = reservationId;
        this.reservationDate = reservationDate;
        this.orderedItems = new HashMap<>();
        this.tableNumber = tableNumber;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public HashMap<T, Integer> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(HashMap<T, Integer> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public void addItemToOrder(T item, int quantity) {
        if(quantity <= 0){
            System.out.println("Mora da je vece od nule!!");
            return;
        }
        if(orderedItems.containsKey(item)){
            int trenutno = orderedItems.get(item);
            orderedItems.put(item, trenutno + quantity);
        }else{
            orderedItems.put(item,quantity);
        }
    }

    public double  calculateTotalAmount(){
        double total = 0.0;

        for(T item : orderedItems.keySet()){
            int quantity = orderedItems.get(item);
            total += item.getPrice() * quantity;
        }
        return total;
    }

}

class Customer{
    private String customerId;
    private String name;
    private String phoneNumber;
    private List<TableReservation<? extends MenuItem>> reservations;

    public Customer(String customerId, String name, String phoneNumber, List<TableReservation<? extends MenuItem>> reservations){
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.reservations = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<TableReservation<? extends MenuItem>> getReservations() {
        return reservations;
    }

    public void setReservations(List<TableReservation<? extends MenuItem>> reservations) {
        this.reservations = reservations;
    }

    public void addReservations(TableReservation<? extends MenuItem> reservation){
        reservations.add(reservation);
    }
}

class Restaurant{
    private String restaurantName;
    private List<Customer> customers;
    private Map<String, MenuItem> menuItems;

    public Restaurant(String restaurantName,List<Customer> customers, Map<String, MenuItem> menuItems){
        this.restaurantName = restaurantName;
        this.customers = new ArrayList<>();
        this.menuItems = new HashMap<>();
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Map<String, MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Map<String, MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void addCustomers(Customer customer){
        customers.add(customer);
    }

    public void addMenuItem(MenuItem item){
        menuItems.put(item.getCode(), item);
    }

    public Customer getCustomer(String customerId){
        for(Customer customer : customers){
            if(customer.getCustomerId().equals(customerId)){
                return customer;
            }
        }
        return null;
    }

    public void displayMenu(){
        for(MenuItem item : menuItems.values()){
            System.out.println(item.getDescription());
        }
    }

    public double calculateTotalSales(){
        double total = 0.0;
        for(Customer customer : customers){
            for(TableReservation<? extends MenuItem> reservation : customer.getReservations()){
                total += reservation.calculateTotalAmount();
            }
        }
        return total;
    }
}


