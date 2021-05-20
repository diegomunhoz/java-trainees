package elisandro;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 * Programa para Efetuar calculos e operações dentro de um Array de Inteiros.
 * 
 * @author Elisandro Heck
 * @Since 25 de fev. de 2021
 * 
 */
public class CalculaArray {

	// declarando a lista para armazenar os numeros:
	private ArrayList<Integer> numeros;

	// declarando o construtor da classe
	public CalculaArray() {
		numeros = new ArrayList<Integer>();
		getNumeros();
		menuPrincipal();
	}

	// ***************************************************************************************************************
	// metodo para criar um menu de Opçoes:
	public void menuPrincipal() {

		String menu = "DIGITE A OPÇAO DESEJADA\n" 
						+ "\n1 - MAIOR ELEMENTO " 
						+ "\n2 - MENOR ELEMENTO"
						+ "\n3 - ORDEM CRESCENTE " 
						+ "\n4 - ORDEM DECRESCENTE" 
						+ "\n5 - MEDIA DOS ELEMENTOS "
						+ "\n6 - SOMA DO MAIOR E MENOR " 
						+ "\n7 - SOMA DOS IGUAIS " 
						+ "\n8 - MEDIA DOS IGUAIS "
						+ "\n9 - SAIR DO SISTEMA";

		while (true) {
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
				processamentoPrincipal(opcao);

			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulos.calculoArray, 0);
			}
		}
	}

	// ***************************************************************************************************************
	// metodo pra controlar o processsamento do programa.
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
			ordemCrescente();
			break;
		}
		case 4: {
			ordemDecrescente();
			break;
		}
		case 5: {
			mediaElementos();
			;
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
			sairSistema();
			break;
		}
		default:
			JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulos.escolhaMenu, 1);
			break;
		}
	}

	// ***************************************************************************************************************
	// criação do metodo pra executar o menu de Maior elemento digitado
	public void maiorElemento() {
		Collections.sort(numeros);// ordena em ordem Crescente
		String msg = "Exibindo MAIOR valor:\n";
		msg += numeros.get(9);// pega o ultima elemento no indice 9;
		JOptionPane.showMessageDialog(null, msg, Rotulos.maiorValor, 1);
	}

	// ***************************************************************************************************************
	// criação do metodo pra executar o menu de MENOR elemento digitado
	public void menorElemento() {
		Collections.sort(numeros);// ordena em ordem crecente
		String msg = "Exibindo MENOR valor:\n";
		msg += numeros.get(0);
		JOptionPane.showMessageDialog(null, msg, Rotulos.menorValor, 1);
	}

	// ***************************************************************************************************************
	// criação do metodo pra executar o menu de Menor para Maior elementos digitados
	public void ordemCrescente() {
		Collections.sort(numeros);// ordena em ordem crecente
		String msg = "Exibindo em ORDEM CRESCENTE :\n";
		for (Integer numero : numeros) {
			msg += numero + ",";
		}
		JOptionPane.showMessageDialog(null, msg, Rotulos.ordemCrescente, 1);

	}

	// ***************************************************************************************************************
	// criação do metodo pra executar o menu de MAIOR para MENOR elementos digitados
	public void ordemDecrescente() {
		Collections.reverse(numeros);// ordena a lista de forma decrescente
		String msg = "Exibindo em ORDEM DECRESCENTE :\n";
		for (Integer numero : numeros) {
			msg += numero + ",";
		}
		JOptionPane.showMessageDialog(null, msg, Rotulos.ordemDecrescente, 1);
	}

	// ***************************************************************************************************************
	// criação do metodo pra executar o menu de MEDIA SIMPLES dos elementos digitados
	public void mediaElementos() {

		double mediaElementos = 0;
		int somaElementos = 0;
		String msg = "MEDIA dos Numeros: :\n";
		for (Integer numero : numeros) {
			somaElementos += numero;
		}
		mediaElementos = ((somaElementos) / 10);
		msg += mediaElementos;

		JOptionPane.showMessageDialog(null, msg, Rotulos.mediaElementos, 1);
	}

	// ***************************************************************************************************************
	// criação do metodo pra executar o menu de SOMAR o MAIOR e o  Menor  elementos digitados
	public void somaMaiorMenor() {
		Collections.sort(numeros);// ordena em ordem Crescente
		int somar = 0;
		String msg = "SOMANDO os MAIOR e MENOR Valores :\n";
		msg += numeros.get(9) + "+";// pega o elementos do indice 9 pra mostrar na msg
		msg += numeros.get(0) + "=";// pega o elementos do indice 0 pra mostrar na msg
		somar = (numeros.get(9) + numeros.get(0));// simples soma
		JOptionPane.showMessageDialog(null, msg + somar, Rotulos.somarElementos, 1);

//		Collections.sort(numeros);
//		System.out.println(numeros.get(numeros.size() - 1) + numeros.get(0));
	}

	// ***************************************************************************************************************
	// criação do metodo pra executar o menu de SOMAR Elementos Repetidos entre SI.
	public void somaIguais() {
		String msg = "";
		boolean existe = false;

		for (int i = 0; i < numeros.size(); i++) {
			int quantidade = Collections.frequency(numeros, numeros.get(i));
			if (quantidade > 1) {
				existe = true;
				msg += "Repete se : " + numeros.get(i) + "  \n";
				msg += "Total de : " + quantidade + " vezes  \n";
				msg += "Soma é : " + (numeros.get(i) * quantidade) + "   \n\n";
				i += (quantidade - 1);
			
			}
		}
		if (existe) {
			// resultado em tela
			JOptionPane.showMessageDialog(null, msg, Rotulos.somarElementos, 1);
		}else
			JOptionPane.showMessageDialog(null, "Não Existem numeros Repetidos",Rotulos.somarElementos,0);
	}

	// ***************************************************************************************************************
	// criação do metodo pra executar o menu de Calcular a Media de todos Elementos Repetidos
	public void mediaIguais() {
		// Cálculo para obter a média total dos elementos iguais
		boolean existe = false;
		int soma = 0;
		int contador = 0;
		double media = 0;
		for (Integer numero : numeros) {
			if (Collections.frequency(numeros, numero) >= 2) {//verifica se a frequencia de repeticão é pelo menos 2x.
				contador++;
				soma += numero;
				media = soma / contador;
				existe = true;
			}
		}
		if (existe) {
			// resultado em tela
			JOptionPane.showMessageDialog(null, "A média dos elementos repetidos é: " + media, Rotulos.mediaElementos, 1);
		}else
			JOptionPane.showMessageDialog(null, "Não Existem numeros Repetidos",Rotulos.mediaElementos,0);
	}

	// ***************************************************************************************************************
	//metodo pra sair com pergunta antes.
	public void sairSistema() {
		int opcao = JOptionPane.showConfirmDialog(null, "Encerrar Sistema?", "Atenção", JOptionPane.YES_OPTION,
				JOptionPane.CANCEL_OPTION);
		if (opcao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}

	// ***************************************************************************************************************
	//metodo para receber os 10 numeros 
	private void getNumeros() {

		for (int i = 0; i < 10; i++) {
			boolean execute = true;
			int numero = 0;

			while (execute) {
				try {
					numero = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.digiteNumero));
					if (Valida.isMaiorZero(numero)) {//validação de numeros apenas inteiros positivos.
						JOptionPane.showMessageDialog(null, Mensagem.numeroInvalido, Rotulos.entradaArray, 0);
						execute = true;
					} else {
						numeros.add(numero);
						execute = false;
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, Mensagem.numeroInvalido, Rotulos.entradaArray, 0);
					execute = true;
				}
				System.out.println( numero ) ;//opcional: aparece no console os numeros digitados pra facilitar
			}

		}
	}// fim getNumeros
		// ***************************************************************************************************************
	
	public static void main(String[] args) {
		new CalculaArray();

	}
}
// entrega arquivo CalculaArray.java , Mensagem, Rotulo, Valida, Main no email

/*
 * Desenvolver um programa java chamado CalculaArray.java no projeto
 * java-basico, pacote exercicios que deverá atender os seguintes quesitos: ·
 * uma ArrayList de números inteiros; · o usuário deverá informar 10 números
 * maiores que zero e NÃO pode permitir nenhum valor diferente de números;
 * 
 * O programa deve atender as seguintes opções: 1. Maior elemento; 2. Menor
 * elemento; 3. Ordenar Lista Crescente; 4. Ordenar Lista Decrescente; 5. Média
 * dos elementos; 6. Soma do maior e menor elemento; 7. Soma dos elementos
 * iguais;// apenas 1 JOP 8. Média dos elementos iguais; // apenas uma media 9.
 * Sair do sistema
 */

