package hello;

import jdk.nashorn.internal.ir.LiteralNode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

import java.util.*;

@Component
public class GreetingHandler {

	public Mono<ServerResponse> hello(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
			.body(BodyInserters.fromValue("Hello, Spring!"));
	}

	public Mono<ServerResponse> helloj(ServerRequest request) {
		Map<String, Object> helloMap = new HashMap<>();
		helloMap.put("name", "banulp");
		helloMap.put("say", "hello");
		helloMap.put("to","seyong");

		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(helloMap));
	}

	public Mono<ServerResponse> hellom(ServerRequest serverRequest) {

		Map<String, Object> helloMap = new HashMap<>();
		helloMap.put("name", "banulp");
		helloMap.put("say", "hello");
		helloMap.put("to","seyong");

		List<Map<String, Object>> lm = new ArrayList<>();
		lm.add(Collections.singletonMap("username1", "password1"));
		lm.add(Collections.singletonMap("username2", "password2"));
		lm.add(Collections.singletonMap("username3", "password3"));

		helloMap.put("lm",lm);

		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(helloMap));

	}
}
