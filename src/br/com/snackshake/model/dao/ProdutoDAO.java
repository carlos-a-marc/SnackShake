package br.com.snackshake.model.dao;

import br.com.snackshake.model.db.ProdutosDB;
import br.com.snackshake.model.vo.ProdutoVO;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class ProdutoDAO {

    public ArrayList<ProdutoVO> lerProdutos() {
        return new ProdutosDB().criaProdutos();
    }

    public void inserirProduto(ProdutoVO produto) {
        ProdutosDB.produtos.add(produto);
    }

    public void atualizarProduto(ProdutoVO produto) {
        int index = ProdutosDB.produtos.indexOf(produto);
        ProdutosDB.produtos.get(index).setCodigo(produto.getCodigo());
        ProdutosDB.produtos.get(index).setNome(produto.getNome());
        ProdutosDB.produtos.get(index).setImagem(produto.getImagem());
        ProdutosDB.produtos.get(index).setDescricao(produto.getDescricao());
        ProdutosDB.produtos.get(index).setSabor(produto.getSabor());
        ProdutosDB.produtos.get(index).setPreco(produto.getPreco());
    }

    public void deletarProduto(ProdutoVO produto) {
        ProdutosDB.produtos.remove(produto);
    }
}
