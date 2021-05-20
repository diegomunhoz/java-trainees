package matheus;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

/**
 * Classe responsável pelo sistema de Arraylist de números inteiros
 * 
 * @author mtomazs
 * @since 25/02/2021
 */
public class CalculaArray {

	// declarando a lista de números inteiros
	private ArrayList<Integer> numeros;

	// construtor da classe
	public CalculaArray() {
		numeros = new ArrayList<Integer>();

		boolean execute = true;
		int numero = 0;
		int contador = 0;

		// método para receber do usuário os números para serem adicionados na array com sua validação
		while (execute) {
			try {
				numero = Integer.parseInt(JOptionPane.showInputDialog("Informe os números:"));
				if (Valida.isIntPositivo(numero)) {
					JOptionPane.showMessageDialog(null, "Número adicionado com sucesso!", Rotulo.sistemaCalculo, 1);
					numeros.add(numero);
					execute = true;
					contador++;
				} else {
					JOptionPane.showMessageDialog(null, "O sistema só permite números maiores que Zero", Rotulo.sistemaCalculo, 0);
					execute = true;
				}

				// contador para controlar e receber somente 10 números
				if (contador > 9) {
					menuPrincipal();
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "O sistema só permite números maiores que Zero", "", 0);
				execute = true;
			}
		}
	}

	// método para criar um menu de opções

	public void menuPrincipal() {

		String menu = "INFORME A OPÇÃO DESEJADA \n\n" + "\n1 - MAIOR ELEMENTO" + "\n2 - MENOR ELEMENTO"
				+ "\n3 - ORDEM LISTA CRESCENTE" + "\n4 - ORDEM LISTA DECRESCENTE" + "\n5 - MÉDIA DOS ELEMENTOS"
				+ "\n6 - SOMA DO MAIOR E MENOR ELEMENTO" + "\n7 - SOMA DOS ELEMENTOS IGUAIS" // SEPARADOS
				+ "\n8 - MÉDIA DOS ELEMENTOS IGUAIS" // JUNTOS
				+ "\n9 - SAIR DO SISTEMA";

		while (true) {
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
				processamentoPrincipal(opcao);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Opção Inválida", Rotulo.sistemaCalculo, 0);
			}
		}

	}

	// método para controlar o processamento do programa
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
			JOptionPane.showMessageDialog(null, "Opção inválida", Rotulo.sistemaCalculo, 0);
			break;
		}
	}

	// Método para encontrar o maior elemento da Arraylist
	public void maiorElemento() {
		for (Integer integer : numeros) {
			JOptionPane.showMessageDialog(null, ("Maior número é: " + Collections.max(numeros)), Rotulo.sistemaCalculo,
					1);
			menuPrincipal();
		}
	}

	// Método para encontrar o menor elemento da Arraylist
	public void menorElemento() {
		for (Integer integer : numeros) {
			JOptionPane.showMessageDialog(null, ("Menor número é: " + Collections.min(numeros)), Rotulo.sistemaCalculo,
					1);
			menuPrincipal();
		}
	}

	// Método para listar os elementos em ordem Crescente
	public void listaCrescente() {
		for (Integer integer : numeros) {
			Collections.sort(numeros);
			JOptionPane.showMessageDialog(null, ("Ordem crescente:\n" + numeros), Rotulo.sistemaCalculo, 1);
			menuPrincipal();
		}
	}

	// Método para listar os elementos em ordem Decrescente
	public void listaDecrescente() {
		for (Integer integer : numeros) {
			Collections.reverse(numeros);
			JOptionPane.showMessageDialog(null, numeros, Rotulo.sistemaCalculo, 1);
			menuPrincipal();
		}
	}

	// Método para calcular a média dos elementos
	public void mediaElemento() {
		double somaElementos = 0;
		double media = 0;
		for (Integer num : numeros) {
			somaElementos += num;
			media = somaElementos / 10;
		}
		JOptionPane.showMessageDialog(null, ("Média de todos os números:\n" + media), Rotulo.sistemaCalculo, 1);
	}

	// Método para somar o maior elemento com o menor
	public void somaMaiorComMenor() {
		for (Integer integer : numeros) {
			Collections.sort(numeros);
			JOptionPane.showMessageDialog(null,
					("A soma do maior número com o menor é: " + (numeros.get(numeros.size() - 1) + numeros.get(0))),
					Rotulo.sistemaCalculo, 1);
			menuPrincipal();
		}
	}

	// Método para somar cada elemento repetido separadamente
	public void somaElementosIguais() {
		String mensagem = "";
		boolean existe = false;

		for (int i = 0; i < numeros.size(); i++) {
			int quantidade = Collections.frequency(numeros, numeros.get(i));
			if (quantidade > 1) {
				existe = true;
				mensagem += "O número " + numeros.get(i) + " aparece " + quantidade +  " vezes, e a soma é: "
						+ (numeros.get(i) * quantidade) + "\n";
				i += (quantidade - 1);
			}
		}
		if (existe) {
			// exibição para o usuário
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.sistemaCalculo, 1);
		} else {
			JOptionPane.showMessageDialog(null, "O sistema não possui números repetidos", Rotulo.sistemaCalculo, 0);
		}
	}

	// Método para calcular a média dos elementos que se repetem
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
		// exibição para o usuário
		JOptionPane.showMessageDialog(null, "A média dos elementos repetidos é: " + result, Rotulo.sistemaCalculo, 1);
		} else {
			JOptionPane.showMessageDialog(null, "O sistema não possui números repetidos", Rotulo.sistemaCalculo, 0);
		}
	}

	// Método para sair do sistema
	public void sairSistema() {
		int opcao = JOptionPane.showConfirmDialog(null, "Encerrar o sistema?", "Atenção", JOptionPane.YES_OPTION,
				JOptionPane.CANCEL_OPTION);

		if (opcao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new CalculaArray();
	}
}