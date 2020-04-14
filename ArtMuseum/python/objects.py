from configs import OBJECTS
from req_lib import getJSON

'''
Prints information related to objects in
the Princeton University Art Museum's
collection.
'''

if __name__ == "__main__":
    object_id = "25277"
    endpoint = OBJECTS + object_id
    objects = getJSON(endpoint)
    print(objects)