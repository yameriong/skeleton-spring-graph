package com.hojun.sg.utiltest;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

@Slf4j
public class StringTest {

  @Test
  public void TEST() {
    final String stringlong = "안녕하세, 문의하신 [상품명]상품 관련, 교환 절차 안내드립니다.  1. 성함, 연락처, 요청사항을 기재한 메모와 왕복배송비 동봉 2. 반송 상품 재포장하시어 방문하는 택배 기사님께 전달 3. 상품 검수 후 교환 발송  회수 기사님은 영업일 기준 2~3일 내 방문 예정이며, 택배사 사정에 따라 방문이 지연될 수 있는 점 참고 바랍니다.  =============================================== *반송 전 주의사항 1. 변심 : 제품 수령일을 포함하여 7일 이내 요청에 한하여 처리 가능 2. 초기불량 : 제품 수령일을 포함하여 30일 이내 요청에 한하여 처리 가능. (환불의 경우 수령일을 포함하여 14일까지 요청 가능하며 이후에는 수령일 포함 30일까지 A/S 또는 교환으로 진행)  ※고객님의 부주의로 인하여 상품의 가치가 감소한 경우 교환 및 환불이 불가합니다. ===============================================  고객님의 기대에 어긋나지 않도록 더욱 노력하겠습니다.  ";

    final String string = "\n일\r이\r\n삼";
    final String string2 = "\n \r \r\n";
    log.debug("{}", htmlSignToString(string));
    log.debug("{}", StringUtils.isBlank(htmlSignToBlank(string2)));


    log.debug("{}", stringlong.length());
    String[] strings = splitByLength(stringlong,200);
    log.debug("{}", strings[2]);
  }

  /**
   * 특수문자 치환
   *
   * @param text 판별할문자열
   * @return boolean
   */
  public static String htmlSignToString(String text) {

    if (!StringUtils.isEmpty(text)) {
      // front-web에서 doFilter를 통해 <>가 변환되서 들어옴
      return text.replaceAll("(\r\n|\r|\n|\n\r)", "<br />");
    } else {
      return text;
    }

  }

  /**
   * 특수문자 치환
   *
   * @param text 판별할문자열
   * @return boolean
   */
  public static String htmlSignToBlank(String text) {

    if (!StringUtils.isEmpty(text)) {
      // front-web에서 doFilter를 통해 <>가 변환되서 들어옴
      return text.replaceAll("(\r\n|\r|\n|\n\r)", "");
    } else {
      return text;
    }

  }


  /**
   * 지정된 길이만큼 str을 split한다.
   *
   * @param str 자를 문자열
   * @param splitLength 문자열을 자를 길이
   * @return String Array
   */
  public static String[] splitByLength(String str, int splitLength) {
    if (str == null) {
      return null;
    }

    int strLen = str.length();
    int arrayLength = Math.abs(strLen / splitLength) + 1;

    String[] strArray = null;
    if (arrayLength == 0) {
      return new String[] { str };
    } else {
      strArray = new String[arrayLength];
    }

    String temp = "";
    for (int i = 0; i < arrayLength; i++) {
      if (str.length() > splitLength) {
        strArray[i] = str.substring(0, splitLength);
        temp = str.substring(splitLength, str.length());
      } else {
        strArray[i] = str.substring(0, str.length());
      }
      str = temp;
    }
    return strArray;
  }
}

