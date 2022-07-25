package exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SalesManagementExceptionHandler extends ResponseEntityExceptionHandler {

	private static final String CONSTANT_VALIDATION_NOT_BLANK = "NotBlank";
	private static final String CONSTANT_VALIDATION_Length = "Length";
	private static final String CONSTANT_VALIDATION_NOT_NULL = "NotNull";
	private static final String CONSTANT_VALIDATION_PATTERN = "Pattern";
	private static final String CONSTANT_VALIDATION_MIN = "Min";

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<MyError> errorList = generateErrorList(ex.getBindingResult());
		return handleExceptionInternal(ex, errorList, headers, HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex,
			WebRequest request) {
		String messageUser = "Recurso não encontrado";
		String messageDev = ex.toString();
		List<MyError> errors = Arrays.asList(new MyError(messageUser, messageDev));
		return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler(BusinessRuleException.class)
	public ResponseEntity<Object> handleBusinessRuleException(BusinessRuleException ex, WebRequest request) {
		String messageUser = ex.getMessage();
		String messageDev = ex.toString();
		List<MyError> errors = Arrays.asList(new MyError(messageUser, messageDev));
		return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex,
			WebRequest request) {
		String messageUser = "Recurso não encontrado";
		String messageDev = ex.toString();
		List<MyError> errors = Arrays.asList(new MyError(messageUser, messageDev));
		return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	private List<MyError> generateErrorList(BindingResult bindingResult) {
		List<MyError> errors = new ArrayList<MyError>();
		bindingResult.getFieldErrors().forEach(requestError -> {
			String messageUser = handleErrorMessageForUser(requestError);
			String messageDev = requestError.toString();
			errors.add(new MyError(messageUser, messageDev));
		});
		return errors;
	}

	private String handleErrorMessageForUser(FieldError requestError) {
		if (requestError.getCode().equals(CONSTANT_VALIDATION_MIN)) {
			return requestError.getDefaultMessage().concat(" é obrigatorio colocar um valor maior que 0.");
		}
		
		if (requestError.getCode().equals(CONSTANT_VALIDATION_NOT_BLANK)) {
			return requestError.getDefaultMessage().concat(" é obrigatorio.");
		}

		if (requestError.getCode().equals(CONSTANT_VALIDATION_Length)) {
			return requestError.getDefaultMessage().concat(String.format(" deve ter entre %s e %s caracteres.",
					requestError.getArguments()[2], requestError.getArguments()[1]));
		}

		if (requestError.getCode().equals(CONSTANT_VALIDATION_NOT_NULL)) {
			return requestError.getDefaultMessage().concat(" não pode ser nulo.");
		}

		if (requestError.getCode().equals(CONSTANT_VALIDATION_PATTERN)) {
			return requestError.getDefaultMessage().concat(" formato inválido.");
		}
		return requestError.toString();
	}
}
