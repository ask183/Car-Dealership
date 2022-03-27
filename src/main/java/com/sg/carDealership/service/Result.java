/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.carDealership.service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abekoppal
 */
public class Result<T> {

    private boolean success = true;
    private List<String> messages = new ArrayList<>();
    private T payload;

    public boolean isSuccess() {
        return success;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void addMessage(String message) {
        this.success = false;
        this.messages.add(message);
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

}
