package liana;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

/**
 * @author Liana Merlin
 * @since 25/02/2021
 */
public class CalculaArray {
	
	/*
	 * método principal para executar o programa
	 */
	public static void main(String[] args) {
		new CalculaArray();
	}
	
	// declarando a listas para armazenar números inteiros
	private ArrayList<Integer> numeros;

	// construtor da classe
	public CalculaArray() {
		numeros = new ArrayList<Integer>();
		pegaNumeros();
		menuPrincipal();
	}

	// método para pegar números do usuário
	public int pegaNumeros() {
		
		String msg = "Número inválido!\nDigite apenas números inteiros maiores que 0!";
		int numero = 0, cont = 0;
		while (cont < 10) {
			try {
				//informa o numero
				numero = Integer.parseInt(JOptionPane.showInputDialog("Informe o " + (cont + 1) + "° número:"));
				//valida se o numero é zero ou menor
				if (numero <= 0) {
					//erro caso seja vazio
					JOptionPane.showMessageDialog(null,msg, "ATENÇÃO!", 0);
					
				} else {
					//adiciona o número ao vetor
					numeros.add(numero);
					cont++;
				}
			} catch (Exception e) {
				//erro caso digite texto
				JOptionPane.showMessageDialog(null,msg, "ATENÇÃO!", 0);
			}
		}
		return numero;
	}

	// método para criar um menu de opções
	public void menuPrincipal() {

		// opçoes do menu
		String menu = "Selecione uma opção:\n" + "\n1 - Maior elemento" + "\n2 - Menor elemento"
				+ "\n3 - Ordenar lista crescente" + "\n4 - Ordenar lista decrescente" + "\n5 - Média dos elementos"
				+ "\n6 - Soma do maior e menor elemento" + "\n7 - Soma dos elementos iguais"
				+ "\n8 - Média dos elementos iguais" + "\n9 - Sair do sistema";

		// verificação de selecao de opção inválida
		while (true) {
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
				processamentoPrincipal(opcao);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Opção inválida!", "Calcula Array", 0);
			}
		}
	}

	// método para controlar o processamento do programa
	public void processamentoPrincipal(int opcao) {

		// opcoes do menu
		switch (opcao) {
		case 1: {
			maiorElemento();
			break;
		}
		case 2: {
			menorElemento();
			break;
		}
		case 3: {
			ordenaCrescente();
			break;
		}
		case 4: {
			ordenaDecrescente();
			break;
		}
		case 5: {
			mediaElementos();
			break;
		}
		case 6: {
			somaMaiorMenor();
			break;
		}
		case 7: {
			somaElementosIguais();
			break;
		}
		case 8: {
			mediaElementosIguais();
			break;
		}
		case 9: {
			sair();
			break;
		}

		default:
			JOptionPane.showMessageDialog(null, "Opção inválida!", "Calcula Array", 0);
			break;
		}
	}

	// método para pegar maior elemento digitado
	public void maiorElemento() {
		int nMaior = numeros.get(0);
		for (Integer n : numeros) {
			if (n > nMaior) {
				nMaior = n;
			}
		}
		JOptionPane.showMessageDialog(null, "Maior número da lista: " + nMaior);
	}

	// método para pegar menor elemento digitado
	public void menorElemento() {
		int nMenor = numeros.get(0);
		for (Integer n : numeros) {
			if (n < nMenor) {
				nMenor = n;
			}
		}
		JOptionPane.showMessageDialog(null, "Menor número da lista: " + nMenor);
	}

	// método para ordenar numeros de forma crescente
	public void ordenaCrescente() { // ordena a lista de forma crescente
		Collections.sort(numeros);
		JOptionPane.showMessageDialog(null, "Números da lista em ordem crescente: " + numeros);
	}

	// método para ordenar numeros de forma decrescente
	public void ordenaDecrescente() {
		Collections.reverse(numeros);// ordena a lista de forma decrescente
		JOptionPane.showMessageDialog(null, "Números da lista em ordem decrescente: " + numeros);
	}

	// método para calcular média de todos os elementos
	public void mediaElementos() {
		int somaNumeros = 0;
		for (Integer n : numeros) {
			somaNumeros += n;
		}
		JOptionPane.showMessageDialog(null, "Média dos números da lista: " + (somaNumeros / 10));
	}

	// método para calcular soma do maior com o menor numero
	public void somaMaiorMenor() {
		Collections.sort(numeros);
		JOptionPane.showMessageDialog(null, "Soma do maior com o menor número: " + (numeros.get(9) + numeros.get(0)));
	}

	// método para calcular soma dos elementos que se repetem
	public void somaElementosIguais() {

		int cont = 1;
		int rep = 0;
		String msg = "Números repetidos: \n";
		ArrayList<String> somaRepetidos = new ArrayList<String>(); // array para listar numeros repetidos

		Collections.sort(numeros); // Ordena o Array na ordem crescente

		for (int i = 0; i < 10; i++) {

			for (int j = 0; j < 10; j++) {
				if (numeros.get(i) == numeros.get(j) && i != j) {
					cont++;
					i = j;
				}
			}
			if (cont > 1) {
				rep = cont * numeros.get(i);
				somaRepetidos.add("Elemento " + numeros.get(i) + " repetindo " + cont + " vezes. Soma: " + rep + ";");
			} 
			cont = 1;
			rep = 0;
		}

		for (String n : somaRepetidos) {
			msg += "\n" + n;
		}
		if (somaRepetidos.size() == 0) {
			JOptionPane.showMessageDialog(null, "Nenhum número repetido encontrado.", "Atenção!", 2);
		} else {
			JOptionPane.showMessageDialog(null, msg);
		}
	}

	// método para calcular media de todos os elementos repetidos
	public void mediaElementosIguais() {

		// variaveis auxiliares
		int cont = 1;
		Double media = 0.0;
		// novo array para numeros repetidos
		ArrayList<Integer> mediaRepetidos = new ArrayList<Integer>(); // array para listar numeros repetidos

		Collections.sort(numeros); // Ordena o Array na ordem crescente

		for (int i = 0; i < 10; i++) {

			for (int j = 0; j < 10; j++) {
				if (numeros.get(i) == numeros.get(j) && i != j) {
					cont++;
					i = j;
				}
			}
			if (cont > 1) {
				media += (double) numeros.get(i);
				mediaRepetidos.add(numeros.get(i));
			}
			cont = 1;
		}

		// calculando média dos numeros repetidos
		media = media / mediaRepetidos.size();

		if (mediaRepetidos.size() == 0) {
			JOptionPane.showMessageDialog(null, "Nenhum número repetido encontrado.", "Atenção!", 2);
		} else {
			// mostrando resultado
			JOptionPane.showMessageDialog(null, "\nMédia dos números repetidos: " + media + ";");
		}
	}

	// método para sair do sistema
	public void sair() {
		int opcao = JOptionPane.showConfirmDialog(null, "Encerrar o sistema?", "Atenção", JOptionPane.YES_OPTION,
				JOptionPane.CANCEL_OPTION);

		if (opcao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
