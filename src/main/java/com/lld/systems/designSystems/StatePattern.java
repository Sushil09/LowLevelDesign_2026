package com.lld.systems.designSystems;

import lombok.Getter;
import lombok.Setter;

public class StatePattern {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin();
        vendingMachine.selectItem();
        vendingMachine.dispenseItem();
    }
}


interface VendingMachineState {
    void insertCoin();
    void selectItem();
    void dispenseItem();
}

class VendingMachine {

    @Setter
    private VendingMachineState state;
    @Getter
    private InsertCoinState insertCoinState;
    @Getter
    private SelectItemState selectItemState;
    @Getter
    private DispenseItemState dispenseItemState;

    public VendingMachine() {
        insertCoinState = new InsertCoinState(this);
        selectItemState = new SelectItemState(this);
        dispenseItemState = new DispenseItemState(this);
        state = insertCoinState;
    }

    public void insertCoin() {
        state.insertCoin();
    }

    public void selectItem() {
        state.selectItem();
    }

    public void dispenseItem() {
        state.dispenseItem();
    }

}

class InsertCoinState implements VendingMachineState {

    VendingMachine machine;

    public InsertCoinState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin inserted");
        machine.setState(machine.getSelectItemState());
    }

    @Override
    public void selectItem() {
        System.out.println("Please insert coin first");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Please insert coin first");
    }
}

class SelectItemState implements VendingMachineState {

    VendingMachine machine;

    public SelectItemState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin is already inserted");
    }

    @Override
    public void selectItem() {
        System.out.println("Select the item");
        machine.setState(machine.getDispenseItemState());
    }

    @Override
    public void dispenseItem() {
        System.out.println("Please select the item First");
    }
}

class DispenseItemState implements VendingMachineState {

    VendingMachine machine;

    public DispenseItemState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin is already inserted");
    }

    @Override
    public void selectItem() {
        System.out.println("Items is already being dispensed now");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Dispensing the item");
        machine.setState(machine.getInsertCoinState());
    }
}


