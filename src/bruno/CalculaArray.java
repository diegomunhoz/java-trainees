package bruno;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

/**
 * Classe para receber valores inteiros do usuário e mostrar o resultado de
 * diversas operações feitas com esses números
 *
 * @author Bruno Ferreira Mariani
 * @since 24/02/2021
 */
public class CalculaArray {

	// Declarando a lista de inteiros a ser recebida do usuário
	ArrayList<Integer> inteiros = new ArrayList<Integer>();

	// Construtor da classe
	public CalculaArray() {
		// Instancia a lista quando o construtor é chamado
		inteiros = new ArrayList<Integer>();
		getInteiros();
	}

	// Recebe os valores do usuário
	public void getInteiros() {
		// Variável auxiliar para receber os números digitados
		int valorInteiro = 0;

		for (int i = 0; i < 10; i++) {
			// Booleana auxiliar para continuar pedindo valores ou não
			boolean executa = true;
			while (executa) {
				try {
					// Pede cada valor ao usuário
					valorInteiro = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.pedeInteiro + (i + 1)));
					if (Valida.isLessThanOne(valorInteiro)) {
						// Caso o valor seja válido, ele é guardado na lista
						inteiros.add(valorInteiro);
						executa = false;
					} else {
						// Se o valor for inteiro, porém menor que 1, esse erro ocorre
						JOptionPane.showMessageDialog(null, Mensagem.valorMenorQueUm, Rotulo.valorInvalido, 0);
					}

				} catch (Exception e) {
					// Erro caso o usuário digite letras ou símbolos
					JOptionPane.showMessageDialog(null, Mensagem.valorNaoInteiro, Rotulo.valorInvalido, 0);
				}
			}

		}

		// Chama o menu principal
		menuUsuario();
	}

	// Menu principal do programa
	public void menuUsuario() {
		// Variável auxiliar para montar a mensagem do menu
		String mensagem = "Informe a opção desejada:\n";
		mensagem += "\nOPÇÃO 1: Mostrar maior elemento";
		mensagem += "\nOPÇÃO 2: Mostrar menor elemento";
		mensagem += "\nOPÇÃO 3: Ordenar lista crescente";
		mensagem += "\nOPÇÃO 4: Ordenar lista decrescente";
		mensagem += "\nOPÇÃO 5: Mostrar média dos elementos";
		mensagem += "\nOPÇÃO 6: Mostrar soma do maior e menor elemento";
		mensagem += "\nOPÇÃO 7: Mostrar soma dos elementos iguais";
		mensagem += "\nOPÇÃO 8: Mostrar média dos elementos iguais";
		mensagem += "\nOPÇÃO 9: Sair do sistema\n";

		while (true) {
			try {
				// Mostra a mensagem para o usuário e pede o código
				// Caso o código seja número inteiro, chama o método
				int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
				avaliaOpcao(codigo);
			} catch (Exception e) {
				// Erro caso o código contenha letras ou símbolos
				JOptionPane.showMessageDialog(null, Mensagem.valorInvalidoMenu, Rotulo.valorForaDoMenu, 0);
			}
		}
	}

	// Método para retornar o método referente a opção selecionada, ou mensagem de
	// erro
	public void avaliaOpcao(int args) {
		switch (args) {
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
			mediaDosElementos();
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
			sairDoSistema();
			break;
		}
		default:
			// Erro caso o valor não esteja contemplado no menu
			JOptionPane.showMessageDialog(null, Mensagem.valorInvalidoMenu, Rotulo.valorForaDoMenu, 0);
			break;
		}
	}

	// Método para mostrar o maior elemento para o usuário
	public void maiorElemento() {

		// Inicializa a variável com o primeiro elemento da lista
		int maiorElemento = inteiros.get(0);

		// Foreach para varrer a lista
		for (Integer inteiro : inteiros) {
			if (inteiro > maiorElemento) {
				// Se o valor da vez for maior que o maior valor registrado, ele o substitui
				maiorElemento = inteiro;
			}
		}

		// Mostra a mensagem para o usuário
		JOptionPane.showMessageDialog(null, Mensagem.maiorElemento + maiorElemento, Rotulo.maiorElemento, 1);

	}

	// Método para retornar o valor do maior elemento da lista
	public int getMaiorElemento() {

		// Inicializa a variável com o primeiro elemento da lista
		int maiorElemento = inteiros.get(0);

		// Foreach para varrer a lista
		for (Integer inteiro : inteiros) {
			// Se o valor da vez for maior que o maior valor registrado, ele o substitui
			if (inteiro > maiorElemento) {
				maiorElemento = inteiro;
			}
		}

		// Retorna o valor do maior elemento calculado
		return maiorElemento;

	}

	// Método para mostrar o menor elemento ao usuário
	public void menorElemento() {

		// Chamando a função que retorna o menor elemento
		int menorElemento = getMenorElemento();

		// Mostrando o menor elemento para o usuário
		JOptionPane.showMessageDialog(null, Mensagem.menorElemento + menorElemento, Rotulo.menorElemento, 1);

	}

	// Método para retornar o menor elemento da lista
	public int getMenorElemento() {

		// Declarando e iniciando o menor elemento como o primeiro item da lista
		int menorElemento = inteiros.get(0);

		// Foreach para varrer a lista
		for (Integer inteiro : inteiros) {
			// Se o valor da vez for menor que o menor valor registrado, ele o substitui
			if (inteiro < menorElemento) {
				menorElemento = inteiro;
			}
		}

		// Retornando o menor elemento
		return menorElemento;

	}

	// Método para ordenar a lista em ordem crescente e mostrar ao usuário
	public void ordenarListaCrescente() {

		// Variável de controle para auxiliar na mensagem
		int i = 0;

		// Método que ordena a lista em ordem crescente
		Collections.sort(inteiros);

		// Variável auxiliar para montar a mensagem para o usuário
		String mensagem = "Números em ordem crescente:\n";

		// Foreach para varrer a lista
		for (Integer inteiro : inteiros) {
			// If para não deixar a vírgula após o último elemento
			if (i != inteiros.size() - 1) {
				// Colocando na mensagem os elementos eme ordem crescente
				mensagem += inteiro + ", ";
				i++;
			} else {
				// Caso seja o último elemento, ele não coloca a vírgula no final
				mensagem += inteiro;
			}
		}

		// Mostrando a lista em ordem crescente para o usuário
		JOptionPane.showMessageDialog(null, mensagem, Rotulo.ordemCrescente, 1);

	}

	// Método para ordenar a lista em ordem decrescente e mostrar ao usuário
	public void ordenarListaDecrescente() {

		// Variável de controle para auxiliar na mensagem
		int i = 0;

		// Método que coloca a lista em ordem decrescente
		Collections.reverse(inteiros);

		// Variável auxiliar para montar a mensagem para o usuário
		String mensagem = "Números em ordem decrescente:\n";

		// Foreach para varrer a lista
		for (Integer inteiro : inteiros) {
			// If para não deixar a vírgula após o último elemento
			if (i != inteiros.size() - 1) {
				// Colocando na mensagem os elementos eme ordem decrescente
				mensagem += inteiro + ", ";
				i++;
			} else {
				// Caso seja o último elemento, ele não coloca a vírgula no final
				mensagem += inteiro;
			}
		}

		// Mostrando a lista em ordem decrescente para o usuário
		JOptionPane.showMessageDialog(null, mensagem, Rotulo.ordemDecrescente, 1);
	}

	// Método para retornar a média dos elementos
	public void mediaDosElementos() {

		// Variável auxiliar para receber a soma dos elementos
		int somaDosElementos = 0;

		// Foreach para varrer a lista
		for (Integer inteiro : inteiros) {
			// Cada elemento da lista é somado na variável
			somaDosElementos += inteiro;
		}

		// Calcula a média dos elementos dividindo a soma pelo tamanho da lista
		double mediaDosElementos = (double) somaDosElementos / inteiros.size();

		// Mostra a média dos elementos para o usuário
		JOptionPane.showMessageDialog(null, Mensagem.mediaElementos + mediaDosElementos, Rotulo.mediaElementos, 1);

	}

	// Método para calcular e mostrar a soma do maior e menor elemento
	public void somaMaiorMenorElemento() {

		// Variável que recebe a soma, chamando os métodos que retornam o maior e menor
		// elemento
		int soma = getMaiorElemento() + getMenorElemento();

		// Mostrando a mensagem para o usuário
		JOptionPane.showMessageDialog(null, Mensagem.somaMaiorMenorElemento + soma, Rotulo.somaMaiorMenorElemento, 1);
	}

	// Método para retornar a soma dos elementos iguais
	public void somaElementosIguais() {

		// Booleana auxiliar para conferir se existem números repetidos
		boolean existeRepetido = false;
		// Booleana auxiliar para conferir se um número já foi contabilizado
		boolean continua = true;
		// Variável auxiliar para montar a mensagem para o usuário
		String mensagem = "Soma de elementos iguais:\n\n";

		// Criando e instanciando ArrayLists para guardar os números repetidos
		ArrayList<Integer> numerosRepetidos = new ArrayList<Integer>();

		// Adicionando o valor 0 para a lista não ficar vazia
		numerosRepetidos.add(0);

		// Varrendo a lista com o Foreach
		for (Integer inteiro : inteiros) {
			// Varrendo a lista com o Foreach
			for (Integer inteiro2 : inteiros) {
				continua = true;
				// Foreach para checar se um certo número já foi contabilizado
				for (Integer repetido : numerosRepetidos) {
					if (inteiro2 == repetido) {
						continua = false;
						break;
					}
				}
				// O If continua se o número não foi contabilizado e dois números da lista são
				// iguais
				if (inteiro == inteiro2 && continua) {
					// Adiciona o número contabilizado para a lista de números contabilizados
					numerosRepetidos.add(inteiro);
					// Guarda o número de vezes que o número se repete na lista
					int frequencia = Collections.frequency(inteiros, inteiro);
					// A soma dos elementos iguais é o elemento vezes sua frequência na lista
					int soma = frequencia * inteiro;
					// Se a frequência for 1, o número não se repete, existe apenas ele mesmo
					// O if continua apenas se a frequência for maior que 1
					if (frequencia > 1) {
						mensagem += "Número: " + inteiro + ". Repetições: " + Collections.frequency(inteiros, inteiro)
								+ ". Soma: " + soma + "\n";
						existeRepetido = true;

					}
				}
			}
		}
		if (existeRepetido) {
			// Mostra a soma dos elementos iguais para o usuário
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.somaElementosIguais, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.naoExisteRepetido, Rotulo.somaElementosIguais, 1);
		}

	}

	// Método para mostrar a média dos elementos iguais para o usuário
	public void mediaElementosIguais() {

		// Booleana auxiliar para conferir se existem números repetidos
		boolean existeRepetido = false;

		// Booleana auxiliar para continuar o método
		boolean continua = true;

		// Variável auxiliar para calcular a média de todos os repetidos (extra)
		//
		int somaFrequencias = 0;

		// Variável auxiliar para calcular a média de todos os repetidos (extra)
		int somaSomas = 0;

		// Variável auxiliar para montar a mensagem para o usuário
		String mensagem = "Média de elementos iguais:\n\n";

		// Criando e instanciando lista que guarda os números que já foram
		// contabilizados
		ArrayList<Integer> numerosRepetidos = new ArrayList<Integer>();

		// Adiciona um elemento na lista para não ficar vazia
		numerosRepetidos.add(0);

		// Foreach para varrer a lista
		for (Integer inteiro : inteiros) {
			// Foreach para varrer a lista
			for (Integer inteiro2 : inteiros) {
				continua = true;
				// Foreach para checar se um certo número já foi contabilizado
				for (Integer repetido : numerosRepetidos) {
					if (inteiro == repetido) {
						continua = false;
						break;
					}
				}
				// O If continua se o número não foi contabilizado e dois números da lista são
				// iguais
				if (inteiro == inteiro2 && continua) {
					// Adiciona o número contabilizado para a lista de números contabilizados
					numerosRepetidos.add(inteiro);
					// Guarda o número de vezes que o número se repete na lista
					int frequencia = Collections.frequency(inteiros, inteiro);
					// Se a frequência for 1, o número não se repete, existe apenas ele mesmo
					// O if continua apenas se a frequência for maior que 1
					if (frequencia > 1) {
						// Cálculo da soma e da média
						int soma = frequencia * inteiro;
						int media = soma / frequencia;
						// Soma de todas as frequências e somas obtidas
						somaFrequencias += frequencia;
						somaSomas += soma;
						// Montando mensagem para o usuário
						mensagem += "Número: " + inteiro + ". Média: " + media + "\n";
						existeRepetido = true;
					}
				}
			}
		}

		// Calculando a média de todos os números que se repetem
		double mediaTodosRepetidos = (double) somaSomas / somaFrequencias;

		// Finalizando a mensagem para o usuário
		mensagem += "Como um extra, a média de todos os números repetidos é: " + mediaTodosRepetidos;

		if (existeRepetido) {
			// Mostrando mensagem final para o usuário
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.mediaElementosIguais, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.naoExisteRepetido, Rotulo.mediaElementosIguais, 1);
		}
		

	}

	// Método para encerrar o programa
	public void sairDoSistema() {
		// Pedindo mensagem de confirmação para o usuário
		int confirmacao = JOptionPane.showConfirmDialog(null, Mensagem.sairDoSistema);
		// Caso ele confirme, o sistema encerra
		if (confirmacao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	// Método principal para executar o programa
	public static void main(String[] args) {
		// Chamando o construtor da classe
		new CalculaArray();
	}
}
