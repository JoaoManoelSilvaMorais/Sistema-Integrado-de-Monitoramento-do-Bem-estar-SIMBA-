package br.simba.bem_estar.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.simba.bem_estar.exceptions.AcessoNegadoException;
import br.simba.bem_estar.exceptions.DadoNaoEncontradoException;
import br.simba.bem_estar.exceptions.DadosDuplicadosException;
import br.simba.bem_estar.exceptions.RegraDeNegocioException;

@RestControllerAdvice 
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
    

    //trata as exceptions das nossas regras de negocio
    @ExceptionHandler(RegraDeNegocioException.class)
    private ResponseEntity<RestErrorMessage> handlerRegraDeNegocio(RegraDeNegocioException exception){

        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.UNPROCESSABLE_ENTITY, exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(threatResponse);
    }
    //trata as exceptions para quando a aplicação não acha um dado no banco
    @ExceptionHandler(DadoNaoEncontradoException.class)
    private ResponseEntity<RestErrorMessage> handlerDadosNaoEncontrados(DadoNaoEncontradoException exception){
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatResponse);
    }
    //tratamento de erro de autorização,um usuario tenta modificar um registro que nao tem acesso
    @ExceptionHandler(AcessoNegadoException.class)
    private ResponseEntity<RestErrorMessage> handlerAcessoNegado(AcessoNegadoException exception){
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.FORBIDDEN, exception.getMessage());
        return  ResponseEntity.status(HttpStatus.FORBIDDEN).body(threatResponse);
    }

    //tratamentos para dados duplicados exemplo:um usuario tenta cadastrar uma nova conta com um email q ja esta cadastrado
    
    @ExceptionHandler(DadosDuplicadosException.class)
    private ResponseEntity<RestErrorMessage> handlerDadosDuplicados(DadosDuplicadosException exception){
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(threatResponse);
    }


    //tratamento generico pra outros erros genericos,oculta as informaçoes da aplicação
    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity<RestErrorMessage> handlerRunTimeException(RuntimeException exception){
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro interno inesperado no servidor.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(threatResponse);
    }

    
}
