package br.com.snackshake.model.db;

import br.com.snackshake.model.vo.ClienteVO;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class ClientesDB {

    public static ArrayList<ClienteVO> clientes = new ArrayList<>();

    public ArrayList<ClienteVO> criaClientes() {
        ClienteVO c0 = new ClienteVO("Admin", "", "admin@admin", "admin", "", "/br/com/snackshake/view/img/foto-padrao.png");
        ClienteVO c1 = new ClienteVO("Emma Stone", "Emma Stone", "emma@gmail.com", "stone", "31 99334-0987", "/br/com/snackshake/view/img/cliente01.png");
        ClienteVO c2 = new ClienteVO("Keanu Reeves", "Keanu Reeves", "neo@gmail.com", "neo", "31 98763-9863", "/br/com/snackshake/view/img/cliente02.png");
        clientes.add(c0); clientes.add(c1); clientes.add(c2);
        
        return clientes;
    }

}
