package kalleo;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;


/**
 * Classe respons�vel por armazenar e executar os atributos e m�todos da aplica��o CalculaArray
 * @author Kalleo Leandro dos Santos Leal
 * @since 25/02/2021 
 */

public class CalculaArray 
{
	//Declara��o de lista que conter� os valores a serem trabalhos no programa
	private ArrayList<Integer> numeros;
	
	public CalculaArray()
	{
		//Fun��o para mudar as propriedades de fonte do JoptionPane
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Courier", Font.PLAIN, 18)));
		
		//Fun��o para mudar o texto do ConfirmDialog
		UIManager.put("OptionPane.yesButtonText", "Sim");
		UIManager.put("OptionPane.noButtonText", "N�o");
		UIManager.put("OptionPane.okButtonText", "Ok");
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");
		
		//Declara��o de lista armazenadora
		numeros = new ArrayList<Integer>();	
		
		//Execu��o da fun��o de menu
		menuPrincipal();
		
	}
	
	//M�todo principal de exibi��o e inicializa��o do menu
	public void menuPrincipal()
	{
		//Declara��o de vari�vel que receber� os valores digitados pelo usu�rio
		int valor;
		do
		{//inicio do la�o
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
				//Caso receba um valor n�o inteiro
				JOptionPane.showMessageDialog(null, Mensagem.numeroInvalido,Titulo.listaNumerica,JOptionPane.ERROR_MESSAGE);
			}
		}while(numeros.size() < 10);//fim do la�o
		
		
		
		
		//Mensagem de menu
		String menu = "INFORME A OP��O DESEJADA\n\n"
				 + "\n1 - Maior elemento"
				 + "\n2 - Menor elemento"
				 + "\n3 - Ordenar Lista Crescente"
				 + "\n4 - Ordenar Lista Decrescente"
				 + "\n5 - M�dia dos elementos"
				 + "\n6 - Soma do maior e menor elemento"
				 + "\n7 - Soma dos elementos iguais"
				 + "\n8 - M�dia dos elementos iguais"
				 + "\n9 - Sair do Sistema";		
	
		
		while(true)
		{
			try
			{//Tenta receber a op��o digitada pelo usu�rio
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
				processamentoPrincipal(opcao);
			}
			catch(Exception e)
			{
				//Caso o valor digitado n�o seja um n�mero inteiro
				JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Titulo.listaNumerica,JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	//M�todo que executa a escolha do usu�rio 
	public void processamentoPrincipal(int opcao)
	{
		//Chamada de m�todos por op��o selecionada
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
	
	//M�todo para exibir o maior elemento da lista
	
	public void maiorElemento()
	{
		if(todosIguais())//Caso os n�meros sejam todos iguais informar ao usu�rio, sen�o, exibir o maior n�mero
		{
			JOptionPane.showMessageDialog(null, "Todos os elementos s�o iguais a " + numeros.get(0), Titulo.listaNumerica, JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "O maior elemento � " + getMaior(), Titulo.listaNumerica, JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//M�todo para exibir o menor elemento da lista
	
	public void menorElemento()
	{
		if(todosIguais())//Caso os n�meros sejam todos iguais informar ao usu�rio, sen�o, exibir o menor n�mero
		{
			JOptionPane.showMessageDialog(null, "Todos os elementos s�o iguais a " + numeros.get(0), Titulo.listaNumerica, JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "O menor elemento � " + getMenor(), Titulo.listaNumerica, JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//M�todo para exibir a lista em ordem crescente
	
	public void listaCrescente()
	{		
		String mensagem = "Lista em ordem crescente\n\n";
		ArrayList<Integer> lista = getListaCrescente(); //Chamar o m�todo reordenador de lista
		for(Integer numero : lista)
		{
			mensagem += numero + "\n";//Concatena os numeros da lista ordenada
		}
		
		JOptionPane.showMessageDialog(null, mensagem, Titulo.listaNumerica, JOptionPane.INFORMATION_MESSAGE);
	}
	
	//M�todo para exibir a lista em ordem decrescente
	
	public void listaDecrescente()
	{
		String mensagem = "Lista em ordem decrescente\n\n";
		ArrayList<Integer> lista = getListaDecrescente();//Chamar o m�todo reordenador de lista
		for(Integer numero : lista)
		{
			mensagem += numero + "\n";//Concatena os numeros da lista ordenada
		}
		
		JOptionPane.showMessageDialog(null, mensagem, Titulo.listaNumerica, JOptionPane.INFORMATION_MESSAGE);
	}
	
	//M�todo para exibir a m�dia dos elementos
	
	public void mediaElementos()
	{	
		JOptionPane.showMessageDialog(null, Mensagem.mediaElementos + getMediaElementos(), Titulo.listaNumerica, JOptionPane.INFORMATION_MESSAGE);
	}
	
	//M�todo para exibir a soma do maior e do menor elemento
	
	public void somaMaiorMenor()
	{
		JOptionPane.showMessageDialog(null, Mensagem.somaMaiorMenor + (getMaior() + getMenor()), Titulo.listaNumerica, JOptionPane.INFORMATION_MESSAGE);
	}
	
	//M�todo para exibir a soma dos elementos iguais, separados por elemento literal diferente
	
	public void somaIguais()
	{		
		String mensagem = getSomaIguais();
		if(mensagem== "") //Caso o retorno da mensagem venha vazio, n�o foi detectado n�meros reincidentes na lista
		{
			JOptionPane.showMessageDialog(null, Mensagem.somaIguaisSemOcorrencias, Titulo.listaNumerica,JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, mensagem, Titulo.listaNumerica,JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//M�todo para exibir a m�dia dos elementos iguais
	
	public void mediaIguais()
	{
		String mensagem = getMediaIguais();//Caso o retorno da mensagem venha vazio, n�o foi detectado n�meros reincidentes na lista
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
			if(numero != numeros.get(0))//Verifica se um n�mero dentro da lista � diferente dos demais
			{
				teste = false;
			}
		}
		return teste;		
	}
	
	//M�todo para sair do sistema
	
	public void sair()
	{
		if(JOptionPane.showConfirmDialog(null, Mensagem.sairDoSistema,Titulo.listaNumerica, JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
		
	}
	
	//M�todos de retorno de valores
	
	//M�todo para retornar o maior valor da lista
	
	public int getMaior()
	{		
		int maior=Integer.MIN_VALUE;//Inicializa a vari�vel com o maior valor poss�vel
		
		for(Integer numero : numeros)
		{
			if(numero > maior)//Caso o n�mero encontrado seja maior que a vari�vel, substituir o valor
			{
				maior = numero;
			}
		}
		
		return maior;
	}
	
	//M�todo para retornar o menor valor da lista
	
	public int getMenor()
	{		
		int menor=Integer.MAX_VALUE;//Inicializa a vari�vel com o maior valor poss�vel
		
		for(Integer numero : numeros)
		{
			if(numero < menor)//Caso o n�mero encontrado seja menor que a vari�vel, substituir o valor
			{
				menor = numero;
			}
		}
		
		return menor;
	}
	
	//M�todo para retornar uma lista em ordem crescente
	
	public ArrayList<Integer> getListaCrescente()
	{
		ArrayList<Integer> lista = new ArrayList<Integer>();
		//Recebe a lista principal e reordena os valores
		lista = numeros;
		Collections.sort(lista);					
		return lista;
	}
	
	//M�todo para retornar uma lista em ordem decrescente
	
	public ArrayList<Integer> getListaDecrescente()
	{		
		ArrayList<Integer> lista = new ArrayList<Integer>();
		//Recebendo a lista reordenada pelo m�todo e devolve a lista invertida 
		lista = getListaCrescente();
		Collections.reverse(lista);
		return lista;
	}
	
	//M�todo para retornar a m�dia dos elementos da lista
	
	public double getMediaElementos()
	{
		//Declara��o de vari�vel para c�lculo
		double media=0;
		for(Integer numero : numeros)//Realiza a somat�ria dos valores da lista
		{
			media += numero;
		}
		
		media /= numeros.size();//Realiza a m�dia dos valores somados com base no tamanho da lista
		
		return media;
	}	
	
	//M�todo para obter lista com elementos �NICOS
	
	public ArrayList<Integer> getListaUnicos()
	{
		//Converte a lista principal em uma lista de elementos �nicos
		HashSet<Integer> unicos = new HashSet<Integer>(numeros);		
		ArrayList<Integer> lista = new ArrayList<Integer>(unicos);
		return lista;
	}
	
	//M�todo para retonar um texto contendo a soma dos elementos que possuem mais de uma ocorr�ncia na lista
	
	public String getSomaIguais()
	{
		//Declara��o de vari�vel que receber� o texto concatenado com o resultado
		String mensagem = "";
		int total=0,soma=0, contador=0;
		//Declara��o de vari�veis para recebimento e c�lculo dos valores
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista = getListaUnicos();//Receber a lista de elementos �nicos
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
			if(contador != 1)//Se o contador for maior que 1, encontrou uma ocorr�ncia id�ntica, s� ent�o realiza os c�lculos
			{				
				total += soma;
				mensagem += "O numero " + elemento + " aparece um total de " + contador  + " vezes. A soma de suas ocorr�ncias totaliza " + soma + "\n";
			}			
		}
		
		if(total != 0)
		{
			mensagem += "A soma geral de todos os valores repetidos em conjunto � de " + total + "\n";
		}
		
		return mensagem;
	}
	
	//M�todo para retornar um texto contendo a m�dia dos elementos que possuem mais de uma ocorr�ncia na lista
	
	public String getMediaIguais()
	{
		//Declara��o de vari�vel que receber� o texto concatenado com o resultado
		String mensagem = "";
		//Declara��o de vari�veis para recebimento e c�lculo dos valores
		double total=0,media=0;
		int contador=0, contadorgeral=0;
		
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista = getListaUnicos();//Receber a lista de elementos �nicos
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
			if(contador != 1)//Se o contador for maior que 1, encontrou uma ocorr�ncia id�ntica, s� ent�o realiza os c�lculos
			{
				total += media;
				contadorgeral += contador;
			}						
		}			
		if(total !=0)
		{
			//Da mesma forma, somente realiza o c�lculo se o valor da somat�ria n�o estiver zerado
			total /= contadorgeral;
			mensagem += "A m�dia geral de todos os valores repetidos em conjunto � de " + total;
		}		
		return mensagem;
	}
	
	

	/*
	 *M�todo principal de execu��o do programa
	 * */
	public static void main(String[] args) 
	{
		new CalculaArray();
	}

}
