package israel;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

/**
 * Classe responsavel por controlar o sistema de calcular Array
 *
 * @author Israel Oliveira Rodrigues
 * @since 25 de fev. de 2021
 * 
 */
public class CalculaArray {

	private ArrayList<Integer> numeros;

	public CalculaArray() {

		numeros = new ArrayList<Integer>();

		// Declarando vari�veis
		int contador = 1;
		Integer numero = 0;
		boolean execute = true;

		// Imput de dados pelo usu�rio
		while (execute) {
			try {
				
				numero = Integer.parseInt(JOptionPane.showInputDialog(null, Mensagem.informeNumero, Rotulo.calculaArray, 1));
				// Verificando se o n�mero informado � positivo ou negativo, caso seja negativo
				// o sistema apresentar� uma mensagem
				
				if (Valida.isIntPositivo(numero)) {
					numeros.add(numero);
					execute = true;
					contador++;
				} else {
					// Erro caso o valor informado seja negativo
					JOptionPane.showMessageDialog(null, "Informe um numero maior que 0", Rotulo.calculaArray, 0);
					execute = true;
				}

				if (contador > 10) {
					// Mensagem de sucesso no cadastro ap�s o imput dos 10 valores
					JOptionPane.showMessageDialog(null, Mensagem.numerosCadastrados, Rotulo.calculaArray, 1);

					menuPrincipal();
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Informe um valor v�lido", Rotulo.calculaArray, 0);
				execute = true;
			}
		}
		menuPrincipal();
	}

	// M�todo para criar um menu de op��es
	public void menuPrincipal() {

		String menu = "INFORME A OP��O DESEJADA\n\n"

				+ "1 - Maior elemento\n" 
				+ "2 - Menor elemento\n" 
				+ "3 - Ordenar Lista Crescente\n"
				+ "4 - Ordenar Lista Decrescente\n" 
				+ "5 - M�dia dos elementos\n"
				+ "6 - Soma do maior e menor elemento\n" 
				+ "7 - Soma dos elementos iguais\n"
				+ "8 - M�dia dos elementos iguais\n" 
				+ "9 - Sair do sistema\n";

		// Verificando se o usu�rio digitou uma op��o v�lida ou inv�lida, caso seja
		// inv�lida ser� apresentada uma mensagem de erro
		while (true) {
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
				processamentoPrincipal(opcao);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulo.calculaArray, 0);
			}
		}
	}

	// M�todo principal para processamento do programa
	public void processamentoPrincipal(int opcao) {

		switch (opcao) {
		case 1: {
			mostrarMaiorElemento();
			break;
		}
		case 2: {
			mostrarMentoElemento();
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
			somaMaiorMenorElemento();
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
			JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulo.calculaArray, 0);
			break;
		}
	}

	// 1. M�todo para mostrar o maior elemento
	public void mostrarMaiorElemento() {

		// Exibindo para o usu�rio o maior elemento utilizando o m�todo max da classe Collections
		JOptionPane.showMessageDialog(null, "O maior n�mero �: " + Collections.max(numeros), Rotulo.maiorValor, 1);
	}

	// 2. M�todo para mostrar o menor elemento
	public void mostrarMentoElemento() {

		// Exibindo para o usu�rio o menor elemento utilizando o m�todo min da classe Collections
		JOptionPane.showMessageDialog(null, "O menor n�mero �: " + Collections.min(numeros), Rotulo.menorValor, 1);
	}

	// 3. M�todo para ordenar a lista crescente
	public void ordenarListaCrescente() {
		
		// Ordenando os elementos em ordem crescente utilizando o m�todo sort da classe Collections
		Collections.sort(numeros);

		// Exibindo para o usu�rio os elementos em ordem crescente
		JOptionPane.showMessageDialog(null, "Elementos em ordem crescente: " + numeros, Rotulo.ordenarCrescente, 1);
		
	}

	// 4. M�todo para ordenar a lista decrescente
	public void ordenarListaDecrescente() {
		
		// Ordenando os elementos em ordem decrescente utilizando o m�todo reverse da classe Collections
		Collections.reverse(numeros);

		// Exibindo para o usu�rio os elementos em ordem decrescente
		JOptionPane.showMessageDialog(null, "Elementos em ordem decrescente: " + numeros, Rotulo.ordenarDecrescente, 1);
	}

	// 5. M�todo para calcular a m�dia dos elementos informados
	public void calcularMediaElementos() {
		
		// Declarando vari�vel auxiliar para efetuar a opera��o
		double somaElementos = 0;
		
		// Utilizando for para varrer o Array e somar os elementos
		for (Integer num : numeros) {
			somaElementos += num;
		}

		// Apresenando ao usu�rio a m�dia dos elementos (Soma dos elementos dividido pela quantidade)
		JOptionPane.showMessageDialog(null, "A m�dia da soma dos elementos informdos �: " + somaElementos / 10, Rotulo.mediaIguais, 1);
	}

	// 6. M�todo para somar o meior com o menor elemento
	public void somaMaiorMenorElemento() {

		Collections.sort(numeros);
		
		JOptionPane.showMessageDialog(null, "A mosa do maior com o menor n�mero �: " + (numeros.get(numeros.size() - 1) + numeros.get(0)), Rotulo.somaMaiorElemento, 1);
	
	}

	// 7. M�todo para somar os elementos iguais
	public void somaElementosIguais() {
		
		// Declarando vari�vel auxiliar para armazenar a mensagem
		String mensagem = "";
		
		// Vari�vel para verificar se existem valores iguais ou n�o
		boolean existe = false;

		// Varrendo o array para verificar se existem valores iguais
		for (int i = 0; i < numeros.size(); i++) {
			
			// Verificando a frequancia de apari��o dos valores 
			int quantidade = Collections.frequency(numeros, numeros.get(i));
			if (quantidade > 1) {
				existe = true;
				
				// Armazenando os valores iguais na mensagem
				mensagem += "O elemento " + numeros.get(i) + " repetiu " + quantidade + " vezes" + "\n";
				mensagem += "A soma das repeti��es �: " + (numeros.get(i) * quantidade) + "\n\n";
				i += (quantidade - 1);
			}
		}
		if (existe) {
			// Apresentando o resultado para o usu�rio
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.somaValoresIguais, 1);
		} else {
			JOptionPane.showMessageDialog(null, "N�o existem elementos repetidos", Rotulo.somaValoresIguais,1);
		}
	}

	// 8. M�todo para calcular a m�dia dos elementos iguais
	public void mediaElementosIguais() {
		
		// Declarando as vari�veis
		boolean existe = false;
		double soma = 0;
		int contador = 0;
		double result = 0;
		
		// Varrendo o array para verificar se existem valores iguais
		for (Integer num : numeros) {
			
			// Armazenando os valores caso a frequ�ncia de apari��o seja maior ou igual a 2
			if (Collections.frequency(numeros, num) >= 2) {
				contador++;
				soma += num;
				result = soma / contador;
				existe = true;
			}
		}
		if (existe) {
			
			// Apresentando o resultado para o usu�rio
			JOptionPane.showMessageDialog(null, "A m�dia dos elementos repetidos �: " + result,
					Rotulo.mediaValoresIguais, 1);
		} else {
			JOptionPane.showMessageDialog(null, "N�o existem elementos repetidos", Rotulo.mediaValoresIguais, 1);
		}

	}

	// 9. M�todo para sair do sistema
	public void sair() {

		// Mensagem para o usu�rio para confirmar se deseja sair do sistema ou n�o
		int opcao = JOptionPane.showConfirmDialog(null, "Encerrar sistema?", "Aten��o", JOptionPane.YES_OPTION,
				JOptionPane.CANCEL_OPTION);

		if (opcao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new CalculaArray();
	}
}
