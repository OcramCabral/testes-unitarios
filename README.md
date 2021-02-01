
# Testes unitários em Java

## O que é?

- Projeto Java de uma locadora de exemplo para realização de testes unitários

Tarefas liberadas dia 29/01:

* Passar a usar a dependência do JUnit no POM do projeto, junit 4.13;
* Alterar método main para um teste usando os recursos do junit com @Test; Opcional - Falar do princípio da janela de vidro-Testes devem estar sempre verdes;
* Organizar os testes em pastas mais coerente a sua finalidade;
* Utilizar os recursos do assert, para as validações dos métodos de teste;
* Criar uma Classe de teste, dentro do escopo de testes, chamada AssertTest, com os exemplos de:
	* Assert.assertTrue() validando true e observando seu comportamento; OK
	* Assert.assertTrue() validando false e observando seu comportamento;
	* Assert.assertFalse() validando true e observando seu comportamento; OK
	* Assert.assertFalse() validando false e observando seu comportamento;
	* Assert.assertEquals() validando dois inteiros primitivos e observando seu comportamento; OK
	* Assert.assertEquals() validando um inteiro primitivo e um objeto do tipo Integer e observando seu comportamento; OK
	* Assert.assertEquals() validando dois objetos do tipo Integer e observando seu comportamento; OK
	* Assert.assertEquals() validando dois Strings e observando seu comportamento; OK
	* Assert.assertEquals() validando dois valores primitivos do tipo double e observando seu comportamento; OK
	* Assert.assertSame() validando o mesmo objeto do tipo Integer e observando seu comportamento;
	* Assert.assertSame() validando dois objetos do tipo Integer e observando seu comportamento;
	* Escolher um assert para validar um objeto nulo e observando seu comportamento;
	* Validar todos os exemplos anteriores com suas variações negativas AssertNot... e observando seu comportamento;
	
* Organizar os testes do terceiro passo para usar o métodos mais coerentes do Assert.assertThat + CoreMatchers;
	* Utilizar CoreMatchers com is(equalTo()) e is(not());
	* Realizar uma cópia das validações acima utilizando o recurso da notação @Rule do JUnit instanciando um objeto com nome error da classe ErrorColetor, trocando a validação do Assert.assertThat, por error.checkThat() analise a diferença entre as duas abordagens para revisarmos juntos;
	
* Observação importante 1, confirmar que os testes passam e falham, evitando falsos positivos.	
* Observação importante 2, conforme for avançando nas tarefas, atualizar readme com os testes realizados.
