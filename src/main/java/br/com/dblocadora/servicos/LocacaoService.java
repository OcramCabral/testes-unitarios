package br.com.dblocadora.servicos;

import java.util.Date;

import br.com.dblocadora.entidades.Filme;
import br.com.dblocadora.entidades.Locacao;
import br.com.dblocadora.entidades.Usuario;
import br.com.dblocadora.utils.DataUtils;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) throws Exception {
		if(filme.getEstoque() == 0) throw new Exception("Nenhum filme no estoque");
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = DataUtils.adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar método para salvar
		
		return locacao;
	}

	public static void main(String[] args) {
		/*//cenário  ou pré-condição
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 1,  5.0);

		//ação
		Locacao locacao = service.alugarFilme(usuario, filme);

		//verificação
		System.out.println(locacao.getValor() == 5.0);
		System.out.println(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		System.out.println(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));

		//F = Fast;
		//I = Independent;
		//R = Repeatable;
		//S = Self-Veryfying
		//T = Timely*/
	}
}