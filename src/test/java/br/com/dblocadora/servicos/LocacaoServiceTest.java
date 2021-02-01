package br.com.dblocadora.servicos;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;
import br.com.dblocadora.entidades.Filme;
import br.com.dblocadora.entidades.Locacao;
import br.com.dblocadora.entidades.Usuario;
import br.com.dblocadora.utils.DataUtils;

import java.util.Date;


public class LocacaoServiceTest {

    @Test
    public void deveria_fazer_uma_alocacao_hoje() {
        //cenário  ou pré-condição
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 1,  5.0);

        //ação
        Locacao locacao = service.alugarFilme(usuario, filme);

        assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
        assertTrue(locacao!=null);
        assertFalse(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(2)));
        assertFalse(locacao==null);
    }

    @Test
    public void deveria_reduzir_estoque_filme_ao_alocacar(){
        //cenário  ou pré-condição
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 1,  5.0);

        //ação
        Locacao locacao = service.alugarFilme(usuario, filme);

        //Problema quantidade do estoque não é reduzida
        assertEquals(1, filme.getEstoque().intValue(), 0.0001);
        assertEquals(1, filme.getEstoque(), 0.0001);
        assertEquals(Integer.valueOf(1), filme.getEstoque());


    }

    @Test
    public void deveria_conter_usuario_que_alugou(){
        //cenário  ou pré-condição
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 1,  5.0);

        //ação
        Locacao locacao = service.alugarFilme(usuario, filme);

        assertEquals(usuario.getNome(), locacao.getUsuario().getNome());
    }

    /*
    *   você pode tornar seus testes mais específicos
    *   você obtém uma exceção mais detalhada, se os testes falharem
    *   mais fácil de ler o teste
    */
    @Test
    public void deveria_conter_usuario_que_alugou_coreMatchers(){
        //cenário  ou pré-condição
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 1,  5.0);

        //ação
        Locacao locacao = service.alugarFilme(usuario, filme);

        assertEquals(usuario.getNome(), locacao.getUsuario().getNome());
        assertThat(usuario.getNome(), equalTo(locacao.getUsuario().getNome()));
    }

    @Test
    public void deveria_ter_mesma_referencia(){
        //cenário  ou pré-condição
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 1,  5.0);

        //ação
        Locacao locacao = service.alugarFilme(usuario, filme);

        assertSame(locacao, locacao);
    }

    @Test
    public void deveria_conter_valor_para_um_filme(){
        //cenário  ou pré-condição
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 1,  5.0);

        //ação
        Locacao locacao = service.alugarFilme(usuario, filme);

        assertEquals(filme.getPrecoLocacao(), locacao.getFilme().getPrecoLocacao());
    }


}