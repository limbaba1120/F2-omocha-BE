package org.omocha.api.common.config;

import java.util.ArrayList;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;

@OpenAPIDefinition(
	servers = {
		@Server(url = "${url.server-domain}", description = "API Server")
	}
)
@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {
	public SwaggerConfig(MappingJackson2HttpMessageConverter converter) {
		var supportedMediaTypes = new ArrayList<>(converter.getSupportedMediaTypes());
		supportedMediaTypes.add(new MediaType("application", "octet-stream"));
		converter.setSupportedMediaTypes(supportedMediaTypes);
	}

	@Bean
	public ModelResolver modelResolver(ObjectMapper objectMapper) {
		return new ModelResolver(objectMapper);
	}

	@Bean
	public GroupedOpenApi customTestOpenAPI() {
		String[] paths = {"/api/**", "/{roomId}/messages"};

		return GroupedOpenApi.builder()
			.group("사용자를 위한 API")
			.pathsToMatch(paths)
			.build();
	}
}