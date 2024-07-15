package c.securebank.view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;

public class BotaoArredondado extends JButton {

    public BotaoArredondado(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(getBackground().darker());
        } else {
            g.setColor(getBackground());
        }

        // Ajuste os valores nos métodos fillRoundRect para modificar o raio das bordas
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Defina a cor da borda para ser a mesma que a cor de fundo
        g.setColor(getBackground());

        // Ajuste os valores nos métodos drawRoundRect para modificar o raio das bordas
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
    }

    // Adiciona dicas de renderização para suavizar as bordas
    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        super.paintChildren(g2);
        g2.dispose();
    }
}