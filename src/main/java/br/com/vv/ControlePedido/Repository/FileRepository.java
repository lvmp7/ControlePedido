package br.com.vv.ControlePedido.Repository;

import br.com.vv.ControlePedido.DataSource.BaseDataSource;
import br.com.vv.ControlePedido.modelo.Pedido;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.springframework.util.SerializationUtils;

import java.io.File;
import java.util.Collection;

public class FileRepository extends BaseRepository {

    private final String diretorioPedidosDB = "/tmp/pedidos_db/";

    public FileRepository() {
        super();
        iniciarDiretorioDB();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void listar() {
        carregarListaPedidos();
        super.listar();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void incluir() {
        super.incluir();
        atualizarListaPedidos();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void editar() {
        super.editar();
        atualizarListaPedidos();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void excluir() {
        super.excluir();
        atualizarListaPedidos();
    }

    private void atualizarListaPedidos() {
        try {
            FileUtils.cleanDirectory(new File(diretorioPedidosDB));
            for (Pedido pedido : pedidos) {
                byte[] pedidoBytes =
                        SerializationUtils.serialize(pedido);
                FileUtils.
                        writeByteArrayToFile(new File(diretorioPedidosDB.
                                concat(pedido.getCodigo())), pedidoBytes);
            }
        } catch (Exception e1) {
            System.err.println("Erro ao atualizar pedidos");
            e1.printStackTrace();
        }
    }

    private void carregarListaPedidos() {
        try {
            pedidos.clear();
            Collection<File> files =
                    FileUtils.listFiles(new File(diretorioPedidosDB),
                            new WildcardFileFilter("*"),//filtro de arquivos
                            new WildcardFileFilter("*"));//filtro de dir

            for (File pedidoFile :	files) {
                //Apache Commons Lang 3
                byte[] bytesPedido =
                        FileUtils.readFileToByteArray(pedidoFile);
                Pedido pedido = (Pedido) SerializationUtils.deserialize(bytesPedido);
                pedidos.add(pedido);
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar lista de pedidos");
            e.printStackTrace();
        }
    }

    private void iniciarDiretorioDB() {
        File dir = new File(diretorioPedidosDB);
        if (!dir.exists()) {
            dir.mkdir();
        }
    }
}
