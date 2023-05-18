package com.cafyf.code.entity;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SessionGroup {
    private int sessionId;
    private String sessionName;
    private int manageId;
    private Map<String, Integer> modes;

    public SessionGroup() {
        modes = new HashMap<>();
    }

}