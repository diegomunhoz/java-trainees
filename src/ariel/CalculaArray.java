package ariel;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

/**
 * Classe respons�vel por controlar o sistema Calcula Array
 * 
 * @author Ariel Batista
 * @since 25 de fev. de 2021
 */
public class CalculaArray {

	// declarando o array list
	private ArrayList<Integer> numeros;
	private int valor;

	// construtor principal
	public CalculaArray() {
		// inicializando array
		numeros = new ArrayList<Integer>();
		// variavel auxiliar
		boolean execute;

		// solicita 10 n�meros do usu�rio
		for (int i = 0; i < 10; i++) {
			// variavel auxiliar. Atribui os valores informados ao Array
			execute = true;
			// enquanto o valor informado for igual a zero ou menor que zero,
			// valores vazio o sistema pede que seja informado um valor v�lido
			while (execute) {
				try {// retorna para o usu�rio quando um n�mero inv�lido seja informado
					valor = Integer.parseInt(JOptionPane.showInputDialog("Digite o " + (i + 1) + "� valor:"));
					// atribuindo valor a arraylist
					numeros.add(valor);
					// verificando se o valor informado � zero
					if (Valida.isIntZero(valor)) {
						JOptionPane.showMessageDialog(null, Mensagem.valorInvalido, Rotulos.informeNumeros, 0);
						// remove o valor da arraylist
						numeros.remove(i);
						// variavel auxiliar recebe true, pedidndo que seja informado novamente o valor
						execute = true;
						// se o elemento for negativo informa erro
					} else if (Valida.isMenorZero(valor)) {
						JOptionPane.showMessageDialog(null, Mensagem.valorInvalido, Rotulos.informeNumeros, 0);
						// remove o valor da arraylist
						numeros.remove(i);
						// variavel auxiliar recebe true, pedidndo que seja informado novamente o valor
						execute = true;
					} else {// valor inv�lido
						execute = false;
					}
				} catch (Exception e) {// tratamento de exce��es
					JOptionPane.showMessageDialog(null, Mensagem.valorInvalido, Rotulos.informeNumeros, 0);
				}
			}
		}
		menu();
	}

	// m�todo para criar menu
	public void menu() {
		// menu principal
		String menu = "INFORME A OP��O DESEJADA\n" + "\n1. Maior elemento" + "\n2. Menor elemento"
				+ "\n3. Ordenar Lista Crescente" + "\n4. Ordenar Lista Decrescente" + "\n5. M�dia dos elementos"
				+ "\n6. Soma do maior e menor elemento" + "\n7. Soma dos elementos iguais"
				+ "\n8. M�dia dos elementos iguais" + "\n9. Sair do sistema";

		while (true) {// enquanto a op��o selecionada for menor que 1 e maior que 9 ele fica no
						// looping
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
				processamentoPrincipal(opcao);
			} catch (Exception e) {// tratamento de exce��es
				JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulos.menuPrincipal, 0);
			}
		}

	}

	// m�todo para controlar o processamento
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
			ordenarListaCrescente();
			break;
		}
		case 4: {
			ordenarListaDecrescente();
			break;
		}
		case 5: {
			mediaElementos();
			break;
		}
		case 6: {
			somaMaiorEMenorElemento();
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
			JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulos.menuPrincipal, opcao);
			break;
		}
	}

	// m�todo para encontrar o maior elemnto em um array
	public void maiorElemento() {
		// encontra o maior valor informado
		Collections.reverse(numeros);
		JOptionPane.showMessageDialog(null, "O maior elemento informado foi o " + numeros.get(0), Rotulos.maiorElemento,
				1);

	}

	// m�todo para encontrar o m elemnto em um array
	public void menorElemento() {
		Collections.sort(numeros);// ordena a lista de forma crescente
		JOptionPane.showMessageDialog(null, "O menor elemento informado foi o " + numeros.get(0), Rotulos.menorElemento,
				1);
	}

	// m�todo para ordenar elementos de um array em ordem crescente
	private void ordenarListaCrescente() {
		// montando mensagem ao usu�rio
		String mensagem = "Os valores em ordem crescente �:\n";
		Collections.sort(numeros);// ordena a lista de forma crescente
		for (Integer num : numeros) {
			mensagem += num + " ";
		}
		JOptionPane.showMessageDialog(null, mensagem, Rotulos.ordemCrescente, 1);
	}

	// m�todo par aordenar elementos de um array em ordem decrescente
	private void ordenarListaDecrescente() {
		// montando mensagem ao usu�rio
		String mensagem = "Os valores em ordem decrescente �:\n";
		Collections.reverse(numeros);// ordena a lista de forma decrescente
		for (Integer num : numeros) {
			mensagem += num + " ";
		}
		JOptionPane.showMessageDialog(null, mensagem, Rotulos.ordemDecrescente, 1);
	}

	// m�todo para calcular a m�dia dos elementos de um array
	private void mediaElementos() {
		// montando mensagem ao usu�rio
		String mensagem = "A m�dia dos valores informados �: ";
		int somaElementos = 0;
		for (Integer num : numeros) {
			somaElementos += num;
		}
		JOptionPane.showMessageDialog(null, mensagem + somaElementos / 10, Rotulos.mediaElementos, 1);
	}

	// m�todo para calcular a soma do menor e amior valor informado
	private void somaMaiorEMenorElemento() {
		Collections.sort(numeros);
		JOptionPane.showMessageDialog(null,
				"A soma do maior elemento com o menor �: " + (numeros.get(numeros.size() - 1) + numeros.get(0)),
				Rotulos.somaMaiorMenor, 1);
	}

	// m�todo pra calcular a soma de elementos iguais em um vetor
	public void somaElementosIguais() {
		// montando mensagem para o usu�rio
		String mensagem = "";
		// vari�vel auxiliar
		boolean existe = false;

		// varrendo o array
		for (int i = 0; i < numeros.size(); i++) {
			// atribuindo a quantidade de n�meros iguais a vari�vel quantiddae
			int quantidade = Collections.frequency(numeros, numeros.get(i));
			// verificando se a quantidade de n�meros iguais � maior que 1
			if (quantidade > 1) {
				existe = true;
				mensagem += "A soma dos n�meros iguais a " + numeros.get(i) + " presentes na lista � de: "
						+ (numeros.get(i) * quantidade) + "\n";
				i += (quantidade - 1);
			}
		}
		// mostrando o resultado
		if (existe) {
			// resultado em tela
			JOptionPane.showMessageDialog(null, mensagem, Rotulos.somaIguais, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.naoExisteNumerosRepetidos, Rotulos.somaIguais, 2);
		}
	}

	// m�todo para calcular a m�dia dos elementos iguais
	public void mediaElementosIguais() {
		// C�lculo para obter a m�dia total dos elementos iguais
		boolean existe = false;
		double soma = 0;
		int contador = 0;
		double result = 0;
		//varrendo array de numeros
		for (Integer num : numeros) {
			//verificando se os n�meros s�o iguais 
			if (Collections.frequency(numeros, num) >= 2) {
				contador++;// incrementando
				soma += num;//soma dos n�meros iguais
				result = soma / contador;//calculo da m�dia
				existe = true;
			}
		}
		if (existe) {
			// resultado em tela
			JOptionPane.showMessageDialog(null, Mensagem.mediaRepetidos + result, Rotulos.mediaRepetidos, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.naoExisteNumerosRepetidos, Rotulos.mediaRepetidos, 2);
		}
	}

	// m�todo para sair do sistema
	public void sair() {
		// ser� apresentado duas caixas de texto perguntando se o usu�rio deseja sair
		int opcao = JOptionPane.showConfirmDialog(null, "Encerrar o sistema?", "Aten��o", JOptionPane.YES_OPTION,
				JOptionPane.CANCEL_OPTION);

		// se a op��o informada for sim o sistema ser� encerrado
		if (opcao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	// m�todo principal par aexecutar o programa
	public static void main(String[] args) {
		new CalculaArray();
	}

}
