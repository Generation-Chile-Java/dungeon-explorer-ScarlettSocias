package player;
import gameobjects.GameObject;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int health;
    private List<GameObject> inventory;

    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.inventory = new ArrayList<>();
    }

    public void takeDamage(int amount) {
        health -= amount;
        System.out.println(name + " recibió " + amount + " de daño.");
    }

    public void addToInventory(GameObject item) {
        inventory.add(item);
        System.out.println(item.getName() + " añadido al inventario.");
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public List<GameObject> getInventory() {
        return inventory;
    }
}
