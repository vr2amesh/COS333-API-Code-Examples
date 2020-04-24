import json
from configs import OBJECTS, MAKERS, PACKAGES
from req_lib import getJSON

if __name__ == "__main__":
    with open("allobjects.json", "r") as objfile:
        data = objfile.read()

    objects = json.loads(data)

    for obj in objects:
        endpoint = OBJECTS + str(obj["ObjectID"])
        req = getJSON(endpoint)
        obj["displaytitle"] = req["displaytitle"]
        print(obj["ObjectID"])
    
        with open("objects.json", "a") as objfile:
            objfile.write("\t")
            json.dump(obj, objfile)
            objfile.write(",\n")

    with open("objects.json", "a") as objfile:
        objfile.write("]")

########################################################

    with open("allmakers.json", "r") as makefile:
        data = makefile.read()

    makers = json.loads(data)

    with open("makers.json", "w") as makefile:
        makefile.write("[")
        makefile.write("\n")

    for m in makers:
        endpoint = MAKERS + str(m["ConstituentID"])
        req = getJSON(endpoint)
        m["displayname"] = req["displayname"]
        print(m["ConstituentID"])
    
        with open("makers.json", "a") as makefile:
            makefile.write("\t")
            json.dump(m, makefile)
            makefile.write(",\n")

    with open("makers.json", "a") as makefile:
        makefile.write("]")

# ########################################################

    with open("allpackages.json", "r") as pfile:
        data = pfile.read()

    packages = json.loads(data)

    with open("packages.json", "w") as pfile:
        pfile.write("[")
        pfile.write("\n")

    for p in packages:
        endpoint = PACKAGES + str(p["PackageId"])
        req = getJSON(endpoint)
        p["packagenote"] = req["packagenote"]
        print(p["PackageId"])
    
        with open("packages.json", "a") as pfile:
            pfile.write("\t")
            json.dump(p, pfile)
            pfile.write(",\n")

    with open("packages.json", "a") as pfile:
        pfile.write("]")


