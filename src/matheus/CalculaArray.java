package matheus;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

/**
 * Classe respons�vel pelo sistema de Arraylist de n�meros inteiros
 * 
 * @author mtomazs
 * @since 25/02/2021
 */
public class CalculaArray {

	// declarando a lista de n�meros inteiros
	private ArrayList<Integer> numeros;

	// construtor da classe
	public CalculaArray() {
		numeros = new ArrayList<Integer>();

		boolean execute = true;
		int numero = 0;
		int contador = 0;

		// m�todo para receber do usu�rio os n�meros para serem adicionados na array com sua valida��o
		while (execute) {
			try {
				numero = Integer.parseInt(JOptionPane.showInputDialog("Informe os n�meros:"));
				if (Valida.isIntPositivo(numero)) {
					JOptionPane.showMessageDialog(null, "N�mero adicionado com sucesso!", Rotulo.sistemaCalculo, 1);
					numeros.add(numero);
					execute = true;
					contador++;
				} else {
					JOptionPane.showMessageDialog(null, "O sistema s� permite n�meros maiores que Zero", Rotulo.sistemaCalculo, 0);
					execute = true;
				}

				// contador para controlar e receber somente 10 n�meros
				if (contador > 9) {
					menuPrincipal();
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "O sistema s� permite n�meros maiores que Zero", "", 0);
				execute = true;
			}
		}
	}

	// m�todo para criar um menu de op��es

	public void menuPrincipal() {

		String menu = "INFORME A OP��O DESEJADA \n\n" + "\n1 - MAIOR ELEMENTO" + "\n2 - MENOR ELEMENTO"
				+ "\n3 - ORDEM LISTA CRESCENTE" + "\n4 - ORDEM LISTA DECRESCENTE" + "\n5 - M�DIA DOS ELEMENTOS"
				+ "\n6 - SOMA DO MAIOR E MENOR ELEMENTO" + "\n7 - SOMA DOS ELEMENTOS IGUAIS" // SEPARADOS
				+ "\n8 - M�DIA DOS ELEMENTOS IGUAIS" // JUNTOS
				+ "\n9 - SAIR DO SISTEMA";

		while (true) {
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
				processamentoPrincipal(opcao);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Op��o Inv�lida", Rotulo.sistemaCalculo, 0);
			}
		}

	}

	// m�todo para controlar o processamento do programa
	public void processamentoPrincipal(int opcao) {
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
			listaCrescente();
			break;
		}

		case 4: {
			listaDecrescente();
			break;
		}

		case 5: {
			mediaElemento();
			break;
		}

		case 6: {
			somaMaiorComMenor();
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
			sairSistema();
			break;
		}

		default:
			JOptionPane.showMessageDialog(null, "Op��o inv�lida", Rotulo.sistemaCalculo, 0);
			break;
		}
	}

	// M�todo para encontrar o maior elemento da Arraylist
	public void maiorElemento() {
		for (Integer integer : numeros) {
			JOptionPane.showMessageDialog(null, ("Maior n�mero �: " + Collections.max(numeros)), Rotulo.sistemaCalculo,
					1);
			menuPrincipal();
		}
	}

	// M�todo para encontrar o menor elemento da Arraylist
	public void menorElemento() {
		for (Integer integer : numeros) {
			JOptionPane.showMessageDialog(null, ("Menor n�mero �: " + Collections.min(numeros)), Rotulo.sistemaCalculo,
					1);
			menuPrincipal();
		}
	}

	// M�todo para listar os elementos em ordem Crescente
	public void listaCrescente() {
		for (Integer integer : numeros) {
			Collections.sort(numeros);
			JOptionPane.showMessageDialog(null, ("Ordem crescente:\n" + numeros), Rotulo.sistemaCalculo, 1);
			menuPrincipal();
		}
	}

	// M�todo para listar os elementos em ordem Decrescente
	public void listaDecrescente() {
		for (Integer integer : numeros) {
			Collections.reverse(numeros);
			JOptionPane.showMessageDialog(null, numeros, Rotulo.sistemaCalculo, 1);
			menuPrincipal();
		}
	}

	// M�todo para calcular a m�dia dos elementos
	public void mediaElemento() {
		double somaElementos = 0;
		double media = 0;
		for (Integer num : numeros) {
			somaElementos += num;
			media = somaElementos / 10;
		}
		JOptionPane.showMessageDialog(null, ("M�dia de todos os n�meros:\n" + media), Rotulo.sistemaCalculo, 1);
	}

	// M�todo para somar o maior elemento com o menor
	public void somaMaiorComMenor() {
		for (Integer integer : numeros) {
			Collections.sort(numeros);
			JOptionPane.showMessageDialog(null,
					("A soma do maior n�mero com o menor �: " + (numeros.get(numeros.size() - 1) + numeros.get(0))),
					Rotulo.sistemaCalculo, 1);
			menuPrincipal();
		}
	}

	// M�todo para somar cada elemento repetido separadamente
	public void somaElementosIguais() {
		String mensagem = "";
		boolean existe = false;

		for (int i = 0; i < numeros.size(); i++) {
			int quantidade = Collections.frequency(numeros, numeros.get(i));
			if (quantidade > 1) {
				existe = true;
				mensagem += "O n�mero " + numeros.get(i) + " aparece " + quantidade +  " vezes, e a soma �: "
						+ (numeros.get(i) * quantidade) + "\n";
				i += (quantidade - 1);
			}
		}
		if (existe) {
			// exibi��o para o usu�rio
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.sistemaCalculo, 1);
		} else {
			JOptionPane.showMessageDialog(null, "O sistema n�o possui n�meros repetidos", Rotulo.sistemaCalculo, 0);
		}
	}

	// M�todo para calcular a m�dia dos elementos que se repetem
	public void mediaElementosIguais() {
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
		if(existe) {
		// exibi��o para o usu�rio
		JOptionPane.showMessageDialog(null, "A m�dia dos elementos repetidos �: " + result, Rotulo.sistemaCalculo, 1);
		} else {
			JOptionPane.showMessageDialog(null, "O sistema n�o possui n�meros repetidos", Rotulo.sistemaCalculo, 0);
		}
	}

	// M�todo para sair do sistema
	public void sairSistema() {
		int opcao = JOptionPane.showConfirmDialog(null, "Encerrar o sistema?", "Aten��o", JOptionPane.YES_OPTION,
				JOptionPane.CANCEL_OPTION);

		if (opcao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new CalculaArray();
	}
}