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
	 * M�todo principal para
	 */

	// declarando as listas para armazenar os conte�dos do sistema
	ArrayList<Integer> numeros = new ArrayList<Integer>();

	// Construtor da classe
	public CalculaArray() { // In�cio do m�todo

		// Vari�vel auxiliar para repetir a solicita��o caso o usu�rio informe um valor
		// inv�lido
		boolean execute;
		numeros = new ArrayList<Integer>();

		// La�o de repeti��o para solicitar 10 elementos do usu�rio
		for (int i = 0; i < 10; i++) {

			// Vari�vel auxiliar para a execu��o do la�o que atribui os valores digitados �
			// ArrayList
			execute = true;

			// Vari�vel para auxiliar na valida��o
			int elemento;

			// Enquanto o usu�rio informar uma op��o inv�lida, o la�o retorna para que o
			// elemento do respectivo �ndice seja informado
			while (execute) {
				try { // Try - Catch para retornar ao usu�rio caso um caractere inv�lido ou nulo seja
						// digitado
					elemento = Integer.parseInt(JOptionPane.showInputDialog("Digite o " + (i + 1) + "� elemento:"));
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

		String menu = "INFORME A OP��O DESEJADA\n" + "\n1 - Maior elemento" + "\n2 - Menor elemento"
				+ "\n3 - Ordenar Lista Crescente" + "\n4 - Ordenar Lista Decrescente" + "\n5 - M�dia dos elementos"
				+ "\n6 - Soma do maior e menor elemento" + "\n7 - Soma dos elementos iguais"
				+ "\n8 - M�dia dos elementos iguais" + "\n9  - Sair do sistema";

		while (true) {
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
				processamentoPrincipal(opcao);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Op��o inv�lida", "===== M E N U =====", 0);
			}
		}

	}

	// m�todo para controlar o processamento do programa
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
			JOptionPane.showMessageDialog(null, "Op��o inv�lida", "===== M E N U =====", 0);
			break;
		}

	}

	private void MaiorElemento() {

		// C�lculo para obter o maior elemento // Resultado em tela
		JOptionPane.showMessageDialog(null, "O maior n�mero �: " + Collections.max(numeros), "MAIOR ELEMENTO", 1);
	}

	private void MenorElemento() {

		// C�lculo para obter o menor elemento // Resultado em tela
		JOptionPane.showMessageDialog(null, "O menor n�mero �: " + Collections.min(numeros), "MENOR ELEMENTO", 1);
	}

	private void ListaCrescente() {

		// C�lculo para obter a lista crescente
		Collections.sort(numeros);

		// Resultado em tela
		JOptionPane.showMessageDialog(null, numeros, "LISTA CRESCENTE", 1);
	}

	private void ListaDecrescente() {

		// C�lculo para obter a lista decrescente
		Collections.reverse(numeros);

		// Resultado em tela
		JOptionPane.showMessageDialog(null, numeros, "LISTA ORDEM DECRESCENTE", 1);
	}

	private void MediaTotal() {

		// C�lculo para obter a m�dia total elemento
		int somaElementos = 0; // Vari�vel auxiliar

		for (Integer num : numeros) {
			somaElementos += num;
		}

		// Resusultado em tela
		JOptionPane.showMessageDialog(null, "A m�dia dos elementos � de: " + somaElementos / numeros.size(),
				"M�DIA TOTAL DOS ELEMENTOS", 1);
	}

	private void SomaMaiorMenor() {

		// C�lculo para obter o resultado a soma do maior com o menor n�mero informado
		Collections.sort(numeros);
		int resultado = numeros.get(numeros.size() - 1) + numeros.get(0);

		// Resultado em tela
		JOptionPane.showMessageDialog(null, "A soma do maior valor informado com o menor valor � de: " + resultado,
				"SOMA DO MAIOR E MENOR N�MERO", 1);
	}

	private void SomaElementosIguais() {
		String mensagem = "";
		boolean existe = false;

		for (int i = 0; i < numeros.size(); i++) {
			int quantidade = Collections.frequency(numeros, numeros.get(i));
			if (quantidade > 1) {
				existe = true;
				mensagem += "O elemento " + numeros.get(i) + " repetiu " + quantidade + " vezes. Sua soma � de: "
						+ (numeros.get(i) * quantidade) + "\n";
				i += (quantidade - 1);
			}
		}
		if (existe) {
			// resultado em tela
			JOptionPane.showMessageDialog(null, mensagem, "OP��O 7: SOMA DOS ELEMENTOS IGUAIS", 1);
		} else {
			JOptionPane.showMessageDialog(null, "N�o existem elementos repetidos", "OP��O 7: SOMA DOS ELEMENTOS IGUAIS",
					1);
		}
	}

	private void MediaElementosIguais() {
		// C�lculo para obter a m�dia total dos elementos iguais
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
			JOptionPane.showMessageDialog(null, "A m�dia dos elementos repetidos �: " + result,
					"OP��O 8: M�DIA DOS ELEMENTOS IGUAIS", 1);
		} else {
			JOptionPane.showMessageDialog(null, "N�o existem elementos repetidos",
					"OP��O 8: M�DIA DOS ELEMENTOS IGUAIS", 1);
		}
	}

	private void SairSistema() {
		int opcao = JOptionPane.showConfirmDialog(null, "Encerrar o sistema?", "Aten��o", JOptionPane.YES_OPTION,
				JOptionPane.CANCEL_OPTION);

		if (opcao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	// verificando se o valor informado � zero
	public static boolean isIntZero(int args) {
		return args == 0;
	}

	// verificando se o valor informado � menor que zero
	public static boolean isMenorZero(int args) {
		return args < 0;
	}

	public static void main(String[] args) {
		new CalculaArray();
	}

}
