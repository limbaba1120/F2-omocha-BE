package org.omocha.api.member.dto;

import org.omocha.domain.common.Role;
import org.omocha.domain.member.vo.Email;
import org.omocha.domain.member.vo.PhoneNumber;

public class MemberDto {

	public record CurrentMemberInfoResponse(
		// TODO : 회원 가입 정보 추가 후 변경
		Long memberId,
		Email email,
		String userName,
		String nickName,
		PhoneNumber phoneNumber,
		String birth,
		String profileImageUrl,
		String loginType,
		int likeCount
	) {
	}

	public record MemberModifyRequest(
		String nickName,
		String phoneNumber
	) {
	}

	public record MemberModifyResponse(
		// TODO : 회원 가입 정보 추가 후 변경
		Long memberId,
		Email email,
		String userName,
		String nickName,
		PhoneNumber phoneNumber,
		String birth,
		Role role,
		String profileImageUrl
	) {
	}

	public record PasswordModifyRequest(
		String currentPassword,
		String newPassword
	) {
	}

	public record ProfileImageModifyResponse(
		String imageUrl
	) {

	}

}