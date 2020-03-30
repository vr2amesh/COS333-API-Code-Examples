#!/usr/bin/env python3
from configs import DINING_LOCATIONS
from req_lib import getXMLorTXT

'''
This route does not return data back in a JSON
format, rather it returns in an XML format. Therefore,
if you wish to access this data in JSON form, you will
need to do some manual parsing.

This route returns dining locations along with 
its latitude/longitude information, payment options,
building name, etc.

some categories:

2: dining halls
3: cafes
4: vending machines
6: shows amenities of each hall on campus. 
   Printers, Mac clusters, scanners, and wheelchair
   accessibility.

Please explore the rest of the category ids in order to see
which ones may fit your application needs.

Parameter: categoryID
'''
if __name__ == "__main__":
    # category 2 refers to all of the dining halls
    # on campus. A different number will return 
    # different types of  dining locations. For
    # example, category 3 returns all of the 
    # cafes on campus
    categoryID = 2
    locations = getXMLorTXT(
        DINING_LOCATIONS,
        categoryID=categoryID,
    )
    print(locations)