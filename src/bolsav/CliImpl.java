package bolsav;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * A classe CliImpl implementa os métodos remotos da interface InterfaceCli e
 * implementa os métodos locais que trabalha com as ações do cliente.
 *
 * @author davi
 * @author geova
 */
public class CliImpl extends UnicastRemoteObject implements InterfaceCli {

    public List<Stock> stocks;
    public InterfaceServ server;
    public long id;
    public Client_BolsaV frame_client;

    /**
     * Método para verificar se o cliente recebe alguma mensagem e a exibe
     *
     * @param eee com a mensagem
     * @throws RemoteException
     */
    @Override
    public void echo(String eee) throws RemoteException {
        System.out.println("Echo recebido: " + eee);
    }

    /**
     * O cliente recebe uma mensagem e de acordo com o conteúdo exibe um alerta
     * para o cliente
     *
     * @param event com a mensagem recebida
     * @throws RemoteException
     */
    @Override
    public void notify(String event) throws RemoteException {
        //parte a string recebida nos espaços e armazena em um vetor de strings 
        String n[] = event.split(" ");
        String message = null;
        //caso o início da mensagem
        switch (n[0]) {
            case "rise":
                //seja rise, a mensagem a ser exibida é formatada
                message = "O preço da ação " + n[1] + " subiu de " + n[2] + " para " + n[3];
                break;
            case "drop":
                //seja drop, a mensagem a ser exibida é formatada
                message = "O preço da ação " + n[1] + " caiu de " + n[2] + " para " + n[3];
                break;
            case "buy":
                //seja buy, a mensagem a ser exibida é formatada
                message = "Foi comprada " + n[3] + " ação da " + n[1] + " pelo preço " + n[2];
                //cria uma nova ação com os valores recebidos de compra
                //n[1] possui a empresa, n[3] a quantidade e n[4] o preço mínimo
                Stock stockB = new Stock(n[1], Integer.parseInt(n[3]), Double.parseDouble(n[4]));
                //delay para evitar conflitos de acessos
                 {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException ex) {
                        System.out.println("ex em delay 1");
                        Logger.getLogger(CliImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                //chama o método para atualizar a ação comprada
                updateStock(stockB);
                //atualiza as tabelas de monitoramento e de minha carteira
                frame_client.setUpTableWallet();
                //frame_client.setUpTableMonitor();
                break;
            case "sell":
                //seja sell, a mensagem a ser exibida é formatada
                message = "Foi vendida " + n[3] + " ação da " + n[1] + " pelo preço " + n[2];
                //cria uma nova ação com os valores recebidos de venda
                //n[1] possui a empresa, n[3] a quantidade (nesse caso negativa porque houve uma venda) e n[4] o preço mínimo
                Stock stockS = new Stock(n[1], -Integer.parseInt(n[3]), Double.parseDouble(n[4]));
                //delay para evitar conflitos de acessos
                 {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException ex) {
                        System.out.println("ex em delay 2");
                        Logger.getLogger(CliImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                //chama o método para atualizar a ação vendida
                updateStock(stockS);
                //atualiza as tabelas de monitoramento e de minha carteira
                frame_client.setUpTableWallet();
                //frame_client.setUpTableMonitor();
                break;
            default:
                //caso recebe algo que não esteja documentado
                message = "Algo deu errado";
                break;
        }
        //exibe a mensagem ao cliente
        JOptionPane.showMessageDialog(null, message, "Notificação " + id, JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Construtor da classe, recebe o id do cliente, cria uma referência do
     * servidor disponível
     *
     * @param id com o id do cliente
     * @throws RemoteException
     */
    public CliImpl(long id) throws RemoteException {
        //lista com as ações que o cliente possui
        stocks = new ArrayList();
        try {
            this.id = id;
            //cria um registo para o servidor
            Registry refSN = LocateRegistry.getRegistry("localhost", 1099);
            //pega no serviços de nomes a referência do servidor
            server = (InterfaceServ) refSN.lookup("RefServidor");
            //utiliza o chamar para testar conexão
            server.chamar("Cliente", this);
        } catch (NotBoundException ex) {
            Logger.getLogger(CliImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AccessException ex) {
            Logger.getLogger(CliImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Insere nova ação recebida na lista de ações do cliente caso não exista ou
     * atualiza caso exista
     *
     * @param stock com a ação criada
     */
    public void insertStock(Stock stock) {
        try {
            //testa para todas as ações se já existe uma ação daquela empresa
            for (Stock st : stocks) {
                //se houver atualiza a disponibilidade de compra para true
                if (st.company.equals(stock.company)) {
                    st.setAvailable(true);
                    //envia a nova ação para o servidor
                    server.newStock(this, stock, id);
                    //retorna se encontrar algo
                    return;
                }
            }
            //caso não encontre adiciona nova na lista
            stocks.add(stock);
            //envia a nova ação para o servidor
            server.newStock(this, stock, id);
        } catch (RemoteException ex) {
            System.out.println("ex remote em insert");
            Logger.getLogger(CliImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //atualiza a quantidade comprada ou vendida 
    /**
     * Método que atualiza a quantidade da ação depois de realizada compra ou
     * venda
     *
     * @param stock com a ação envolvida no processo
     */
    public void updateStock(Stock stock) {
        try {
            //testa para todas as ações se já existe uma ação daquela empresa
            for (Stock st : stocks) {

                //caso o cliente já possui ações da empresa
                if (st.company.equals(stock.company)) {
                    //atualiza a quantidade das ações
                    st.setQt(stock.getQt() + st.getQt());
                    //envia para o servidor
                    server.newStock(this, st, id);
                    return;
                }
            }
            //adiciona nova ação na lista do cliente
            stocks.add(stock);
            //envia a nova ação para o servidor
            server.newStock(this, stock, id);
        } catch (RemoteException ex) {
            System.out.println("ex remote em update");
            Logger.getLogger(CliImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Retorna a lista de ações que o cliente possui
     *
     * @return do tipo lista com as ações do cliente
     */
    public List<Stock> getStocks() {
        return stocks;
    }

    /**
     * Retorna o id do cliente
     *
     * @return do tipo long com o id do cliente
     */
    public long getId() {
        return id;
    }

}
