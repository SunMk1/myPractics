package com.myPractics;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

  String[] contacts = new String[5];
  int size = 0;

  @RequestMapping("/contact/list")
  public Object list() {
    String[] contactList = new String[size];
    for (int i = 0; i < size; i++) {
      contactList[i] = contacts[i];
    }
    return contactList;
  }

  @RequestMapping("/contact/add")
  public Object add(String name, String mail, String tel, String company) {
    String contact = name + "," + mail + "," + tel + "," + company;
    contacts[size++] = contact;
    return size;
  }

  @RequestMapping("/contact/get")
  public Object get(String mail) {
    for (int i = 0; i < size; i++) {
      if (contacts[i].split(",")[1].equals(mail)) {
        return contacts[i];
      }
    }
    return "";
  }
}
