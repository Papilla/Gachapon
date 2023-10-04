package gacha;

public class Tiradas {

    int tiradapersonaje, tiradaarma, tiradaperma, maximo, contadorpersonaje4, contadorarma4, contadorperma4,
            randompersonaje, randomarma, randomperma, senda = 0, puntossenda;
    double probabilidad5, probabilidad4, random5, random4;
    boolean aseguradopersonaje5 = false, aseguradopersonaje4 = false, aseguradoarma5 = false, aseguradoarma4 = false,
            nuevo = true, obligatorio;
    private int[] recordar, imagenespersonaje, imagenesarma;
    String[] nombre = new String[Gachapon.labels.length];
    int aux;

    // sabe en que tirada salió el 3*, 4* y 5*
    public void setRecordar(int[] recordar) {
        this.recordar = recordar;
    }

    public int[] getRecordar() {
        return recordar;
    }

    public void setImagenespersonaje(int[] imagenespersonaje) {
        this.imagenespersonaje = imagenespersonaje;
    }

    public int[] getImagenespersonaje() {
        return imagenespersonaje;
    }

    public void setImagenesarma(int[] imagenesarma) {
        this.imagenesarma = imagenesarma;
    }

    public int[] getImagenesarma() {
        return imagenesarma;
    }

    public void guardar(String nombre, boolean bandera) {

        for (int i = 0; i < this.nombre.length; i++) {
            if (this.nombre[i].equals("")) {
                this.nombre[i] = nombre;
                aux = i;
                i = this.nombre.length;
            } else {
                for (int j = 0; j < this.nombre.length; j++) {
                    if (this.nombre[j].equals("")) {
                        j = this.nombre.length;
                    } else if (this.nombre[j].startsWith(nombre)) {
                        aux = j;
                        i = this.nombre.length;
                        j = this.nombre.length;
                    }
                }
            }
        }

        if (!Gachapon.repetido.isEmpty()) {
            try {
                if (Gachapon.repetido.get(this.nombre[aux]) >= 0) {
                    Gachapon.repetido.replace(nombre, Gachapon.repetido.get(nombre), Gachapon.repetido.get(nombre) + 1);
                } else {
                    Gachapon.repetido.put(nombre, 0);
                    Gachapon.personaje.put(nombre, bandera);
                }
            } catch (NullPointerException ex) {
                Gachapon.repetido.put(nombre, 0);
                Gachapon.personaje.put(nombre, bandera);
            }
        } else {
            Gachapon.repetido.put(nombre, 0);
            Gachapon.personaje.put(nombre, bandera);
        }
    }

    public void tirar(int repetir, int banner) {
        int[] recordar = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
        int[] imagenespersonaje = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
        int[] imagenesarma = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
        setRecordar(recordar);
        setImagenespersonaje(imagenespersonaje);
        setImagenesarma(imagenesarma);
        maximo = 0;

        for (int i = 0; i < repetir; i++) {

            random5 = Math.random() * 100;
            random4 = Math.random() * 100;

            // BANNER DE PERSONAJES
            if (banner == 0 || banner == 1) {
                tiradapersonaje++;
                contadorpersonaje4++;

                if (contadorpersonaje4 == 0) {
                    probabilidad4 = 5.1;
                }

                if (tiradapersonaje == 0) {
                    probabilidad5 = 0.6;

                } else {

                    if (tiradapersonaje == 76) {
                        probabilidad5 = 20.627;
                    } else if (tiradapersonaje == 77) {
                        probabilidad5 = 22.946;
                    } else if (tiradapersonaje == 78) {
                        probabilidad5 = 24.429;
                    } else if (tiradapersonaje == 79) {
                        probabilidad5 = 26.375;
                    } else if (tiradapersonaje == 80) {
                        probabilidad5 = 28.306;
                    } else if (tiradapersonaje == 81) {
                        probabilidad5 = 30.914;
                    } else if (tiradapersonaje == 82) {
                        probabilidad5 = 32.970;
                    } else if (tiradapersonaje == 83) {
                        probabilidad5 = 34.332;
                    } else if (tiradapersonaje == 84) {
                        probabilidad5 = 36.901;
                    } else if (tiradapersonaje == 85) {
                        probabilidad5 = 38.608;
                    } else if (tiradapersonaje == 86) {
                        probabilidad5 = 40.411;
                    } else if (tiradapersonaje == 87) {
                        probabilidad5 = 42.278;
                    } else if (tiradapersonaje == 88) {
                        probabilidad5 = 44.187;
                    } else if (tiradapersonaje == 89) {
                        probabilidad5 = 46.126;
                    } else {
                        probabilidad5 = 0.6 - (0.004 * tiradapersonaje);
                    }

                    probabilidad4 = 5.1 + (2.55 * contadorpersonaje4);
                }

                // sacar 5 estrellas
                if (probabilidad5 > random5 || tiradapersonaje >= 90) {
                    if (repetir == 1) {
                        maximo = 3;
                    } else {
                        maximo = 4;
                    }
                    recordar[i] = 2;
                    tiradapersonaje = 0;

                    randompersonaje = (int) (Math.random() * 2 + 1);

                    if (randompersonaje == 2 || aseguradopersonaje5) {

                        if (banner == 0) {
                            imagenespersonaje[i] = 0;
                            guardar("Nahida", true);
                        } else {
                            imagenespersonaje[i] = 1;
                            guardar("Yoimiya", true);
                        }

                        aseguradopersonaje5 = false;

                    } else {
                        randompersonaje = (int) (Math.random() * 7 + 1);

                        if (randompersonaje == 1) {
                            imagenespersonaje[i] = 5;
                            guardar("Diluc", true);
                        } else if (randompersonaje == 2) {
                            imagenespersonaje[i] = 6;
                            guardar("Jean", true);
                        } else if (randompersonaje == 3) {
                            imagenespersonaje[i] = 7;
                            guardar("Keching", true);
                        } else if (randompersonaje == 4) {
                            imagenespersonaje[i] = 8;
                            guardar("Qiqi", true);
                        } else if (randompersonaje == 5) {
                            imagenespersonaje[i] = 9;
                            guardar("Mona", true);
                        } else if (randompersonaje == 6) {
                            imagenespersonaje[i] = 10;
                            guardar("Tignari", true);
                        } else if (randompersonaje == 7) {
                            imagenespersonaje[i] = 11;
                            guardar("Dehya", true);
                        }

                        aseguradopersonaje5 = true;
                    }

                    // sacar 4 estrellas
                } else if (probabilidad4 > random4 || contadorpersonaje4 >= 10) {

                    recordar[i] = 1;
                    if (maximo < 3) {
                        if (repetir == 1) {
                            maximo = 1;
                        } else {
                            maximo = 2;
                        }
                    }
                    contadorpersonaje4 = 0;

                    randompersonaje = (int) (Math.random() * 100 + 1);

                    if (randompersonaje > 50 || aseguradopersonaje4) {
                        randompersonaje = (int) (Math.random() * 3 + 1);

                        if (randompersonaje == 1) {
                            imagenespersonaje[i] = 2;
                        } else if (randompersonaje == 2) {
                            imagenespersonaje[i] = 3;
                        } else {
                            imagenespersonaje[i] = 4;
                        }

                        aseguradopersonaje4 = false;

                    } else {
                        randompersonaje = (int) (Math.random() * 5 + 1);

                        if (randompersonaje == 1) {
                            imagenesarma[i] = 2;
                        } else if (randompersonaje == 2) {
                            imagenesarma[i] = 3;
                        } else if (randompersonaje == 3) {
                            imagenesarma[i] = 4;
                        } else if (randompersonaje == 4) {
                            imagenesarma[i] = 5;
                        } else if (randompersonaje == 5) {
                            imagenesarma[i] = 6;
                        }

                        aseguradopersonaje4 = true;
                    }

                } else {
                    recordar[i] = 0;
                    if (maximo < 1) {
                        maximo = 0;
                    }
                }

                // BANNER DE ARMAS
            } else if (banner == 2) {
                tiradaarma++;
                contadorarma4++;

                if (contadorarma4 == 0) {
                    probabilidad4 = 6;
                }

                if (tiradaarma == 0) {
                    probabilidad5 = 0.7;

                } else {

                    if (tiradaarma == 66) {
                        probabilidad5 = 20.627;
                    } else if (tiradaarma == 67) {
                        probabilidad5 = 22.946;
                    } else if (tiradaarma == 68) {
                        probabilidad5 = 24.429;
                    } else if (tiradaarma == 69) {
                        probabilidad5 = 26.375;
                    } else if (tiradaarma == 70) {
                        probabilidad5 = 28.306;
                    } else if (tiradaarma == 71) {
                        probabilidad5 = 30.914;
                    } else if (tiradaarma == 72) {
                        probabilidad5 = 32.970;
                    } else if (tiradaarma == 73) {
                        probabilidad5 = 34.332;
                    } else if (tiradaarma == 74) {
                        probabilidad5 = 36.901;
                    } else if (tiradaarma == 75) {
                        probabilidad5 = 38.608;
                    } else if (tiradaarma == 76) {
                        probabilidad5 = 40.411;
                    } else if (tiradaarma == 77) {
                        probabilidad5 = 42.278;
                    } else if (tiradaarma == 78) {
                        probabilidad5 = 44.187;
                    } else if (tiradaarma == 79) {
                        probabilidad5 = 46.126;
                    } else {
                        probabilidad5 = 0.7 - (0.005 * tiradaarma);
                    }

                    probabilidad4 = 6 + (3 * contadorarma4);
                }

                // sacar 5 estrellas
                if (probabilidad5 > random5 || tiradaarma >= 80) {
                    if (repetir == 1) {
                        maximo = 3;
                    } else {
                        maximo = 4;
                    }
                    recordar[i] = 2;
                    tiradaarma = 0;

                    randomarma = (int) (Math.random() * 100 + 1);

                    if (randomarma <= 75 || aseguradoarma5 || puntossenda == 2) {
                        randomarma = (int) (Math.random() * 2 + 1);

                        if (puntossenda == 2) {
                            obligatorio = true;
                        } else {
                            obligatorio = false;
                        }

                        if (obligatorio) {
                            if (senda == 1) {
                                imagenesarma[i] = 0;
                                guardar("Sueños de las mil noches", false);
                                if (senda == 1) {
                                    puntossenda = 0;
                                } else if (senda == 2) {
                                    puntossenda++;
                                }
                            } else {
                                imagenesarma[i] = 1;
                                guardar("Agitador del Relámpago", false);
                                if (senda == 2) {
                                    puntossenda = 0;
                                } else if (senda == 1) {
                                    puntossenda++;
                                }
                            }
                        } else {
                            if (randomarma == 1) {
                                imagenesarma[i] = 0;
                                guardar("Sueños de las mil noches", false);
                                if (senda == 1) {
                                    puntossenda = 0;
                                } else if (senda == 2) {
                                    puntossenda++;
                                }
                            } else {
                                imagenesarma[i] = 1;
                                guardar("Agitador del Relámpago", false);
                                if (senda == 2) {
                                    puntossenda = 0;
                                } else if (senda == 1) {
                                    puntossenda++;
                                }
                            }
                        }

                        aseguradoarma5 = false;

                    } else {
                        randomarma = (int) (Math.random() * 10 + 1);

                        if (randomarma == 1) {
                            imagenesarma[i] = 7;
                            guardar("Alas celestiales", false);
                        } else if (randomarma == 2) {
                            imagenesarma[i] = 8;
                            guardar("Aquila favonia", false);
                        } else if (randomarma == 3) {
                            imagenesarma[i] = 9;
                            guardar("Arco de amos", false);
                        } else if (randomarma == 4) {
                            imagenesarma[i] = 10;
                            guardar("Halcón de jade", false);
                        } else if (randomarma == 5) {
                            imagenesarma[i] = 11;
                            guardar("Hoja afilada celestial", false);
                        } else if (randomarma == 6) {
                            imagenesarma[i] = 12;
                            guardar("Lápida del lobo", false);
                        } else if (randomarma == 7) {
                            imagenesarma[i] = 13;
                            guardar("Oración perdida", false);
                        } else if (randomarma == 8) {
                            imagenesarma[i] = 14;
                            guardar("Orgullo celestial", false);
                        } else if (randomarma == 9) {
                            imagenesarma[i] = 15;
                            guardar("Pergamino celestial", false);
                        } else if (randomarma == 10) {
                            imagenesarma[i] = 16;
                            guardar("Púa celestial", false);
                        }
                        puntossenda++;

                        aseguradoarma5 = true;
                    }

                    // sacar 4 estrellas
                } else if (probabilidad4 > random4 || contadorarma4 >= 10) {

                    recordar[i] = 1;
                    if (maximo < 3) {
                        if (repetir == 1) {
                            maximo = 1;
                        } else {
                            maximo = 2;
                        }
                    }
                    contadorarma4 = 0;

                    randomarma = (int) (Math.random() * 10 + 1);

                    if (randomarma > 5 || aseguradoarma4) {
                        randomarma = (int) (Math.random() * 5 + 1);

                        if (randomarma == 1) {
                            imagenesarma[i] = 2;
                        } else if (randomarma == 2) {
                            imagenesarma[i] = 3;
                        } else if (randomarma == 3) {
                            imagenesarma[i] = 4;
                        } else if (randomarma == 4) {
                            imagenesarma[i] = 5;
                        } else if (randomarma == 5) {
                            imagenesarma[i] = 6;
                        }

                        aseguradoarma4 = false;

                    } else {
                        randomarma = (int) (Math.random() * 3 + 1);

                        if (randomarma == 1) {
                            imagenespersonaje[i] = 2;
                        } else if (randomarma == 2) {
                            imagenespersonaje[i] = 3;
                        } else if (randomarma == 3) {
                            imagenespersonaje[i] = 4;
                        }

                        aseguradoarma4 = true;
                    }

                } else {
                    recordar[i] = 0;
                    if (maximo < 1) {
                        maximo = 0;
                    }
                }

                // BANNER PERMANENTE
            } else if (banner == 3) {
                tiradaperma++;
                contadorperma4++;

                if (contadorperma4 == 0) {
                    probabilidad4 = 5.1;
                }

                if (tiradaperma == 0) {
                    probabilidad5 = 0.6;

                } else {

                    if (tiradaperma == 76) {
                        probabilidad5 = 20.627;
                    } else if (tiradaperma == 77) {
                        probabilidad5 = 22.946;
                    } else if (tiradaperma == 78) {
                        probabilidad5 = 24.429;
                    } else if (tiradaperma == 79) {
                        probabilidad5 = 26.375;
                    } else if (tiradaperma == 80) {
                        probabilidad5 = 28.306;
                    } else if (tiradaperma == 81) {
                        probabilidad5 = 30.914;
                    } else if (tiradaperma == 82) {
                        probabilidad5 = 32.970;
                    } else if (tiradaperma == 83) {
                        probabilidad5 = 34.332;
                    } else if (tiradaperma == 84) {
                        probabilidad5 = 36.901;
                    } else if (tiradaperma == 85) {
                        probabilidad5 = 38.608;
                    } else if (tiradaperma == 86) {
                        probabilidad5 = 40.411;
                    } else if (tiradaperma == 87) {
                        probabilidad5 = 42.278;
                    } else if (tiradaperma == 88) {
                        probabilidad5 = 44.187;
                    } else if (tiradaperma == 89) {
                        probabilidad5 = 46.126;
                    } else {
                        probabilidad5 = 0.6 - (0.004 * tiradaperma);
                    }

                    probabilidad4 = 5.1 + (2.55 * contadorperma4);
                }

                // sacar 5 estrellas
                if (probabilidad5 > random5 || tiradaperma >= 90) {
                    recordar[i] = 2;
                    if (repetir == 1) {
                        maximo = 3;
                    } else {
                        maximo = 4;
                    }
                    tiradaperma = 0;

                    randomperma = (int) (Math.random() * 17 + 1);

                    if (randomperma == 1) {
                        imagenespersonaje[i] = 5;
                        guardar("Diluc", true);
                    } else if (randomperma == 2) {
                        imagenespersonaje[i] = 6;
                        guardar("Jean", true);
                    } else if (randomperma == 3) {
                        imagenespersonaje[i] = 7;
                        guardar("Keching", true);
                    } else if (randomperma == 4) {
                        imagenespersonaje[i] = 8;
                        guardar("Qiqi", true);
                    } else if (randomperma == 5) {
                        imagenespersonaje[i] = 9;
                        guardar("Mona", true);
                    } else if (randomperma == 6) {
                        imagenespersonaje[i] = 10;
                        guardar("Tignari", true);
                    } else if (randomperma == 7) {
                        imagenespersonaje[i] = 11;
                        guardar("Dehya", true);
                    } else if (randomperma == 8) {
                        imagenesarma[i] = 7;
                        guardar("Alas celestiales", false);
                    } else if (randomperma == 9) {
                        imagenesarma[i] = 8;
                        guardar("Aquila favonia", false);
                    } else if (randomperma == 10) {
                        imagenesarma[i] = 9;
                        guardar("Arco de amos", false);
                    } else if (randomperma == 11) {
                        imagenesarma[i] = 10;
                        guardar("Halcón de jade", false);
                    } else if (randomperma == 12) {
                        imagenesarma[i] = 11;
                        guardar("Hoja afilada celestial", false);
                    } else if (randomperma == 13) {
                        imagenesarma[i] = 12;
                        guardar("Lápida del lobo", false);
                    } else if (randomperma == 14) {
                        imagenesarma[i] = 13;
                        guardar("Oración perdida", false);
                    } else if (randomperma == 15) {
                        imagenesarma[i] = 14;
                        guardar("Orgullo celestial", false);
                    } else if (randomperma == 16) {
                        imagenesarma[i] = 15;
                        guardar("Pergamino celestial", false);
                    } else if (randomperma == 17) {
                        imagenesarma[i] = 16;
                        guardar("Púa celestial", false);
                    }

                    // sacar 4 estrellas
                } else if (probabilidad4 > random4 || contadorperma4 >= 10) {

                    recordar[i] = 1;
                    if (maximo < 3) {
                        if (repetir == 1) {
                            maximo = 1;
                        } else {
                            maximo = 2;
                        }
                    }
                    contadorperma4 = 0;

                    randomperma = (int) (Math.random() * 8 + 1);

                    if (randomperma == 1) {
                        imagenespersonaje[i] = 2;
                    } else if (randomperma == 2) {
                        imagenespersonaje[i] = 3;
                    } else if (randomperma == 3) {
                        imagenespersonaje[i] = 4;
                    } else if (randomperma == 4) {
                        imagenesarma[i] = 2;
                    } else if (randomperma == 5) {
                        imagenesarma[i] = 3;
                    } else if (randomperma == 6) {
                        imagenesarma[i] = 4;
                    } else if (randomperma == 7) {
                        imagenesarma[i] = 5;
                    } else if (randomperma == 8) {
                        imagenesarma[i] = 6;
                    }

                } else {
                    recordar[i] = 0;
                    if (maximo < 1) {
                        maximo = 0;
                    }
                }
            }
        }
    }
}