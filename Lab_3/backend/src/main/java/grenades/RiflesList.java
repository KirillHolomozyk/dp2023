package grenades;

import Entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class RiflesList {

    private List<Entity> riflesList = new ArrayList<>();

    public RiflesList(){
        this.riflesList.add(new Entity(0, "АК-47", "1", "мм: 7,62", 4));
        this.riflesList.add(new Entity(2, "АКМ", "3", "мм: 7,62", 4));
        this.riflesList.add(new Entity(3, "АР-15", "4", "5,56 мм", 4));
        this.riflesList.add(new Entity(1, "АСР", "2", "7,62 мм", 3));
        this.riflesList.add(new Entity(4, "Вулкан", "5", "7,62", 3));
        this.riflesList.add(new Entity(5, "АК-74", "6", "5,56", 5));
    }

    public List<Entity> getRiflesList() {
        return riflesList;
    }

    public void setRiflesList(List<Entity> grenadesList) {
        this.riflesList = grenadesList;
    }
}
