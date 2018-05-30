
package br.com.snackshake.model.vo;

/**
 *
 * @author Carlos
 */
public class ProdutoVO {
    private String codigo;
    private String nome;
    private String imagem;
    private String descricao;
    private String sabor;
    private double preco;
    private NutritionalInfoVO infoNutricional;

    public ProdutoVO(String codigo, String nome, String imagem, String descricao, String sabor, double preco, NutritionalInfoVO infoNutricional) {
        this.codigo = codigo;
        this.nome = nome;
        this.imagem = imagem;
        this.descricao = descricao;
        this.sabor = sabor;
        this.preco = preco;
        this.infoNutricional = infoNutricional;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public NutritionalInfoVO getInfoNutricional() {
        return infoNutricional;
    }

    public void setInfoNutricional(NutritionalInfoVO infoNutricional) {
        this.infoNutricional = infoNutricional;
    }
    
}
