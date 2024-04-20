package investmentascode.projects.investmentascodedal.exception;

import org.springframework.http.HttpStatus;

public class SearchKeyNotFoundException extends RuntimeException {
  private final String message;
  private final HttpStatus httpStatus;

  public SearchKeyNotFoundException(String message, HttpStatus httpStatus) {
    this.message = message;
    this.httpStatus = httpStatus;
  }

  public String getMessage() {
    return message;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }
}
