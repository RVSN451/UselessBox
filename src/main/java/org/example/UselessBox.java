package org.example;

public class UselessBox {
    String boxName;
    Switch mySwitch = new Switch(this);

    public UselessBox (String boxName) {
        this.boxName = boxName;
    }

    public String getBoxName() {
        return boxName;
    }

    public Switch getMySwitch() {
        return mySwitch;
    }

    public void boxSwitchOn(){
        mySwitch.switchOn();
    }

    public void boxSwitchOff() {
        mySwitch.switchOff();
    }


}
