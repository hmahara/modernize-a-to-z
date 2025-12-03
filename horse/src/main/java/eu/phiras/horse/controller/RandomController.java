package eu.phiras.horse.controller;

import java.security.SecureRandom;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class RandomController {

	@RequestMapping("/random")
    @ResponseBody
    public String random() {
		log.info("Randomize text");
        return generateDefault(12);
    }
	
	private String generate(int length, String pool) {
	    SecureRandom random = new SecureRandom();
	    StringBuilder builder = new StringBuilder();

	    for (int i = 0; i < length; i++) {
	        int idx = random.nextInt(pool.length());
	        builder.append(pool.charAt(idx));
	    }
	    return builder.toString();
	}
	
	private String generateDefault(int length) {
	    String pool = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    String key = "result";
	    String val = generate(length, pool);
	    String retVal = "{\""+key+"\":\""+val+"\"}";
	    return retVal;
	}
	
}
