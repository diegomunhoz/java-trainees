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

		// Declarando variáveis
		int contador = 1;
		Integer numero = 0;
		boolean execute = true;

		// Imput de dados pelo usuário
		while (execute) {
			try {
				
				numero = Integer.parseInt(JOptionPane.showInputDialog(null, Mensagem.informeNumero, Rotulo.calculaArray, 1));
				// Verificando se o número informado é positivo ou negativo, caso seja negativo
				// o sistema apresentará uma mensagem
				
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
					// Mensagem de sucesso no cadastro após o imput dos 10 valores
					JOptionPane.showMessageDialog(null, Mensagem.numerosCadastrados, Rotulo.calculaArray, 1);

					menuPrincipal();
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Informe um valor válido", Rotulo.calculaArray, 0);
				execute = true;
			}
		}
		menuPrincipal();
	}

	// Método para criar um menu de opções
	public void menuPrincipal() {

		String menu = "INFORME A OPÇÃO DESEJADA\n\n"

				+ "1 - Maior elemento\n" 
				+ "2 - Menor elemento\n" 
				+ "3 - Ordenar Lista Crescente\n"
				+ "4 - Ordenar Lista Decrescente\n" 
				+ "5 - Média dos elementos\n"
				+ "6 - Soma do maior e menor elemento\n" 
				+ "7 - Soma dos elementos iguais\n"
				+ "8 - Média dos elementos iguais\n" 
				+ "9 - Sair do sistema\n";

		// Verificando se o usuário digitou uma opção válida ou inválida, caso seja
		// inválida será apresentada uma mensagem de erro
		while (true) {
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
				processamentoPrincipal(opcao);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulo.calculaArray, 0);
			}
		}
	}

	// Método principal para processamento do programa
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

	// 1. Método para mostrar o maior elemento
	public void mostrarMaiorElemento() {

		// Exibindo para o usuário o maior elemento utilizando o método max da classe Collections
		JOptionPane.showMessageDialog(null, "O maior número é: " + Collections.max(numeros), Rotulo.maiorValor, 1);
	}

	// 2. Método para mostrar o menor elemento
	public void mostrarMentoElemento() {

		// Exibindo para o usuário o menor elemento utilizando o método min da classe Collections
		JOptionPane.showMessageDialog(null, "O menor número é: " + Collections.min(numeros), Rotulo.menorValor, 1);
	}

	// 3. Método para ordenar a lista crescente
	public void ordenarListaCrescente() {
		
		// Ordenando os elementos em ordem crescente utilizando o método sort da classe Collections
		Collections.sort(numeros);

		// Exibindo para o usuário os elementos em ordem crescente
		JOptionPane.showMessageDialog(null, "Elementos em ordem crescente: " + numeros, Rotulo.ordenarCrescente, 1);
		
	}

	// 4. Método para ordenar a lista decrescente
	public void ordenarListaDecrescente() {
		
		// Ordenando os elementos em ordem decrescente utilizando o método reverse da classe Collections
		Collections.reverse(numeros);

		// Exibindo para o usuário os elementos em ordem decrescente
		JOptionPane.showMessageDialog(null, "Elementos em ordem decrescente: " + numeros, Rotulo.ordenarDecrescente, 1);
	}

	// 5. Método para calcular a média dos elementos informados
	public void calcularMediaElementos() {
		
		// Declarando variável auxiliar para efetuar a operação
		double somaElementos = 0;
		
		// Utilizando for para varrer o Array e somar os elementos
		for (Integer num : numeros) {
			somaElementos += num;
		}

		// Apresenando ao usuário a média dos elementos (Soma dos elementos dividido pela quantidade)
		JOptionPane.showMessageDialog(null, "A média da soma dos elementos informdos é: " + somaElementos / 10, Rotulo.mediaIguais, 1);
	}

	// 6. Método para somar o meior com o menor elemento
	public void somaMaiorMenorElemento() {

		Collections.sort(numeros);
		
		JOptionPane.showMessageDialog(null, "A mosa do maior com o menor número é: " + (numeros.get(numeros.size() - 1) + numeros.get(0)), Rotulo.somaMaiorElemento, 1);
	
	}

	// 7. Método para somar os elementos iguais
	public void somaElementosIguais() {
		
		// Declarando variável auxiliar para armazenar a mensagem
		String mensagem = "";
		
		// Variável para verificar se existem valores iguais ou não
		boolean existe = false;

		// Varrendo o array para verificar se existem valores iguais
		for (int i = 0; i < numeros.size(); i++) {
			
			// Verificando a frequancia de aparição dos valores 
			int quantidade = Collections.frequency(numeros, numeros.get(i));
			if (quantidade > 1) {
				existe = true;
				
				// Armazenando os valores iguais na mensagem
				mensagem += "O elemento " + numeros.get(i) + " repetiu " + quantidade + " vezes" + "\n";
				mensagem += "A soma das repetições é: " + (numeros.get(i) * quantidade) + "\n\n";
				i += (quantidade - 1);
			}
		}
		if (existe) {
			// Apresentando o resultado para o usuário
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.somaValoresIguais, 1);
		} else {
			JOptionPane.showMessageDialog(null, "Não existem elementos repetidos", Rotulo.somaValoresIguais,1);
		}
	}

	// 8. Método para calcular a média dos elementos iguais
	public void mediaElementosIguais() {
		
		// Declarando as variáveis
		boolean existe = false;
		double soma = 0;
		int contador = 0;
		double result = 0;
		
		// Varrendo o array para verificar se existem valores iguais
		for (Integer num : numeros) {
			
			// Armazenando os valores caso a frequência de aparição seja maior ou igual a 2
			if (Collections.frequency(numeros, num) >= 2) {
				contador++;
				soma += num;
				result = soma / contador;
				existe = true;
			}
		}
		if (existe) {
			
			// Apresentando o resultado para o usuário
			JOptionPane.showMessageDialog(null, "A média dos elementos repetidos é: " + result,
					Rotulo.mediaValoresIguais, 1);
		} else {
			JOptionPane.showMessageDialog(null, "Não existem elementos repetidos", Rotulo.mediaValoresIguais, 1);
		}

	}

	// 9. Método para sair do sistema
	public void sair() {

		// Mensagem para o usuário para confirmar se deseja sair do sistema ou não
		int opcao = JOptionPane.showConfirmDialog(null, "Encerrar sistema?", "Atenção", JOptionPane.YES_OPTION,
				JOptionPane.CANCEL_OPTION);

		if (opcao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new CalculaArray();
	}
}
