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

	// M�todo construtor criando novo ArrayList e chamando processamento
	public CalculaArray() {
		numeros = new ArrayList<Integer>();

		processamento();
	}

	// M�todo processamento() Respons�vel por captar os valores, inserir no
	// arraylist validado e apresentar menu de op��es
	public void processamento() {
		// Contador incrementando em um a cada cadastro
		int contador = 0;

		// While para contador menor que 10, validando os cadastros
		while (contador < 10) {

			// Try catch para receber apenas valores inteiros
			try {
				// Recebendo valores do usu�rio
				int numero = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeValor));
				// Validando valores para pegar apenas maiores que zero
				if (numero > 0) {
					// Incrementando contador e adicionando valor ao Arraylist
					contador++;
					numeros.add(numero);
				} else {
					// Apresentando mensagem de erro caso o valor informado seja inv�lido
					JOptionPane.showMessageDialog(null, Mensagem.valorInvalido, Rotulos.valorInvalido, 0);
				}
			} catch (Exception e) {
				// Tratamento de exce��es
				JOptionPane.showMessageDialog(null, Mensagem.valorInvalido, Rotulos.valorInvalido, 0);
			}
		}

		// Loop infinito para apresentar menu de op��es
		while (true) {
			menuOpcoes();
		}

	}

	// Criando menu de op��es
	public void menuOpcoes() {

		// String auxiliar para apresentar menu
		String menu = "======== M E N U ========\n" + "\n1 - Maior elemento" + "\n2 -  Menor elemento"
				+ "\n3 -  Ordenar Lista Crescente" + "\n4 -  Ordenar Lista Decrescente" + "\n5 -  M�dia dos elementos"
				+ "\n6 -  Soma do maior e menor elemento" + "\n7 -  Soma dos elementos iguais"
				+ "\n8 -  M�dia dos elementos iguais" + "\n9 -  Sair do sistema" + "\n\nInforme a op��o";

		// Try catch para pegar apenas valores inteiros
		try {
			// Recebendo op��o do usu�rio e passando-a como argumento para a fun��o
			// escolhaProcessamento() o qual entrar� no m�todo switch case
			int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
			escolhaProcessamento(opcao);
		} catch (Exception e) {
			// Tratamento de exce��o
			JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulos.valorInvalido, 0);
		}
	}

	// M�todo switch case, encaminhando o usu�rio as fun��es que ele requisitou
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
			// Verificando se o array cont�m n�meros duplicados
			if (contemDuplicados(numeros)) {
				somaElementosiguais();
			} else {
				// Apresentando erro caso array esteja sem duplica��es
				apresentaErro();
			}

			break;
		case 8:
			// Verificando se o array cont�m n�meros duplicados
			if (contemDuplicados(numeros)) {
				mediaElementosIguais();
			} else {
				// Apresentando erro caso array esteja sem duplica��es
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
	// op��es 7 e 8 caso o array n�o conhenha elementos duplicados
	public boolean contemDuplicados(ArrayList<Integer> arr) {
		// boolean para retornar resultado
		boolean contem = false;

		// Percorrendo arraylist de numeros
		for (Integer valor : numeros) {
			// Verificando a frequencia de cada valor
			int frequencia = Collections.frequency(numeros, valor);
			// Caso a frequencia seja maior que um, h� elementos duplicados
			if (frequencia > 1) {
				// Atribuindo true aos boolean, afirmando existirem valores duplicados
				contem = true;
			}
		}
		// Retornando resultado
		return contem;
	}

	// M�todo para apresentar erro quando n�o houver valores duplicados no arraylist
	public void apresentaErro() {
		JOptionPane.showMessageDialog(null, Mensagem.arrayVazio, Rotulos.erro, 0);
	}

	// 1 - Maior elemento
	public void getMaiorElemento() {
		// Capturando maior elemento
		int maior = Collections.max(numeros);
		// Apresentando ao usu�rio
		JOptionPane.showMessageDialog(null, Mensagem.maiorElemento + maior, Rotulos.maiorElemento, 1);
	}

	// 2 - Menor elemento
	public void getMenorElemento() {
		// Capturando menor elemento
		int menor = Collections.min(numeros);
		// Apresentando ao usu�rio
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

	// 5 - M�dia dos elementos
	public void mediaElementos() {
		// Atribuindo valor zero � vari�vel soma e declarando m�dia
		double soma = 0;
		double media;
		// foreach varrendo todos os elementos do arraylist
		for (Integer numero : numeros) {
			// acrescentando valores � soma
			soma += numero;
		}
		// Calculando a m�dia
		media = soma / 10;

		// Apresentando resultado
		JOptionPane.showMessageDialog(null, Mensagem.media + media, Rotulos.media, 1);
	}

	// 6 - Soma do maior e menor elemento
	public void somaMaiorMenorElemento() {
		// Atribuindo maior e menor valor as vari�veis
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
		// Criando arraylist auxiliar para armazenar valores j� contabilizados
		ArrayList<Integer> ultimoValorValido = new ArrayList<Integer>();
		// Percorrendo arraylist de n�meros
		for (Integer valor : numeros) {
			// Capturando a frequ�ncia de cada valor
			int frequencia = Collections.frequency(numeros, valor);
			// Atribuindo valor 0 a vari�vel soma
			int soma = 0;

			// Caso a frequencia do valor seja maior que um o elemento aparece mais de uma
			// vez
			if (frequencia > 1) {
				// caso o elemento n�o esteja no arraylist auxiliar entramos nesta condicional
				if (!ultimoValorValido.contains(valor)) {
					// Atribuimos o valor da soma ao valor do n�mero multiplicado por sua frequ�ncia
					soma = valor * frequencia;
					// Concatenamos a mensagem � String
					mensagem += "O valor " + valor + " aparece " + frequencia + " vezes e o resultado de sua soma � = " + soma + "\n";

				}
				// Adicionamos o valor computado ao arraylist auxiliar
				ultimoValorValido.add(valor);
			}

		}
		// Apresentando mensagem
		JOptionPane.showMessageDialog(null, mensagem, Rotulos.somaValoresIguais, 1);

	}

	// 8 - M�dia dos elementos iguais
	public void mediaElementosIguais() {
		// Declarando vari�veis para calcular a m�dia
		double soma = 0;
		double media = 0;
		double contador = 0;

		// Percorrendo arraylist de n�meros
		for (Integer valor : numeros) {
			// Capturando a frequencia de cada valor
			int frequencia = Collections.frequency(numeros, valor);
			// caso a frequencia seja maior que 1, os valores s�o repetiros
			if (frequencia > 1) {
				// atribuimos o valor � soma e acrescentamos um ao contador, que ser� nosso
				// futuro divisor para capturar o valor da m�dia
				soma += valor;
				contador++;
			}
		}
		// calculando a m�dia
		media = soma / contador;
		// Apresentando valor ao usu�rio
		JOptionPane.showMessageDialog(null, Mensagem.mediaValoresIguais + media, Rotulos.mediaValoresIguais, 1);

	}

	// 9 - Sair do sistema
	public void sair() {
		// capturando op��o do usu�rio
		int opcao = JOptionPane.showConfirmDialog(null, "Sair do sistema?", "Aten��o", JOptionPane.YES_OPTION,
				JOptionPane.CANCEL_OPTION);
		// caso op��o SIM, sa�mos do sistema
		if (opcao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	// M�todo main para executar nossa aplica��o
	public static void main(String[] args) {
		new CalculaArray();
	}

}
