import javax.swing.*;
import java.awt.*;
import player.Player;
import rooms.*;

public class GameGUI extends JFrame {
    private Player player;
    private Room[] dungeon;
    private int currentRoom = 0;
    private JLabel statusLabel;
    private BackgroundPanel contentPanel;

    public GameGUI() {
        setTitle("Hogwarts Adventure - Historia Interactiva");
        setSize(600, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        statusLabel = new JLabel();
        add(statusLabel, BorderLayout.NORTH);

        contentPanel = new BackgroundPanel("src/resources/fondo.jpg");
        add(new JScrollPane(contentPanel), BorderLayout.CENTER);

        String name = JOptionPane.showInputDialog(this, "¿Tu nombre, mago o bruja?");
        player = new Player(name);
        dungeon = new Room[] {
            new EmptyRoom(),
            new TreasureRoom(),
            new EnemyRoom(),
            new TreasureRoom(),
            new EmptyRoom()
        };

        nextRoom();
        setVisible(true);
    }

    private void nextRoom() {
        if (!player.isAlive()) {
            contentPanel.removeAll();
            JTextArea text = new JTextArea("Has muerto. Fin del juego.");
            text.setEditable(false);
            contentPanel.add(text);
            contentPanel.revalidate();
            contentPanel.repaint();
            return;
        }

        if (currentRoom >= dungeon.length) {
            contentPanel.removeAll();
            JTextArea text = new JTextArea("🎉 ¡Has superado todas las salas mágicas!");
            text.setEditable(false);
            contentPanel.add(text);
            contentPanel.revalidate();
            contentPanel.repaint();
            return;
        }

        Room room = dungeon[currentRoom++];
        updateStatus();
        room.enter(player, contentPanel, this::nextRoom);
    }

    private void updateStatus() {
        statusLabel.setText("Vida: " + player.getHealth() + " | Jugador: " + player.getName());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameGUI::new);
    }
}
