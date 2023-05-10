package com.acme.suryayasaantariksa.quarkus.general.shopapp.core.util.jackson;

import java.time.LocalDateTime;

import com.acme.suryayasaantariksa.quarkus.general.shopapp.core.util.FormatUtil;
import com.fasterxml.jackson.databind.util.StdConverter;

public class TimeSerialize extends StdConverter<LocalDateTime, String> {
  @Override
  public String convert(LocalDateTime time) {
    return FormatUtil.convertToString(time);
  }
}
