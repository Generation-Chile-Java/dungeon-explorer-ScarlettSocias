package rooms;
import player.Player;
import javax.swing.JPanel;

public interface Room {
    void enter(Player player, JPanel panel, Runnable onContinue);
    String getDescription();
}
