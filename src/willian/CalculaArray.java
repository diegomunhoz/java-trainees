package willian;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

/**
 * Programa para receber uma lista de n�meros inteiros e retornar opera��es com
 * estes
 * 
 * @author Willian Carlos Gomes
 * @since 25 de fev. de 2021
 */


public class CalculaArray {
	// Definindo uma ArrayList privada de n�meros inteiros com o nome "numeros"
	private ArrayList<Integer> numeros;
	
	//M�todo inicial que solicita do usu�rio os elementos da ArrayList
	public CalculaArray() { // In�cio do m�todo
		// Vari�vel auxiliar para repetir a solicita��o caso o usu�rio informe um valor
		// inv�lido
		boolean execute;
		int elemento;
		numeros = new ArrayList<Integer>();

		// La�o de repeti��o para solicitar 10 elementos do usu�rio
		for (int i = 0; i < 10; i++) {
			// Vari�vel auxiliar para a execu��o do la�o que atribui os valores digitados �
			// ArrayList
			execute = true;
			// Enquanto o usu�rio informar uma op��o inv�lida, o la�o retorna para que o
			// elemento do respectivo �ndice seja informado
			while (execute) {
				try { // Try - Catch para retornar ao usu�rio caso um caractere inv�lido ou nulo seja
						// digitado
					elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o " + (i + 1) + "� elemento:",
							"Lista de 10 n�meros", 3));
					numeros.add(elemento); // adicionando o valor informado � ArrayList
					if (isIntZero(elemento)) { // se o elemento for 0, informar erro
						JOptionPane.showMessageDialog(null, "O valor 0 n�o � permitido, favor informar um valor v�lido",
								"ERRO: O USU�RIO INFORMOU O VALOR 0", 0);
						numeros.remove(i); // Removendo da ArrayList o valor informado
						execute = true; // Ativando a vari�vel auxiliar para executar novamente a solicita��o no mesmo
										// �ndice

					} else if (isMenorZero(elemento)) {// se o elemento for menor que 0, informar erro
						JOptionPane.showMessageDialog(null,
								"S�o permitidos apenas valores maiores que 0, favor informar um valor v�lido", "ERRO",
								0);
						numeros.remove(i); // Removendo da ArrayList o valor informado
						execute = true; // Ativando a vari�vel auxiliar para executar novamente a solicita��o no mesmo
										// �ndice
					} else { // Caso o valor seja v�lido
						execute = false; // N�o executar novamente e incrementar +1 ao �ndice
					}
				} catch (Exception e) { // Caso um caractere inv�lido seja informado
					JOptionPane.showMessageDialog(null, "Valor Inv�lido - Por favor insira um n�mero v�lido!", "ERRO",
							0);
				} // Fim do Catch

			} // Fim do while
		} // fim do for
		menuPrincipal(); // Chamando o m�todo do menu
	} // Fim do m�todo

	public void menuPrincipal() {

		// Mensagem para ser exibida em janela para o usu�rio
		String menu = "INFORME A OP��O DESEJADA \n\n" + "1 - MOSTRAR O MAIOR ELEMENTO\n"
				+ "2 - MOSTRAR O MENOR ELEMENTO\n" + "3 - ORDENAR EM ORDEM CRESCENTE\n"
				+ "4 - ORDENAR EM ORDEM DECRESCENTE\n" + "5 - M�DIA DOS ELEMENTOS\n"
				+ "6 - SOMA DO MAIOR E DO MENOR ELEMENTO\n" + "7 - SOMA DOS ELEMENTOS IGUAIS\n"
				+ "8 - M�DIA DOS ELEMENTOS IGUAIS\n" + "9 - SAIR DO SISTEMA\n";

		// La�o para repetir menu caso seja informada uma op��o inv�lida
		while (true) {
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "MENU PRINCIPAL", 1));
				processamentoPrincipal(opcao);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "OP��O INV�LIDA", "MENU PRINCIPAL", 0);
			}
		}
	}

//m�todo de procesamento principal
	public void processamentoPrincipal(int opcao) {
		// caso de escolhas
		switch (opcao) {
		case 1:
			mostraMaior();
			break;
		case 2:
			mostraMenor();
			;
			break;
		case 3:
			ordenaCrescente();
			break;
		case 4:
			ordenaDecrescente();
			break;
		case 5:
			mediaElementos();
			break;
		case 6:
			somaMaiorMenor();
			break;
		case 7:
			somaIguais();
			break;
		case 8:
			mediaIguais();
			break;
		case 9:
			sairDoSistema();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Op��o Inv�lida!", "MENU PRINCIPAL", 0);
			break;
		}
	}

	// M�todo para mostrar o maior valor da lista
	private void mostraMaior() {

		// Impress�o do maior valor em tela
		JOptionPane.showMessageDialog(null, "O maior elemento �: " + Collections.max(numeros),
				"OP��O 1: MAIOR ELEMENTO", 1);
	} // Fim do m�todo

	// M�todo para mostrar o menor valor da lista
	private void mostraMenor() {
		// Impress�o do menor valor em tela
		JOptionPane.showMessageDialog(null, "O menor elemento �: " + Collections.min(numeros),
				"OP��O 2: MENOR ELEMENTO", 1);
	} // Fim do m�todo

	// M�todo para organizar a Lista em ordem crescente
	private void ordenaCrescente() {
		// Utilizando a framework Collections para reorganizar a Arraylist
		Collections.sort(numeros);

		// Impress�o da lista atualizada em ordem crescente
		JOptionPane.showMessageDialog(null, "Ordem crescente:\n" + numeros, "OP��O 3: ORDEM CRESCENTE", 1);
	} // Fim do m�todo

	// M�todo para organizar a Lista em ordem decrescente
	private void ordenaDecrescente() {
		// Utilizando a framework Collections para reorganizar a Arraylist
		Collections.reverse(numeros);

		// Impress�o da lista atualizada em ordem decrescente
		JOptionPane.showMessageDialog(null, "Ordem decrescente:\n" + numeros, "OP��O 4: ORDEM DECRESCENTE", 1);
	} // Fim do m�todo

	// M�todo para calcular a m�dia dos elementos
	private void mediaElementos() {
		// Vari�vel auxiliar para somar os valores da ArrayList
		int somaElementos = 0;
		// Vari�vel que recebe o c�lculo da m�dia
		double media;

		// La�o de repeti��o para passar por todos os valores da Lista
		for (Integer num : numeros) {
			somaElementos += num;
		}
		// C�lculo da m�dia
		media = (somaElementos / numeros.size());
		// Impress�o da m�dia em tela
		JOptionPane.showMessageDialog(null, "A m�dia dos elementos �: " + media + ".", "OP��O 5: M�DIA DOS ELEMENTOS",
				1);
	} // fim do m�todo

	// M�todo para somar o maior e o menor valor informado
	private void somaMaiorMenor() {
		// Ordenando valores em ordem crescente
		Collections.sort(numeros);
		// Somando o �ltimo valor da lista (que ap�s ordenado se torna o maior)
		// com o primeiro valor da lista (que se torna o menor ap�s a ordena��o)
		int resultado = numeros.get(numeros.size() - 1) + numeros.get(0);

		// Impress�o do resultado em tela
		JOptionPane.showMessageDialog(null, "A soma do maior (" + (numeros.get(9)) + ") e do menor elemento ("
				+ numeros.get(0) + ") informado �: " + resultado + ".", "OP��O 6: SOMA DO MAIOR COM O MENOR VALOR", 1);
	}

	// M�todo para somar os valores que se repetem
	private void somaIguais() {
		String mensagem = "";
		// Vari�vel para verificar se existem n�meros iguais
		boolean existe = false;

		// Verifica��o de frequ�ncias e atribui��es � vari�vel quantidade
		for (int i = 0; i < numeros.size(); i++) {
			int quantidade = Collections.frequency(numeros, numeros.get(i));

			// Se houver frequ�ncia de repeti��o, a var�avel mensagem deve ser atualizada e
			// impressa em tela posteriormente
			if (quantidade > 1) {
				existe = true; // Vari�vel informando a exist�ncia de repeti��o
				mensagem += "O elemento " + numeros.get(i) + " repetiu " + quantidade + " vezes. Sua soma � de: "
						+ (numeros.get(i) * quantidade) + "\n";
				i += (quantidade - 1);
			}
		}
		if (existe) {
			// resultado em tela
			JOptionPane.showMessageDialog(null, mensagem, "OP��O 7: SOMA DOS ELEMENTOS IGUAIS", 1);
		} else { // Se n�o existir n�meros repetindo, a vari�vel existe ser� falsa e ser�
					// impressa a mensagem em tela
			JOptionPane.showMessageDialog(null, "N�o existem elementos repetidos", "OP��O 7: SOMA DOS ELEMENTOS IGUAIS",
					1);
		}
	}

	// m�todo para calcular a m�dia dos elementos repetidos
	private void mediaIguais() {
		// C�lculo para obter a m�dia total dos elementos iguais
		boolean existe = false; // Vari�vel para definir a condicional de exibi��o da mensagem
		double soma = 0;
		int contador = 0;
		double media = 0;
		for (Integer num : numeros) { // la�o de repeti��o passando por todos os elementos da ArrayList
			if (Collections.frequency(numeros, num) >= 2) { // Verifica��o de frequ�ncia
				contador++; // caso exista a repeti��o, a vari�vel contadora incrementar�
				soma += num; // soma recebe seu valor interior somado ao novo valor repetido
				media = soma / contador; // c�lculo da m�dia
				existe = true; // define exist�ncia de frequ�ncias na ArrayList
			}
		}
		if (existe) {
			// resultado em tela
			JOptionPane.showMessageDialog(null, "A m�dia dos elementos repetidos �: " + media,
					"OP��O 8: M�DIA DOS ELEMENTOS IGUAIS", 1);
		} else {// Se n�o existir n�meros repetindo, a vari�vel existe ser� falsa e ser�
				// impressa a mensagem em tela
			JOptionPane.showMessageDialog(null, "N�o existem elementos repetidos",
					"OP��O 8: M�DIA DOS ELEMENTOS IGUAIS", 1);
		}
	}

	private void sairDoSistema() {

		// variavel para encerrar o sistema com sim ou n�o
		int opcao = JOptionPane.showConfirmDialog(null, "Encerrar o sistema?", "ATEN��O", JOptionPane.YES_OPTION,
				JOptionPane.NO_OPTION);

		// se sim, sai do sistema
		if (opcao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}

	// M�todo para verificar se o valor informado � zero
	public static boolean isIntZero(int args) {
		return args == 0;
	}

	// M�todo para verificar se o valor informado � menor que zero
	public static boolean isMenorZero(int args) {
		return args < 0;
	}

	// M�todo principal para executar a classe
	public static void main(String[] args) {
		new CalculaArray();
	}

} // Fim da classe
