package bruno;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

/**
 * Classe para receber valores inteiros do usu�rio e mostrar o resultado de
 * diversas opera��es feitas com esses n�meros
 *
 * @author Bruno Ferreira Mariani
 * @since 24/02/2021
 */
public class CalculaArray {

	// Declarando a lista de inteiros a ser recebida do usu�rio
	ArrayList<Integer> inteiros = new ArrayList<Integer>();

	// Construtor da classe
	public CalculaArray() {
		// Instancia a lista quando o construtor � chamado
		inteiros = new ArrayList<Integer>();
		getInteiros();
	}

	// Recebe os valores do usu�rio
	public void getInteiros() {
		// Vari�vel auxiliar para receber os n�meros digitados
		int valorInteiro = 0;

		for (int i = 0; i < 10; i++) {
			// Booleana auxiliar para continuar pedindo valores ou n�o
			boolean executa = true;
			while (executa) {
				try {
					// Pede cada valor ao usu�rio
					valorInteiro = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.pedeInteiro + (i + 1)));
					if (Valida.isLessThanOne(valorInteiro)) {
						// Caso o valor seja v�lido, ele � guardado na lista
						inteiros.add(valorInteiro);
						executa = false;
					} else {
						// Se o valor for inteiro, por�m menor que 1, esse erro ocorre
						JOptionPane.showMessageDialog(null, Mensagem.valorMenorQueUm, Rotulo.valorInvalido, 0);
					}

				} catch (Exception e) {
					// Erro caso o usu�rio digite letras ou s�mbolos
					JOptionPane.showMessageDialog(null, Mensagem.valorNaoInteiro, Rotulo.valorInvalido, 0);
				}
			}

		}

		// Chama o menu principal
		menuUsuario();
	}

	// Menu principal do programa
	public void menuUsuario() {
		// Vari�vel auxiliar para montar a mensagem do menu
		String mensagem = "Informe a op��o desejada:\n";
		mensagem += "\nOP��O 1: Mostrar maior elemento";
		mensagem += "\nOP��O 2: Mostrar menor elemento";
		mensagem += "\nOP��O 3: Ordenar lista crescente";
		mensagem += "\nOP��O 4: Ordenar lista decrescente";
		mensagem += "\nOP��O 5: Mostrar m�dia dos elementos";
		mensagem += "\nOP��O 6: Mostrar soma do maior e menor elemento";
		mensagem += "\nOP��O 7: Mostrar soma dos elementos iguais";
		mensagem += "\nOP��O 8: Mostrar m�dia dos elementos iguais";
		mensagem += "\nOP��O 9: Sair do sistema\n";

		while (true) {
			try {
				// Mostra a mensagem para o usu�rio e pede o c�digo
				// Caso o c�digo seja n�mero inteiro, chama o m�todo
				int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
				avaliaOpcao(codigo);
			} catch (Exception e) {
				// Erro caso o c�digo contenha letras ou s�mbolos
				JOptionPane.showMessageDialog(null, Mensagem.valorInvalidoMenu, Rotulo.valorForaDoMenu, 0);
			}
		}
	}

	// M�todo para retornar o m�todo referente a op��o selecionada, ou mensagem de
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
			// Erro caso o valor n�o esteja contemplado no menu
			JOptionPane.showMessageDialog(null, Mensagem.valorInvalidoMenu, Rotulo.valorForaDoMenu, 0);
			break;
		}
	}

	// M�todo para mostrar o maior elemento para o usu�rio
	public void maiorElemento() {

		// Inicializa a vari�vel com o primeiro elemento da lista
		int maiorElemento = inteiros.get(0);

		// Foreach para varrer a lista
		for (Integer inteiro : inteiros) {
			if (inteiro > maiorElemento) {
				// Se o valor da vez for maior que o maior valor registrado, ele o substitui
				maiorElemento = inteiro;
			}
		}

		// Mostra a mensagem para o usu�rio
		JOptionPane.showMessageDialog(null, Mensagem.maiorElemento + maiorElemento, Rotulo.maiorElemento, 1);

	}

	// M�todo para retornar o valor do maior elemento da lista
	public int getMaiorElemento() {

		// Inicializa a vari�vel com o primeiro elemento da lista
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

	// M�todo para mostrar o menor elemento ao usu�rio
	public void menorElemento() {

		// Chamando a fun��o que retorna o menor elemento
		int menorElemento = getMenorElemento();

		// Mostrando o menor elemento para o usu�rio
		JOptionPane.showMessageDialog(null, Mensagem.menorElemento + menorElemento, Rotulo.menorElemento, 1);

	}

	// M�todo para retornar o menor elemento da lista
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

	// M�todo para ordenar a lista em ordem crescente e mostrar ao usu�rio
	public void ordenarListaCrescente() {

		// Vari�vel de controle para auxiliar na mensagem
		int i = 0;

		// M�todo que ordena a lista em ordem crescente
		Collections.sort(inteiros);

		// Vari�vel auxiliar para montar a mensagem para o usu�rio
		String mensagem = "N�meros em ordem crescente:\n";

		// Foreach para varrer a lista
		for (Integer inteiro : inteiros) {
			// If para n�o deixar a v�rgula ap�s o �ltimo elemento
			if (i != inteiros.size() - 1) {
				// Colocando na mensagem os elementos eme ordem crescente
				mensagem += inteiro + ", ";
				i++;
			} else {
				// Caso seja o �ltimo elemento, ele n�o coloca a v�rgula no final
				mensagem += inteiro;
			}
		}

		// Mostrando a lista em ordem crescente para o usu�rio
		JOptionPane.showMessageDialog(null, mensagem, Rotulo.ordemCrescente, 1);

	}

	// M�todo para ordenar a lista em ordem decrescente e mostrar ao usu�rio
	public void ordenarListaDecrescente() {

		// Vari�vel de controle para auxiliar na mensagem
		int i = 0;

		// M�todo que coloca a lista em ordem decrescente
		Collections.reverse(inteiros);

		// Vari�vel auxiliar para montar a mensagem para o usu�rio
		String mensagem = "N�meros em ordem decrescente:\n";

		// Foreach para varrer a lista
		for (Integer inteiro : inteiros) {
			// If para n�o deixar a v�rgula ap�s o �ltimo elemento
			if (i != inteiros.size() - 1) {
				// Colocando na mensagem os elementos eme ordem decrescente
				mensagem += inteiro + ", ";
				i++;
			} else {
				// Caso seja o �ltimo elemento, ele n�o coloca a v�rgula no final
				mensagem += inteiro;
			}
		}

		// Mostrando a lista em ordem decrescente para o usu�rio
		JOptionPane.showMessageDialog(null, mensagem, Rotulo.ordemDecrescente, 1);
	}

	// M�todo para retornar a m�dia dos elementos
	public void mediaDosElementos() {

		// Vari�vel auxiliar para receber a soma dos elementos
		int somaDosElementos = 0;

		// Foreach para varrer a lista
		for (Integer inteiro : inteiros) {
			// Cada elemento da lista � somado na vari�vel
			somaDosElementos += inteiro;
		}

		// Calcula a m�dia dos elementos dividindo a soma pelo tamanho da lista
		double mediaDosElementos = (double) somaDosElementos / inteiros.size();

		// Mostra a m�dia dos elementos para o usu�rio
		JOptionPane.showMessageDialog(null, Mensagem.mediaElementos + mediaDosElementos, Rotulo.mediaElementos, 1);

	}

	// M�todo para calcular e mostrar a soma do maior e menor elemento
	public void somaMaiorMenorElemento() {

		// Vari�vel que recebe a soma, chamando os m�todos que retornam o maior e menor
		// elemento
		int soma = getMaiorElemento() + getMenorElemento();

		// Mostrando a mensagem para o usu�rio
		JOptionPane.showMessageDialog(null, Mensagem.somaMaiorMenorElemento + soma, Rotulo.somaMaiorMenorElemento, 1);
	}

	// M�todo para retornar a soma dos elementos iguais
	public void somaElementosIguais() {

		// Booleana auxiliar para conferir se existem n�meros repetidos
		boolean existeRepetido = false;
		// Booleana auxiliar para conferir se um n�mero j� foi contabilizado
		boolean continua = true;
		// Vari�vel auxiliar para montar a mensagem para o usu�rio
		String mensagem = "Soma de elementos iguais:\n\n";

		// Criando e instanciando ArrayLists para guardar os n�meros repetidos
		ArrayList<Integer> numerosRepetidos = new ArrayList<Integer>();

		// Adicionando o valor 0 para a lista n�o ficar vazia
		numerosRepetidos.add(0);

		// Varrendo a lista com o Foreach
		for (Integer inteiro : inteiros) {
			// Varrendo a lista com o Foreach
			for (Integer inteiro2 : inteiros) {
				continua = true;
				// Foreach para checar se um certo n�mero j� foi contabilizado
				for (Integer repetido : numerosRepetidos) {
					if (inteiro2 == repetido) {
						continua = false;
						break;
					}
				}
				// O If continua se o n�mero n�o foi contabilizado e dois n�meros da lista s�o
				// iguais
				if (inteiro == inteiro2 && continua) {
					// Adiciona o n�mero contabilizado para a lista de n�meros contabilizados
					numerosRepetidos.add(inteiro);
					// Guarda o n�mero de vezes que o n�mero se repete na lista
					int frequencia = Collections.frequency(inteiros, inteiro);
					// A soma dos elementos iguais � o elemento vezes sua frequ�ncia na lista
					int soma = frequencia * inteiro;
					// Se a frequ�ncia for 1, o n�mero n�o se repete, existe apenas ele mesmo
					// O if continua apenas se a frequ�ncia for maior que 1
					if (frequencia > 1) {
						mensagem += "N�mero: " + inteiro + ". Repeti��es: " + Collections.frequency(inteiros, inteiro)
								+ ". Soma: " + soma + "\n";
						existeRepetido = true;

					}
				}
			}
		}
		if (existeRepetido) {
			// Mostra a soma dos elementos iguais para o usu�rio
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.somaElementosIguais, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.naoExisteRepetido, Rotulo.somaElementosIguais, 1);
		}

	}

	// M�todo para mostrar a m�dia dos elementos iguais para o usu�rio
	public void mediaElementosIguais() {

		// Booleana auxiliar para conferir se existem n�meros repetidos
		boolean existeRepetido = false;

		// Booleana auxiliar para continuar o m�todo
		boolean continua = true;

		// Vari�vel auxiliar para calcular a m�dia de todos os repetidos (extra)
		//
		int somaFrequencias = 0;

		// Vari�vel auxiliar para calcular a m�dia de todos os repetidos (extra)
		int somaSomas = 0;

		// Vari�vel auxiliar para montar a mensagem para o usu�rio
		String mensagem = "M�dia de elementos iguais:\n\n";

		// Criando e instanciando lista que guarda os n�meros que j� foram
		// contabilizados
		ArrayList<Integer> numerosRepetidos = new ArrayList<Integer>();

		// Adiciona um elemento na lista para n�o ficar vazia
		numerosRepetidos.add(0);

		// Foreach para varrer a lista
		for (Integer inteiro : inteiros) {
			// Foreach para varrer a lista
			for (Integer inteiro2 : inteiros) {
				continua = true;
				// Foreach para checar se um certo n�mero j� foi contabilizado
				for (Integer repetido : numerosRepetidos) {
					if (inteiro == repetido) {
						continua = false;
						break;
					}
				}
				// O If continua se o n�mero n�o foi contabilizado e dois n�meros da lista s�o
				// iguais
				if (inteiro == inteiro2 && continua) {
					// Adiciona o n�mero contabilizado para a lista de n�meros contabilizados
					numerosRepetidos.add(inteiro);
					// Guarda o n�mero de vezes que o n�mero se repete na lista
					int frequencia = Collections.frequency(inteiros, inteiro);
					// Se a frequ�ncia for 1, o n�mero n�o se repete, existe apenas ele mesmo
					// O if continua apenas se a frequ�ncia for maior que 1
					if (frequencia > 1) {
						// C�lculo da soma e da m�dia
						int soma = frequencia * inteiro;
						int media = soma / frequencia;
						// Soma de todas as frequ�ncias e somas obtidas
						somaFrequencias += frequencia;
						somaSomas += soma;
						// Montando mensagem para o usu�rio
						mensagem += "N�mero: " + inteiro + ". M�dia: " + media + "\n";
						existeRepetido = true;
					}
				}
			}
		}

		// Calculando a m�dia de todos os n�meros que se repetem
		double mediaTodosRepetidos = (double) somaSomas / somaFrequencias;

		// Finalizando a mensagem para o usu�rio
		mensagem += "Como um extra, a m�dia de todos os n�meros repetidos �: " + mediaTodosRepetidos;

		if (existeRepetido) {
			// Mostrando mensagem final para o usu�rio
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.mediaElementosIguais, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.naoExisteRepetido, Rotulo.mediaElementosIguais, 1);
		}
		

	}

	// M�todo para encerrar o programa
	public void sairDoSistema() {
		// Pedindo mensagem de confirma��o para o usu�rio
		int confirmacao = JOptionPane.showConfirmDialog(null, Mensagem.sairDoSistema);
		// Caso ele confirme, o sistema encerra
		if (confirmacao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	// M�todo principal para executar o programa
	public static void main(String[] args) {
		// Chamando o construtor da classe
		new CalculaArray();
	}
}
