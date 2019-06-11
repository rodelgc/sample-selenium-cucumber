package com.rodelcalasagsag.utils;

import java.util.ArrayList;
import java.util.List;

public class ListTrimmer {
  public static List<String> trim(List<String> list) {
    List<String> trimmedList = new ArrayList<>();
    list.forEach(
        item -> {
          if (!item.isEmpty()) {
            trimmedList.add(item);
          }
        });

    return trimmedList;
  }
}
