package kalleo;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;


/**
 * Classe responsável por armazenar e executar os atributos e métodos da aplicação CalculaArray
 * @author Kalleo Leandro dos Santos Leal
 * @since 25/02/2021 
 */

public class CalculaArray 
{
	//Declaração de lista que conterá os valores a serem trabalhos no programa
	private ArrayList<Integer> numeros;
	
	public CalculaArray()
	{
		//Função para mudar as propriedades de fonte do JoptionPane
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Courier", Font.PLAIN, 18)));
		
		//Função para mudar o texto do ConfirmDialog
		UIManager.put("OptionPane.yesButtonText", "Sim");
		UIManager.put("OptionPane.noButtonText", "Não");
		UIManager.put("OptionPane.okButtonText", "Ok");
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");
		
		//Declaração de lista armazenadora
		numeros = new ArrayList<Integer>();	
		
		//Execução da função de menu
		menuPrincipal();
		
	}
	
	//Método principal de exibição e inicialização do menu
	public void menuPrincipal()
	{
		//Declaração de variável que receberá os valores digitados pelo usuário
		int valor;
		do
		{//inicio do laço
			try
			{
				//Tenta pegar o valor e se for maior que zero, adiciona a lista
				valor = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeNumero));
				if(valor >0)
				{
					numeros.add(valor);
				}
				else
				{
					JOptionPane.showMessageDialog(null, Mensagem.numeroInvalido,Titulo.listaNumerica,JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(Exception e)
			{
				//Caso receba um valor não inteiro
				JOptionPane.showMessageDialog(null, Mensagem.numeroInvalido,Titulo.listaNumerica,JOptionPane.ERROR_MESSAGE);
			}
		}while(numeros.size() < 10);//fim do laço
		
		
		
		
		//Mensagem de menu
		String menu = "INFORME A OPÇÃO DESEJADA\n\n"
				 + "\n1 - Maior elemento"
				 + "\n2 - Menor elemento"
				 + "\n3 - Ordenar Lista Crescente"
				 + "\n4 - Ordenar Lista Decrescente"
				 + "\n5 - Média dos elementos"
				 + "\n6 - Soma do maior e menor elemento"
				 + "\n7 - Soma dos elementos iguais"
				 + "\n8 - Média dos elementos iguais"
				 + "\n9 - Sair do Sistema";		
	
		
		while(true)
		{
			try
			{//Tenta receber a opção digitada pelo usuário
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
				processamentoPrincipal(opcao);
			}
			catch(Exception e)
			{
				//Caso o valor digitado não seja um número inteiro
				JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Titulo.listaNumerica,JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	//Método que executa a escolha do usuário 
	public void processamentoPrincipal(int opcao)
	{
		//Chamada de métodos por opção selecionada
		switch(opcao)
		{
		case 1:
			maiorElemento();
			break;
		case 2:
			menorElemento();
			break;
		case 3:
			listaCrescente();
			break;
		case 4:
			listaDecrescente();
			break;
		case 5:
			mediaElementos();
			break;
		case 6:
			somaMaiorMenor();
			break;
		case 7:
			somaIguais();
			break;
		case 8:
			mediaIguais();
			break;
		case 9:
			sair();
			break;
		default:
			JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida,Titulo.listaNumerica,JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
	
	//Método para exibir o maior elemento da lista
	
	public void maiorElemento()
	{
		if(todosIguais())//Caso os números sejam todos iguais informar ao usuário, senão, exibir o maior número
		{
			JOptionPane.showMessageDialog(null, "Todos os elementos são iguais a " + numeros.get(0), Titulo.listaNumerica, JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "O maior elemento é " + getMaior(), Titulo.listaNumerica, JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//Método para exibir o menor elemento da lista
	
	public void menorElemento()
	{
		if(todosIguais())//Caso os números sejam todos iguais informar ao usuário, senão, exibir o menor número
		{
			JOptionPane.showMessageDialog(null, "Todos os elementos são iguais a " + numeros.get(0), Titulo.listaNumerica, JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "O menor elemento é " + getMenor(), Titulo.listaNumerica, JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//Método para exibir a lista em ordem crescente
	
	public void listaCrescente()
	{		
		String mensagem = "Lista em ordem crescente\n\n";
		ArrayList<Integer> lista = getListaCrescente(); //Chamar o método reordenador de lista
		for(Integer numero : lista)
		{
			mensagem += numero + "\n";//Concatena os numeros da lista ordenada
		}
		
		JOptionPane.showMessageDialog(null, mensagem, Titulo.listaNumerica, JOptionPane.INFORMATION_MESSAGE);
	}
	
	//Método para exibir a lista em ordem decrescente
	
	public void listaDecrescente()
	{
		String mensagem = "Lista em ordem decrescente\n\n";
		ArrayList<Integer> lista = getListaDecrescente();//Chamar o método reordenador de lista
		for(Integer numero : lista)
		{
			mensagem += numero + "\n";//Concatena os numeros da lista ordenada
		}
		
		JOptionPane.showMessageDialog(null, mensagem, Titulo.listaNumerica, JOptionPane.INFORMATION_MESSAGE);
	}
	
	//Método para exibir a média dos elementos
	
	public void mediaElementos()
	{	
		JOptionPane.showMessageDialog(null, Mensagem.mediaElementos + getMediaElementos(), Titulo.listaNumerica, JOptionPane.INFORMATION_MESSAGE);
	}
	
	//Método para exibir a soma do maior e do menor elemento
	
	public void somaMaiorMenor()
	{
		JOptionPane.showMessageDialog(null, Mensagem.somaMaiorMenor + (getMaior() + getMenor()), Titulo.listaNumerica, JOptionPane.INFORMATION_MESSAGE);
	}
	
	//Método para exibir a soma dos elementos iguais, separados por elemento literal diferente
	
	public void somaIguais()
	{		
		String mensagem = getSomaIguais();
		if(mensagem== "") //Caso o retorno da mensagem venha vazio, não foi detectado números reincidentes na lista
		{
			JOptionPane.showMessageDialog(null, Mensagem.somaIguaisSemOcorrencias, Titulo.listaNumerica,JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, mensagem, Titulo.listaNumerica,JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//Método para exibir a média dos elementos iguais
	
	public void mediaIguais()
	{
		String mensagem = getMediaIguais();//Caso o retorno da mensagem venha vazio, não foi detectado números reincidentes na lista
		if(mensagem == "")
		{
			JOptionPane.showMessageDialog(null, Mensagem.mediaIguaisSemOcorrencias, Titulo.listaNumerica,JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, mensagem, Titulo.listaNumerica,JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/*
	 * Verificar igualdade completa na lista
	 * */
	
	public boolean todosIguais()
	{
		boolean teste = true;
		for(Integer numero : numeros)
		{			
			if(numero != numeros.get(0))//Verifica se um número dentro da lista é diferente dos demais
			{
				teste = false;
			}
		}
		return teste;		
	}
	
	//Método para sair do sistema
	
	public void sair()
	{
		if(JOptionPane.showConfirmDialog(null, Mensagem.sairDoSistema,Titulo.listaNumerica, JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
		
	}
	
	//Métodos de retorno de valores
	
	//Método para retornar o maior valor da lista
	
	public int getMaior()
	{		
		int maior=Integer.MIN_VALUE;//Inicializa a variável com o maior valor possível
		
		for(Integer numero : numeros)
		{
			if(numero > maior)//Caso o número encontrado seja maior que a variável, substituir o valor
			{
				maior = numero;
			}
		}
		
		return maior;
	}
	
	//Método para retornar o menor valor da lista
	
	public int getMenor()
	{		
		int menor=Integer.MAX_VALUE;//Inicializa a variável com o maior valor possível
		
		for(Integer numero : numeros)
		{
			if(numero < menor)//Caso o número encontrado seja menor que a variável, substituir o valor
			{
				menor = numero;
			}
		}
		
		return menor;
	}
	
	//Método para retornar uma lista em ordem crescente
	
	public ArrayList<Integer> getListaCrescente()
	{
		ArrayList<Integer> lista = new ArrayList<Integer>();
		//Recebe a lista principal e reordena os valores
		lista = numeros;
		Collections.sort(lista);					
		return lista;
	}
	
	//Método para retornar uma lista em ordem decrescente
	
	public ArrayList<Integer> getListaDecrescente()
	{		
		ArrayList<Integer> lista = new ArrayList<Integer>();
		//Recebendo a lista reordenada pelo método e devolve a lista invertida 
		lista = getListaCrescente();
		Collections.reverse(lista);
		return lista;
	}
	
	//Método para retornar a média dos elementos da lista
	
	public double getMediaElementos()
	{
		//Declaração de variável para cálculo
		double media=0;
		for(Integer numero : numeros)//Realiza a somatória dos valores da lista
		{
			media += numero;
		}
		
		media /= numeros.size();//Realiza a média dos valores somados com base no tamanho da lista
		
		return media;
	}	
	
	//Método para obter lista com elementos ÚNICOS
	
	public ArrayList<Integer> getListaUnicos()
	{
		//Converte a lista principal em uma lista de elementos únicos
		HashSet<Integer> unicos = new HashSet<Integer>(numeros);		
		ArrayList<Integer> lista = new ArrayList<Integer>(unicos);
		return lista;
	}
	
	//Método para retonar um texto contendo a soma dos elementos que possuem mais de uma ocorrência na lista
	
	public String getSomaIguais()
	{
		//Declaração de variável que receberá o texto concatenado com o resultado
		String mensagem = "";
		int total=0,soma=0, contador=0;
		//Declaração de variáveis para recebimento e cálculo dos valores
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista = getListaUnicos();//Receber a lista de elementos únicos
		for(Integer elemento : lista)
		{
			soma=0;
			contador=0;
			for(Integer numero : numeros)
			{
				//Com base na lista de elementos unicos, andar na lista de elementos principal e procurar os valores iguais
				if(numero == elemento)
				{
					soma += numero;
					contador++;
				}				
			}
			if(contador != 1)//Se o contador for maior que 1, encontrou uma ocorrência idêntica, só então realiza os cálculos
			{				
				total += soma;
				mensagem += "O numero " + elemento + " aparece um total de " + contador  + " vezes. A soma de suas ocorrências totaliza " + soma + "\n";
			}			
		}
		
		if(total != 0)
		{
			mensagem += "A soma geral de todos os valores repetidos em conjunto é de " + total + "\n";
		}
		
		return mensagem;
	}
	
	//Método para retornar um texto contendo a média dos elementos que possuem mais de uma ocorrência na lista
	
	public String getMediaIguais()
	{
		//Declaração de variável que receberá o texto concatenado com o resultado
		String mensagem = "";
		//Declaração de variáveis para recebimento e cálculo dos valores
		double total=0,media=0;
		int contador=0, contadorgeral=0;
		
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista = getListaUnicos();//Receber a lista de elementos únicos
		for(Integer elemento : lista)
		{
			media=0;
			contador=0;			
			for(Integer numero : numeros)
			{
				//Com base na lista de elementos unicos, andar na lista de elementos principal e procurar os valores iguais
				if(numero == elemento)
				{
					media += numero;
					contador++;
				}
			}			
			if(contador != 1)//Se o contador for maior que 1, encontrou uma ocorrência idêntica, só então realiza os cálculos
			{
				total += media;
				contadorgeral += contador;
			}						
		}			
		if(total !=0)
		{
			//Da mesma forma, somente realiza o cálculo se o valor da somatória não estiver zerado
			total /= contadorgeral;
			mensagem += "A média geral de todos os valores repetidos em conjunto é de " + total;
		}		
		return mensagem;
	}
	
	

	/*
	 *Método principal de execução do programa
	 * */
	public static void main(String[] args) 
	{
		new CalculaArray();
	}

}
