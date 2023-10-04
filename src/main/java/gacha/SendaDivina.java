package gacha;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SendaDivina extends JDialog {

    Mouse mouse = new Mouse();
    static Tiradas t;
    private int senda;
    JLabel arma1;
    JLabel arma2;

    public void setSenda(int senda) {
        this.senda = senda;
    }

    public int getSenda() {
        return senda;
    }

    public SendaDivina(Gachapon g, Tiradas t, Imagenes img) {
        super(g, true);
        setTitle("Haz doble click para escoger un arma");
        setLayout(new FlowLayout());

        arma1 = new JLabel(img.armas[17]);
        arma1.setVisible(true);
        arma1.addMouseListener(mouse);
        add(arma1);

        arma2 = new JLabel(img.armas[18]);
        arma2.setVisible(true);
        arma2.addMouseListener(mouse);
        add(arma2);

        SendaDivina.t = t;
    }

    private class Mouse extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                if (SendaDivina.t.senda != 0 && SendaDivina.t.puntossenda > 0) {
                    if (JOptionPane.showConfirmDialog(null,
                            "Si cambias el arma, la senda divina volverá a 0. ¿Estás seguro que quieres cambiar?",
                            "Reset de senda divina", JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION) {
                        if (e.getSource() == arma1) {
                            SendaDivina.t.senda = 1;
                            SendaDivina.t.puntossenda = 0;
                        } else {
                            SendaDivina.t.senda = 2;
                            SendaDivina.t.puntossenda = 0;
                        }
                    }
                } else {
                    if (e.getSource() == arma1) {
                        SendaDivina.t.senda = 1;
                    } else {
                        SendaDivina.t.senda = 2;
                    }
                }
                dispose();
            }
        }
    }
}