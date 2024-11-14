package org.omocha.infra;

import org.omocha.domain.auction.AuctionCommand;
import org.omocha.domain.auction.AuctionInfo;
import org.omocha.domain.auction.LikeReader;
import org.omocha.infra.repository.LikeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LikeReaderImpl implements LikeReader {

	private final LikeRepository likeRepository;

	@Override
	public boolean getAuctionLikeStatus(AuctionCommand.LikeAuction likeCommand) {
		return likeRepository.existsByAuctionAuctionIdAndMemberMemberId(likeCommand.auctionId(),
			likeCommand.memberId());
	}

	@Override
	public Page<AuctionInfo.RetrieveMyAuctionLikes> getMyAuctionLikes(Long memberId, Pageable pageable) {
		return likeRepository.getMyAuctionLikes(memberId, pageable);
	}

}
