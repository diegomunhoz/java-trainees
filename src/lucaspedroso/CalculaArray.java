package lucaspedroso;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

/**
 * Classe para praticar o uso de um ArrayList possuindo as opções: 1. Maior
 * elemento; 2. Menor elemento; 3. Ordenar Lista Crescente; 4. Ordenar Lista
 * Decrescente; 5. Média dos elementos; 6. Soma do maior e menor elemento; 7.
 * Soma dos elementos iguais; 8. Média dos elementos iguais; 9. Sair do sistema;
 * 
 * @author Lucas Pedroso Krzyzanowski
 * @since 25 de fev. de 2021
 */
public class CalculaArray {

////// Declarando lista de inteiros
	private ArrayList<Integer> listaNumeros;

	// declarando variaveis auxiliares
	private int maiorN = 0;
	private int menorN = 2147483647;

////// Declarando rótulos
	public static String calculaArray = "Menu ArrayList";
	public static String rotuloMaiorElemento = "Maior elemento";
	public static String rotuloMenorElemento = "Menor elemento";
	public static String rotuloMediaElementos = "Média elementos";
	public static String rotuloSomaMaiorMenor = "Soma do maior e menor elemento";
	public static String rotuloSomaIguais = "Soma dos elementos iguais";
	public static String rotuloMediaIguais = "Média dos elementos iguais";
	public static String rotuloCarregaLista = "Carregar ArrayList de Inteiros";

////// Declarando Mensagens
	public static String selecionaOpcao = "Informe o código da opção desejada: \n" + "\n1.      Maior elemento"
			+ "\n2.      Menor elemento" + "\n3.      Ordenar Lista Crescente" + "\n4.      Ordenar Lista Decrescente"
			+ "\n5.      Média dos elementos" + "\n6.      Soma do maior e menor elemento"
			+ "\n7.      Soma dos elementos iguais" + "\n8.      Média dos elementos iguais"
			+ "\n9.      Sair do sistema\n";

	public static String opcaoInvalida = "Opção Invalida!";
	public static String valorInvalido = "Valor Invalido!\nFavor informe apenas números inteiros e maiores do que zero";

	public static String mensagemMaiorElemento = "O maior elemento é: ";
	public static String mensagemMenorElemento = "O menor elemento é: ";
	public static String mensagemMediaElementos = "A média dos elementos é: ";
	public static String mensagemSomaMaiorMenor = "A soma do maior com o menor elemento é: ";

	// contrutor da classse CalculaArray
	public CalculaArray() {
		// instanciando a lista
		listaNumeros = new ArrayList<Integer>();

//		// inicializando os valores da lista
//		listaNumeros.add(1);
//		listaNumeros.add(2);
//		listaNumeros.add(5);
//		listaNumeros.add(4);
//		listaNumeros.add(5);
//		listaNumeros.add(6);
//		listaNumeros.add(7);
//		listaNumeros.add(8);
//		listaNumeros.add(10);
//		listaNumeros.add(10);

//		Recebendo do usuário valores para a lista
		carregaLista();
		
		// chamando o método do menu principal
		menuPrincipal();
	}

//  Método para carregar dados na lista
	public void carregaLista() {

		// laço de repetição para receber apenas valores validos e maiores do que 0
		for (int i = 0; i < 10; i++) {
			boolean positivo = false;
			while (!positivo) {
				// testando se o valor informado é valido
				try {
					int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe o " + (i + 1) + " número: "));
					if (numero > 0) {
						listaNumeros.add(numero);
						positivo = true;
					} else {
						JOptionPane.showMessageDialog(null, valorInvalido, rotuloCarregaLista, 0);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, valorInvalido, rotuloCarregaLista, 0);
				}
			}
		}
	}

//	Método para criar um menu de opções
	public void menuPrincipal() {

		// laço de repetição para executar o menu
		while (true) {
			// testando se o código da opção informado é valido
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(selecionaOpcao));
				processamentoPrincipal(opcao);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, opcaoInvalida, calculaArray, 0);
			}
		}
	}

//	Método para controlar o processamento do sistema
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
			somaIguais();
			break;
		}
		case 8: {
			mediaIguais();
			break;
		}
		case 9: {
			sair();
			break;
		}
		default:
			JOptionPane.showMessageDialog(null, opcaoInvalida, calculaArray, 0);
			break;
		}
	}

//	Métodos para encontrar e mostrar maior elemento
	public void maiorElemento() {
		JOptionPane.showMessageDialog(null, mensagemMaiorElemento + getMaiorElemento(), rotuloMaiorElemento, 1);
	}

	public int getMaiorElemento() {
		for (Integer integer : listaNumeros) {
			if (integer > maiorN) {
				maiorN = integer;
			}
		}
		return maiorN;
	}

//	Métodos para encontrar e mostrar menor elemento
	public void menorElemento() {
		JOptionPane.showMessageDialog(null, mensagemMenorElemento + getMenorElemento(), rotuloMenorElemento, 1);
	}

	public int getMenorElemento() {
		for (Integer integer : listaNumeros) {
			if (integer < menorN) {
				menorN = integer;
			}
		}
		return menorN;
	}

//	Método para ordenar a lista em ordem crescente
	public void ordenaCrescente() {
		listaNumeros.sort(null);
		mostraLista();
	}

//	Método para ordenar a lista em ordem crescente
	public void ordenaDecrescente() {
		listaNumeros.sort(Collections.reverseOrder());
		mostraLista();
	}

//	Métodos para calcular e exibir média dos elementos
	public void mediaElementos() {
		JOptionPane.showMessageDialog(null, mensagemMediaElementos + getMediaElementos(), rotuloMediaElementos, 1);
	}

	public double getMediaElementos() {
		double media = 0;

		for (Integer integer : listaNumeros) {
			media += integer;
		}
		media /= 10;

		return media;
	}

//	Métodos para calcular e mostrar a soma dos maiores e menores elementos
	public void somaMaiorMenor() {
		JOptionPane.showMessageDialog(null, mensagemSomaMaiorMenor + getSomaMaiorMenor(), rotuloSomaMaiorMenor, 1);
	}

	public int getSomaMaiorMenor() {
		int soma = getMaiorElemento() + getMenorElemento();
		return soma;
	}

//	Método para realizar soma dos itens iguais
	public void somaIguais() {
		int soma;
		int somado = 0;
		String mensagem = "Soma dos elementos iguais\n\n";

		for (Integer integer : listaNumeros) {
			soma = 0;
			for (Integer integer2 : listaNumeros) {
				if (integer.equals(integer2) && integer != somado) {
					soma += integer2;
				}
			}
			if (soma > integer) {
				somado = integer;
				mensagem += "A soma dos elementos iguais a " + integer + " presentes na lista é: " + soma + "\n";
			}
		}
		if (mensagem == "Soma dos elementos iguais\n\n") {
			mensagem += "Nenhum elemento repetido na lista";
		}
		JOptionPane.showMessageDialog(null, mensagem, rotuloSomaIguais, 1);
	}

//	Método para calcular a média dos elementos iguais na lista
	public void mediaIguais() {
		int soma = 0;
		int somado = 0;
		int cont = 0;
		double media = 0;
		String mensagem = "Média dos elementos iguais\n\n";

		for (Integer integer : listaNumeros) {
			soma = 0;
			for (Integer integer2 : listaNumeros) {
				if (integer.equals(integer2) && integer != somado) {
					soma += integer2;
				}
			}
			if (soma > integer) {
				somado = integer;
				media += soma;
				cont += soma / integer;
			}
		}
		if (media == 0) {
			mensagem += "Nenhum elemento repetido na lista";
		} else {
			mensagem += "A média dos elementos iguais é: " + media / cont;
		}
		JOptionPane.showMessageDialog(null, mensagem, rotuloMediaIguais, 1);
	}

//  Método para mostrar a lista
	public void mostraLista() {
		JOptionPane.showMessageDialog(null, listaNumeros.toString(), calculaArray, 1);
	}

//	Método para sair do sistema
	public void sair() {
		int opcao = JOptionPane.showConfirmDialog(null, "Encerrar o sistema?", "Atenção", JOptionPane.YES_OPTION,
				JOptionPane.CANCEL_OPTION);

		if (opcao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

////// Métodos de validação
	// vereficando se o valor digitado é zero
	public static boolean isIntZero(int args) {
		return (args == 0);
	}

////// Método principal (main) para executar a classe
	public static void main(String[] args) {
		new CalculaArray();
	}
}
