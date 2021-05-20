package victor;

/**
 * Classe respons�vel por validar os dados inputados pelo usu�rio
 * @author Victor Baptista
 * @since 25/02/2021
 */
public class Valida {

	//valida o n�mero informado pelo usu�rio, aceitando apenas n�meros positivos
	public static boolean isValido(int numero) {
		return (numero > 0);
	}
}
