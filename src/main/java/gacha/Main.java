package gacha;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Gachapon g = new Gachapon();
        g.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        g.setExtendedState(JFrame.MAXIMIZED_BOTH);
        g.setResizable(false);
        g.setVisible(true);
    }
}