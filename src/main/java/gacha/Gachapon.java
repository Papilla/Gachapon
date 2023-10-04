package gacha;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Gachapon extends JFrame implements ActionListener {

    Tiradas t = new Tiradas();
    Imagenes imagenes = new Imagenes();
    static Map<String, Integer> repetido = new HashMap<>();
    static Map<String, Boolean> personaje = new HashMap<>();
    File f = new File(System.getProperty("user.home") + "/gachapon.txt");
    JButton personaje1, personaje2, arma, permanente, bannerchiquito, deseo1, deseo10, deseos, reset, sendadivina;
    JLabel bannergordo, historial, senda;
    static JLabel[] labels = new JLabel[21];
    ImageIcon[] banner, deseo;
    int tirar, escoger, aux = 35;
    String nombre;
    String[] nombres = new String[] { "Nahida", "Yoimiya", "Bennett", "Razor", "Noelle", "Diluc", "Jean", "Keching",
            "Mona", "Qiqi", "Tignari", "Dehya" };

    public Gachapon() {
        super("Gachapón");
        this.setLayout(null);
        addWindowListener(new CierreVentana());
        this.getContentPane().setFocusable(true);

        // crea el archivo si no existe
        if (!f.exists()) {
            try (PrintWriter w = new PrintWriter(new FileWriter(f, false))) {
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }

        // comprueba el numero de tiradas
        try (Scanner s = new Scanner(f)) {
            while (s.hasNextLine()) {
                t.tiradapersonaje = Integer.parseInt(String.format("%s", s.nextLine()));
                t.aseguradopersonaje5 = Boolean.parseBoolean(String.format("%s", s.nextLine()));
                t.contadorpersonaje4 = Integer.parseInt(String.format("%s", s.nextLine()));
                t.aseguradopersonaje4 = Boolean.parseBoolean(String.format("%s", s.nextLine()));
                t.tiradaarma = Integer.parseInt(String.format("%s", s.nextLine()));
                t.aseguradoarma5 = Boolean.parseBoolean(String.format("%s", s.nextLine()));
                t.contadorarma4 = Integer.parseInt(String.format("%s", s.nextLine()));
                t.aseguradoarma4 = Boolean.parseBoolean(String.format("%s", s.nextLine()));
                t.senda = Integer.parseInt(String.format("%s", s.nextLine()));
                t.puntossenda = Integer.parseInt(String.format("%s", s.nextLine()));
                t.tiradaperma = Integer.parseInt(String.format("%s", s.nextLine()));
                t.contadorperma4 = Integer.parseInt(String.format("%s", s.nextLine()));
                escoger = Integer.parseInt(String.format("%s", s.nextLine()));
                for (int i = 0; i < labels.length; i++) {
                    if (s.hasNextLine()) {
                        labels[i] = new JLabel();
                        labels[i].setText(String.format("%s", s.nextLine()));
                        t.nombre[i] = labels[i].getText().substring(0, labels[i].getText().length() - 3);
                        repetido.put(t.nombre[i], Integer.parseInt(String.format("%s", s.nextLine())));
                        for (int j = 0; j < nombres.length; j++) {
                            if (nombres[j].contains(t.nombre[i])) {
                                personaje.put(t.nombre[i], nombres[j].contains(t.nombre[i]));
                                j = nombres.length;
                            }
                        }

                    } else {
                        i = labels.length;
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        for (int i = 0; i < imagenes.personajeschiquitos.length; i++) {
            int aux = 350;
            bannerchiquito = new JButton();
            bannerchiquito.setIcon(imagenes.personajeschiquitos[i]);
            bannerchiquito.setContentAreaFilled(false);
            bannerchiquito.setBorderPainted(false);
            bannerchiquito.setSize(bannerchiquito.getPreferredSize());
            bannerchiquito.setLocation(370 + (aux * i), 5);
            bannerchiquito.setVisible(true);
            bannerchiquito.addActionListener(this);
            add(bannerchiquito);
            if (i == 0) {
                personaje1 = bannerchiquito;
            } else if (i == 1) {
                personaje2 = bannerchiquito;
            } else if (i == 2) {
                arma = bannerchiquito;
            } else if (i == 3) {
                permanente = bannerchiquito;
            }
        }

        for (int i = 0; i < t.nombre.length; i++) {
            if (t.nombre[i] == null) {
                t.nombre[i] = "";
            }
        }

        deseo1 = new JButton("Tirar deseo x1");
        deseo1.addActionListener(this);
        deseo1.setSize(125, 30);
        deseo1.setLocation(1600, 950);
        deseo1.setVisible(true);
        add(deseo1);

        deseo10 = new JButton("Tirar deseo x10");
        deseo10.addActionListener(this);
        deseo10.setSize(125, 30);
        deseo10.setLocation(1750, 950);
        deseo10.setVisible(true);
        add(deseo10);

        bannergordo = new JLabel();
        bannergordo.setIcon(imagenes.banner[escoger]);
        bannergordo.setSize(bannergordo.getPreferredSize());
        bannergordo.setLocation(imagenes.banner[3] == bannergordo.getIcon() ? 300 : 250, 150);
        bannergordo.setVisible(true);
        add(bannergordo);

        deseos = new JButton("\u221E",
                imagenes.banner[3] == bannergordo.getIcon() ? imagenes.deseo[1] : imagenes.deseo[0]);
        deseos.setFont(new Font("Arial", 10, 30));
        deseos.setSize(deseos.getPreferredSize());
        deseos.setLocation(1800, 10);
        deseos.setBorderPainted(false);
        deseos.setFocusable(false);
        deseos.setContentAreaFilled(false);
        add(deseos);

        reset = new JButton("Resetear");
        reset.setLocation(20, 55);
        reset.setSize(90, 26);
        reset.addActionListener(this);
        reset.setVisible(true);
        add(reset);

        sendadivina = new JButton(imagenes.senda[t.puntossenda]);
        sendadivina.setLocation(20, 825);
        sendadivina.setBorderPainted(false);
        sendadivina.setContentAreaFilled(false);
        sendadivina.setSize(sendadivina.getPreferredSize());
        sendadivina.addActionListener(this);
        sendadivina.setVisible(escoger == 2 ? true : false);
        add(sendadivina);

        senda = new JLabel(t.senda == 0 ? "No se ha seleccionado ningún arma"
                : "Seleccionado: " + (t.senda == 1 ? "Sueños de las mil noches" : "Agitador del relámpago"));
        senda.setFont(new Font("Arial", 10, 20));
        senda.setLocation(20, 1000);
        senda.setSize(500, 50);
        senda.setVisible(escoger == 2 ? true : false);
        add(senda);

        for (int i = 0; i <= 20; i++) {
            if (labels[i] == null) {
                labels[i] = new JLabel();
            }
            labels[i].setFont(new Font("Arial", 10, 17));
            labels[i].setSize(300, 30);
            labels[i].setLocation(20, 75 + aux);
            labels[i].setVisible(true);
            add(labels[i]);
            aux += 35;
        }

        historial = new JLabel(String.format("Pity: %d / %d",
                escoger == 0 || escoger == 1 ? t.tiradapersonaje : escoger == 2 ? t.tiradaarma : t.tiradaperma,
                escoger == 2 ? 80 : 90));
        historial.setFont(new Font("Arial", 20, 20));
        historial.setSize(historial.getPreferredSize());
        historial.setLocation(20, 20);
        add(historial);
    }

    // selecciona el banner por el que va a tirar
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == personaje1) {
                bannergordo.setIcon(imagenes.banner[0]);
                bannergordo.setLocation(imagenes.banner[3] == bannergordo.getIcon() ? 150 : 250, 175);
                bannergordo.setSize(bannergordo.getPreferredSize());
                deseos.setIcon(imagenes.deseo[0]);
                senda.setVisible(false);
                sendadivina.setVisible(false);
                escoger = 0;

            } else if (e.getSource() == personaje2) {
                bannergordo.setIcon(imagenes.banner[1]);
                bannergordo.setLocation(imagenes.banner[3] == bannergordo.getIcon() ? 150 : 250, 175);
                bannergordo.setSize(bannergordo.getPreferredSize());
                deseos.setIcon(imagenes.deseo[0]);
                senda.setVisible(false);
                sendadivina.setVisible(false);
                escoger = 1;

            } else if (e.getSource() == arma) {
                bannergordo.setIcon(imagenes.banner[2]);
                bannergordo.setLocation(imagenes.banner[3] == bannergordo.getIcon() ? 150 : 250, 175);
                bannergordo.setSize(bannergordo.getPreferredSize());
                deseos.setIcon(imagenes.deseo[0]);
                senda.setVisible(true);
                sendadivina.setVisible(true);
                escoger = 2;

            } else if (e.getSource() == permanente) {
                bannergordo.setIcon(imagenes.banner[3]);
                bannergordo.setLocation(300, 150);
                bannergordo.setSize(bannergordo.getPreferredSize());
                deseos.setIcon(imagenes.deseo[1]);
                senda.setVisible(false);
                sendadivina.setVisible(false);
                escoger = 3;
            }

            if (e.getSource() == deseo1 || e.getSource() == deseo10) {

                Animaciones a = new Animaciones(this, t, imagenes, e.getSource() == deseo1 ? 1 : 10, escoger);
                a.setSize(700, 400);
                a.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                a.setResizable(false);
                a.setLocationRelativeTo(this);
                a.setVisible(true);
                // t.tirar(e.getSource() == deseo1 ? 1 : 10, escoger);

                for (int i = 0; i < repetido.size(); i++) {
                    nombre = t.nombre[i];
                    labels[i].setText(String.format("%s %s%d", nombre, personaje.get(nombre) ? "C" : "R",
                            personaje.get(nombre) ? repetido.get(nombre) <= 6 ? repetido.get(nombre) : 6
                                    : repetido.get(nombre) + 1 <= 5 ? repetido.get(nombre) + 1 : 5));
                    Gachapon.labels[i].setSize(Gachapon.labels[i].getPreferredSize());
                }
            }

            if (e.getSource() == sendadivina) {
                SendaDivina s = new SendaDivina(this, t, imagenes);
                s.setSize(700, 400);
                s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                s.setResizable(false);
                s.setLocationRelativeTo(this);
                s.setVisible(true);

                senda.setText(t.senda == 0 ? "No se ha seleccionado ningún arma"
                        : "Seleccionado: " + (t.senda == 1 ? "Sueños de las mil noches" : "Agitador del relámpago"));
                sendadivina.setIcon(imagenes.senda[t.puntossenda]);
            }

            if (e.getSource() == reset) {
                if (JOptionPane.showConfirmDialog(null, "Se reseteará todo tu progreso", "Reset",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                    t.tiradapersonaje = 0;
                    t.tiradaarma = 0;
                    t.tiradaperma = 0;
                    t.contadorpersonaje4 = 0;
                    t.contadorarma4 = 0;
                    t.contadorperma4 = 0;
                    t.aseguradopersonaje5 = false;
                    t.aseguradopersonaje4 = false;
                    t.aseguradoarma5 = false;
                    t.aseguradoarma4 = false;
                    t.nuevo = true;
                    t.senda = 0;
                    t.puntossenda = 0;

                    senda.setText(t.senda == 0 ? "No se ha seleccionado ningún arma"
                            : "Seleccionado: "
                                    + (t.senda == 1 ? "Sueños de las mil noches" : "Agitador del relámpago"));

                    sendadivina.setIcon(imagenes.senda[t.puntossenda]);

                    repetido.clear();
                    personaje.clear();

                    for (int i = 0; i < labels.length; i++) {
                        labels[i].setText("");
                        t.nombre[i] = "";
                    }
                }
            }

            historial.setText(String.format("Pity: %d / %d",
                    escoger == 0 || escoger == 1 ? t.tiradapersonaje : escoger == 2 ? t.tiradaarma : t.tiradaperma,
                    escoger == 2 ? 80 : 90));
            historial.setSize(historial.getPreferredSize());
            sendadivina.setIcon(imagenes.senda[t.puntossenda]);

        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, el programa se cerrará");
            f.delete();
            dispose();
        }
    }

    // cierra la aplicacion y guarda los datos
    class CierreVentana extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            int res = JOptionPane.showConfirmDialog(null, "Deseas cerrar el programa?", "Genshin Impacto",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (res == JOptionPane.OK_OPTION) {
                try {
                    f.setWritable(true, false);
                    f.setReadable(true, false);
                } catch (SecurityException ex) {
                    System.out.println("No se han podido cambiar los valores del archivo");
                }
                try (PrintWriter w = new PrintWriter(new FileWriter(f, false))) {
                    w.println(String.format("%d", t.tiradapersonaje));
                    w.println(String.format("%s", t.aseguradopersonaje5));
                    w.println(String.format("%d", t.contadorpersonaje4));
                    w.println(String.format("%s", t.aseguradopersonaje4));
                    w.println(String.format("%d", t.tiradaarma));
                    w.println(String.format("%s", t.aseguradoarma5));
                    w.println(String.format("%d", t.contadorarma4));
                    w.println(String.format("%s", t.aseguradoarma4));
                    w.println(String.format("%d", t.senda));
                    w.println(String.format("%d", t.puntossenda));
                    w.println(String.format("%d", t.tiradaperma));
                    w.println(String.format("%d", t.contadorperma4));
                    w.println(String.format("%d", escoger));

                    for (int i = 0; i < labels.length; i++) {
                        if (!labels[i].getText().equals("")) {
                            w.println(String.format("%s", labels[i].getText()));
                            w.println(String.format("%d", repetido.get(t.nombre[i])));
                        } else {
                            i = labels.length;
                        }
                    }
                    w.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                try {
                    f.setWritable(false, false);
                    f.setReadable(false, false);
                } catch (SecurityException ex) {
                    System.out.println("No se han podido cambiar los valores del archivo");
                }
                e.getWindow().dispose();
            }
        }
    }
}