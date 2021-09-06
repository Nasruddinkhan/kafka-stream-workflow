package com.mypractice.listener;

import com.mypractice.PayloadRequest;
import com.mypractice.stream.TestStreams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;
@Component
@Slf4j
public class TestListener {
    private final TestStreams testStreams;
    public TestListener(TestStreams testStreams) {
        this.testStreams = testStreams;
    }
    @StreamListener(TestStreams.INPUT)
    public void handleLoans(@Payload PayloadRequest payloadRequest) {
        log.info("Received results: {}", payloadRequest);
        payloadRequest.setResult(payloadRequest.getResult()+"");
        MessageChannel messageChannel = testStreams.outboundTopic();
        messageChannel.send(MessageBuilder
                .withPayload(payloadRequest)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }


}
