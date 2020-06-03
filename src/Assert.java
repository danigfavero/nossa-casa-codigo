public class Assert {

	public static void isNotEmpty (Object obj, String mensagemDeErro) {
		if (obj == null)
			throw new IllegalArgumentException(mensagemDeErro);
		if (obj instanceof String && obj.equals("")) 
			throw new IllegalArgumentException(mensagemDeErro);
	}
	
	public static void assertTrue(boolean condicao, String mensagemDeErro) {
		if (!condicao)
			throw new IllegalArgumentException(mensagemDeErro);
	}
}
