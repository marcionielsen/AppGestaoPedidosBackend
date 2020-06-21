package br.com.nielsen.app.services.exceptions;

public class ObjetoNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ObjetoNaoEncontradoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ObjetoNaoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjetoNaoEncontradoException(String message) {
		super(message);
	}

	public ObjetoNaoEncontradoException(Throwable cause) {
		super(cause);
	}

	public ObjetoNaoEncontradoException(String id, String tipo) {
		super( (new StringBuilder()).append("Objeto não encontrado! -> (Id: ").append(id).append(", Tipo: ").append(tipo).append(")").toString() );
	}

}

