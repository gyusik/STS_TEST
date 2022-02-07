package com.example.demo.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//ALWAYS : 속성의 값에 의존하지 말고 항상 포함
//NOT_EMPTY : null 또는 값이 빈 경우가 아니면 포함
//NOT_NULL : null 이 아니면 포함
//NOT_DEFAULT : bean의 기본생성자로 정의된 필드값과 다르게 변경된 필드만 포함
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestTestDTO {
	
	private String id;
    private String sendUrl;
    
    @Builder
    public RestTestDTO(String id, String sendUrl) {
        this.id = id;
        this.sendUrl = sendUrl;
    }

}
