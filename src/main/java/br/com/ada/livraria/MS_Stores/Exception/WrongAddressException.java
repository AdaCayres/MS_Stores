package br.com.ada.livraria.MS_Stores.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongAddressException extends RuntimeException {
    public WrongAddressException(String message){ super(message);}
}
