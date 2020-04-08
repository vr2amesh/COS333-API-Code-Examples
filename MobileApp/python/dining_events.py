from req_lib import ReqLib

'''
This endpoint on the MobileApp API returns 
an iCal stream of dining venue open hours.
The iCal stream really is just a plain 
text stream.

Parameter: placeID


Experiment with different placeID values
to learn
'''

if __name__ == "__main__":
    req_lib = ReqLib()
    req = req_lib.getXMLorTXT(
        req_lib.configs.DINING_EVENTS,
        placeID=1,
    )
    print(req)