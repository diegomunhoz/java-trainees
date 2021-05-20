package elisandro;

/**
 * Classe responsavel por armazenar os metodos de Valida��o do Programa
 * CalculaArray
 * 
 * @author Elisandro Heck
 * @Since 25 de fev. de 2021
 * 
 */
public class Valida {

	// verificando se valor digitado � nulo ou vazio;
	public static boolean isEmpyOrNull(String string) {
		return (string == null || string.trim().equals(""));
	}

	// verificando se o valor informando zero
	public static boolean isMaiorZero(int args) {
		return (args <= 0);
	}

	public static boolean isStringValidaLetras(String args) {
		if (args.matches("[A-Z]*")) {// aceita apenas caracteres incluindo maiusculo , minusculos, � e com acentos
										// ! inverte a condi��o
			return true;
		} else {
			return false;
		}
	}

	public static boolean isStringValidaNumeros(String args) {
		if (!args.matches("[0-9]*")) {// aceita apenas numeros incluindo maiusculo , minusculos, � e com acentos
										// ! inverte a condi��o
			return true;
		} else {
			return false;
		}
	}

	// metodo para verificar se � numero
	public static boolean isNumber(String args) {
		try {
			int numero = Integer.parseInt(args);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// verifica se a string n�o tem n�meros
	// caso tenha numero metodo retorna false
	public static boolean isOnlyText(String args) {
		return args.matches("[^\\d]+");
	}
}
