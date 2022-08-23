## 휴런 **백엔드 사전과제**

## Introduction

환자 이미지와 데이터를 업로드하고 저장할 수 있는 시스템 설계
</br>
</br>


## 요구사항

- REST API
- Java 1.8
- Spring Boot 
- 데이터 베이스 자유 선택
</br>
</br>


## 프로젝트 사용 기술
- Java 1.8
- Spring Boot 2.7.3
- H2
- Spring Data JPA
- Git(Git Flow 브랜치 전략을 사용했습니다.)
</br>
</br>


## **API Specifications 및 문제 해결 방법**

### -저장 API : POST http://localhost:8080/api/v1/patient
 - @RequestPart 애노테이션을 이용해서 환자데이터와 이미지 데이터를 각각 받아와 저장하였습니다. 이때 이미지 파일이 있으면, patient 엔티티의 SaveLevel을 기본 값 level1에서 level2로 올려주었습니다.
</br>

patientRequest
```json
{
    "patientName":"patientA",
    "patientAge":"59",
    "patientGender":"MAN",
    "hasDisease": true
		
}
```




![image](https://user-images.githubusercontent.com/69364279/185926929-bf1748a0-2baf-4241-87d9-664a9f511db6.png)
  - id값으로 응답받도록 구현하였습니다.

</br>

### -상세 조회 API GET http://localhost:8080/api/v1/patient/{patientId}
- 레벨 측정 메서드를 만들어 레벨 측정후 1단계면 메시지를 뿌려주고, 2단계면 환자 조회가 가능하도록 해줍니다.

- Level1일 때 조회  
![image](https://user-images.githubusercontent.com/69364279/186096793-4fa3d75e-bb42-47ad-9bf4-4d3a1ff9945e.png)
  </br>
  1단계에서는 사진 등록 메시지를 받습니다. 

- Level2(이미지가 존재할 때)일 때 조회
![image](https://user-images.githubusercontent.com/69364279/186044445-8fd5d844-0d61-4d37-8cf3-be9e6f1cf05c.png)
  </br>
  2단계에서는 환자 정보가 조회 됩니다. 
  
</br>

### -이미지 조회 API GET http://localhost:8080/api/v1/image/{imageName}
- 이미지의 이름을 통해 파일을 읽어와 byte[] 형태의 값으로 인코딩 해 보내줍니다. 
![image](https://user-images.githubusercontent.com/69364279/186042971-3f9b54b8-5bd6-47dd-9135-3c15e57feb4a.png)
</br>


</br>

### - 삭제 API DELETE http://localhost:8080/api/v1/patient/{patientId}
![image](https://user-images.githubusercontent.com/69364279/186047520-7c00c783-9080-4476-a167-51455dee7206.png)
</br>
삭제후 삭제 아이디값을 반환합니다. 

</br>
</br>






