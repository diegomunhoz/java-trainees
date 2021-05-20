package victor;

import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JOptionPane;

/**
 * Classe responsável por processar e gerenciar os números informados pelo
 * usuário, as comparações de grandeza entre eles, os calculos de média dos
 * núemros e a ordenação deles
 * 
 * @author Victor Baptista
 * @since 25/02/2021
 */
public class CalculaArray {

	// declara a lista para armazenar números informados pelo usuário
	ArrayList<Integer> numeros;

	// construtor da classe
	public CalculaArray() {
		// instancializa a lista de números
		numeros = new ArrayList<Integer>();

		// incializa a lista de números com 10 entradas
		numeros.ensureCapacity(10);

		// recebe os números do usuário
		numeros = getNumeros();

		// inicializa o menu principal
		menuPrincipal();
	}

	// Método para a criação de um menu de opções
	public void menuPrincipal() {
		// variável auxiliar de mensagem
		String menu = "INFORME A OPÇÃO DESEJADA\n\n" + "1-MAIOR ELEMENTO\n" + "2-MENOR ELEMENTO\n"
				+ "3-ORDENAR LISTA CRESCENTE\n" + "4-ORDENAR LISTA DECRESCENTE\n" + "5-MÉDIA DOS ELEMENTOS\n"
				+ "6-SOMA DO MAIOR E MENOR ELEMENTO\n" + "7-SOMA DOS ELEMENTOS IGUAIS\n"
				+ "8-MÉDIA DOS ELEMENTOS IGUAIS\n" + "9-SAIR DO SISTEMA\n";

		// looping de processamento do menu principal
		while (true) {
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
				processamentoPrincipal(opcao);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulo.menu, 0);
			}
		}
	}

	// Processa o menu e as escolhas do usuário
	public void processamentoPrincipal(int opcao) {

		// acessa o setor do menu baseado na escolha do usuário
		switch (opcao) {
		case 1:
			maiorElemento();
			break;

		case 2:
			menorElemento();
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
			somaMaiorMenor();
			break;

		case 7:
			somaElementosIguais();
			break;

		case 8:
			mediaElementosIguais();
			break;

		case 9:
			sairSistema();
			break;

		default:
			JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulo.menu, 0);
			break;
		}
	}

	// Método para exibir o maior elemento entre os números informados pelo usuário
	public void maiorElemento() {
		// organiza a lista de números informados de maneira crescente
		numeros.sort(Comparator.reverseOrder());

		// variável auxiliar para a exibição ao usuário
		String mensagem = "O maior número entre os informados é:  " + numeros.get(0);

		// exibe a mensagem ao usuário
		JOptionPane.showMessageDialog(null, mensagem, Rotulo.maiorElemento, 1);
	}

	// Método para exibir o menor elemento entre os números informados pelo usuário
	public void menorElemento() {
		// organiza a lista de números informados de maneira crescente
		numeros.sort(Comparator.naturalOrder());

		// variável auxiliar para a exibição ao usuário
		String mensagem = "O menor número entre os informados é:  " + numeros.get(0);

		// exibe a mensagem ao usuário
		JOptionPane.showMessageDialog(null, mensagem, Rotulo.menorElemento, 1);
	}

	// Método para exibir a lista crescente dos números informados pelo usuário
	public void ordenarListaCrescente() {
		// variável auxiliar para a exibição ao usuário
		String mensagem = "Lista dos números em ordem crescente!\n\n";

		// organiza a lista de números informados de maneira crescente
		numeros.sort(Comparator.naturalOrder());

		// organiza a lista crescente dos números iformados
		for (Integer numero : numeros) {

			mensagem += numero + "     ";
		}

		// exibe a mensagem ao usuário
		JOptionPane.showMessageDialog(null, mensagem, Rotulo.listaCrescente, 1);
	}

	// Método para exibir a lista decrescente dos números informados pelo usuário
	public void ordenarListaDecrescente() {
		// variável auxiliar para a exibição ao usuário
		String mensagem = "Lista dos números em ordem decrescente!\n\n";

		// organiza a lista de números informados de maneira decrescente
		numeros.sort(Comparator.reverseOrder());

		// organiza a lista decrescente dos números iformados
		for (Integer numero : numeros) {

			mensagem += numero + "     ";
		}

		// exibe a mensagem ao usuário
		JOptionPane.showMessageDialog(null, mensagem, Rotulo.listaDecrescente, 1);
	}

	// Método para exibir a média dos números informados pelo usuário
	public void mediaElementos() {
		// variáveis auxiliares
		double soma = 0;
		double media = 0;
		String mensagem = "A média dos números informados é:  ";

		// contabiliza a soma dos números existente na lista
		for (Integer numero : numeros) {
			soma += numero;
		}

		// realiza o calculo da média dos números existentes na lista
		media = soma / numeros.size();
		mensagem += media;

		// exibe a mensagem ao usuário
		JOptionPane.showMessageDialog(null, mensagem, Rotulo.mediaElementos, 1);
	}

	// Método para exibir a soma do maior e menor número informado pelo usuário
	public void somaMaiorMenor() {
		// organiza a lista de números informados de maneira crescente
		numeros.sort(Comparator.naturalOrder());

		// calcula a soma do maior com o menor número informado, atribui o resultado à
		// variável auxiliar
		int soma = numeros.get(numeros.size() - 1) + numeros.get(0);
		String mensagem = "A soma do maior com o menor número informado é:  " + soma;

		// exibe a mensagem ao usuário
		JOptionPane.showMessageDialog(null, mensagem, Rotulo.somaMaiorMenor, 1);
	}

	// Método para exibir a soma dos números iguais entre os números informados pelo
	// usuário
	public void somaElementosIguais() {
		// organiza a lista de números informados de maneira crescente
		numeros.sort(Comparator.naturalOrder());

		// variáveis auxiliares
		String mensagem = "A soma dos números iguais é:\n";
		boolean existe1 = false;
		boolean existe2 = false;
		int soma;

		// calcula a soma de cada número repetido com suas repectivas repetições
		for (int i = 0; i < numeros.size(); i++) {
			soma = numeros.get(i);
			for (int j = 0; j < numeros.size(); j++) {
				if ((numeros.get(i) == numeros.get(j)) && (i != j)) {
					soma += numeros.get(i);
					existe2 = true;
				}
			}

			// atribui a variável auxiliar 'mensagem' a soma de cada número repetido com
			// suas repetições
			if (i == 0) {
				if ((numeros.get(0) == numeros.get(1)) && (soma != numeros.get(i))) {
					if (!existe1) {
						mensagem += "\nA soma do número repetido " + numeros.get(i) + " é: " + soma;
						existe1 = true;
					}
				}
			} else if ((soma != numeros.get(i)) && (numeros.get(i) != numeros.get(i - 1))) {
				mensagem += "\nA soma do número repetido " + numeros.get(i) + " é: " + soma;
			}

		}

		// exibe a mensagem ao usuário
		if (existe2) {
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.somaIguais, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.naoNumerosIguais, Rotulo.somaIguais, 0);
		}
	}

	// Método para exibir a média dos números iguais entre os números informados
	// pelo usuário
	public void mediaElementosIguais() {
		// organiza a lista de números informados de maneira crescente
		numeros.sort(Comparator.naturalOrder());

		// variáveis auxiliares
		String mensagem = "A média dos números iguais é:\n";
		boolean existe1 = false;
		boolean existe2 = false;
		double aux1 = 0;
		double aux2 = 0;
		double soma1 = 0;
		double soma2 = 0;
		double media = 0;

		// calcula a soma de cada número repetido com suas repectivas repetições
		for (int i = 0; i < numeros.size(); i++) {
			soma1 = numeros.get(i);
			aux1 = 1;
			for (int j = 0; j < numeros.size(); j++) {
				if ((numeros.get(i) == numeros.get(j)) && (i != j)) {
					soma1 += numeros.get(i);
					aux1++;
					existe2 = true;
				}
			}

			// atribui às variáveis auxiliares os resultados do calculo da soma de cada
			// número repetido com suas repectivas repetições e quantas vezes eles se
			// repetem
			if (i == 0) {
				if ((numeros.get(0) == numeros.get(1)) && (soma1 != numeros.get(i))) {
					if (!existe1) {
						soma2 += soma1;
						aux2 += aux1;
						existe1 = true;
					}
				}
			} else if ((soma1 != numeros.get(i)) && (numeros.get(i) != numeros.get(i - 1))) {
				soma2 += soma1;
				aux2 += aux1;
			}

		}

		// calcula a média dos números repetidos e atribui o resultado a variável
		// auxiliar 'mensagem'
		media += soma2 / aux2;
		mensagem += "\nA média dos números repetidos é: " + media;

		// exibe o resultado ao usuário
		if (existe2) {
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.mediaIguais, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.naoNumerosIguais, Rotulo.mediaIguais, 0);
		}

	}

	// método para sair do sistema
	public void sairSistema() {
		// Mensagem de confirmação para sair do programa
		int opcao = JOptionPane.showConfirmDialog(null, "Encerrar o sistema?", "Atenção", JOptionPane.YES_OPTION,
				JOptionPane.CANCEL_OPTION);

		// caso o usuário escolha a opção sim, o programa finaliza
		if (opcao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	private ArrayList<Integer> getNumeros() {
		// declata e instancializa uma lista de números
		ArrayList<Integer> numeros = new ArrayList<Integer>();

		// variáveis auxiliares
		int numero = 0;
		int quantidadeDeNumeros = 0;

		// atribui os números informados, caso válidos, à lista de números
		while (quantidadeDeNumeros < 10) {
			try {
				// recebe o número do usuário
				numero = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.numeroInforme));

				// valida o número recebido do usuário
				if (Valida.isValido(numero)) {
					numeros.add(numero);
					quantidadeDeNumeros++;
				} else {
					JOptionPane.showMessageDialog(null, Mensagem.numeroInvalido, Rotulo.registraNumero, 0);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.numeroInvalido, Rotulo.registraNumero, 0);
			}
		}

		// retorna os 10 números informados pelo usuário
		return numeros;
	}

	/*
	 * Método principal para excutar a classe
	 */
	public static void main(String[] args) {
		new CalculaArray();
	}
}
