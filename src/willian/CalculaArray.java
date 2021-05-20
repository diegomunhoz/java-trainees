package willian;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

/**
 * Programa para receber uma lista de números inteiros e retornar operações com
 * estes
 * 
 * @author Willian Carlos Gomes
 * @since 25 de fev. de 2021
 */


public class CalculaArray {
	// Definindo uma ArrayList privada de números inteiros com o nome "numeros"
	private ArrayList<Integer> numeros;
	
	//Método inicial que solicita do usuário os elementos da ArrayList
	public CalculaArray() { // Início do método
		// Variável auxiliar para repetir a solicitação caso o usuário informe um valor
		// inválido
		boolean execute;
		int elemento;
		numeros = new ArrayList<Integer>();

		// Laço de repetição para solicitar 10 elementos do usuário
		for (int i = 0; i < 10; i++) {
			// Variável auxiliar para a execução do laço que atribui os valores digitados à
			// ArrayList
			execute = true;
			// Enquanto o usuário informar uma opção inválida, o laço retorna para que o
			// elemento do respectivo índice seja informado
			while (execute) {
				try { // Try - Catch para retornar ao usuário caso um caractere inválido ou nulo seja
						// digitado
					elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o " + (i + 1) + "º elemento:",
							"Lista de 10 números", 3));
					numeros.add(elemento); // adicionando o valor informado à ArrayList
					if (isIntZero(elemento)) { // se o elemento for 0, informar erro
						JOptionPane.showMessageDialog(null, "O valor 0 não é permitido, favor informar um valor válido",
								"ERRO: O USUÁRIO INFORMOU O VALOR 0", 0);
						numeros.remove(i); // Removendo da ArrayList o valor informado
						execute = true; // Ativando a variável auxiliar para executar novamente a solicitação no mesmo
										// índice

					} else if (isMenorZero(elemento)) {// se o elemento for menor que 0, informar erro
						JOptionPane.showMessageDialog(null,
								"São permitidos apenas valores maiores que 0, favor informar um valor válido", "ERRO",
								0);
						numeros.remove(i); // Removendo da ArrayList o valor informado
						execute = true; // Ativando a variável auxiliar para executar novamente a solicitação no mesmo
										// índice
					} else { // Caso o valor seja válido
						execute = false; // Não executar novamente e incrementar +1 ao índice
					}
				} catch (Exception e) { // Caso um caractere inválido seja informado
					JOptionPane.showMessageDialog(null, "Valor Inválido - Por favor insira um número válido!", "ERRO",
							0);
				} // Fim do Catch

			} // Fim do while
		} // fim do for
		menuPrincipal(); // Chamando o método do menu
	} // Fim do método

	public void menuPrincipal() {

		// Mensagem para ser exibida em janela para o usuário
		String menu = "INFORME A OPÇÃO DESEJADA \n\n" + "1 - MOSTRAR O MAIOR ELEMENTO\n"
				+ "2 - MOSTRAR O MENOR ELEMENTO\n" + "3 - ORDENAR EM ORDEM CRESCENTE\n"
				+ "4 - ORDENAR EM ORDEM DECRESCENTE\n" + "5 - MÉDIA DOS ELEMENTOS\n"
				+ "6 - SOMA DO MAIOR E DO MENOR ELEMENTO\n" + "7 - SOMA DOS ELEMENTOS IGUAIS\n"
				+ "8 - MÉDIA DOS ELEMENTOS IGUAIS\n" + "9 - SAIR DO SISTEMA\n";

		// Laço para repetir menu caso seja informada uma opção inválida
		while (true) {
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "MENU PRINCIPAL", 1));
				processamentoPrincipal(opcao);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA", "MENU PRINCIPAL", 0);
			}
		}
	}

//método de procesamento principal
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
			JOptionPane.showMessageDialog(null, "Opção Inválida!", "MENU PRINCIPAL", 0);
			break;
		}
	}

	// Método para mostrar o maior valor da lista
	private void mostraMaior() {

		// Impressão do maior valor em tela
		JOptionPane.showMessageDialog(null, "O maior elemento é: " + Collections.max(numeros),
				"OPÇÃO 1: MAIOR ELEMENTO", 1);
	} // Fim do método

	// Método para mostrar o menor valor da lista
	private void mostraMenor() {
		// Impressão do menor valor em tela
		JOptionPane.showMessageDialog(null, "O menor elemento é: " + Collections.min(numeros),
				"OPÇÃO 2: MENOR ELEMENTO", 1);
	} // Fim do método

	// Método para organizar a Lista em ordem crescente
	private void ordenaCrescente() {
		// Utilizando a framework Collections para reorganizar a Arraylist
		Collections.sort(numeros);

		// Impressão da lista atualizada em ordem crescente
		JOptionPane.showMessageDialog(null, "Ordem crescente:\n" + numeros, "OPÇÃO 3: ORDEM CRESCENTE", 1);
	} // Fim do método

	// Método para organizar a Lista em ordem decrescente
	private void ordenaDecrescente() {
		// Utilizando a framework Collections para reorganizar a Arraylist
		Collections.reverse(numeros);

		// Impressão da lista atualizada em ordem decrescente
		JOptionPane.showMessageDialog(null, "Ordem decrescente:\n" + numeros, "OPÇÃO 4: ORDEM DECRESCENTE", 1);
	} // Fim do método

	// Método para calcular a média dos elementos
	private void mediaElementos() {
		// Variável auxiliar para somar os valores da ArrayList
		int somaElementos = 0;
		// Variável que recebe o cálculo da média
		double media;

		// Laço de repetição para passar por todos os valores da Lista
		for (Integer num : numeros) {
			somaElementos += num;
		}
		// Cálculo da média
		media = (somaElementos / numeros.size());
		// Impressão da média em tela
		JOptionPane.showMessageDialog(null, "A média dos elementos é: " + media + ".", "OPÇÃO 5: MÉDIA DOS ELEMENTOS",
				1);
	} // fim do método

	// Método para somar o maior e o menor valor informado
	private void somaMaiorMenor() {
		// Ordenando valores em ordem crescente
		Collections.sort(numeros);
		// Somando o último valor da lista (que após ordenado se torna o maior)
		// com o primeiro valor da lista (que se torna o menor após a ordenação)
		int resultado = numeros.get(numeros.size() - 1) + numeros.get(0);

		// Impressão do resultado em tela
		JOptionPane.showMessageDialog(null, "A soma do maior (" + (numeros.get(9)) + ") e do menor elemento ("
				+ numeros.get(0) + ") informado é: " + resultado + ".", "OPÇÃO 6: SOMA DO MAIOR COM O MENOR VALOR", 1);
	}

	// Método para somar os valores que se repetem
	private void somaIguais() {
		String mensagem = "";
		// Variável para verificar se existem números iguais
		boolean existe = false;

		// Verificação de frequências e atribuições à variável quantidade
		for (int i = 0; i < numeros.size(); i++) {
			int quantidade = Collections.frequency(numeros, numeros.get(i));

			// Se houver frequência de repetição, a varíavel mensagem deve ser atualizada e
			// impressa em tela posteriormente
			if (quantidade > 1) {
				existe = true; // Variável informando a existência de repetição
				mensagem += "O elemento " + numeros.get(i) + " repetiu " + quantidade + " vezes. Sua soma é de: "
						+ (numeros.get(i) * quantidade) + "\n";
				i += (quantidade - 1);
			}
		}
		if (existe) {
			// resultado em tela
			JOptionPane.showMessageDialog(null, mensagem, "OPÇÃO 7: SOMA DOS ELEMENTOS IGUAIS", 1);
		} else { // Se não existir números repetindo, a variável existe será falsa e será
					// impressa a mensagem em tela
			JOptionPane.showMessageDialog(null, "Não existem elementos repetidos", "OPÇÃO 7: SOMA DOS ELEMENTOS IGUAIS",
					1);
		}
	}

	// método para calcular a média dos elementos repetidos
	private void mediaIguais() {
		// Cálculo para obter a média total dos elementos iguais
		boolean existe = false; // Variável para definir a condicional de exibição da mensagem
		double soma = 0;
		int contador = 0;
		double media = 0;
		for (Integer num : numeros) { // laço de repetição passando por todos os elementos da ArrayList
			if (Collections.frequency(numeros, num) >= 2) { // Verificação de frequência
				contador++; // caso exista a repetição, a variável contadora incrementará
				soma += num; // soma recebe seu valor interior somado ao novo valor repetido
				media = soma / contador; // cálculo da média
				existe = true; // define existência de frequências na ArrayList
			}
		}
		if (existe) {
			// resultado em tela
			JOptionPane.showMessageDialog(null, "A média dos elementos repetidos é: " + media,
					"OPÇÃO 8: MÉDIA DOS ELEMENTOS IGUAIS", 1);
		} else {// Se não existir números repetindo, a variável existe será falsa e será
				// impressa a mensagem em tela
			JOptionPane.showMessageDialog(null, "Não existem elementos repetidos",
					"OPÇÃO 8: MÉDIA DOS ELEMENTOS IGUAIS", 1);
		}
	}

	private void sairDoSistema() {

		// variavel para encerrar o sistema com sim ou não
		int opcao = JOptionPane.showConfirmDialog(null, "Encerrar o sistema?", "ATENÇÃO", JOptionPane.YES_OPTION,
				JOptionPane.NO_OPTION);

		// se sim, sai do sistema
		if (opcao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}

	// Método para verificar se o valor informado é zero
	public static boolean isIntZero(int args) {
		return args == 0;
	}

	// Método para verificar se o valor informado é menor que zero
	public static boolean isMenorZero(int args) {
		return args < 0;
	}

	// Método principal para executar a classe
	public static void main(String[] args) {
		new CalculaArray();
	}

} // Fim da classe
