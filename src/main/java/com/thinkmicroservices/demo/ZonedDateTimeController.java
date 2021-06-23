package com.thinkmicroservices.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Set;
import java.time.DateTimeException;
import java.time.zone.ZoneRulesException;

@RestController
public class ZonedDateTimeController {

    @GetMapping("/zones")
    public Set<String> getZoneIds() {
        return ZoneId.getAvailableZoneIds();
    }

    @GetMapping("/zonedDateTime")
    public ZonedDateTimeDetail zonedDateTime(@RequestParam(value = "zone", defaultValue = "US/Eastern") String zoneId) {

        return new ZonedDateTimeDetail(zoneId);

    }

    public class ZonedDateTimeDetail {

        private String error;
        private String zoneId;
        private ZonedDateTime zonedDateTime;

        ZonedDateTimeDetail(String zoneId) {
            this.zoneId = zoneId;

            try {

                this.zonedDateTime = ZonedDateTime.now(ZoneId.of(zoneId));

            } catch (DateTimeException ex) {
                this.error = ex.getMessage();
            }
        }

        public String getError() {
            return this.error;
        }

        public String getZoneId() {
            return this.zoneId;
        }

        public ZonedDateTime getDateTime() {
            return this.zonedDateTime;
        }

    }

}
