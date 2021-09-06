package com.mypractice;


import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PayloadRequest {
    private long timestamp;
    private String result;
}
