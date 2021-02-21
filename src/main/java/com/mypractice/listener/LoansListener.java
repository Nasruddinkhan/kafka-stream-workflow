package com.mypractice.listener;

import com.mypractice.Loans;
import com.mypractice.stream.LoansStreams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;
@Component
@Slf4j
public class LoansListener {
    private final LoansStreams loansStreams;
    public LoansListener(LoansStreams loansStreams) {
        this.loansStreams = loansStreams;
    }
    @StreamListener(LoansStreams.INPUT)
    public void handleLoans(@Payload Loans loans) {
        log.info("Received results: {}", loans);
        loans.setResult(loans.getResult()+"");
        MessageChannel messageChannel = loansStreams.outboundLoans();
        messageChannel.send(MessageBuilder
                .withPayload(loans)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }
}
