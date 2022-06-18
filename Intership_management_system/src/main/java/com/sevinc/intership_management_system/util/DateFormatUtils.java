package com.sevinc.intership_management_system.util;

import com.sevinc.intership_management_system.exceptions.ServiceRuntimeException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DateFormatUtils {

    public static final FastDateFormat DATE_TIME = FastDateFormat.getInstance("dd.MM.yyyy HH:mm:ss aa");
    public static final FastDateFormat DATE = FastDateFormat.getInstance("dd/MM/yyyy");

    public static String formatDate(Date date, FastDateFormat fdf) {
        if (date == null) {
            return "";
        }
        return fdf.format(date);
    }

    public static Date getDate(String date, FastDateFormat fdf) throws ParseException {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        return fdf.parse(date);
    }

    public static String getDateFormat(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return  formatter.format(date);

    }

    public static long toMilliseconds(Timestamp timestamp) {
        return timestamp == null ? 0 : timestamp.getTime();
    }

    public static long toMilliseconds(Date date) {
        return date == null ? 0 : date.getTime();
    }

    public static Date toDateIfGreaterThanZero(long milliseconds) {
        return milliseconds > 0 ? new Date(milliseconds) : null;
    }

    public static Date addMinutes(Date currentDate, int minutesToAdd) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.MINUTE, minutesToAdd);
        return cal.getTime();
    }

    public static Date formatBirthdate(String birthDate) {
        try {
            return DateFormatUtils.getDate(birthDate, DATE);
        } catch (ParseException e) {
            throw new ServiceRuntimeException("Cannot parse birthdate : " + birthDate);
        }
    }
}
