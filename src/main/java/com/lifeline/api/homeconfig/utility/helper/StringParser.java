package com.lifeline.api.homeconfig.utility.helper;

import java.util.regex.Pattern;

public class StringParser {

    // Check if an UUID key is valid using regex Pattern
    public static Boolean isValidUUID(String uuid){
        if (uuid.isEmpty()) return Boolean.FALSE;

        Pattern uuidPattern = Pattern.compile("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$");

        return uuidPattern.matcher(uuid).matches();
    }

}
