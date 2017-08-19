package colouredLights.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeService {

    public String currentTime() {
        Date instant = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        return simpleDateFormat.format(instant);
    }
}
