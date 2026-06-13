package com.lld.systems.designSystems;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

public class StrategyPattern {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Cashier, Please input the amount..");
        float amount = scanner.nextFloat();

        System.out.println("What mode would you like to pay?" +
                " 1: Credit Card 2. UPI 3.Cash");
        int input = scanner.nextInt();
        scanner.nextLine();
        PaymentClient client =null;
        switch (input) {
            case 1:
                System.out.println("Enter card number, cvv, name and expiry");
                String cardNumber = scanner.nextLine();
                String cvv = scanner.nextLine();
                String name = scanner.nextLine();
                client = new PaymentClient(new CreditCardPayment(cardNumber,cvv,name));
                break;
            case 2:
                System.out.println("Please enter your phoneNumber");
                String phone = scanner.nextLine();
                client = new PaymentClient(new UPIdPayment("xyz.com",phone));
                break;
            case 3:
                client = new PaymentClient(new CashPayment());
                break;
        }

        if(client!=null)
            if(client.processPayment(amount)) {
                System.out.println("Payment successful");
            }else {
                System.out.println("Payment failed");
            }
        else
            System.out.println("Select correct option for payment");
    }
}

class PaymentClient {

    private final PaymentProcessor paymentProcessor;

    PaymentClient(Payment payment) {
        this.paymentProcessor =  new PaymentProcessor(payment);
    }

    public boolean processPayment(float amount) {
        return paymentProcessor.processPayment(amount);
    }
}

class PaymentProcessor {
    private Payment payment;

    PaymentProcessor(Payment payment) {
        this.payment = payment;
    }

    public boolean processPayment(float amount) {
        return payment.pay(amount);
    }
}


interface Payment {
    boolean pay(float amount);
}

@Getter
@Setter
@AllArgsConstructor
class CashPayment implements Payment{

    @Override
    public boolean pay(float amount) {
        return true;
    }
}

@Getter
@Setter
@AllArgsConstructor
class UPIdPayment implements Payment{
    private String email;
    private String phoneNumber;

    @Override
    public boolean pay(float amount) {
        try{
            if(isUPIExists()) {
                //make call to external API and deduct balance;
                //response is success
                return true;
            }
        }catch (Exception ex) {
            return false;
        }
        return true;
    }

    private boolean isUPIExists() {
        //validate upi details
        return true;
    }
}

@Getter
@Setter
@AllArgsConstructor
class CreditCardPayment implements Payment{
    private String cardNumber;
    private String cvv;
    private String name;

    @Override
    public boolean pay(float amount) {
        try{
            if(isValidCardDetails()) {
                //make call to external API and deduct balance;
                //response is success
                return true;
            }
        }catch (Exception ex) {
            return false;
        }
        return true;
    }

    private boolean isValidCardDetails() {
        //validate card details
        return true;
    }
}