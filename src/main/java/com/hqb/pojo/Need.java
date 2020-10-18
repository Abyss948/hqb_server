package com.hqb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Need {
    private int needid;
    private int userid;
    private double rate;
    private double timelimit;
    private double goalmoney;
    private double nowmoney;
    private int status;
}
