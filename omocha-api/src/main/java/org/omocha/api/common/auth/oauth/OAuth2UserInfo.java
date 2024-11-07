package org.omocha.api.common.auth.oauth;

import java.util.Map;

import org.omocha.domain.auction.review.Rating;
import org.omocha.domain.exception.UnsupportedOAuthProviderException;
import org.omocha.domain.member.Member;
import org.omocha.domain.member.Role;
import org.omocha.domain.member.UserStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class OAuth2UserInfo {
	private String name;
	private String email;
	private String provider;
	private String providerId;

	public static OAuth2UserInfo of(String provider, Map<String, Object> attributes) {
		return switch (provider) {
			case "google" -> ofGoogle(attributes);
			case "naver" -> ofNaver(attributes);
			default -> throw new UnsupportedOAuthProviderException(provider);
		};
	}

	private static OAuth2UserInfo ofGoogle(Map<String, Object> attributes) {
		return OAuth2UserInfo.builder()
			.name((String)attributes.get("name"))
			.email((String)attributes.get("email"))
			.provider("google")
			.providerId((String)attributes.get("sub"))
			.build();
	}

	private static OAuth2UserInfo ofNaver(Map<String, Object> attributes) {
		Map<String, Object> response = (Map<String, Object>)attributes.get("response");

		return OAuth2UserInfo.builder()
			.name((String)response.get("name"))
			.email((String)response.get("email"))
			.provider("naver")
			.providerId((String)response.get("id"))
			.build();
	}

	public Member toEntity() {
		return Member.builder()
			.username(name)
			.email(email)
			.averageRating(new Rating(0d))
			.role(Role.ROLE_USER)
			.provider(provider)
			.providerId(providerId)
			.userStatus(UserStatus.ACTIVATE)
			.build();
	}

}
