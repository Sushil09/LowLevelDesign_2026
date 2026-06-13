package com.lld.systems.designSystems;

public class StatePattern {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin();
        vendingMachine.selectItem();
        vendingMachine.dispenseItem();
    }
}


interface VendingMachineState {
    void insertCoin(VendingMachine machine);
    void selectItem(VendingMachine machine);
    void dispenseItem(VendingMachine machine);
}

class InsertCoinState implements VendingMachineState {

    VendingMachine machine;

    public InsertCoinState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("Coin inserted");
        machine.setState(new SelectItemState(machine));
    }

    @Override
    public void selectItem(VendingMachine machine) {
        System.out.println("Please insert coin first");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Please insert coin first");
    }
}

class SelectItemState implements VendingMachineState {

    VendingMachine machine;

    public SelectItemState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("Coin is already inserted");
    }

    @Override
    public void selectItem(VendingMachine machine) {
        System.out.println("Select the item");
        machine.setState(new DispenseItemState(machine));
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Please select the item First");
    }
}

class DispenseItemState implements VendingMachineState {

    VendingMachine machine;

    public DispenseItemState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("Coin is already inserted");
    }

    @Override
    public void selectItem(VendingMachine machine) {
        System.out.println("Items is already being dispensed now");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Dispensing the item");
        machine.setState(new InsertCoinState(machine));
    }
}

class VendingMachine {

    VendingMachineState state;

    public VendingMachine() {
        this.state = new InsertCoinState(this);
    }

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public void insertCoin() {
        state.insertCoin(this);
    }

    public void selectItem() {
        state.selectItem(this);
    }

    public void dispenseItem() {
        state.dispenseItem(this);
    }

}
