package org.omocha.api.common.handler;

import java.io.IOException;

import org.omocha.api.auth.jwt.JwtProvider;
import org.omocha.api.common.response.ResultDto;
import org.omocha.domain.common.code.ErrorCode;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomAuthenticationEntryPointHandler implements AuthenticationEntryPoint {

	private final JwtProvider jwtProvider;

	@Override
	public void commence(
		HttpServletRequest request,
		HttpServletResponse response,
		AuthenticationException authException
	) throws IOException, ServletException {

		log.warn("Client IP: {}, Request URL: {}, HTTP Method: {}",
			request.getRemoteAddr(),
			request.getRequestURL(),
			request.getMethod()
		);

		log.warn("Authentication failed. Exception type: {}",
			authException.getClass().getSimpleName());

		log.warn("Exception message: {}", authException.getMessage());

		jwtProvider.logout(response);

		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		ResultDto<Void> resultDto = ResultDto.res(
			ErrorCode.UNAUTHORIZED.getStatusCode(),
			ErrorCode.UNAUTHORIZED.getDescription()
		);

		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), resultDto);
	}
}