package br.com.nielsen.app.resources.exceptions;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.nielsen.app.services.exceptions.IntegridadeDadosException;
import br.com.nielsen.app.services.exceptions.ObjetoNaoEncontradoException;

@ControllerAdvice
public class ControllerExceptionHandler {

	private static final String HTTP_BAD_REQUEST = "====== >> HTTP BAD REQUEST ";
	private static final String HTTP_OBJECT_NOT_FOUND = "====== >> HTTP OBJECT NOT FOUND";
	private static final String ERRO_DE_VALIDACAO = "Erro de validação";
	private static final String TZ_AMERICA_SAO_PAULO = "America/Sao_Paulo";
	private static final String FORMATO_DATA_HORA = "yyyy-MM-dd HH:mm:ss";

	@ExceptionHandler(ObjetoNaoEncontradoException.class)
	public ResponseEntity<ErroPadrao> objetoNaoEncontrado(ObjetoNaoEncontradoException e, HttpServletRequest request) {

		Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
		DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern(FORMATO_DATA_HORA);
		String horaSistema = formatoDataHora.format(instant.atZone(ZoneId.of(TZ_AMERICA_SAO_PAULO)));

		imprimirCabecalhoMensagem(HTTP_OBJECT_NOT_FOUND, formatoDataHora.format(instant.atZone(ZoneId.systemDefault())),
				formatoDataHora.format(instant.atZone(ZoneId.of(TZ_AMERICA_SAO_PAULO))));

		ErroPadrao erro = new ErroPadrao(HttpStatus.NOT_FOUND.value(), e.getMessage(), horaSistema);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(IntegridadeDadosException.class)
	public ResponseEntity<ErroPadrao> violacaoIntegridadeDadosEncontrado(IntegridadeDadosException e,
			HttpServletRequest request) {

		Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
		DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern(FORMATO_DATA_HORA);
		String horaSistema = formatoDataHora.format(instant.atZone(ZoneId.of(TZ_AMERICA_SAO_PAULO)));

		this.imprimirCabecalhoMensagem(HTTP_BAD_REQUEST, formatoDataHora.format(instant.atZone(ZoneId.systemDefault())),
				formatoDataHora.format(instant.atZone(ZoneId.of(TZ_AMERICA_SAO_PAULO))));

		ErroPadrao erro = new ErroPadrao(HttpStatus.BAD_REQUEST.value(), e.getMessage(), horaSistema);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErroPadrao> violacaoValidacao(MethodArgumentNotValidException e, HttpServletRequest request) {

		Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
		DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern(FORMATO_DATA_HORA);
		String horaSistema = formatoDataHora.format(instant.atZone(ZoneId.of(TZ_AMERICA_SAO_PAULO)));

		this.imprimirCabecalhoMensagem(HTTP_BAD_REQUEST, formatoDataHora.format(instant.atZone(ZoneId.systemDefault())),
				formatoDataHora.format(instant.atZone(ZoneId.of(TZ_AMERICA_SAO_PAULO))));

		ErroValidacao erro = new ErroValidacao(HttpStatus.BAD_REQUEST.value(), ERRO_DE_VALIDACAO, horaSistema);

		for (FieldError elemento : e.getBindingResult().getFieldErrors()) {
			erro.addError(elemento.getField(), elemento.getDefaultMessage());
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

	private void imprimirCabecalhoMensagem(String titulo, String tzSystemDefault, String tzBrasil) {
		System.out.println("======================================================");
		System.out.println(titulo);
		System.out.println("------------------------------------------------------");
		System.out.println("====== >> Zona SystemDefault..: " + tzSystemDefault);
		System.out.println("====== >> Zona BRASIL_SP......: " + tzBrasil);
		System.out.println("======================================================");
	}

}
