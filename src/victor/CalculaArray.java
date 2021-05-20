package victor;

import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JOptionPane;

/**
 * Classe respons�vel por processar e gerenciar os n�meros informados pelo
 * usu�rio, as compara��es de grandeza entre eles, os calculos de m�dia dos
 * n�emros e a ordena��o deles
 * 
 * @author Victor Baptista
 * @since 25/02/2021
 */
public class CalculaArray {

	// declara a lista para armazenar n�meros informados pelo usu�rio
	ArrayList<Integer> numeros;

	// construtor da classe
	public CalculaArray() {
		// instancializa a lista de n�meros
		numeros = new ArrayList<Integer>();

		// incializa a lista de n�meros com 10 entradas
		numeros.ensureCapacity(10);

		// recebe os n�meros do usu�rio
		numeros = getNumeros();

		// inicializa o menu principal
		menuPrincipal();
	}

	// M�todo para a cria��o de um menu de op��es
	public void menuPrincipal() {
		// vari�vel auxiliar de mensagem
		String menu = "INFORME A OP��O DESEJADA\n\n" + "1-MAIOR ELEMENTO\n" + "2-MENOR ELEMENTO\n"
				+ "3-ORDENAR LISTA CRESCENTE\n" + "4-ORDENAR LISTA DECRESCENTE\n" + "5-M�DIA DOS ELEMENTOS\n"
				+ "6-SOMA DO MAIOR E MENOR ELEMENTO\n" + "7-SOMA DOS ELEMENTOS IGUAIS\n"
				+ "8-M�DIA DOS ELEMENTOS IGUAIS\n" + "9-SAIR DO SISTEMA\n";

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

	// Processa o menu e as escolhas do usu�rio
	public void processamentoPrincipal(int opcao) {

		// acessa o setor do menu baseado na escolha do usu�rio
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

	// M�todo para exibir o maior elemento entre os n�meros informados pelo usu�rio
	public void maiorElemento() {
		// organiza a lista de n�meros informados de maneira crescente
		numeros.sort(Comparator.reverseOrder());

		// vari�vel auxiliar para a exibi��o ao usu�rio
		String mensagem = "O maior n�mero entre os informados �:  " + numeros.get(0);

		// exibe a mensagem ao usu�rio
		JOptionPane.showMessageDialog(null, mensagem, Rotulo.maiorElemento, 1);
	}

	// M�todo para exibir o menor elemento entre os n�meros informados pelo usu�rio
	public void menorElemento() {
		// organiza a lista de n�meros informados de maneira crescente
		numeros.sort(Comparator.naturalOrder());

		// vari�vel auxiliar para a exibi��o ao usu�rio
		String mensagem = "O menor n�mero entre os informados �:  " + numeros.get(0);

		// exibe a mensagem ao usu�rio
		JOptionPane.showMessageDialog(null, mensagem, Rotulo.menorElemento, 1);
	}

	// M�todo para exibir a lista crescente dos n�meros informados pelo usu�rio
	public void ordenarListaCrescente() {
		// vari�vel auxiliar para a exibi��o ao usu�rio
		String mensagem = "Lista dos n�meros em ordem crescente!\n\n";

		// organiza a lista de n�meros informados de maneira crescente
		numeros.sort(Comparator.naturalOrder());

		// organiza a lista crescente dos n�meros iformados
		for (Integer numero : numeros) {

			mensagem += numero + "     ";
		}

		// exibe a mensagem ao usu�rio
		JOptionPane.showMessageDialog(null, mensagem, Rotulo.listaCrescente, 1);
	}

	// M�todo para exibir a lista decrescente dos n�meros informados pelo usu�rio
	public void ordenarListaDecrescente() {
		// vari�vel auxiliar para a exibi��o ao usu�rio
		String mensagem = "Lista dos n�meros em ordem decrescente!\n\n";

		// organiza a lista de n�meros informados de maneira decrescente
		numeros.sort(Comparator.reverseOrder());

		// organiza a lista decrescente dos n�meros iformados
		for (Integer numero : numeros) {

			mensagem += numero + "     ";
		}

		// exibe a mensagem ao usu�rio
		JOptionPane.showMessageDialog(null, mensagem, Rotulo.listaDecrescente, 1);
	}

	// M�todo para exibir a m�dia dos n�meros informados pelo usu�rio
	public void mediaElementos() {
		// vari�veis auxiliares
		double soma = 0;
		double media = 0;
		String mensagem = "A m�dia dos n�meros informados �:  ";

		// contabiliza a soma dos n�meros existente na lista
		for (Integer numero : numeros) {
			soma += numero;
		}

		// realiza o calculo da m�dia dos n�meros existentes na lista
		media = soma / numeros.size();
		mensagem += media;

		// exibe a mensagem ao usu�rio
		JOptionPane.showMessageDialog(null, mensagem, Rotulo.mediaElementos, 1);
	}

	// M�todo para exibir a soma do maior e menor n�mero informado pelo usu�rio
	public void somaMaiorMenor() {
		// organiza a lista de n�meros informados de maneira crescente
		numeros.sort(Comparator.naturalOrder());

		// calcula a soma do maior com o menor n�mero informado, atribui o resultado �
		// vari�vel auxiliar
		int soma = numeros.get(numeros.size() - 1) + numeros.get(0);
		String mensagem = "A soma do maior com o menor n�mero informado �:  " + soma;

		// exibe a mensagem ao usu�rio
		JOptionPane.showMessageDialog(null, mensagem, Rotulo.somaMaiorMenor, 1);
	}

	// M�todo para exibir a soma dos n�meros iguais entre os n�meros informados pelo
	// usu�rio
	public void somaElementosIguais() {
		// organiza a lista de n�meros informados de maneira crescente
		numeros.sort(Comparator.naturalOrder());

		// vari�veis auxiliares
		String mensagem = "A soma dos n�meros iguais �:\n";
		boolean existe1 = false;
		boolean existe2 = false;
		int soma;

		// calcula a soma de cada n�mero repetido com suas repectivas repeti��es
		for (int i = 0; i < numeros.size(); i++) {
			soma = numeros.get(i);
			for (int j = 0; j < numeros.size(); j++) {
				if ((numeros.get(i) == numeros.get(j)) && (i != j)) {
					soma += numeros.get(i);
					existe2 = true;
				}
			}

			// atribui a vari�vel auxiliar 'mensagem' a soma de cada n�mero repetido com
			// suas repeti��es
			if (i == 0) {
				if ((numeros.get(0) == numeros.get(1)) && (soma != numeros.get(i))) {
					if (!existe1) {
						mensagem += "\nA soma do n�mero repetido " + numeros.get(i) + " �: " + soma;
						existe1 = true;
					}
				}
			} else if ((soma != numeros.get(i)) && (numeros.get(i) != numeros.get(i - 1))) {
				mensagem += "\nA soma do n�mero repetido " + numeros.get(i) + " �: " + soma;
			}

		}

		// exibe a mensagem ao usu�rio
		if (existe2) {
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.somaIguais, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.naoNumerosIguais, Rotulo.somaIguais, 0);
		}
	}

	// M�todo para exibir a m�dia dos n�meros iguais entre os n�meros informados
	// pelo usu�rio
	public void mediaElementosIguais() {
		// organiza a lista de n�meros informados de maneira crescente
		numeros.sort(Comparator.naturalOrder());

		// vari�veis auxiliares
		String mensagem = "A m�dia dos n�meros iguais �:\n";
		boolean existe1 = false;
		boolean existe2 = false;
		double aux1 = 0;
		double aux2 = 0;
		double soma1 = 0;
		double soma2 = 0;
		double media = 0;

		// calcula a soma de cada n�mero repetido com suas repectivas repeti��es
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

			// atribui �s vari�veis auxiliares os resultados do calculo da soma de cada
			// n�mero repetido com suas repectivas repeti��es e quantas vezes eles se
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

		// calcula a m�dia dos n�meros repetidos e atribui o resultado a vari�vel
		// auxiliar 'mensagem'
		media += soma2 / aux2;
		mensagem += "\nA m�dia dos n�meros repetidos �: " + media;

		// exibe o resultado ao usu�rio
		if (existe2) {
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.mediaIguais, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.naoNumerosIguais, Rotulo.mediaIguais, 0);
		}

	}

	// m�todo para sair do sistema
	public void sairSistema() {
		// Mensagem de confirma��o para sair do programa
		int opcao = JOptionPane.showConfirmDialog(null, "Encerrar o sistema?", "Aten��o", JOptionPane.YES_OPTION,
				JOptionPane.CANCEL_OPTION);

		// caso o usu�rio escolha a op��o sim, o programa finaliza
		if (opcao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	private ArrayList<Integer> getNumeros() {
		// declata e instancializa uma lista de n�meros
		ArrayList<Integer> numeros = new ArrayList<Integer>();

		// vari�veis auxiliares
		int numero = 0;
		int quantidadeDeNumeros = 0;

		// atribui os n�meros informados, caso v�lidos, � lista de n�meros
		while (quantidadeDeNumeros < 10) {
			try {
				// recebe o n�mero do usu�rio
				numero = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.numeroInforme));

				// valida o n�mero recebido do usu�rio
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

		// retorna os 10 n�meros informados pelo usu�rio
		return numeros;
	}

	/*
	 * M�todo principal para excutar a classe
	 */
	public static void main(String[] args) {
		new CalculaArray();
	}
}
