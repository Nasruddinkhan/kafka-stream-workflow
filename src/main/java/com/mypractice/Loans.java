package com.mypractice;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Loans {
    private long timestamp;
    private String result;
}
