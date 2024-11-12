package org.omocha.domain.exception.code;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccessCode {

	// Member Code

	MEMBER_CREATE_SUCCESS(HttpStatus.OK, "회원을 성공적으로 생성하였습니다."),
	MEMBER_LOGIN_SUCCESS(HttpStatus.OK, "로그인이 완료되었습니다."),
	MEMBER_LOGOUT_SUCCESS(HttpStatus.OK, "로그아웃이 완료되었습니다."),
	VALIDATE_EMAIL_SUCCESS(HttpStatus.OK, "사용 가능한 이메일입니다."),
	
	// Auction Code
	AUCTION_CREATE_SUCCESS(HttpStatus.OK, "경매가 성공적으로 생성되었습니다."),
	AUCTION_DELETE_SUCCESS(HttpStatus.OK, "경매가 성공적으로 삭제되었습니다."),
	AUCTION_LIST_ACCESS_SUCCESS(HttpStatus.OK, "경매 리스트를 성공적으로 조회하였습니다."),
	AUCTION_DETAIL_SUCCESS(HttpStatus.OK, "경매 상세정보를 성공적으로 조회하였습니다."),

	// Bid Code
	BIDDING_CREATE_SUCCESS(HttpStatus.OK, "성공적으로 입찰되었습니다."),
	BIDDING_GET_SUCCESS(HttpStatus.OK, "성공적으로 입찰을 불러왔습니다."),
	NOW_PRICE_GET_SUCCESS(HttpStatus.OK, "성공적으로 현재가를 불러왔습니다."),

	// Chat Code
	CHATROOM_CREATE_SUCCESS(HttpStatus.CREATED, "채팅방이 성공적으로 생성되었습니다."),
	CHATROOM_LIST_SUCCESS(HttpStatus.OK, "채팅방 목록을 성공적으로 조회하였습니다."),
	CHATROOM_MESSAGES_SUCCESS(HttpStatus.OK, "전체 메시지를 성공적으로 조회하였습니다."),

	// Review Code
	REVIEW_ADD_SUCCESS(HttpStatus.OK, "리뷰가 성공적으로 생성되었습니다."),
	REVIEW_LIST_ACCESS_SUCCESS(HttpStatus.OK, "리뷰 리스트를 성공적으로 조회하였습니다.");

	private final HttpStatus httpStatus;
	private final String description;

	public int getStatusCode() {
		return httpStatus.value();
	}
}
