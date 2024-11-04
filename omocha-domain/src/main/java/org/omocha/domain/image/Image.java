package org.omocha.domain.image;

import org.omocha.domain.auction.Auction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "image")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_id")
	private Long imageId;

	private String fileName;

	private String imagePath;

	@ManyToOne
	@JoinColumn(name = "auction_id")
	private Auction auction;

	@Builder
	public Image(
		String fileName,
		String imagePath,
		Auction auction
	) {
		this.fileName = fileName;
		this.imagePath = imagePath;
		this.auction = auction;
	}

}