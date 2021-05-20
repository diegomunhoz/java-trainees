package elisandro;

/**
 * Classe responsavel por armazenar os metodos de Validação do Programa
 * CalculaArray
 * 
 * @author Elisandro Heck
 * @Since 25 de fev. de 2021
 * 
 */
public class Valida {

	// verificando se valor digitado é nulo ou vazio;
	public static boolean isEmpyOrNull(String string) {
		return (string == null || string.trim().equals(""));
	}

	// verificando se o valor informando zero
	public static boolean isMaiorZero(int args) {
		return (args <= 0);
	}

	public static boolean isStringValidaLetras(String args) {
		if (args.matches("[A-Z]*")) {// aceita apenas caracteres incluindo maiusculo , minusculos, Ç e com acentos
										// ! inverte a condição
			return true;
		} else {
			return false;
		}
	}

	public static boolean isStringValidaNumeros(String args) {
		if (!args.matches("[0-9]*")) {// aceita apenas numeros incluindo maiusculo , minusculos, Ç e com acentos
										// ! inverte a condição
			return true;
		} else {
			return false;
		}
	}

	// metodo para verificar se é numero
	public static boolean isNumber(String args) {
		try {
			int numero = Integer.parseInt(args);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// verifica se a string não tem números
	// caso tenha numero metodo retorna false
	public static boolean isOnlyText(String args) {
		return args.matches("[^\\d]+");
	}
}
