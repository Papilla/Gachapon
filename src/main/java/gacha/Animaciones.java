package gacha;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Animaciones extends JDialog {

    MouseListener mouse = new Mouse();
    ImageIcon[] personajes, armas, gifs, estrella;
    JButton skip;
    JLabel todo, gif;
    int cont = 0, i = 1;
    private Tiradas t;
    private int tirada, escoger;
    Imagenes img;

    public void setTirada(int tirada) {
        this.tirada = tirada;
    }

    public int getTirada() {
        return tirada;
    }

    public void setEscoger(int escoger) {
        this.escoger = escoger;
    }

    public int getEscoger() {
        return escoger;
    }

    public void setT(Tiradas t) {
        this.t = t;
    }

    public Tiradas getT() {
        return t;
    }

    Timer time = new Timer(6000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            time.stop();
            gif.setVisible(false);
            gif.setIcon(null);
            todo.setVisible(true);
            skip.setVisible(false);
            setTitle("Tiradas - " + i);
            getContentPane().setLayout(new FlowLayout());

            if (getT().getRecordar()[0] == 0) {
                todo.setIcon(img.estrella[(int) (Math.random() * 4)]);
                getContentPane().setBackground(new Color(135, 206, 234));
            } else if (getT().getRecordar()[0] == 1) {
                getContentPane().setBackground(new Color(201, 155, 203));
                if (getT().getImagenespersonaje()[0] == -1) {
                    todo.setIcon(img.armas[getT().getImagenesarma()[0]]);
                } else {
                    todo.setIcon(img.personajes[getT().getImagenespersonaje()[0]]);
                }
            } else {
                getContentPane().setBackground(new Color(253, 253, 150));
                if (t.getImagenespersonaje()[0] == -1) {
                    todo.setIcon(img.armas[getT().getImagenesarma()[0]]);
                } else {
                    todo.setIcon(img.personajes[getT().getImagenespersonaje()[0]]);
                }
            }
        }
    });

    public Animaciones(Gachapon g, Tiradas t, Imagenes img, int tirada, int escoger) {
        super(g, true);
        setLayout(null);
        setTitle("Tiradas");
        setT(t);
        setTirada(tirada);
        setEscoger(escoger);
        getT().tirar(getTirada(), getEscoger());
        setTirada(getTirada() - 1);
        getContentPane().addMouseListener(mouse);
        time.restart();
        time.setInitialDelay(0);
        this.img = img;

        todo = new JLabel();
        todo.setVisible(false);
        todo.addMouseListener(mouse);
        add(todo);

        gif = new JLabel(img.gifs[getT().maximo]);
        gif.setSize(gif.getPreferredSize());
        gif.setLocation(0, 0);
        gif.setVisible(true);
        add(gif);

        skip = new JButton("Saltar");
        skip.setFont(new Font("Fuente", 10, 20));
        skip.setForeground(Color.BLACK);
        skip.setSize(skip.getPreferredSize());
        skip.setLocation(590, 10);
        skip.addMouseListener(mouse);
        skip.setVisible(true);
        add(skip);

        time.start();
    }

    private class Mouse extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {

            if (e.getSource() == skip) {
                time.stop();
                gif.setVisible(false);
                gif.setIcon(null);
                todo.setVisible(true);
                skip.setVisible(false);
                setTitle("Tiradas - " + i);
                getContentPane().setLayout(new FlowLayout());

                if (getT().getRecordar()[0] == 0) {
                    todo.setIcon(img.estrella[(int) (Math.random() * 4)]);
                    getContentPane().setBackground(new Color(135, 206, 234));
                } else if (getT().getRecordar()[0] == 1) {
                    getContentPane().setBackground(new Color(201, 155, 203));
                    if (getT().getImagenespersonaje()[0] == -1) {
                        todo.setIcon(img.armas[getT().getImagenesarma()[0]]);
                    } else {
                        todo.setIcon(img.personajes[getT().getImagenespersonaje()[0]]);
                    }
                } else {
                    getContentPane().setBackground(new Color(253, 253, 150));
                    if (t.getImagenespersonaje()[0] == -1) {
                        todo.setIcon(img.armas[getT().getImagenesarma()[0]]);
                    } else {
                        todo.setIcon(img.personajes[getT().getImagenespersonaje()[0]]);
                    }
                }
            }

            if (!time.isRunning()) {
                if (e.getSource() == todo || e.getSource() == getContentPane()) {
                    if (getTirada() > 0) {
                        setTirada(getTirada() - 1);

                        if (getT().getRecordar()[i] == 0) {
                            todo.setIcon(img.estrella[(int) (Math.random() * 4)]);
                            getContentPane().setBackground(new Color(135, 206, 234));
                        } else if (getT().getRecordar()[i] == 1) {
                            getContentPane().setBackground(new Color(201, 155, 203));
                            if (getT().getImagenespersonaje()[i] == -1) {
                                todo.setIcon(img.armas[getT().getImagenesarma()[i]]);
                            } else {
                                todo.setIcon(img.personajes[getT().getImagenespersonaje()[i]]);
                            }
                        } else {
                            getContentPane().setBackground(new Color(253, 253, 150));
                            if (t.getImagenespersonaje()[i] == -1) {
                                todo.setIcon(img.armas[getT().getImagenesarma()[i]]);
                            } else {
                                todo.setIcon(img.personajes[getT().getImagenespersonaje()[i]]);
                            }
                        }
                        i++;
                        setTitle("Tiradas - " + i);
                    } else {
                        dispose();
                    }
                }
            }
        }
    }
}