package com.myPractics;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

  @RequestMapping("/contact/list")
  public String list() {
    String contant = "홍길동" + "," + "aaa@test" + "," + "0102211" + "," + "홍컴퍼니";
    return contant;
  }
}
