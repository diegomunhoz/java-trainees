package ariel;

/**
 * Classe respons�vel por validar os dados inputadps pelo usu�rio
 * 
 * @author Ariel Batista
 * @since 25 de fev. de 2021
 */

public class Valida {

	// verificando se o valor informado � zero
	public static boolean isIntZero(int args) {
		return (args == 0);
	}

	// m�todo para verificar se � n�mero
	public static boolean isMenorZero(int args) {
			return args <= 0;
		
	}

}
