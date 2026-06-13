package com.lld.systems.designSystems;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class BuilderPattern {
    public static void main(String[] args) {

    }
}

class PhoneBuilder{
    float weight;
    float height;
    float inches;
    int ram;
    int cpu;
    int memory;

    PhoneBuilder(){
    }

    public PhoneBuilder setWeight(float weight){
        this.weight = weight;
        return this;
    }

    public PhoneBuilder setHeight(float height){
        this.height = height;
        return this;
    }
    public PhoneBuilder setInches(float inches){
        this.inches = inches;
        return  this;
    }

    public PhoneBuilder setRam(int ram){
        this.ram = ram;
        return this;
    }

    public PhoneBuilder setCpu(int cpu){
        this.cpu = cpu;
        return this;
    }

}

