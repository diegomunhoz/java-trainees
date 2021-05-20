package gustavo;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

/**
 * Classe controller para rodar as funcionalidades do programa
 *
 * @author Gustavo Metzler Pontes
 * @since 25 de fev. de 2021
 * 
 */
public class CalculaArray {

	// Declarando atributos
	private ArrayList<Integer> numeros;

	// Método construtor criando novo ArrayList e chamando processamento
	public CalculaArray() {
		numeros = new ArrayList<Integer>();

		processamento();
	}

	// Método processamento() Responsável por captar os valores, inserir no
	// arraylist validado e apresentar menu de opções
	public void processamento() {
		// Contador incrementando em um a cada cadastro
		int contador = 0;

		// While para contador menor que 10, validando os cadastros
		while (contador < 10) {

			// Try catch para receber apenas valores inteiros
			try {
				// Recebendo valores do usuário
				int numero = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeValor));
				// Validando valores para pegar apenas maiores que zero
				if (numero > 0) {
					// Incrementando contador e adicionando valor ao Arraylist
					contador++;
					numeros.add(numero);
				} else {
					// Apresentando mensagem de erro caso o valor informado seja inválido
					JOptionPane.showMessageDialog(null, Mensagem.valorInvalido, Rotulos.valorInvalido, 0);
				}
			} catch (Exception e) {
				// Tratamento de exceções
				JOptionPane.showMessageDialog(null, Mensagem.valorInvalido, Rotulos.valorInvalido, 0);
			}
		}

		// Loop infinito para apresentar menu de opções
		while (true) {
			menuOpcoes();
		}

	}

	// Criando menu de opções
	public void menuOpcoes() {

		// String auxiliar para apresentar menu
		String menu = "======== M E N U ========\n" + "\n1 - Maior elemento" + "\n2 -  Menor elemento"
				+ "\n3 -  Ordenar Lista Crescente" + "\n4 -  Ordenar Lista Decrescente" + "\n5 -  Média dos elementos"
				+ "\n6 -  Soma do maior e menor elemento" + "\n7 -  Soma dos elementos iguais"
				+ "\n8 -  Média dos elementos iguais" + "\n9 -  Sair do sistema" + "\n\nInforme a opção";

		// Try catch para pegar apenas valores inteiros
		try {
			// Recebendo opção do usuário e passando-a como argumento para a função
			// escolhaProcessamento() o qual entrará no método switch case
			int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
			escolhaProcessamento(opcao);
		} catch (Exception e) {
			// Tratamento de exceção
			JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulos.valorInvalido, 0);
		}
	}

	// Método switch case, encaminhando o usuário as funções que ele requisitou
	public void escolhaProcessamento(int opcao) {
		switch (opcao) {
		case 1:
			getMaiorElemento();
			break;
		case 2:
			getMenorElemento();
			break;
		case 3:
			ordenarListaCrescente();
			break;
		case 4:
			ordenarListaDecrescente();
			break;
		case 5:
			mediaElementos();
			break;
		case 6:
			somaMaiorMenorElemento();
			break;
		case 7:
			// Verificando se o array contém números duplicados
			if (contemDuplicados(numeros)) {
				somaElementosiguais();
			} else {
				// Apresentando erro caso array esteja sem duplicações
				apresentaErro();
			}

			break;
		case 8:
			// Verificando se o array contém números duplicados
			if (contemDuplicados(numeros)) {
				mediaElementosIguais();
			} else {
				// Apresentando erro caso array esteja sem duplicações
				apresentaErro();
			}

			break;
		case 9:
			sair();
			break;
		default:
			// Apresentando erro default
			JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulos.valorInvalido, 0);
			break;
		}
	}

	// verificando se o array possui elementos iguais para retornar mensagens nas
	// opções 7 e 8 caso o array não conhenha elementos duplicados
	public boolean contemDuplicados(ArrayList<Integer> arr) {
		// boolean para retornar resultado
		boolean contem = false;

		// Percorrendo arraylist de numeros
		for (Integer valor : numeros) {
			// Verificando a frequencia de cada valor
			int frequencia = Collections.frequency(numeros, valor);
			// Caso a frequencia seja maior que um, há elementos duplicados
			if (frequencia > 1) {
				// Atribuindo true aos boolean, afirmando existirem valores duplicados
				contem = true;
			}
		}
		// Retornando resultado
		return contem;
	}

	// Método para apresentar erro quando não houver valores duplicados no arraylist
	public void apresentaErro() {
		JOptionPane.showMessageDialog(null, Mensagem.arrayVazio, Rotulos.erro, 0);
	}

	// 1 - Maior elemento
	public void getMaiorElemento() {
		// Capturando maior elemento
		int maior = Collections.max(numeros);
		// Apresentando ao usuário
		JOptionPane.showMessageDialog(null, Mensagem.maiorElemento + maior, Rotulos.maiorElemento, 1);
	}

	// 2 - Menor elemento
	public void getMenorElemento() {
		// Capturando menor elemento
		int menor = Collections.min(numeros);
		// Apresentando ao usuário
		JOptionPane.showMessageDialog(null, Mensagem.menorElemento + menor, Rotulos.menorElemento, 1);
	}

	// 3 - Ordenar Lista Crescente
	public void ordenarListaCrescente() {
		// String auxiliar
		String mensagem = "";

		// Ordenando arraylist de forma crescente
		Collections.sort(numeros);
		// Loop no array ordenado
		for (Integer numero : numeros) {
			// concatenando mensagem
			mensagem += numero + " | ";
		}
		// Apresentando resultado
		JOptionPane.showMessageDialog(null, mensagem, Rotulos.ordemCrescente, 1);

	}

	// 4 - Ordenar Lista Decrescente
	public void ordenarListaDecrescente() {
		// String auxiliar
		String mensagem = "";

		// Ordenando arraylist de forma decrescente
		Collections.reverse(numeros);
		// Loop no array ordenado de forma decrescente
		for (Integer numero : numeros) {
			// Concatenando mensagem
			mensagem += numero + " | ";
		}
		// apresentando resultado
		JOptionPane.showMessageDialog(null, mensagem, Rotulos.ordemDecrescente, 1);
	}

	// 5 - Média dos elementos
	public void mediaElementos() {
		// Atribuindo valor zero à variável soma e declarando média
		double soma = 0;
		double media;
		// foreach varrendo todos os elementos do arraylist
		for (Integer numero : numeros) {
			// acrescentando valores à soma
			soma += numero;
		}
		// Calculando a média
		media = soma / 10;

		// Apresentando resultado
		JOptionPane.showMessageDialog(null, Mensagem.media + media, Rotulos.media, 1);
	}

	// 6 - Soma do maior e menor elemento
	public void somaMaiorMenorElemento() {
		// Atribuindo maior e menor valor as variáveis
		int maior = Collections.max(numeros);
		int menor = Collections.min(numeros);
		// Calculando a soma do maior com o menor
		int soma = maior + menor;
		// Criando string para apresentar resultado
		String mensagem = "Maior: " + maior + "\nMenor: " + menor + "\n" + maior + " + " + menor + " = " + soma;
		// Apresentando resultado
		JOptionPane.showMessageDialog(null, mensagem, Rotulos.somaMaiorMenor, 1);
	}

	// 7 - Soma dos elementos iguais
	public void somaElementosiguais() {
		// String auxiliar para concatenar mensagem
		String mensagem = "";
		// Criando arraylist auxiliar para armazenar valores já contabilizados
		ArrayList<Integer> ultimoValorValido = new ArrayList<Integer>();
		// Percorrendo arraylist de números
		for (Integer valor : numeros) {
			// Capturando a frequência de cada valor
			int frequencia = Collections.frequency(numeros, valor);
			// Atribuindo valor 0 a variável soma
			int soma = 0;

			// Caso a frequencia do valor seja maior que um o elemento aparece mais de uma
			// vez
			if (frequencia > 1) {
				// caso o elemento não esteja no arraylist auxiliar entramos nesta condicional
				if (!ultimoValorValido.contains(valor)) {
					// Atribuimos o valor da soma ao valor do número multiplicado por sua frequência
					soma = valor * frequencia;
					// Concatenamos a mensagem à String
					mensagem += "O valor " + valor + " aparece " + frequencia + " vezes e o resultado de sua soma é = " + soma + "\n";

				}
				// Adicionamos o valor computado ao arraylist auxiliar
				ultimoValorValido.add(valor);
			}

		}
		// Apresentando mensagem
		JOptionPane.showMessageDialog(null, mensagem, Rotulos.somaValoresIguais, 1);

	}

	// 8 - Média dos elementos iguais
	public void mediaElementosIguais() {
		// Declarando variáveis para calcular a média
		double soma = 0;
		double media = 0;
		double contador = 0;

		// Percorrendo arraylist de números
		for (Integer valor : numeros) {
			// Capturando a frequencia de cada valor
			int frequencia = Collections.frequency(numeros, valor);
			// caso a frequencia seja maior que 1, os valores são repetiros
			if (frequencia > 1) {
				// atribuimos o valor à soma e acrescentamos um ao contador, que será nosso
				// futuro divisor para capturar o valor da média
				soma += valor;
				contador++;
			}
		}
		// calculando a média
		media = soma / contador;
		// Apresentando valor ao usuário
		JOptionPane.showMessageDialog(null, Mensagem.mediaValoresIguais + media, Rotulos.mediaValoresIguais, 1);

	}

	// 9 - Sair do sistema
	public void sair() {
		// capturando opção do usuário
		int opcao = JOptionPane.showConfirmDialog(null, "Sair do sistema?", "Atenção", JOptionPane.YES_OPTION,
				JOptionPane.CANCEL_OPTION);
		// caso opção SIM, saímos do sistema
		if (opcao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	// Método main para executar nossa aplicação
	public static void main(String[] args) {
		new CalculaArray();
	}

}
