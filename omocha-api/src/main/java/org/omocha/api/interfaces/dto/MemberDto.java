package org.omocha.api.interfaces.dto;

import org.omocha.domain.member.Role;

import jakarta.validation.constraints.NotBlank;

public class MemberDto {

	// TODO: 회원가입 로직을 확정하고 수정해야함
	public record MemberCreateRequest(
		@NotBlank
		String email,

		@NotBlank
		String password
	) {
	}

	public record MemberDuplicateRequest(
		@NotBlank
		String email
	) {
	}

	public record MemberLoginRequest(
		@NotBlank
		String email,

		@NotBlank
		String password
	) {
	}

	// TODO: 넘겨줄 정보들에 대해 추후 정해야함, 일단은 Password 제외하고 다 넘겨줌
	public record MemberDetailResponse(
		String email,
		String nickname,
		String birth,
		String phoneNumber,
		String imageUrl,
		Role role
	) {

	}

}