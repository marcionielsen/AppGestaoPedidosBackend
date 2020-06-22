package br.com.nielsen.app.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ErroValidacao extends ErroPadrao {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> erros = new ArrayList<>();

	public ErroValidacao(Integer statusHttp, String mensagem, String timeStamp) {
		super(statusHttp, mensagem, timeStamp);
	}

	public List<FieldMessage> getErros() {
		return erros;
	}

	public void addError(String nomeCampo, String mensagem) {
		this.erros.add(new FieldMessage(nomeCampo, mensagem));
	}

}
