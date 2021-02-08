package br.com.dblocadora.servicos;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import br.com.dblocadora.entidades.Filme;
import br.com.dblocadora.entidades.Locacao;
import br.com.dblocadora.entidades.Usuario;
import br.com.dblocadora.utils.DataUtils;
import org.junit.rules.ErrorCollector;

import java.util.Date;


public class LocacaoServiceTest {

    private Locacao locacao;
    private LocacaoService service;
    private Usuario usuario;
    private Filme filme;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Before
    public void setup(){
        //cenário  ou pré-condição
        service = new LocacaoService();
        usuario = new Usuario("Usuario 1");
        filme = new Filme("Filme 1", 1,  5.0);

        //ação
        //locacao = service.alugarFilme(usuario, filme);
    }

    @Test
    public void deveria_fazer_uma_alocacao_hoje() {
        assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
        assertTrue(locacao!=null);
        assertFalse(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(2)));
        assertFalse(locacao==null);
    }

    @Test
    public void deveria_reduzir_estoque_filme_ao_alocacar(){
        //Problema quantidade do estoque não é reduzida
        assertEquals(1, filme.getEstoque().intValue(), 0.0001);
        assertEquals(1, filme.getEstoque(), 0.0001);
        assertEquals(Integer.valueOf(1), filme.getEstoque());
    }

    @Test
    public void deveria_conter_usuario_que_alugou(){
        assertEquals(usuario.getNome(), locacao.getUsuario().getNome());
    }

  /*  *   você pode tornar seus testes mais específicos
    *   você obtém uma exceção mais detalhada, se os testes falharem
    *   mais fácil de ler o teste*/


    @Test
    public void deveria_conter_usuario_que_alugou_coreMatchers(){
        assertEquals(usuario.getNome(), locacao.getUsuario().getNome());
        assertThat(usuario.getNome(), equalTo(locacao.getUsuario().getNome()));
    }

    @Test
    public void deveria_ter_mesma_referencia(){
        assertSame(locacao, locacao);
    }

    @Test
    public void deveria_conter_valor_para_um_filme(){
        assertEquals(filme.getPrecoLocacao(), locacao.getFilme().getPrecoLocacao());
    }

    @Test
    public void deveria_passar_em_um_teste_e_falhar_nos_outros(){
        //collector.checkThat(1, equalTo(2));
        //collector.checkThat(true, is(false));
        collector.checkThat(false, is(false));
    }




}
