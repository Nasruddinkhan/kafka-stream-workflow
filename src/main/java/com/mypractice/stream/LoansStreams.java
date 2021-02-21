package com.mypractice.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface LoansStreams {
    String INPUT = "loans-in";
    String OUTPUT = "loans-out";

    @Input(INPUT)
    SubscribableChannel inboundLoans();

    @Output(OUTPUT)
    MessageChannel outboundLoans();
}
