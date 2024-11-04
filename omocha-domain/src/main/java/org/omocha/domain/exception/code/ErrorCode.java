package org.omocha.domain.exception.code;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

	// TODO : description을 현재는 exception message와 같게 해놓음, 수정 필요

	// Jwt Code
	INVALID_REFRESH_TOKEN(HttpStatus.BAD_REQUEST, "올바르지 않는 Refresh Token 입니다."),

	JWT_TOKEN_NOT_FOUND(HttpStatus.NOT_FOUND, "JWT 토큰을 찾을 수 없습니다."),

	// OAuth Code
	UNSUPPORTED_OAUTH_PROVIDER(HttpStatus.BAD_REQUEST, "지원하지 않는 OAuth Provider입니다."),

	// Auction Code
	AUCTION_ALREADY_ENDED(HttpStatus.BAD_REQUEST, "이미 종료된 경매입니다."),
	AUCTION_HAS_BIDS(HttpStatus.BAD_REQUEST, "입찰이 걸려있는 경매입니다. 경매를 종료할 수 없습니다."),
	AUCTION_NOT_IN_BIDDING_STATUS(HttpStatus.BAD_REQUEST, "경매의 상태가 입찰중이 아닙니다."),

	AUCTION_NOT_FOUND(HttpStatus.NOT_FOUND, "경매를 찾을 수 없습니다."),
	AUCTION_IMAGE_NOT_FOUND(HttpStatus.NOT_FOUND, "경매이미지를 찾을 수 없습니다."),
	AUCTION_MEMBER_INVALID(HttpStatus.BAD_REQUEST, "경매를 생성한 회원이 아니여서 삭제를 할 수 없습니다."),
	AUCTION_IMAGE_DELETE_FAIL(HttpStatus.BAD_REQUEST, "경매에서 생성된 이미지를 삭제할 수 없습니다."),
	UNSUPPORTED_MEDIA_TYPE(HttpStatus.UNSUPPORTED_MEDIA_TYPE, "지원하지 않는 Content-Type 입니다."),

	// Bid Code
	NO_BIDS_FOUND(HttpStatus.BAD_REQUEST, "입찰이 존재하지 않습니다."),
	SELF_BID_NOT_ALLOWED(HttpStatus.BAD_REQUEST, "자신의 경매에 입찰을 걸 수 없습니다."),
	INVALID_BID_UNIT(HttpStatus.BAD_REQUEST, "입찰 금액이 입찰 단위에 유효하지 않습니다."),
	BID_BELOW_START_PRICE(HttpStatus.BAD_REQUEST, "입찰 가격이 시작 가격보다 낮습니다."),
	BID_NOT_EXCEEDING_CURRENT_HIGHEST(HttpStatus.BAD_REQUEST, "입찰 가격이 최고가보다 높지 않습니다."),

	// Conclude Code
	CONCLUDE_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 경매에는 낙찰 내역이 존재하지 않습니다."),

	// Chat Code,
	CHATROOM_ALREADY_EXISTS(HttpStatus.CONFLICT, "이미 존재하는 채팅방입니다."),
	CHATROOM_ACCESS_FAIL(HttpStatus.FORBIDDEN, "채팅방에 접근 거부되었습니다"),
	CHATROOM_NOT_FOUND(HttpStatus.NOT_FOUND, "채팅방을 찾을 수 없습니다"),

	// EXPLAIN: 500 SERVER ERROR
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버오류 발생");

	private final HttpStatus httpStatus;
	private final String description;

	public int getStatusCode() {
		return httpStatus.value();
	}
}