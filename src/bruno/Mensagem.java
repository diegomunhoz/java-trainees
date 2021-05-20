package bruno;

/**
 * Classe para armazenar as mensagens a serem exibidas para o usu�rio
 *
 * @author Bruno Ferreira Mariani
 * @since 24/02/2021
 */
public class Mensagem {
	
	// Mensagem para explicar o problema ao usu�rio
	public static String explicaProblema = "Informe 10 n�meros inteiros, e faremos algumas opera��es com eles, que podem ser vistas no menu.";
	
	// Mensagem para pedir cada n�mero individual
	public static String pedeInteiro = "Informe o valor inteiro n�mero ";
	
	// Mensagem caso o valor informado n�o seja um n�mero inteiro
	public static String valorNaoInteiro = "O valor informado n�o � inteiro! Digite um valor inteiro.";
	
	// Mensagem caso o valor informado seja menor que 1
	public static String valorMenorQueUm = "O valor informado deve ser maior que 0!";
	
	// Mensagem caso o usu�rio digite um n�mero inv�lido no menu
	public static String valorInvalidoMenu = "O valor informado n�o corresponde a nenhum valor do menu!";
	
	// Mensagem caso n�o haja n�meros repetidos na lista
	public static String naoExisteRepetido = "N�o existem valores repetidos na lista!";
	
	// Mensagens correspondentes a elementos do menu
	public static String maiorElemento = "O maior elemento digitado foi: ";
	public static String menorElemento = "O menor elemento digitado foi: ";
	public static String mediaElementos = "A m�dia dos elementos �: ";
	public static String somaMaiorMenorElemento = "A soma do maior e menor elemento �: ";
	public static String sairDoSistema = "Deseja sair do sistema?";

}
