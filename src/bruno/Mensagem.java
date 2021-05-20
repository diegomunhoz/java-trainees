package bruno;

/**
 * Classe para armazenar as mensagens a serem exibidas para o usuário
 *
 * @author Bruno Ferreira Mariani
 * @since 24/02/2021
 */
public class Mensagem {
	
	// Mensagem para explicar o problema ao usuário
	public static String explicaProblema = "Informe 10 números inteiros, e faremos algumas operações com eles, que podem ser vistas no menu.";
	
	// Mensagem para pedir cada número individual
	public static String pedeInteiro = "Informe o valor inteiro número ";
	
	// Mensagem caso o valor informado não seja um número inteiro
	public static String valorNaoInteiro = "O valor informado não é inteiro! Digite um valor inteiro.";
	
	// Mensagem caso o valor informado seja menor que 1
	public static String valorMenorQueUm = "O valor informado deve ser maior que 0!";
	
	// Mensagem caso o usuário digite um número inválido no menu
	public static String valorInvalidoMenu = "O valor informado não corresponde a nenhum valor do menu!";
	
	// Mensagem caso não haja números repetidos na lista
	public static String naoExisteRepetido = "Não existem valores repetidos na lista!";
	
	// Mensagens correspondentes a elementos do menu
	public static String maiorElemento = "O maior elemento digitado foi: ";
	public static String menorElemento = "O menor elemento digitado foi: ";
	public static String mediaElementos = "A média dos elementos é: ";
	public static String somaMaiorMenorElemento = "A soma do maior e menor elemento é: ";
	public static String sairDoSistema = "Deseja sair do sistema?";

}
