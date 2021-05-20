package victor;

/**
 * Classe responsável por validar os dados inputados pelo usuário
 * @author Victor Baptista
 * @since 25/02/2021
 */
public class Valida {

	//valida o número informado pelo usuário, aceitando apenas números positivos
	public static boolean isValido(int numero) {
		return (numero > 0);
	}
}
