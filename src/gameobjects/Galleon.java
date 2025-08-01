package gameobjects;

public class Galleon implements GameObject {
    public String getName() {
        return "Galeón de oro";
    }

    public void use() {
        System.out.println("No puedes usar un galeón... ¡pero es valioso!");
    }
}
