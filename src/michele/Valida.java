package michele;

/**
 * Classe responsável por validar os dados imputados pelo usuario
 * 
 * @author Michele Oliveira de Araujo
 * @Since 25 de fev. de 2021
 */
public class Valida {

	// verificando se o valor informado é zero
	public static boolean isIntZero(int args) {
		return (args == 0);
	}

	// verificando se o valor digitado é nulo ou vazio
	public static boolean isEmptyOrNull(String string) {
		return (string == null || string.trim().equals(""));
	}
	
	//Método para verificar String válidas
		public static boolean isStringNum(String args) {
		return (!args.matches("[0-9]+$")); 
				
		}
	
		
}
