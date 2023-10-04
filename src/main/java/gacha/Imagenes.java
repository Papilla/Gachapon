package gacha;

import javax.swing.ImageIcon;

public class Imagenes {
        ImageIcon[] personajes, armas, gifs, estrella, senda, personajeschiquitos, banner, deseo;

        public Imagenes() {

                estrella = new ImageIcon[] { new ImageIcon((Gachapon.class.getResource("/img/borla_negra.png"))),
                                new ImageIcon(Gachapon.class.getResource("/img/dragones.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/espada.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/tirachinas.png")) };

                gifs = new ImageIcon[] { new ImageIcon(Gachapon.class.getResource("/img/3_estrellas.gif")),
                                new ImageIcon(Gachapon.class.getResource("/img/4_estrellas-1.gif")),
                                new ImageIcon(Gachapon.class.getResource("/img/4_estrellas-10.gif")),
                                new ImageIcon(Gachapon.class.getResource("/img/5_estrellas-1.gif")),
                                new ImageIcon(Gachapon.class.getResource("/img/5_estrellas-10.gif")) };

                personajes = new ImageIcon[] { new ImageIcon(Gachapon.class.getResource("/img/nahida.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/yoimiya.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/bennett.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/razor.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/noelle.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/diluc.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/jean.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/keching.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/qiqi.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/mona.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/tignari.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/dehya.png")) };

                armas = new ImageIcon[] {
                                new ImageIcon(Gachapon.class.getResource("/img/suenos_de_las_mil_noches.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/agitador_del_relampago.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/herrumbre.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/flauta.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/sinfonia_de_los_merodeadores.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/lanza_de_favonius.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/gran_espada_del_sacrificio.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/alas_celestiales.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/aquila_favonia.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/arco_de_amos.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/halcon_de_jade.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/hoja_afilada_celestial.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/lapida_del_lobo.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/oracion_perdida.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/orgullo_celestial.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/pergamino_celestial.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/pua_celestial.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/arma1.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/arma2.png")) };

                senda = new ImageIcon[] {
                                new ImageIcon(Gachapon.class.getResource("/img/senda0.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/senda1.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/senda2.png")) };

                personajeschiquitos = new ImageIcon[] {
                                new ImageIcon(Gachapon.class.getResource("/img/personaje1.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/personaje2.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/arma.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/permanente.png")) };

                banner = new ImageIcon[] { new ImageIcon(Gachapon.class.getResource("/img/bannerpersonaje1.jpg")),
                                new ImageIcon(Gachapon.class.getResource("/img/bannerpersonaje2.jpg")),
                                new ImageIcon(Gachapon.class.getResource("/img/bannerarma.jpg")),
                                new ImageIcon(Gachapon.class.getResource("/img/bannerpermanente.png")) };

                deseo = new ImageIcon[] { new ImageIcon(Gachapon.class.getResource("/img/deseopromo.png")),
                                new ImageIcon(Gachapon.class.getResource("/img/deseoperma.png")) };
        }
}