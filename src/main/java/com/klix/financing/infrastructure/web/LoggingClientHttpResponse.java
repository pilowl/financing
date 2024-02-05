package com.klix.financing.infrastructure.web;

import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.client.reactive.ClientHttpResponse;
import org.springframework.http.client.reactive.ClientHttpResponseDecorator;

import reactor.core.publisher.Flux;

public class LoggingClientHttpResponse extends ClientHttpResponseDecorator {

    private static final Logger logger = LoggerFactory.getLogger(LoggingClientHttpResponse.class);
    private static final DataBufferFactory bufferFactory = new DefaultDataBufferFactory();
    private final DataBuffer buffer = bufferFactory.allocateBuffer(1000);

    public LoggingClientHttpResponse(ClientHttpResponse delegate) {
        super(delegate);
    }

    @Override
    public Flux<DataBuffer> getBody() {
        return super.getBody()
                .doOnNext(this.buffer::write)
                .doOnComplete(() -> logger.info("Response Body: {}", buffer.toString(StandardCharsets.UTF_8)));
    }
}
