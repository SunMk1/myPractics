package com.myPractics;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

  String[] contacts = new String[5];
  int size = 0;

  @RequestMapping("/contact/list")
  public Object list() {
    return contacts;
  }

  @RequestMapping("/contact/add")
  public Object add(String name, String mail, String tel, String company) {
    String contact = name + "," + mail + "," + tel + "," + company;
    contacts[size] = contact;
    size++;
    return 1;
  }
}
