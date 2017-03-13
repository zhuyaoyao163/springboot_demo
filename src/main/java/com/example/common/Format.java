//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.common;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Format {
    private static Logger logger = LogManager.getLogger(Format.class);

    public Format() {
    }

    public static String stringTrim(String value) {
        if(value != null) {
            value = value.trim();
        }

        return value;
    }

    public static String stringNull(String value) {
        if(value != null) {
            value = value.trim();
            if(value.equals("")) {
                value = null;
            }
        }

        return value;
    }

    public static String stringBlank(String value) {
        value = stringNull(value);
        if(value == null) {
            value = "";
        }

        return value;
    }

    public static String stringBlank(Object value) {
        String result = "";
        result = stringNull((String)value);
        if(result == null) {
            result = "";
        }

        return result;
    }

    public static Date string2Date(String value, String format) {
        Date result = null;

        try {
            SimpleDateFormat e = new SimpleDateFormat(stringNull(format));
            result = e.parse(stringNull(value));
        } catch (Exception var4) {
            logger.error(value + " | " + format, var4);
        }

        return result;
    }

    public static String date2String(Date value, String format) {
        String result = null;

        try {
            SimpleDateFormat e = new SimpleDateFormat(stringNull(format));
            result = e.format(value);
        } catch (Exception var4) {
            logger.error(value + " | " + format, var4);
        }

        return result;
    }

    public static String number2String(BigDecimal value, String format) {
        String result = null;

        try {
            DecimalFormat e = new DecimalFormat(stringNull(format));
            result = e.format(value);
        } catch (Exception var4) {
            logger.error(value + " | " + format, var4);
        }

        return result;
    }

    public static String array2String(Object[] object) {
        StringBuilder result = new StringBuilder();
        result.append("{");
        int n = 0;
        Object[] arr$ = object;
        int len$ = object.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            Object obj = arr$[i$];
            result.append(obj.toString());
            ++n;
            if(n < object.length) {
                result.append(", ");
            }
        }

        result.append("}");
        return result.toString();
    }

    public static String exception2String(Throwable t) {
        StringBuilder result = new StringBuilder();
        result.append(t.toString());
        result.append("\n");
        StackTraceElement[] stes = t.getStackTrace();
        StackTraceElement[] arr$ = stes;
        int len$ = stes.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            StackTraceElement ste = arr$[i$];
            result.append(ste.toString());
            result.append("\n");
        }

        return result.toString();
    }

    public static String format(String pattern, Object... arguments) {
        return MessageFormat.format(pattern, arguments);
    }

    public static String amountYuanTOamountFen(String amountStr) {
        BigDecimal bigDecimalYuan = new BigDecimal(amountStr);
        BigDecimal bigDecimalFen = bigDecimalYuan.multiply(new BigDecimal(100));
        return formatBigDecimalToStr(bigDecimalFen);
    }

    public static String amountFenTOamountYuanStr(String amountStr) {
        if(amountStr != null && !"".equals(amountStr)) {
            BigDecimal bigDecimalFen = new BigDecimal(amountStr);
            BigDecimal bigDecimalYuan = bigDecimalFen.divide(new BigDecimal(100));
            DecimalFormat df = new DecimalFormat("0.00");
            return df.format(bigDecimalYuan.doubleValue());
        } else {
            return "0";
        }
    }

    public static String formatBigDecimalToStr(BigDecimal amount) {
        DecimalFormat format = (DecimalFormat)NumberFormat.getPercentInstance();
        format.applyPattern("##########0");
        return amount != null?format.format(amount):"";
    }

    public static Map<String, Object> formatRequest(HttpServletRequest request) {
        HashMap result = new HashMap();

        try {
            Map e = request.getParameterMap();
            Enumeration names = request.getParameterNames();

            while(names.hasMoreElements()) {
                StringBuilder sb = new StringBuilder();
                Object key = names.nextElement();
                Object[] values = (Object[])((Object[])e.get(key));
                String _key = (String)key;
                Object _value = values.length > 1?values:values[0];
                sb.append(_key);
                sb.append(" = |");
                Object[] arr$ = values;
                int len$ = values.length;

                for(int i$ = 0; i$ < len$; ++i$) {
                    Object value = arr$[i$];
                    sb.append((String)value);
                    sb.append("|");
                }

                logger.info(sb.toString());
                result.put(_key, _value);
            }
        } catch (Exception var13) {
            logger.error(request, var13);
        }

        return result;
    }
}
