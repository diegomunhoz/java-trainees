package ariel;

/**
 * Classe responsável por validar os dados inputadps pelo usuário
 * 
 * @author Ariel Batista
 * @since 25 de fev. de 2021
 */

public class Valida {

	// verificando se o valor informado é zero
	public static boolean isIntZero(int args) {
		return (args == 0);
	}

	// método para verificar se é número
	public static boolean isMenorZero(int args) {
			return args <= 0;
		
	}

}
