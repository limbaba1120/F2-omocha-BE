# 🧸 **Omocha**

<img src="https://github.com/limbaba1120/limbaba1120_images/blob/master/notion_image/opanchu.jpeg" width="200px;" alt="Omocha Logo">

## 📖 **프로젝트 소개**

- **오타쿠를 위한 피규어, 장난감 등의 다양한 굿즈를 경매하는 서비스!**
- 희귀한 제품이 많은 피규어 시장을 타겟으로 함

---

## ⭐ **주요 기능**

### **로그인 페이지 | 메인 페이지**

| 로그인 페이지                                                                                                 | 메인 페이지                                                                                                     |
|----------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|
| ![로그인 페이지](https://github.com/limbaba1120/limbaba1120_images/blob/master/notion_image/omocha_login.gif)| ![메인 페이지](https://github.com/limbaba1120/limbaba1120_images/blob/master/notion_image/omocha_mainpage.gif)  |
| OAuth 2.0(Google, Naver) 회원가입, 로그인을 제공합니다.                                                              | 경매 게시글 전체 확인, 검색을 제공합니다.                                                                                   |
| - *추가필요*                                                                                                | - *추가필요*                                                                                                   |

---

### **경매 게시글 생성 | 입찰**

| 경매 게시글 생성                                                                                                                                 | 입찰                                                                                                       |
|-------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|
| ![경매 게시글 생성](https://github.com/limbaba1120/limbaba1120_images/blob/master/notion_image/omocha_auction_create_new.gif)                        | ![입찰](https://github.com/limbaba1120/limbaba1120_images/blob/master/notion_image/omocha_bid.gif) |
| 새로운 경매 게시글을 생성하고 상품 정보 및 경매 기간을 설정할 수 있습니다.                                                                                               | 상품에 입찰하고 실시간으로 경쟁 입찰 상황을 확인할 수 있습니다.                                                                     |
| - 경매는 일반 경매 or 라이브 경매로 생성할 수 있음. (현재는 일반형만 가능) <br/> - 상품명, 상품 사진(최대 10개), 상품 정보, 시작가, 입찰단위, 경매 시간을 입력해야함. <br/> - 한번 등록된 경매는 수정, 삭제가 불가함 | -  *추가 필요*                                                                                               |

---

### **채팅 | 마이페이지**

| 채팅                                                                                                                                                                                                                            | 마이페이지                                                                                                    |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|
| ![채팅](https://github.com/limbaba1120/limbaba1120_images/blob/master/notion_image/omocha_chat.gif)                                                                                                                     | <img src="https://github.com/limbaba1120/limbaba1120_images/blob/master/notion_image/omocha_mypage.png"> |
| 낙찰 후 자동으로 채팅방이 생성됩니다. 판매자와 구매자가 거래를 할 수 있습니다.                                                                                                                                                                                 | 회원 정보를 확인하고 개인 설정을 관리할 수 있습니다.                                                                           |
| - 채팅방에 들어가면 WebSocket이 연결되고 상대방에게 메시지를 보낼 수 있음.   <br/> - STOMP(Simple/Streaming Text Oriented Messaging Protocal) 텍스트 기반의 메세지 프로토콜 사용 <br/> - 채팅방 입장: Topic 구독 <br/> - 채팅방에서 메세지를 송수신: 해당 Topic으로 메세지를 송신(pub), 메세지를 수신(sub) | - *추가 필요*                                                                                                |

---




## **기술 스택**

<details>
<summary> 접기 / 펼치기</summary>

Framework<BR>
<img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=Spring-Boot&logoColor=white"><br>

Language<BR>
<img src="https://img.shields.io/badge/Java_17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"><br>

INFRA<BR>
<img src="https://img.shields.io/badge/AWS_EC2-FF9900?style=for-the-badge&logo=amazon-aws&logoColor=white"> <img src="https://img.shields.io/badge/AWS_RDS-FF9900?style=for-the-badge&logo=amazon-aws&logoColor=white"> <img src="https://img.shields.io/badge/AWS_S3-FF9900?style=for-the-badge&logo=amazon-aws&logoColor=white"> <img src="https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white"><br>

CI/CD<BR>
<img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white"> <img src="https://img.shields.io/badge/GitHub_Actions-2088FF?style=for-the-badge&logo=github-actions&logoColor=white"><br>

Version Control<BR>
<img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white"> <img src="https://img.shields.io/badge/GitHub-2088FF?style=for-the-badge&logo=github&logoColor=white"><br>

</details>

---

## 👨‍👩‍👧‍👦 **팀원 소개**

<table>
  <tr>
    <td align="center"><b>Frontend</b></td>
    <td align="center"><b>Frontend</b></td>
    <td align="center"><b>Backend</b></td>
    <td align="center"><b>Backend</b></td>
    <td align="center"><b>Backend</b></td>
  </tr>
  <tr>
    <td align="center">
      <a href="https://github.com/haejinyun">
        <img src="https://avatars.githubusercontent.com/u/86779590?v=4" width="100px;" alt="윤해진"/><br />
        <sub><b>팀장 : 윤해진</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/kimeodml">
        <img src="https://avatars.githubusercontent.com/u/88065770?v=4" width="100px;" alt="김대의"/><br />
        <sub><b>팀원 : 김대의</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/limbaba1120">
        <img src="https://avatars.githubusercontent.com/u/102224840?v=4" width="100px;" alt="임건우"/><br />
        <sub><b>팀원 : 임건우</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/ss0ngcode">
        <img src="https://avatars.githubusercontent.com/u/86779839?v=4" width="100px;" alt="송해덕"/><br />
        <sub><b>팀원 : 송해덕</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/gooot">
        <img src="https://avatars.githubusercontent.com/u/26480629?v=4" width="100px;" alt="이재윤"/><br />
        <sub><b>팀원 : 이재윤</b></sub>
      </a>
    </td>
  </tr>
</table>
