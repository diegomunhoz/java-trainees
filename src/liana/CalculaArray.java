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
	 * m�todo principal para executar o programa
	 */
	public static void main(String[] args) {
		new CalculaArray();
	}
	
	// declarando a listas para armazenar n�meros inteiros
	private ArrayList<Integer> numeros;

	// construtor da classe
	public CalculaArray() {
		numeros = new ArrayList<Integer>();
		pegaNumeros();
		menuPrincipal();
	}

	// m�todo para pegar n�meros do usu�rio
	public int pegaNumeros() {
		
		String msg = "N�mero inv�lido!\nDigite apenas n�meros inteiros maiores que 0!";
		int numero = 0, cont = 0;
		while (cont < 10) {
			try {
				//informa o numero
				numero = Integer.parseInt(JOptionPane.showInputDialog("Informe o " + (cont + 1) + "� n�mero:"));
				//valida se o numero � zero ou menor
				if (numero <= 0) {
					//erro caso seja vazio
					JOptionPane.showMessageDialog(null,msg, "ATEN��O!", 0);
					
				} else {
					//adiciona o n�mero ao vetor
					numeros.add(numero);
					cont++;
				}
			} catch (Exception e) {
				//erro caso digite texto
				JOptionPane.showMessageDialog(null,msg, "ATEN��O!", 0);
			}
		}
		return numero;
	}

	// m�todo para criar um menu de op��es
	public void menuPrincipal() {

		// op�oes do menu
		String menu = "Selecione uma op��o:\n" + "\n1 - Maior elemento" + "\n2 - Menor elemento"
				+ "\n3 - Ordenar lista crescente" + "\n4 - Ordenar lista decrescente" + "\n5 - M�dia dos elementos"
				+ "\n6 - Soma do maior e menor elemento" + "\n7 - Soma dos elementos iguais"
				+ "\n8 - M�dia dos elementos iguais" + "\n9 - Sair do sistema";

		// verifica��o de selecao de op��o inv�lida
		while (true) {
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
				processamentoPrincipal(opcao);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Op��o inv�lida!", "Calcula Array", 0);
			}
		}
	}

	// m�todo para controlar o processamento do programa
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
			JOptionPane.showMessageDialog(null, "Op��o inv�lida!", "Calcula Array", 0);
			break;
		}
	}

	// m�todo para pegar maior elemento digitado
	public void maiorElemento() {
		int nMaior = numeros.get(0);
		for (Integer n : numeros) {
			if (n > nMaior) {
				nMaior = n;
			}
		}
		JOptionPane.showMessageDialog(null, "Maior n�mero da lista: " + nMaior);
	}

	// m�todo para pegar menor elemento digitado
	public void menorElemento() {
		int nMenor = numeros.get(0);
		for (Integer n : numeros) {
			if (n < nMenor) {
				nMenor = n;
			}
		}
		JOptionPane.showMessageDialog(null, "Menor n�mero da lista: " + nMenor);
	}

	// m�todo para ordenar numeros de forma crescente
	public void ordenaCrescente() { // ordena a lista de forma crescente
		Collections.sort(numeros);
		JOptionPane.showMessageDialog(null, "N�meros da lista em ordem crescente: " + numeros);
	}

	// m�todo para ordenar numeros de forma decrescente
	public void ordenaDecrescente() {
		Collections.reverse(numeros);// ordena a lista de forma decrescente
		JOptionPane.showMessageDialog(null, "N�meros da lista em ordem decrescente: " + numeros);
	}

	// m�todo para calcular m�dia de todos os elementos
	public void mediaElementos() {
		int somaNumeros = 0;
		for (Integer n : numeros) {
			somaNumeros += n;
		}
		JOptionPane.showMessageDialog(null, "M�dia dos n�meros da lista: " + (somaNumeros / 10));
	}

	// m�todo para calcular soma do maior com o menor numero
	public void somaMaiorMenor() {
		Collections.sort(numeros);
		JOptionPane.showMessageDialog(null, "Soma do maior com o menor n�mero: " + (numeros.get(9) + numeros.get(0)));
	}

	// m�todo para calcular soma dos elementos que se repetem
	public void somaElementosIguais() {

		int cont = 1;
		int rep = 0;
		String msg = "N�meros repetidos: \n";
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
			JOptionPane.showMessageDialog(null, "Nenhum n�mero repetido encontrado.", "Aten��o!", 2);
		} else {
			JOptionPane.showMessageDialog(null, msg);
		}
	}

	// m�todo para calcular media de todos os elementos repetidos
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

		// calculando m�dia dos numeros repetidos
		media = media / mediaRepetidos.size();

		if (mediaRepetidos.size() == 0) {
			JOptionPane.showMessageDialog(null, "Nenhum n�mero repetido encontrado.", "Aten��o!", 2);
		} else {
			// mostrando resultado
			JOptionPane.showMessageDialog(null, "\nM�dia dos n�meros repetidos: " + media + ";");
		}
	}

	// m�todo para sair do sistema
	public void sair() {
		int opcao = JOptionPane.showConfirmDialog(null, "Encerrar o sistema?", "Aten��o", JOptionPane.YES_OPTION,
				JOptionPane.CANCEL_OPTION);

		if (opcao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
