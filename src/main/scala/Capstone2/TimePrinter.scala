package Capstone2
import java.time.format.DateTimeFormatter
import java.time.{ZoneId, ZonedDateTime}

class TimePrinter(formatter: DateTimeFormatter) {

  def now(timezone: String): String ={
    val dateTime = currentDateTime(timezone)
    datetimeToString(dateTime)
  }

  private def currentDateTime(timeZone: String): ZonedDateTime={
    val zoneId = ZoneId.of(timeZone)
    ZonedDateTime.now(zoneId)
  }

  private def datetimeToString(dateTime: ZonedDateTime): String={
    formatter.format(dateTime)
  }
}
