# 대학종합정보시스템
![그림1](https://user-images.githubusercontent.com/71927210/126895277-98982d9a-16df-4a6f-92d2-a73d8349162e.png)
#### 시스템 구조
![구조](https://user-images.githubusercontent.com/71927210/126896686-81eef6a6-8c1c-46d5-9970-2c4585d11fcd.png)
#### 학사 담당자
![학사 담당자](https://user-images.githubusercontent.com/71927210/126896684-6ae76bfa-cfa6-425d-a370-9988e1160f00.png)
#### 교수
![교수](https://user-images.githubusercontent.com/71927210/126896687-92bd28de-6a21-43c6-b518-352b5f488eb6.png)
#### 학생
![학생](https://user-images.githubusercontent.com/71927210/126896688-c6d04c7d-9a5a-467d-80e0-591d57af486c.png)
#### 수업 담당자
![수업 담당자](https://user-images.githubusercontent.com/71927210/126896689-45b091e1-dcad-4677-b6f2-8b1a884e9374.png)
# 로그인 
## 분석
3. 사용자 데이터에 존재하는 아이디와 비밀번호가 일치할 경우 로그인 성공한다.
4. 사용자는 로그인할 수 있다.
5. 로그인 성공 시 사용자에 따라 창이 다르게 구성된다.
6. 사용자는 초기 비밀번호를 변경할 수 있다.

## 설계
1. 사용자의 데이터를 읽기 위해서 “회원정보.txt”를 Reader합니다.
2. “회원정보.txt”를 처음부터 끝까지 Reader합니다.
3. Reader한 정보를 아이디와 비밀번호 구분합니다.
4. 학번과 비밀번호를 입력하기 위해서 JTextField가 필요합니다.
5. 학번과 비밀번호가 일치할 경우 로그인 성공합니다.
6. 학번 정보 중 
    -  s를 가지면 학생으로 로그인됩니다.
    -  p를 가지면 교수로 로그인됩니다.
    -  h를 가지면 학사담당자로 로그인됩니다.
    -  g를 가지면 수업담당자로 로그인됩니다.
    
![로그인](https://user-images.githubusercontent.com/71927210/129730209-a0fbf47b-ccea-457f-b790-327de2739cd9.png)
## 구현
   - 로그인 성공
 
   ![로그인 성공](https://user-images.githubusercontent.com/71927210/126895340-1eda8ef0-1d1e-4c6c-bcc9-cde90baa3112.png)

   - 로그인 실패
   
   ![로그인 실패](https://user-images.githubusercontent.com/71927210/126895338-8b0c4608-0e6c-4abd-a8cb-e242c6684e57.png)
    
   - 학사 담당자 로그인 
 
   ![학사담당자](https://user-images.githubusercontent.com/71927210/126895608-e4e27963-0276-41d4-8e1e-c9e5d1145f03.png)

   - 교수 로그인 
 
   ![교수](https://user-images.githubusercontent.com/71927210/126895605-47defcf5-406d-4d19-afbf-9889c95c1574.png)

   - 학생 로그인 
   
   ![학생](https://user-images.githubusercontent.com/71927210/126895607-e2e73aa3-83d8-4bae-9a2a-ea2b7fe0577a.png)

   - 수업 담당자 로그인
   
   ![수업담당자](https://user-images.githubusercontent.com/71927210/126895610-12ae8ab7-4bfc-4560-a35e-e11cfdac0000.png)
    
   - 사용자 개인정보 수정 
   
   ![사용자 개인정보 수정](https://user-images.githubusercontent.com/71927210/126895703-87341c46-5737-4595-85e4-1c7df65803e2.png)
# 학사 담당자
## 분석
1. 학사관리자는 사용자의 등록, 조회, 삭제 기능을 가지고 있다.
2. 조회 전 학사관리자는 저장된 사용자 정보를 JTable로 확인할 수 있다.
3. 조회는 사용자 데이터에 존재하는 학번이나 비밀번호로 사용자 정보를 조회할 수 있다.
4. 해당 JTable을 선택하여 삭제 버튼을 누르게 되면 해당 정보가 데이터에 삭제된다.
5. 삭제된 정보는 실시간으로 확인할 수 있도록 새로고침 버튼으로 초기화할 수 있다.
6. 학사관리자는 신규 사용자의 해당 정보를 입력하여 계정 생성할 수 있다.

## 설계
1. 학사담당자는  “회원정보.txt”를 수정, 삭제, 조회할 수 있다.
2. 학사담당자의 기능 구현을 위해 등록버튼, 수정, 조회, 삭제 버튼을 만든다.
3. 등록버튼을 누르게 되면 “회원정보.txt“에 입력한 사용자 정보가 추가된다.
4. JTable에 전체 사용자 중 하나를 택해서 해당 셀의 사용자 데이터를 받아 수정할 수 있다.
5. JTable에 전체 사용자 중 하나를 택해서 해당 셀의 사용자 데이터를 받아 삭제 할 수 있다.
6. JTextField에 학번이나 비밀번호를 입력하여 조회 버튼을 누르게 되면 해당 ”회원정보.txt“에 데이터 조회를 할 수 있다.

![학사담당자](https://user-images.githubusercontent.com/71927210/129732403-64997d4e-ca0f-4ca5-be46-985f1f77f365.png)
## 구현
   - 사용자 등록
   
   ![학사담당자1](https://user-images.githubusercontent.com/71927210/126895910-848a37ca-0e91-4b98-89fd-37b815649841.png)
    
   - 등록된 사용자 목록
   
   ![사용자 목록](https://user-images.githubusercontent.com/71927210/126896022-5ca4090d-f67b-4fa8-85b9-0e67a4039784.png)
   
   - 목록 조회 
   
   ![사용자 목록 조회](https://user-images.githubusercontent.com/71927210/126896051-dfdcff80-89bb-4c12-83e0-8b9f99ade41d.png)
   
   - 사용자 목록 수정 
   
   ![사용자 목록 수정](https://user-images.githubusercontent.com/71927210/126896113-534245de-b89f-4764-aa9c-a1189e788bde.png)
   
   - 사용자 목록 삭제 
   
   ![사용자 목록 삭제](https://user-images.githubusercontent.com/71927210/126896111-244a91ca-f2d5-493e-8b0c-97d9ea696fe2.png)

   - 사용자 DB 텍스트 테이블 
   
   ![시용지 DB](https://user-images.githubusercontent.com/71927210/126895966-1357750b-ef9a-4546-82c9-94598fe6ccba.png)



# 수업 관리
## 분석
1. 교수가 성적을 입력한 파일을 읽어올 수 있다.
2. 교수는 자신이 강의하는 강좌를 신청한 학생 명단을 확인할 수 있다.
3. 교수는 학생에 대한 성적을 직접 입력할 수 있다.
4. 교수는 ‘A’, ‘B’, ‘C’, ‘D’, ‘F’의 값으로 학점을 입력할 수 있다.
5. 교수는 로그인하여 출석부 창을 나타나게 할 수 있다.
6. 학생은 성적이 입력된 파일 안에서 현재 사용자의 학번과 일치하는 정보만을 불러올 수 있다.
## 설계
1. 교수가 입력한 성적이 저장되어있는 “성적입력.txt”를 읽는다.
2. 파일을 읽을 때 현재 사용자의 이름과 txt의 성적과 함께 저장된 학생이름이 일치하는 정보만 JTable에 추가한다.
3. 교수는 학점을 입력하고 수정을 누르면 해당 학생의 학점이 “성적입력.txt”에 저장된다.
4. ApplyClass에서 생성된 학생의 수강신청 정보가 저장되어있는 “데이터베이스.txt” 파일에서 정보를 가져와 교수의 강의를 듣는 학생의 명단만 JTable에 나타나게 한다.
5. JTable의 콤보박스 기능을 이용하여 학점의 목록을 ‘A’, ‘B’, ‘C’, ‘D’, ‘F’로 만든다.
6. ProfessorAddGradeClass에서 생성된 “성적입력.txt” 파일에서 정보를 가져와 교수의 강의를 듣는 학생의 명단만 JTable에 나타나게 한다.
7. 학생이 조회 버튼을 누르면 자신이 신청한 강좌에 대한 입력된 성적을 볼 수 있다.
![성적](https://user-images.githubusercontent.com/71927210/129736730-18293203-450f-4df4-b06b-3d175b97f423.png)
## 구현
   - 출석부 화면
   
   ![출석부](https://user-images.githubusercontent.com/71927210/126896397-9299ecb6-21aa-4902-a1e8-14086afddf04.png)

   - 수강생 학번 조회
   
   ![학번 조회](https://user-images.githubusercontent.com/71927210/126896398-922b16e4-93e9-4e34-b2ba-a2199b09fc98.png)

   - 수강생 성적 조회
   
   ![수강 인원 성적 조회](https://user-images.githubusercontent.com/71927210/126896399-ecd46b88-bef4-4d0a-9e7a-c64ab243c2bf.png)

   - 수강생 성적 입력
   
   ![성적 입력](https://user-images.githubusercontent.com/71927210/126896395-817b346e-4e8f-4b3d-a918-49cd6b5ba211.png)

   - 수강생 성적 수정

   ![성적 수정](https://user-images.githubusercontent.com/71927210/126896396-9f3e8ec0-2600-43c8-9f33-c30355712166.png)



# 수강 신청
## 분석
1. 학생이 로그인하여 수강신청 창을 볼 수 있다.
2. 등록된 강좌목록을 불러올 수 있다.
3. 선택한 강좌를 로그인한 유저와 매치하여 저장할 수 있다.
4. 이미 저장된 강좌를 신청 할 경우 중복된 강좌임을 알리고 강좌를 추가하지 않는다.  
5. 신청된 강좌의 학점을 총합하여 18학점이 넘을 경우 신청이 불가능함을 알린다
6. 학사관리자는 신규 사용자의 해당 정보를 입력하여 계정 생성할 수 있다.
## 설계
1. 강좌가 등록되어 저장되어 있는 “강좌목록.txt” 파일에서 정보를 가져와서 JTable에 보여지도록 한다.
2. 검색창을 이용하여 강좌번호를 이용하여 조회 버튼을 누르면 강좌번호와 일치하는 정보만 JTable에 보인다.
3. 목록보기 버튼을 누르면 다시 전체 강좌목록이 보여진다.
4. 신청을 원하는 강좌를 선택하고 신청버튼을 누르면 로그인한 사용자의 이름과 학번과 함께 신청한 강좌의 정보가 함께 “데이터베이스.txt”에 저장된다.
5. 현재사용자의 학번과 선택한 강좌이름이 “데이터베이스.txt”파일에 있는 정보들과 비교하여 일치하는 항목이 있으면 이미 신청된 강좌임을 알리고 강좌를 추가하지 않는다.
6. 최대학점 18학점을 넘었음을 알리고 강좌는 추가되지 않는다.
7. 최대수강인원이 수강하게 되었음을 알리고 강좌는 추가되지 않는다.
8. 개설된 강좌목록이 저장된 “강좌목록.txt”파일과 신청한 강좌가 저장될 “데이터베이스.txt” 파일이 필요하다.
9. 이벤트처리기 클래스를 이용하여 현재 사용자의 이름과 학번을 받고 JTable에서 선택된 열의 값을 변수를 통해서 받아와 함께 “데이터베이스.txt” 파일에 저장한다.

![수강신청](https://user-images.githubusercontent.com/71927210/129734392-20a0e6a3-b15d-4f92-92d5-25dc34d7d095.png)
## 구현
   - 학생 -수강신청 화면
   
   ![수강신청](https://user-images.githubusercontent.com/71927210/126896261-7553a2f5-60db-4ba7-bca2-d01d88ec8313.png)

   - 수강 조회
   
   ![수강 조회](https://user-images.githubusercontent.com/71927210/126896258-731ed081-15d4-4863-a82f-a22d2817a1f8.png)

   - 수강 신청
   
   ![수강 신청하기](https://user-images.githubusercontent.com/71927210/126896256-fea3980a-acaf-437d-87b1-1f11a93deae8.png)

   - 수강 중복 체크
   
   ![수강 중복 체크](https://user-images.githubusercontent.com/71927210/126896259-56e21009-9d57-48c4-a449-01443ef6ad77.png)

   - 수강 최대 학점 체크
   
   ![수강 최대 학점](https://user-images.githubusercontent.com/71927210/126896260-501d6f84-014c-499d-8acb-573ce3543585.png)

   - 수강 인원 초과
   
   ![수강 인원 초과](https://user-images.githubusercontent.com/71927210/126896257-7913eec3-d052-4f8f-87b5-3535291e1717.png)
   
   - 수강 성적확인
   
   ![수강 성적확인](https://user-images.githubusercontent.com/71927210/126896254-2367fbca-6c34-4dd7-978e-84272c7e423e.png)


# 수업 담당자
5. 강좌 관리 기능
   - 수업 담당자 -강좌 등록 화면
   
   ![강좌 등록 화면](https://user-images.githubusercontent.com/71927210/126896597-8426debe-7160-4c79-adde-892085e2d202.png)

   - 강좌 등록
   
   ![강좌 등록](https://user-images.githubusercontent.com/71927210/126896600-de2cd953-de51-4b8d-8cea-3b976fc27117.png)

   - 강좌 수정
   
   ![강좌 수정](https://user-images.githubusercontent.com/71927210/126896601-10a5851b-689b-47b9-a03e-febd774ae4ad.png)

   - 강좌 삭제
   
   ![강좌 삭제](https://user-images.githubusercontent.com/71927210/126896603-35322b20-abd6-4fc8-bbaf-794622d04c4b.png)

   - 강좌 전체 조회 및 상세 조회
   
   ![강좌 전체 검색 및 상세 검색](https://user-images.githubusercontent.com/71927210/126896604-f846b6e8-e0d4-4b27-a9fd-73dbb4dce21c.png)

   - 강좌 청구서 발급
   
   ![청구서 발급](https://user-images.githubusercontent.com/71927210/126896605-f373905f-d9a4-4375-bd63-c9425abae0ba.png)
   












