package c.securebank.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JTextField;


public class TextFieldArredondado extends JTextField {

    public TextFieldArredondado(int columns) {
        super(columns);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (isOpaque()) {
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        }
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(new Color(7, 173, 87));
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
    }

    // Adiciona dicas de renderização para suavizar as bordas
    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        super.paintChildren(g2);
        g2.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        // Ajuste as dimensões preferenciais conforme necessário
        return new Dimension(317, 40); // Exemplo: largura de 150 pixels, altura de 30 pixels
    }
}