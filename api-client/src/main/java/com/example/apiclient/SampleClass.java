package com.example.apiclient;

public class SampleClass {
    public static void main(String[] args) {
        String val = "value1.value2.value3";
        String[] vals = val.split("\\.",2);
        for (int i=0;i<vals.length;i++){
            System.out.println(vals[i]);
        }
    }
}
