#!/usr/bin/env python3
import requests
import json
import xmltodict
from configs import BASE_URL, ACCESS_TOKEN, REFRESH_TOKEN_URL, CONSUMER_KEY, CONSUMER_SECRET
import base64

'''
This function allows a user to make a request to 
a certain endpoint, with the BASE_URL of 
https://api.princeton.edu:443/mobile-app

The parameters kwargs are keyword arguments. It
symbolizes a variable number of arguments 
'''
def getJSON(endpoint, **kwargs):
    req = requests.get(
        BASE_URL + endpoint, 
        params=kwargs if "kwargs" not in kwargs else kwargs["kwargs"], 
        headers={
            "Authorization": "Bearer " + ACCESS_TOKEN
        },
    )
    text = req.text

    # Check to see if the response failed due to invalid
    # credentials
    text = _updateConfigs(text, endpoint, **kwargs)

    return json.loads(text)

def _refreshToken(**kwargs):
    req = requests.post(
        REFRESH_TOKEN_URL, 
        data=kwargs, 
        headers={
            "Authorization": "Basic " + base64.b64encode(bytes(CONSUMER_KEY + ":" + CONSUMER_SECRET, "utf-8")).decode("utf-8")
        },
    )
    text = req.text
    return json.loads(text)

def _updateConfigs(text, endpoint, **kwargs):
    if text.startswith("<ams:fault"):
        req = _refreshToken(grant_type="client_credentials")
        access_token = req["access_token"]

        # Redo the request with the new access token
        req = requests.get(
            BASE_URL + endpoint, 
            params=kwargs if "kwargs" not in kwargs else kwargs["kwargs"], 
            headers={
                "Authorization": "Bearer " + access_token
            },
        )
        text = req.text

        # rewrite the value of the access token in 
        # configs.py
        new_lines = []
        with open("configs.py", "r") as config_file:
            config_file = config_file.readlines()
            for line in config_file:
                if line.startswith("ACCESS_TOKEN"):
                    new_lines.append('ACCESS_TOKEN=' + '"' + access_token + '"\n')
                else:
                    new_lines.append(line)

        with open("configs.py", "w") as config_file:
            config_file.writelines(new_lines)

    return text

def getXMLorTXT(endpoint, **kwargs):
    req = requests.get(
            BASE_URL + endpoint, 
            params=kwargs if "kwargs" not in kwargs else kwargs["kwargs"], 
            headers={
                "Authorization": "Bearer " + ACCESS_TOKEN
            },
        )
    # Check to see if the response failed due to invalid
    # credentials
    text = _updateConfigs(req.text, endpoint, **kwargs)
    return text