package br.com.nielsen.app.resources.exceptions;

import java.io.Serializable;

public class ErroPadrao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer statusHttp;
	private String mensagem;
	private String timeStamp;
	
	public ErroPadrao(Integer statusHttp, String mensagem, String timeStamp) {
		super();
		this.statusHttp = statusHttp;
		this.mensagem = mensagem;
		this.timeStamp = timeStamp;
	}

	public Integer getStatusHttp() {
		return statusHttp;
	}

	public void setStatusHttp(Integer statusHttp) {
		this.statusHttp = statusHttp;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
		
}
