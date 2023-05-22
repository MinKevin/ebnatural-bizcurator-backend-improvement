package ebnatural.bizcurator.apiserver.service;

import java.util.Map;

public interface EmailService {
    Map<String, Object> sendSetNewPwdMessage(String to)throws Exception;
    String sendSimpleMessage(String to)throws Exception;

}