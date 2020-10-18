package com.hqb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Provide {
    private int provideid;
    private int userid;
    private double rate;
    private double timelimit;
    private double goalmoney;
    private double nowmoney;
    private int status;
}
