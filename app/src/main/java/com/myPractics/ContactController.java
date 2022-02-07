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
    // 배열이 꽉 찼을때 추가되지않게 조치
    if (size == 5) {
      return 0;
    }
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

  @RequestMapping("/contact/update")
  public Object update(String name, String mail, String tel, String company) {
    String contact = name + "," + mail + "," + tel + "," + company;
    for (int i = 0; i < size; i++) {
      if (contacts[i].split(",")[1].equals(mail)) {
        contacts[i] = contact;
        return 1;
      }
    }
    return 0;
  }

  @RequestMapping("/contact/delete")
  public Object delete(String mail) {
    for (int i = 0; i < size; i++) {
      if (contacts[i].split(",")[1].equals(mail)) {
        for (int j = i + 1; j < size; j++) {
          contacts[j - 1] = contacts[j];
        }
        size--;
        return 1;
      }
    }
    return 0;
  }
}
