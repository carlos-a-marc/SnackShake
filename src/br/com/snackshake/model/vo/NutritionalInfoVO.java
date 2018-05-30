
package br.com.snackshake.model.vo;

/**
 *
 * @author Carlos
 */
public class NutritionalInfoVO {
    private int calorias;
    private int carbohidratos;
    private int proteinas;
    private int gorduras;
    private int sodio;

    public NutritionalInfoVO(int calorias, int carbohidratos, int proteinas, int gorduras, int sodio) {
        this.calorias = calorias;
        this.carbohidratos = carbohidratos;
        this.proteinas = proteinas;
        this.gorduras = gorduras;
        this.sodio = sodio;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public int getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(int carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public int getProteinas() {
        return proteinas;
    }

    public void setProteinas(int proteinas) {
        this.proteinas = proteinas;
    }

    public int getGorduras() {
        return gorduras;
    }

    public void setGorduras(int gorduras) {
        this.gorduras = gorduras;
    }

    public int getSodio() {
        return sodio;
    }

    public void setSodio(int sodio) {
        this.sodio = sodio;
    } 
}
