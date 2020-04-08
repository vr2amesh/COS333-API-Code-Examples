from req_lib import ReqLib
import datetime

'''
This endpoint on the MobileApp API returns 
an iCal stream of dining venue open hours.
The iCal stream really is just a plain 
text stream.

Parameters: from, to

The from and to parameters are dates formatted
in the following way:

YYYYMMDD

'''

if __name__ == "__main__":
    req_lib = ReqLib()
    # Keep in mind that because "from" is a 
    # keyword in the python language, we 
    # can't put "from" as a parameter in 
    # the following function

    # Get today's date
    today = datetime.datetime.today()
    year = str(today.year)

    # Pad the number with zeros so that 
    # there are always exactly two digits
    month = str(today.month).zfill(2)
    day = str(today.day).zfill(2)

    # Get the date 2 days from now
    two_days_later = today + datetime.timedelta(days=2)
    new_year = str(two_days_later.year)

    # Pad the number with zeros so that 
    # there are always exactly two digits
    new_month = str(two_days_later.month).zfill(2)
    new_day = str(two_days_later.day).zfill(2)

    req = req_lib.getXMLorTXT(
        req_lib.configs.EVENTS_EVENTS,
        kwargs={
            "from": year + month + day,
            "to": new_year + new_month + new_day,
        }
    )
    print(req)