package com.company.validator.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;

public class DateUtil {

    public static String getRoundHour(Long dateTime) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(dateTime), TimeZone.getDefault().toZoneId());
        return localDateTime.truncatedTo(ChronoUnit.HOURS).toString();
    }
}
