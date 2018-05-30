package br.com.snackshake.model.dao;

import br.com.snackshake.model.db.ClientesDB;
import br.com.snackshake.model.vo.ClienteVO;

/**
 *
 * @author Carlos
 */
public class ClienteDAO {

    public ClienteVO lerCliente(ClienteVO cliente) {
        ClienteVO resultado = null;
        for (ClienteVO c : new ClientesDB().criaClientes()) {
            if (c.getMail().equals(cliente.getMail()) && c.getPassword().equals(cliente.getPassword())) {
                resultado = c;
                break;
            }
        }
        return resultado;
    }

    public void inserirCliente(ClienteVO cliente) {
        new ClientesDB().criaClientes().add(cliente);
    }

    public void atualizarCliente(ClienteVO oldClient, ClienteVO newClient) {
        ClientesDB cdb = new ClientesDB();
        int index = new ClientesDB().criaClientes().indexOf(oldClient);
        cdb.criaClientes().get(index).setName(newClient.getName());
        cdb.criaClientes().get(index).setUser(newClient.getUser());
        cdb.criaClientes().get(index).setMail(newClient.getMail());
        cdb.criaClientes().get(index).setPassword(newClient.getPassword());
        cdb.criaClientes().get(index).setPhone(newClient.getPhone());
        cdb.criaClientes().get(index).setPhoto(newClient.getPhoto());
        System.out.println("Atualizado com Sucesso");

    }

    public void deletarCliente(ClienteVO cliente) {
        ClientesDB.clientes.remove(cliente);
    }
}
