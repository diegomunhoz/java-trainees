package eric;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

/**
 * 
 * @author Eric Alessandro Rodrigues Hickenbick
 * @since 25 de fev. de 2021
 */
public class CalculaArray {

	/**
	 * Método principal para
	 */

	// declarando as listas para armazenar os conteúdos do sistema
	ArrayList<Integer> numeros = new ArrayList<Integer>();

	// Construtor da classe
	public CalculaArray() { // Início do método

		// Variável auxiliar para repetir a solicitação caso o usuário informe um valor
		// inválido
		boolean execute;
		numeros = new ArrayList<Integer>();

		// Laço de repetição para solicitar 10 elementos do usuário
		for (int i = 0; i < 10; i++) {

			// Variável auxiliar para a execução do laço que atribui os valores digitados à
			// ArrayList
			execute = true;

			// Variável para auxiliar na validação
			int elemento;

			// Enquanto o usuário informar uma opção inválida, o laço retorna para que o
			// elemento do respectivo índice seja informado
			while (execute) {
				try { // Try - Catch para retornar ao usuário caso um caractere inválido ou nulo seja
						// digitado
					elemento = Integer.parseInt(JOptionPane.showInputDialog("Digite o " + (i + 1) + "º elemento:"));
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

		String menu = "INFORME A OPÇÃO DESEJADA\n" + "\n1 - Maior elemento" + "\n2 - Menor elemento"
				+ "\n3 - Ordenar Lista Crescente" + "\n4 - Ordenar Lista Decrescente" + "\n5 - Média dos elementos"
				+ "\n6 - Soma do maior e menor elemento" + "\n7 - Soma dos elementos iguais"
				+ "\n8 - Média dos elementos iguais" + "\n9  - Sair do sistema";

		while (true) {
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
				processamentoPrincipal(opcao);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Opção inválida", "===== M E N U =====", 0);
			}
		}

	}

	// método para controlar o processamento do programa
	public void processamentoPrincipal(int opcao) {

		switch (opcao) {
		case 1: {
			MaiorElemento();
			break;
		}
		case 2: {
			MenorElemento();
			break;
		}
		case 3: {
			ListaCrescente();
			break;
		}
		case 4: {
			ListaDecrescente();
			break;
		}
		case 5: {
			MediaTotal();
			break;
		}
		case 6: {
			SomaMaiorMenor();
			break;
		}
		case 7: {
			SomaElementosIguais();
			break;
		}
		case 8: {
			MediaElementosIguais();
			break;
		}
		case 9: {
			SairSistema();
			break;
		}

		default:
			JOptionPane.showMessageDialog(null, "Opção inválida", "===== M E N U =====", 0);
			break;
		}

	}

	private void MaiorElemento() {

		// Cálculo para obter o maior elemento // Resultado em tela
		JOptionPane.showMessageDialog(null, "O maior número é: " + Collections.max(numeros), "MAIOR ELEMENTO", 1);
	}

	private void MenorElemento() {

		// Cálculo para obter o menor elemento // Resultado em tela
		JOptionPane.showMessageDialog(null, "O menor número é: " + Collections.min(numeros), "MENOR ELEMENTO", 1);
	}

	private void ListaCrescente() {

		// Cálculo para obter a lista crescente
		Collections.sort(numeros);

		// Resultado em tela
		JOptionPane.showMessageDialog(null, numeros, "LISTA CRESCENTE", 1);
	}

	private void ListaDecrescente() {

		// Cálculo para obter a lista decrescente
		Collections.reverse(numeros);

		// Resultado em tela
		JOptionPane.showMessageDialog(null, numeros, "LISTA ORDEM DECRESCENTE", 1);
	}

	private void MediaTotal() {

		// Cálculo para obter a média total elemento
		int somaElementos = 0; // Variável auxiliar

		for (Integer num : numeros) {
			somaElementos += num;
		}

		// Resusultado em tela
		JOptionPane.showMessageDialog(null, "A média dos elementos é de: " + somaElementos / numeros.size(),
				"MÉDIA TOTAL DOS ELEMENTOS", 1);
	}

	private void SomaMaiorMenor() {

		// Cálculo para obter o resultado a soma do maior com o menor número informado
		Collections.sort(numeros);
		int resultado = numeros.get(numeros.size() - 1) + numeros.get(0);

		// Resultado em tela
		JOptionPane.showMessageDialog(null, "A soma do maior valor informado com o menor valor é de: " + resultado,
				"SOMA DO MAIOR E MENOR NÚMERO", 1);
	}

	private void SomaElementosIguais() {
		String mensagem = "";
		boolean existe = false;

		for (int i = 0; i < numeros.size(); i++) {
			int quantidade = Collections.frequency(numeros, numeros.get(i));
			if (quantidade > 1) {
				existe = true;
				mensagem += "O elemento " + numeros.get(i) + " repetiu " + quantidade + " vezes. Sua soma é de: "
						+ (numeros.get(i) * quantidade) + "\n";
				i += (quantidade - 1);
			}
		}
		if (existe) {
			// resultado em tela
			JOptionPane.showMessageDialog(null, mensagem, "OPÇÃO 7: SOMA DOS ELEMENTOS IGUAIS", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Não existem elementos repetidos", "OPÇÃO 7: SOMA DOS ELEMENTOS IGUAIS",
					1);
		}
	}

	private void MediaElementosIguais() {
		// Cálculo para obter a média total dos elementos iguais
		boolean existe = false;
		double soma = 0;
		int contador = 0;
		double result = 0;
		for (Integer num : numeros) {
			if (Collections.frequency(numeros, num) >= 2) {
				contador++;
				soma += num;
				result = soma / contador;
				existe = true;
			}
		}
		if (existe) {
			// resultado em tela
			JOptionPane.showMessageDialog(null, "A média dos elementos repetidos é: " + result,
					"OPÇÃO 8: MÉDIA DOS ELEMENTOS IGUAIS", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Não existem elementos repetidos",
					"OPÇÃO 8: MÉDIA DOS ELEMENTOS IGUAIS", 1);
		}
	}

	private void SairSistema() {
		int opcao = JOptionPane.showConfirmDialog(null, "Encerrar o sistema?", "Atenção", JOptionPane.YES_OPTION,
				JOptionPane.CANCEL_OPTION);

		if (opcao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	// verificando se o valor informado é zero
	public static boolean isIntZero(int args) {
		return args == 0;
	}

	// verificando se o valor informado é menor que zero
	public static boolean isMenorZero(int args) {
		return args < 0;
	}

	public static void main(String[] args) {
		new CalculaArray();
	}

}
