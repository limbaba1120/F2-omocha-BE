package org.omocha.domain.auction.conclude;

import java.time.LocalDateTime;

import org.omocha.domain.auction.Auction;
import org.omocha.domain.member.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "conclude")
public class Conclude {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long concludeId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "auction_id")
	private Auction auction;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "buyer_id")
	private Member buyer;

	private Long concludePrice;

	private LocalDateTime concludedAt;

	@Builder
	public Conclude(
		Auction auction,
		Member buyer,
		Long concludePrice,
		LocalDateTime concludedAt
	) {
		this.auction = auction;
		this.buyer = buyer;
		this.concludePrice = concludePrice;
		this.concludedAt = concludedAt;
	}
}