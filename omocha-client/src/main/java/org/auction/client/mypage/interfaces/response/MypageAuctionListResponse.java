package org.auction.client.mypage.interfaces.response;

import java.time.LocalDateTime;
import java.util.List;

import org.auction.domain.auction.domain.enums.AuctionStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public record MypageAuctionListResponse(
	Long auctionId,
	String title,
	AuctionStatus auctionStatus,
	Long nowPrice,
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	LocalDateTime endDate,
	List<String> imageKeys
) {

}