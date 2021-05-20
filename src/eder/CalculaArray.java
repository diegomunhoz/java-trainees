package eder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

/**
 * Classe para demonstrar o uso de ArrayList, metodos e validações
 * 
 * @author Éder Diego de Sousa
 * @since 25 de fev. de 2021
 */
public class CalculaArray {

	// criação da ArrayList para armazenar os numeros
	private ArrayList<Integer> numeros;

	// método construtor da classe
	public CalculaArray() {
		numeros = new ArrayList<Integer>();
		getNumeros();
		menuPrincipal();

	}

	// métdo para criar um menu de opções
	public void menuPrincipal() {

		String menu = "INFORME A OPÇÃO DESEJADA\n\n" + "1 - BUSCAR MAIOR NÚMERO\n" + "2 - BUSCAR MENOR NÚMERO\n"
				+ "3 - EXIBIR EM ORDEM CRESCENTE\n" + "4 - EXIBIR EM ORDEM DECRESCENTE\n"
				+ "5 - EXIBIR A MÉDIA DOS ELEMENTOS\n" + "6 - EXIBIR A SOMA DO MAIOR E MENOR ELEMENTO\n"
				+ "7 - EXIBIR A SOMA DOS ELEMENTOS IGUAIS\n" + "8 - EXIBIR A MÉDIA DOS ELEMENTOS IGUAIS\n"
				+ "9 - SAIR DO SISTEMA";

		while (true) {
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
				processamentoPrincipal(opcao);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulo.calcularNumeros, 0);
			}
		}
	}

	// método para seleção das opções do programa
	private void processamentoPrincipal(int opcao) {

		switch (opcao) {
		case 1: {
			buscarMaiorElemento();
			break;
		}
		case 2: {
			buscarMenorElemento();
			break;
		}
		case 3: {
			ordenarListaCrescente();
			break;
		}
		case 4: {
			ordenarListaDecrescente();
			break;
		}
		case 5: {
			calcularMediaElementos();
			break;
		}
		case 6: {
			somarMaiorMenorElemento();
			break;
		}
		case 7: {
			somarElementosIguais();
			break;
		}
		case 8: {
			calcularMediaElementosIguais();
			break;
		}
		case 9: {
			sairDoSistema();
			break;
		}
		default:
			JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulo.calcularNumeros, 0);
			break;
		}

	}

	// método para buscar o maior elemento da lista
	private void buscarMaiorElemento() {

		Collections.reverse(numeros);
		String msg = "Exibindo maior valor:\n";
		msg += numeros.get(0);
		JOptionPane.showMessageDialog(null, msg, Rotulo.calcularNumeros, JOptionPane.INFORMATION_MESSAGE);

	}

	// metodo para buscar o menor elemento da lista
	private void buscarMenorElemento() {

		Collections.sort(numeros);
		String msg = "Exibindo menor valor:\n";
		msg += numeros.get(0);
		JOptionPane.showMessageDialog(null, msg, Rotulo.calcularNumeros, JOptionPane.INFORMATION_MESSAGE);

	}

	// método para ordenar lista em ordem crescente e exibindo
	private void ordenarListaCrescente() {

		Collections.sort(numeros);
		String msg = "Exibindo em ordem crescente:\n";

		for (Integer numero : numeros) {

			if ((numeros.size() - 1) != numeros.indexOf(numero)) {
				msg += numero + " - ";
			} else {
				msg += numero;
			}
		}

		JOptionPane.showMessageDialog(null, msg, Rotulo.calcularNumeros, JOptionPane.INFORMATION_MESSAGE);

	}

	// método para ordenar lista em ordem decrescente e exibindo
	private void ordenarListaDecrescente() {

		Collections.reverse(numeros);
		String msg = "Exibindo em ordem Decrescente:\n";

		for (Integer numero : numeros) {

			if ((numeros.size() - 1) != numeros.indexOf(numero)) {
				msg += numero + " - ";
			} else {
				msg += numero;
			}
		}
		JOptionPane.showMessageDialog(null, msg, Rotulo.calcularNumeros, JOptionPane.INFORMATION_MESSAGE);
	}

	// programa para exibir o valor da média dos elementos
	private void calcularMediaElementos() {

		String msg = "Exibindo o cálculo da média dos elementos:\n";
		double soma = 0;

		for (Integer numero : numeros) {
			soma += numero;
		}

		msg += soma / numeros.size();
		JOptionPane.showMessageDialog(null, msg, Rotulo.calcularNumeros, JOptionPane.INFORMATION_MESSAGE);
	}

	private void somarMaiorMenorElemento() {

		Collections.sort(numeros);

		int maiorElemento = numeros.get(numeros.size() - 1);
		int menorElemento = numeros.get(0);

		String msg = "Exibindo a soma do maior elemento: " + maiorElemento + " e menor elemento: " + menorElemento
				+ "\n" + (maiorElemento + menorElemento);

		JOptionPane.showMessageDialog(null, msg, Rotulo.calcularNumeros, JOptionPane.INFORMATION_MESSAGE);

	}

	private void somarElementosIguais() {

		// variavel para exibir a mensagem
		boolean flag = false;
		
		String msg = "Exibindo o cálculo da soma dos elementos iguais:\n";
		
		// conjunto nao é possivel salvar valores repetidos
		Set<Integer> numerosNaoRepetido = new HashSet<Integer>(numeros);
		for (Integer setNum : numerosNaoRepetido) {		
			// comparando dois conjuntos e vizualizando quantas vezes o valor é encontrado
			if(Collections.frequency(numeros, setNum) > 1) {
				flag = true;
				msg += "Numero Repetido: " + setNum + ". Ocorrências: " + Collections.frequency(numeros, setNum) + " vezes.\n"
					 + "Soma: " + Collections.frequency(numeros, setNum) * setNum + "\n"
					 + "--------------------------------------------------------\n";
			}
		}
		
		if(flag) {
			JOptionPane.showMessageDialog(null, msg, Rotulo.calcularNumeros, JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.nenhumNumeroDuplicado, Rotulo.calcularNumeros, JOptionPane.ERROR_MESSAGE);
		}
		
	}

	private void calcularMediaElementosIguais() {
		
		// variavel para exibir a mensagem
		boolean flag = false;

		String msg = "Exibindo o cálculo da média dos elementos iguais:\n";
		ArrayList<Integer> numerosIguais = new ArrayList<Integer>();
		
		// verificando quantas vezes o numero esta repetido e armazenado em uma nova lista
		for (Integer numero : numeros) {
			if (Collections.frequency(numeros, numero) > 1) {
				numerosIguais.add(numero);
				flag = true;
			}
		}
		// somando os valores iguais da lista
		double soma = 0;
		for (Integer numero : numerosIguais) {
			soma += numero;	
		}
		msg += soma / numerosIguais.size();
		
		if(flag) {
			JOptionPane.showMessageDialog(null, msg, Rotulo.calcularNumeros, JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.nenhumNumeroDuplicado, Rotulo.calcularNumeros, JOptionPane.ERROR_MESSAGE);
		}		
	}

	private void sairDoSistema() {

		int opcao = JOptionPane.showConfirmDialog(null, "Encerrar o sitema?", "Atenção", 0, 2);

		if (opcao == 0) {
			System.exit(0);
		}

	}

	// método para obter os numeros do usuário
	private void getNumeros() {

		for (int i = 0; i < 10; i++) {
			boolean execute = true;
			int numero = 0;

			while (execute) {
				try {
					numero = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeNumero(i)));

					if (Valida.isNegativoOuZero(numero)) {
						JOptionPane.showMessageDialog(null, Mensagem.valorInvalido, Rotulo.calcularNumeros, 0);
						execute = true;
					} else {
						numeros.add(numero);
						execute = false;
					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, Mensagem.valorInvalido, Rotulo.calcularNumeros, 0);
					execute = true;
				}
			}
		}
	}

	// método principal de execução da Classe
	public static void main(String[] args) {
		new CalculaArray();
	}

}
