package br.com.dblocadora.servicos;

import static org.junit.Assert.*;

import br.com.dblocadora.entidades.Filme;
import br.com.dblocadora.entidades.Locacao;
import br.com.dblocadora.entidades.Usuario;
import br.com.dblocadora.utils.DataUtils;
import org.junit.Test;
import java.util.Date;


public class LocacaoServiceTestException {

    @Test(expected = Exception.class)
    public void não_deveria_fazer_uma_alocacao_hoje() throws Exception {
        //cenário  ou pré-condição
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 0,  5.0);

        //ação
        Locacao locacao = service.alugarFilme(usuario, filme);

        assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
        assertTrue(locacao!=null);
        assertFalse(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(2)));
        assertFalse(locacao==null);
    }
    @Test
    public void nao_deveria_fazer_uma_alocacao() {
        //cenário  ou pré-condição
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 0,  5.0);

        //ação
        Locacao locacao = null;
        try {
            locacao = service.alugarFilme(usuario, filme);
            fail();
        } catch (Exception e) {
            // deu certo lancou a exception
        }

    }


}