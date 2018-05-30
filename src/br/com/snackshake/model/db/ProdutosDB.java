package br.com.snackshake.model.db;

import br.com.snackshake.model.vo.NutritionalInfoVO;
import br.com.snackshake.model.vo.ProdutoVO;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class ProdutosDB {

    public static ArrayList<ProdutoVO> produtos = new ArrayList<>();

    public ArrayList<ProdutoVO> criaProdutos() {

        ProdutoVO p1 = new ProdutoVO("0x000","Lorem ipsum dolor sit amet", "/br/com/snackshake/view/img/img1.png", "Pellentesque rhoncus, nulla a mattis o mi turpis vehicula risus, eget tempor leo tellus.", "Lorem", 3.99, new NutritionalInfoVO(420, 30, 6, 20, 172));
        ProdutoVO p2 = new ProdutoVO("0x001","Lorem ipsum dolor sit amet",  "/br/com/snackshake/view/img/img3.png", "Pellentesque rhoncus, nulla a mattis o mi turpis vehicula risus, eget tempor leo tellus.", "Lorem", 15.69, new NutritionalInfoVO(1000, 140, 6, 35, 300));
        ProdutoVO p3 = new ProdutoVO("0x002","Lorem ipsum dolor sit amet",  "/br/com/snackshake/view/img/img4.png", "Pellentesque rhoncus, nulla a mattis o mi turpis vehicula risus, eget tempor leo tellus.", "Lorem", 10.99, new NutritionalInfoVO(300, 40, 10, 10, 180));
        ProdutoVO p4 = new ProdutoVO("0x003","Lorem ipsum dolor sit amet",  "/br/com/snackshake/view/img/img6.png", "Pellentesque rhoncus, nulla a mattis o mi turpis vehicula risus, eget tempor leo tellus.", "Lorem", 1.99, new NutritionalInfoVO(150, 40, 2, 6, 180));
        ProdutoVO p5 = new ProdutoVO("0x004","Lorem ipsum dolor sit amet",  "/br/com/snackshake/view/img/img7.png", "Pellentesque rhoncus, nulla a mattis o mi turpis vehicula risus, eget tempor leo tellus.", "Lorem", 10.50, new NutritionalInfoVO(500, 80, 3, 15, 300));
        ProdutoVO p6 = new ProdutoVO("0x005","Lorem ipsum dolor sit amet",  "/br/com/snackshake/view/img/img8.png", "Pellentesque rhoncus, nulla a mattis o mi turpis vehicula risus, eget tempor leo tellus.", "Lorem", 2.50, new NutritionalInfoVO(300, 30, 2, 20, 140));

        produtos.add(p1); produtos.add(p2); produtos.add(p3); produtos.add(p4); produtos.add(p5); produtos.add(p6);
        return produtos;
    }
}
