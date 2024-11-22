package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component //bean생서하는 어노테이션
@Data //setter, getter, toString(), equals, hashCode 생성 이게 없으면 주소값으로 표시, 다른곳에서 getter(가져오기)는 있지만 이곳에서 보내는 setter(보내기)가 없기때문에 주소값만 표시
public class Chef {
	
}
