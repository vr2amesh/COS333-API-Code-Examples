from configs import MAKERS
from req_lib import getJSON
import json

'''
Prints information related to makers in
the Princeton University Art Museum's
collection.
'''

if __name__ == "__main__":
    maker_name = "Pablo Picasso"
    with open("makers.json", "r") as makefile:
        data = json.loads(makefile.read())
    
    for m in data:
        if m["displayname"] == maker_name:
            maker_id = m["ConstituentID"]
            break

    endpoint = MAKERS + str(maker_id)
    makers = getJSON(endpoint)
    print(makers)