package rooms;
import player.Player;
import javax.swing.*;
import java.util.Random;

public class EnemyRoom implements Room {
    public void enter(Player player, JPanel panel, Runnable onContinue) {
        panel.removeAll();
        JTextArea text = new JTextArea("¡Un Mortífago se interpone en tu camino!\n");
        text.setEditable(false);
        panel.add(text);

        JButton attack = new JButton("Lanzar hechizo");
        attack.addActionListener(e -> {
            int damage = new Random().nextInt(20) + 10;
            player.takeDamage(damage);
            text.append("El Mortífago te ataca. Pierdes " + damage + " de vida.\n");
            attack.setEnabled(false);
        });
        panel.add(attack);

        JButton next = new JButton("Continuar");
        next.addActionListener(e -> onContinue.run());
        panel.add(next);

        panel.revalidate();
        panel.repaint();
    }
    public String getDescription() {
        return "Duelo con Mortífago";
    }
}
