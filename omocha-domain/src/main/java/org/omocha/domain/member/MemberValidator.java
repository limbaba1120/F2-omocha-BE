package org.omocha.domain.member;

public interface MemberValidator {
	boolean isEmailDuplicateForOauth(String email);

	void validateEmail(String email);

}
