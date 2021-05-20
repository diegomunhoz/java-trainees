package luciano;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;


/**
 * Classe responsavel por controlar a manipulação do numero no array
 * @author Luciano Luiz
 * @since 25/02/2021
 */
public class CalculaArray {
	
	private ArrayList<Integer> numero;
	
	public CalculaArray() {
		numero = new ArrayList<Integer>();
		recebeNumero();
		menuPrincipal();
	}
	
	//metodo para receber os numeros
	public void recebeNumero() {
		int numero = 0;
		for (int i = 0; i < 10;) {
			try {
				numero = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeNumero));
				if(Valida.isIntZero(numero)  ) {
					JOptionPane.showMessageDialog(null, Mensagem.numeroInvalido, Rotulo.cadastroNumero, 0);
				} else {
					this.numero.add(numero);
					i++;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.numeroInvalido, Rotulo.cadastroNumero, 0);
			}
		}
	}
	
	// metodo para criar um menu de opções
	public void menuPrincipal() {
		String menu = "1 - MAIOR ELEMENTO" 
						+ "\n2 - MENOR ELEMENTO"
						+ "\n3 - ORDENAR LISTA CRESCENTE"
						+ "\n4 - ORDENAR LISTA DECRESCENTE"
						+ "\n5 - MEDIA DOS ELEMENTOS"
						+ "\n6 - SOMA DO MAIOR E MENOR ELEMENTO"
						+ "\n7 - SOMA DOS ELEMENTOS IGUAIS"
						+ "\n8 - MEDIA DOS ELEMENTOS IGUAIS"
						+ "\n9 - SAIR DO SISTEMA";
		while (true) {
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
				processamentoPrincipal(opcao);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulo.menu, 0);
			}
		}
	}
	
	// metodo para controlar o processamento do programa
	public void processamentoPrincipal(int opcao) {
		switch (opcao) {
		case 1: {
			maiorNumero();
			break;
		}
		case 2: {
			menorNumero();
			break;
		}
		case 3: {
			listarCrecente();
			break;
		}
		case 4: {
			listarDecrescente();
			break;
		}
		case 5: {
			calcularMedia();
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
			elementosIguais();
			break;
		}
		case 9: {
			sair();
			break;
		}
		default:
			JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulo.menu, 0);
		}
	}

	//metodod para achar o maior elemento
	public void maiorNumero() {
		int maiorValor = Integer.MIN_VALUE;
		String mensagem = "O maior número informado é: ";
		boolean existe = false;
		//verifica se á numeros cadastrados
		if(numero.size() > 0) {
			for (Integer valor : numero) {
				if (valor > maiorValor) {
					maiorValor = valor;
					existe = true;
				}
			}
		}
		//se a lista não estiver vazia
		if(existe) {
			JOptionPane.showMessageDialog(null, mensagem + maiorValor, Rotulo.busca, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.erroListaVazia, Rotulo.busca, 0);
		}
	}
	
	//metodod para achar o menor elemento
	public void menorNumero() {
		int menorValor = Integer.MAX_VALUE;
		String mensagem = "O menor número informado é: ";
		boolean existe = false;
		//verifica se á numeros cadastrados
		if(numero.size() > 0) {
			for (Integer valor : numero) {
				if (valor < menorValor) {
					menorValor = valor;
					existe = true;
				}
			}
		}
		//se a lista não estiver vazia
		if(existe) {
			JOptionPane.showMessageDialog(null, mensagem + menorValor, Rotulo.busca, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.erroListaVazia, Rotulo.busca, 0);
		}
	}
	
	//metodo para listar em ordem crecente
	public void listarCrecente() {
		boolean listaItem = false;
		String mensagem = "A ordem crescente da lista ficou:\n";
		if(numero != null) {
			//coloca a lista em ordem crescente
			Collections.sort(numero);
			for (Integer ordenada : numero) {
				mensagem += ordenada + "  ";
			}
			listaItem = true;
		} 
		//se a lista não estiver vazia
		if (listaItem) {
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.listagem, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.erroListaVazia, Rotulo.listagem, 0);
		}
	}
	
	//metodo para listar em ordem decrescente
	public void listarDecrescente() {
		boolean listaItem = false;
		String mensagem = "A ordem decrescente da lista ficou:\n";
		if(numero != null) {
			//coloca em ordem decrescente a lista
			Collections.reverse(numero);
			for (Integer ordenada : numero) {
				mensagem += ordenada + "  ";
			}
			listaItem = true;
		} 
		//se a lista não estiver vazia
		if (listaItem) {
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.listagem, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.erroListaVazia, Rotulo.listagem, 0);
		}
	}
	
	//metodo para calcular a media dos elementos
	public void calcularMedia() {
		int soma = 0;
		double media = 0;
		String mensagem = "A média total da lista é: ";
		boolean vazio = false;
		
		if(numero != null) {
			//soma todos os valores do array
			for (Integer somas : numero) {
				soma += somas;
			}
			//calcula a media do array
			media = soma / numero.size();
			System.out.println(media);
			vazio = true;
		}
		//se a lista não estiver vazia
		if (vazio) {
			JOptionPane.showMessageDialog(null, mensagem + media, Rotulo.calculo, 1);
		}else {
			JOptionPane.showMessageDialog(null, Mensagem.erroListaVazia, Rotulo.calculo, 0);
		}
	}
	
	//metodo para somar o maior e o menor
	public void somaMaiorMenor() {
		Collections.sort(numero);
		JOptionPane.showMessageDialog(null, "A soma do maior e menor valor é: " + (numero.get(numero.size() - 1) + numero.get(0)), Rotulo.calculo, 1);
	}
	
	//metodo para somar os elementos iguis
	public void somaIguais() {
		String mensagem = "A soma dos elementos iguas é\n";
		boolean existe = false;
		
		//variavel para auxiliar a contagem dos iguis
		Map<Integer, Integer> contagem = new HashMap<>();
		for (Integer valor : numero) {
			//metodo frequenci passa quantas vezes foi repetido o numero dentro do arraylist, dando put no contagem que que pega seu valor(key) e volume(value)
			//e passa para a MAP
			contagem.put(valor, Collections.frequency(numero, valor));
		}
		
		//variavel para setar a quantidade de vezes que apareceu
		// chaves = numero informado pelo usuario
		final Set<Integer> chaves = contagem.keySet();

		// laço para armazenar o valor que se repetiu e a quantidade de vezes que apareceu
		for (Integer chave : chaves) {
			//aparece mais que uma vez, procurando em seu value
			if(contagem.get(chave) >= 2) {
				existe = true;
				mensagem += "valor: " + chave + " aparece " + contagem.get(chave) + ", e sua soma fica= " + (chave * contagem.get(chave)) + "\n";
			}
		}
		
		//se existir numeros repetido na lista
		if(existe) {
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.calculo, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.numerosRepetidos, Rotulo.calculo, 0);
		}
	}
	
	//metodo para verificar as media de elementos iguais
	public void elementosIguais() {
		String mensagem = "";
		boolean existe = false;
		
		//variavel para auxiliar a contagem dos iguais
		Map<Integer, Integer> contagem = new HashMap<>();
		//laço para percorrer a array
		for (Integer valor : numero) {
			//metodo frequenci passa quantas vezes foi repetido o numero dentro do arraylist, dando put no contagem que que pega seu valor(key) e volume(value)
			//e passa para a MAP
			contagem.put(valor, Collections.frequency(numero, valor));
		}
		
		//variavel para setar a quantidade de vezes que apareceu, chaves para acessar o contagem
		Set<Integer> chaves = contagem.keySet();

		// laço para armazenar o valor que se repetiu e a quantidade de vezes que apareceu
		for (Integer chave : chaves) {
			//aparece mais que uma vez, procurando em seu value
			if(contagem.get(chave) >= 2) {
				existe = true;
				mensagem += "Possui o  número: " + chave + ", que está repetido: " + contagem.get(chave) + " vezes na lista\n";
			}
		}
		
		//se existir numeros repetido na lista
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.repiticao, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.numerosRepetidos, Rotulo.repiticao, 0);
		}
		
	}
	
	// metodo para sair do sistema
	public void sair() {
		int opcao = JOptionPane.showConfirmDialog(null, "Encerrar o sistema?", "Atenção", JOptionPane.YES_OPTION, JOptionPane.CANCEL_OPTION);
		if (opcao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	//metodo para encerrar o programa
	public static void main(String[] args) {
		new CalculaArray();
	}
}
