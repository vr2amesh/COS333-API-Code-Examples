from configs import OBJECTS
from req_lib import getJSON
import json

'''
Prints information related to objects in
the Princeton University Art Museum's
collection.
'''

if __name__ == "__main__":
    object_name = "Figure Emerging from Clouds"
    with open("objects.json", "r") as objfile:
        data = json.loads(objfile.read())
    
    for obj in data:
        if obj["displaytitle"] == object_name:
            object_id = obj["ObjectID"]
            break

    endpoint = OBJECTS + str(object_id)
    objects = getJSON(endpoint)
    print(objects)