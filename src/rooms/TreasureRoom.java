package rooms;
import player.Player;
import gameobjects.Galleon;
import javax.swing.*;

public class TreasureRoom implements Room {
    public void enter(Player player, JPanel panel, Runnable onContinue) {
        panel.removeAll();
        JTextArea text = new JTextArea("Un baúl antiguo descansa en medio de la sala.\n");
        text.setEditable(false);
        panel.add(text);

        JButton pick = new JButton("Abrir el baúl");
        pick.addActionListener(e -> {
            player.addToInventory(new Galleon());
            text.append("Encuentras un galeón mágico y lo guardas.\n");
            pick.setEnabled(false);
        });
        panel.add(pick);

        JButton next = new JButton("Continuar");
        next.addActionListener(e -> onContinue.run());
        panel.add(next);

        panel.revalidate();
        panel.repaint();
    }
    public String getDescription() {
        return "Sala del Tesoro";
    }
}
