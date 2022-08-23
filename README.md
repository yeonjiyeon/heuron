## 휴런 **백엔드 사전과제**

## Introduction

환자 이미지와 데이터를 업로드하고 저장할 수 있는 시스템 설계
</br>

## 요구사항

- REST API
- Java 1.8
- Spring Boot 2.7.3
- 데이터 베이스 자유 선택
</br>


## 프로젝트 사용 기술
- Java 1.8
- Spring Boot
- H2
- Spring Data JPA
</br>

## **API Specifications**

### -저장 API : POST http://localhost:8080/api/v1/patient
- Request 

patientRequest
```json
{
    "patientName":"patientA",
    "patientAge":"59",
    "patientGender":"MAN",
    "hasDisease": true
		
}
```
imageFile

- Response
  id값으로 응답받습니다.

![image](https://user-images.githubusercontent.com/69364279/185926929-bf1748a0-2baf-4241-87d9-664a9f511db6.png)


### -상세 조회 API GET http://localhost:8080/api/v1/patient/{patientId}

- Level1일 때 조회  
![image](https://user-images.githubusercontent.com/69364279/186096793-4fa3d75e-bb42-47ad-9bf4-4d3a1ff9945e.png)
  1단계에서는 사진 등록 메시지를 받습니다. 

- Level2(이미지가 존재할 때)일 때 조회
![image](https://user-images.githubusercontent.com/69364279/186044445-8fd5d844-0d61-4d37-8cf3-be9e6f1cf05c.png)
  2단계에서는 환자 정보가 조회 됩니다. 

### -이미지 조회 API GET http://localhost:8080/api/v1/image/{imageName}
![image](https://user-images.githubusercontent.com/69364279/186042971-3f9b54b8-5bd6-47dd-9135-3c15e57feb4a.png)
해당 URL로 이미지 확인이 가능합니다. 

### - 삭제 API DELETE http://localhost:8080/api/v1/patient/{patientId}
![image](https://user-images.githubusercontent.com/69364279/186047520-7c00c783-9080-4476-a167-51455dee7206.png)
삭제후 삭제 아이디값을 반환합니다. 


