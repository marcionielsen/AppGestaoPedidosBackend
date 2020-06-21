package br.com.nielsen.app.services.exceptions;

public class IntegridadeDadosException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public IntegridadeDadosException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IntegridadeDadosException(String message, Throwable cause) {
		super(message, cause);
	}

	public IntegridadeDadosException(String message) {
		super(message);
	}

	public IntegridadeDadosException(Throwable cause) {
		super(cause);
	}

	public IntegridadeDadosException(String id, String tipo) {
		super( (new StringBuilder()).append("Violação de Integridade Referencial! -> (Id: ").append(id).append(", Tipo: ").append(tipo).append(")").toString() );
	}

}
