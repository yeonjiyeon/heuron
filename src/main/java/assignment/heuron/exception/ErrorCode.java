package assignment.heuron.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
  PatientNotFoundException("환자 정보가 없습니다."),
  ImageNotFoundException("이미지 등록후 조회 가능합니다.")
  ;

  private final String message;

  ErrorCode(String message) {
    this.message = message;
  }
}
