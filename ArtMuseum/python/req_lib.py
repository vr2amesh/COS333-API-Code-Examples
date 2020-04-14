import requests
from configs import BASE_URL

def getJSON(endpoint, **params):
    req = requests.get(
        BASE_URL + endpoint,
        params=params,
    )

    if req.ok:
        return req.json()
    else:
        return req.text