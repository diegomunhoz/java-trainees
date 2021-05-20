package lucaspedroso;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

/**
 * Classe para praticar o uso de um ArrayList possuindo as op��es: 1. Maior
 * elemento; 2. Menor elemento; 3. Ordenar Lista Crescente; 4. Ordenar Lista
 * Decrescente; 5. M�dia dos elementos; 6. Soma do maior e menor elemento; 7.
 * Soma dos elementos iguais; 8. M�dia dos elementos iguais; 9. Sair do sistema;
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

////// Declarando r�tulos
	public static String calculaArray = "Menu ArrayList";
	public static String rotuloMaiorElemento = "Maior elemento";
	public static String rotuloMenorElemento = "Menor elemento";
	public static String rotuloMediaElementos = "M�dia elementos";
	public static String rotuloSomaMaiorMenor = "Soma do maior e menor elemento";
	public static String rotuloSomaIguais = "Soma dos elementos iguais";
	public static String rotuloMediaIguais = "M�dia dos elementos iguais";
	public static String rotuloCarregaLista = "Carregar ArrayList de Inteiros";

////// Declarando Mensagens
	public static String selecionaOpcao = "Informe o c�digo da op��o desejada: \n" + "\n1.      Maior elemento"
			+ "\n2.      Menor elemento" + "\n3.      Ordenar Lista Crescente" + "\n4.      Ordenar Lista Decrescente"
			+ "\n5.      M�dia dos elementos" + "\n6.      Soma do maior e menor elemento"
			+ "\n7.      Soma dos elementos iguais" + "\n8.      M�dia dos elementos iguais"
			+ "\n9.      Sair do sistema\n";

	public static String opcaoInvalida = "Op��o Invalida!";
	public static String valorInvalido = "Valor Invalido!\nFavor informe apenas n�meros inteiros e maiores do que zero";

	public static String mensagemMaiorElemento = "O maior elemento �: ";
	public static String mensagemMenorElemento = "O menor elemento �: ";
	public static String mensagemMediaElementos = "A m�dia dos elementos �: ";
	public static String mensagemSomaMaiorMenor = "A soma do maior com o menor elemento �: ";

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

//		Recebendo do usu�rio valores para a lista
		carregaLista();
		
		// chamando o m�todo do menu principal
		menuPrincipal();
	}

//  M�todo para carregar dados na lista
	public void carregaLista() {

		// la�o de repeti��o para receber apenas valores validos e maiores do que 0
		for (int i = 0; i < 10; i++) {
			boolean positivo = false;
			while (!positivo) {
				// testando se o valor informado � valido
				try {
					int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe o " + (i + 1) + " n�mero: "));
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

//	M�todo para criar um menu de op��es
	public void menuPrincipal() {

		// la�o de repeti��o para executar o menu
		while (true) {
			// testando se o c�digo da op��o informado � valido
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(selecionaOpcao));
				processamentoPrincipal(opcao);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, opcaoInvalida, calculaArray, 0);
			}
		}
	}

//	M�todo para controlar o processamento do sistema
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

//	M�todos para encontrar e mostrar maior elemento
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

//	M�todos para encontrar e mostrar menor elemento
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

//	M�todo para ordenar a lista em ordem crescente
	public void ordenaCrescente() {
		listaNumeros.sort(null);
		mostraLista();
	}

//	M�todo para ordenar a lista em ordem crescente
	public void ordenaDecrescente() {
		listaNumeros.sort(Collections.reverseOrder());
		mostraLista();
	}

//	M�todos para calcular e exibir m�dia dos elementos
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

//	M�todos para calcular e mostrar a soma dos maiores e menores elementos
	public void somaMaiorMenor() {
		JOptionPane.showMessageDialog(null, mensagemSomaMaiorMenor + getSomaMaiorMenor(), rotuloSomaMaiorMenor, 1);
	}

	public int getSomaMaiorMenor() {
		int soma = getMaiorElemento() + getMenorElemento();
		return soma;
	}

//	M�todo para realizar soma dos itens iguais
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
				mensagem += "A soma dos elementos iguais a " + integer + " presentes na lista �: " + soma + "\n";
			}
		}
		if (mensagem == "Soma dos elementos iguais\n\n") {
			mensagem += "Nenhum elemento repetido na lista";
		}
		JOptionPane.showMessageDialog(null, mensagem, rotuloSomaIguais, 1);
	}

//	M�todo para calcular a m�dia dos elementos iguais na lista
	public void mediaIguais() {
		int soma = 0;
		int somado = 0;
		int cont = 0;
		double media = 0;
		String mensagem = "M�dia dos elementos iguais\n\n";

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
			mensagem += "A m�dia dos elementos iguais �: " + media / cont;
		}
		JOptionPane.showMessageDialog(null, mensagem, rotuloMediaIguais, 1);
	}

//  M�todo para mostrar a lista
	public void mostraLista() {
		JOptionPane.showMessageDialog(null, listaNumeros.toString(), calculaArray, 1);
	}

//	M�todo para sair do sistema
	public void sair() {
		int opcao = JOptionPane.showConfirmDialog(null, "Encerrar o sistema?", "Aten��o", JOptionPane.YES_OPTION,
				JOptionPane.CANCEL_OPTION);

		if (opcao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

////// M�todos de valida��o
	// vereficando se o valor digitado � zero
	public static boolean isIntZero(int args) {
		return (args == 0);
	}

////// M�todo principal (main) para executar a classe
	public static void main(String[] args) {
		new CalculaArray();
	}
}
