from configs import PACKAGES
from req_lib import getJSON
import json

'''
Prints information related to packages in
the Princeton University Art Museum's
collection.
'''

if __name__ == "__main__":
    package_name = "Chinese objects from December 2013 Asian Rotation"
    with open("packages.json", "r") as pkgfile:
        data = json.loads(pkgfile.read())
    
    for pkg in data:
        if pkg["packagenote"] == package_name:
            pkg_id = pkg["PackageId"]
            break

    endpoint = PACKAGES + str(pkg_id)
    packages = getJSON(endpoint)
    print(packages)