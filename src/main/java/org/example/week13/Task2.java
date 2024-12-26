package org.example.week13;

public class Task2 {
    public static void main(String[] args) {
        PaymentFactory creditCardFactory = new CreditCardPaymentFactory();
        Payment creditCardPayment = creditCardFactory.createPayment();
        creditCardPayment.processPayment();

        PaymentFactory payPalFactory = new PayPalPaymentFactory();
        Payment payPalPayment = payPalFactory.createPayment();
        payPalPayment.processPayment();
    }
}

interface Payment{
    void processPayment();
}

interface PaymentFactory{
    Payment createPayment();
}

class CreditCardPayment implements Payment{
    @Override
    public void processPayment() {
        System.out.println("You want to use credit card!");
    }
}

class PayPalPayment implements Payment{
    @Override
    public void processPayment() {
        System.out.println("You want to use PayPal for paying!");
    }
}

class CreditCardPaymentFactory implements PaymentFactory{
    @Override
    public Payment createPayment() {
        return new CreditCardPayment();
    }
}

class PayPalPaymentFactory implements PaymentFactory{
    @Override
    public Payment createPayment() {
        return new PayPalPayment();
    }
}