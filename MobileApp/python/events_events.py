from configs import EVENTS_EVENTS
from req_lib import getXMLorTXT

'''
This endpoint on the MobileApp API returns 
an iCal stream of dining venue open hours.
The iCal stream really is just a plain 
text stream.

Parameters: from, to

The from and to parameters are dates formatted
in the following way:


'''

if __name__ == "__main__":
    # Keep in mind that because "from" is a 
    # keyword in the python language, we 
    # can't put "from" as a parameter in 
    # the following function
    req = getXMLorTXT(
        EVENTS_EVENTS,
        kwargs={
            "from": "2020",
            "to": "2021",
        }
    )
    print(req)