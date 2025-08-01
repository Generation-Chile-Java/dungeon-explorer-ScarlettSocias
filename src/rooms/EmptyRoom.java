package rooms;
import player.Player;
import javax.swing.*;
import java.awt.*;

public class EmptyRoom implements Room {
    public void enter(Player player, JPanel panel, Runnable onContinue) {
        panel.removeAll();
        JTextArea text = new JTextArea("Te encuentras en una sala húmeda y silenciosa.\n");
        text.setEditable(false);
        panel.add(text);
        JButton next = new JButton("Continuar");
        next.addActionListener(e -> onContinue.run());
        panel.add(next);
        panel.revalidate();
        panel.repaint();
    }
    public String getDescription() {
        return "Sala del Eco";
    }
}
