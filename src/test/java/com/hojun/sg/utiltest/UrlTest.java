package com.hojun.sg.utiltest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

@Slf4j
public class UrlTest {

  @Test
  public void TEST (){

    final String string = "/^(?:http(s)?:\\/\\/)?[\\wㄱ-힣.-]+(?:\\.[\\w\\.-]+)+[\\w\\-\\._~:/?#[\\]ㄱ-힣@!\\$&%'\\(\\)\\*\\+,;=.]+$/";

    final String https = "((http[s]?|ftp):\\/)?\\/?";
    final String domain = "([^:\\/\\s]+)";
    final String pathVariableAndQueryString = "((\\/\\w+)*\\/)([\\w\\-\\.]+[^#?\\s]+)(.*)?(#[\\w\\-]+)?";

    final String uriRegex ="^(?:http(s)?:\\/\\/)?[\\wㄱ-힣.-]+(?:\\.[\\w\\.-]+)+\\[\\w\\-\\._~:/?#[\\]ㄱ-힣@!\\$&%'\\(\\)\\*\\+,;=.]+$";
        //String.join("", https, domain, pathVariableAndQueryString);

    final String test = "^(?:http(s)?:\\/\\/)?[\\wㄱ-힣.-]+(?:\\.[\\w\\.-]+)+[\\w\\-\\._~:/?#\\[\\]ㄱ-힣@!\\$&%'\\(\\)\\*\\+,;=.]+$";


    /*testUris.forEach(e->{

      log.debug("{}",  Pattern.compile(test).matcher(e).matches());
    });*/

    log.debug("uri regex : {}", uriRegex);
    log.debug("{}", Pattern.compile(https).matcher("http://").matches());
    log.debug("{}", Pattern.compile(domain).matcher("www.daum.net").matches());
    log.debug("{}", Pattern.compile(pathVariableAndQueryString).matcher("/abd/ddd?aaa").matches());
    log.debug("{}", Pattern.compile(test).matcher("https://post.naver.com/viewer/postView.nhn?volumeNo=16281955&memberNo=31724756").matches());
    log.debug("{}", Pattern.compile(test).matcher("https://www.google.com/search?q=%EC%9D%B4%EB%AF%B8%EC%A7%80+%EB%A1%9C+%EA%B2%80%EC%83%89&source=lnms&tbm=isch&sa=X&ved=0ahUKEwinnofqt6rcAhXUUd4KHfUXBtAQ_AUICigB&biw=2519&bih=1303").matches());
  }
}
