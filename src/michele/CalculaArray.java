package michele;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

/**
 * Classe para obter entradas do usuario e escolher as opera��es realizadas com uma arrayList numeros
 * @author Michele Oliveira de Araujo
 * @Since 25 de fev. de 2021
 */
public class CalculaArray {

	// declarando os atributos do numeros
	private ArrayList<Integer> numeros;

	
	public CalculaArray() {

		numeros = new ArrayList<Integer>();
		adicionarNumero();
		menuPrincipal();

	}

	public void adicionarNumero() {
		//boolean aux = true;
		int cont = 0;
		
		while (cont <= 9) {
	
			
			try {
				String num = JOptionPane.showInputDialog(Mensagem.inserindoNumeros);
				int valor = Integer.parseInt(num);
				
				if (valor > 0) {
					numeros.add(valor);
				}

				if ( (valor <= 0) || Valida.isStringNum(num)) {
					JOptionPane.showMessageDialog(null, Mensagem.numeroZero, Rotulo.valorizandoArray, 0);
					cont--;
					//aux = true;
				} else {
					//aux = false;
					
				}
				
			} catch (Exception e) {
				// mensagem de erro
				JOptionPane.showMessageDialog(null, Mensagem.numeroVazio, Rotulo.valorizandoArray, 0);
				cont--;
			}
			
			cont++;

		}

//		for (Integer integer : numeros) {
//			System.out.println(integer);
//		}
	}

	// m�todo para criar um menu de op��es
	public void menuPrincipal() {

		String menu = "INFORME A OP��O DESEJADA\n" + "\n1 - MAIOR ELEMENTO" + "\n2 - MENOR ELEMENTO"
				+ "\n3 - ORDENAR LISTA CRESCENTE" + "\n4 - ORDENAR LISTA DECRESCENTE" + "\n5 - M�DIA DOS ELEMENTOS"
				+ "\n6 - SOMA DO MAIOR E MENOR ELEMENTO" + "\n7 - SOMA DOS ELEMENTOS IGUAIS"
				+ "\n8 - M�DIA DOS ELEMENTOS IGUAIS" + "\n9 - SAIR DO SISTEMA";

		// valida��o das op��es do menu
		while (true) {
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
				processamentoPrincipal(opcao);
			} catch (Exception e) {
				// mensagem erro
				JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalido, Rotulo.entradaValores, 0);
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
			ordernarListaCrescente();
			break;
		}
		case 4: {
			ordernarListaDecrescente();
			break;
		}
		case 5: {
			mediaElementos();
			break;
		}
		case 6: {
			somaMaiorMenorElemento();
			break;
		}
		case 7: {
			somaDosElementosIguais();
			break;
		}
		case 8: {
			mediaDosElementosIguais();
			break;
		}
		case 9: {
			sair();
			break;
		}

		default:
			JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalido, Rotulo.entradaValores, 0);
			break;
		}

	}
	//m�todo para encontrar o maior elemento
	private void maiorElemento() {
		String texto = "";
		Collections.reverse(numeros);
		texto += numeros.get(0);
		JOptionPane.showMessageDialog(null, "Maior valor: " + texto, Rotulo.maiorElementos, 1);
	}
	
	//m�todo para encontrar o menor elemento
	private void menorElemento() {
		String texto = "";
		Collections.sort(numeros);
		texto += numeros.get(0);
		JOptionPane.showMessageDialog(null, "Menor valor: "+ texto, Rotulo.menorElementos, 1);
	}
	//m�todo para ordenar os valores em ordem crescente
	private void ordernarListaCrescente() {
		Collections.sort(numeros);
		String texto = "";
		for (Integer num : numeros) {
			texto += num + " ";
			
		}
		
		JOptionPane.showMessageDialog(null, texto, Rotulo.ordemCrescenteElementos, 1);

	}
	//metodo para ordenar a lista em ordem decrescente
	private void ordernarListaDecrescente() {
		Collections.reverse(numeros);
		String texto = "";
		for (Integer num : numeros) {
			texto += num + " ";

		}

		JOptionPane.showMessageDialog(null, texto, Rotulo.ordemdecrescenteElementos, 1);
	}
	//m�todo para encontrar a m�dia dos elementos
	private void mediaElementos() {
		int somaElementos = 0;
		int media = 0;
		for (Integer num : numeros) {
			somaElementos += num;
		}
		media = somaElementos / 10;
		JOptionPane.showMessageDialog(null, "M�dia: " + media, Rotulo.mediaElementos, 1);
	}

	//m�todo para somar o menor elemento com o maior
	private void somaMaiorMenorElemento() {
		int soma = 0;
		Collections.sort(numeros);
		soma = numeros.get(numeros.size() - 1) + numeros.get(0);
		System.out.println(soma);
		JOptionPane.showMessageDialog(null, "Soma: " + soma, Rotulo.somaMaiorMenor, 1);
	}
	
	//metodo para somar elementos repetidos
	private void somaDosElementosIguais() {
		String texto = "";
		boolean existe = false;
		for (int i = 0; i < numeros.size(); i++) {
			Collections.sort(numeros);
			int vezes = Collections.frequency(numeros, numeros.get(i));

			 if (vezes > 1) {
			existe = true;
					texto += "Numeros repetidos: " + numeros.get(i) + "\n";
					texto += "Foi encontrado : " + vezes + "\n";
					texto += "Soma : " + (vezes * numeros.get(i)) +"\n" ;
					i += (vezes - 1);
				}
			}
		
		if (existe) {
			JOptionPane.showMessageDialog(null, texto, Rotulo.media, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.numerosRepetidosVazio, Rotulo.media, 2);
		}
	}

	//m�todo para obter a media dos elementos repetidos
	private void mediaDosElementosIguais() {
		int soma = 0;
		int cont = 0;
		int media = 0;
		boolean existe = false;
		for (Integer num : numeros) {
			if (Collections.frequency(numeros, num) >= 2) {
				existe = true;
				cont++;
				soma += num;
				media = soma / cont;
			}

		}
		if (existe) {
			JOptionPane.showMessageDialog(null, "M�dia: " + media, Rotulo.media, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.numerosRepetidosVazio, Rotulo.media, 2);
		}

	}
	
	//metodo sair
	public void sair() {
		int opcao = JOptionPane.showConfirmDialog(null, "Encerrar o sistema?", "Aten��o", JOptionPane.YES_OPTION,
				JOptionPane.CANCEL_OPTION);
		// se o usurio clicar em yes ele sai do sistema
		if (opcao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}
	
	//metodo principal para executar a classe
	public static void main(String[] args) {
		new CalculaArray();
	}
}
