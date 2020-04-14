import requests
import hashlib
import random
from base64 import b64encode
from datetime import datetime
import uuid
from configs import KEY, USERNAME, AGENT, BASE_URL, ALL_UNDERGRADS

# This is mostly taken from the TigerBook API Readme Page
def genheaders():
    created = datetime.utcnow().strftime('%Y-%m-%dT%H:%M:%SZ')
    nonce = ''.join(
        [
            random.choice('0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ+/=') 
            for i in range(32)
        ]
    ).encode("utf-8")
    username = USERNAME + "+" + AGENT
    password = KEY
    generated_digest = b64encode(
        hashlib.sha256(
            nonce + created.encode("utf-8") + password.encode("utf-8")
        ).digest()
    )
    return {
        'Authorization': 'WSSE profile="UsernameToken"',
        'X-WSSE': 'UsernameToken Username="%s", PasswordDigest="%s", Nonce="%s", Created="%s"' 
        % (username, generated_digest.decode("utf-8"), b64encode(nonce).decode("utf-8"), created)
    }

def getAllUndergrads():
    headers = genheaders()
    req = requests.get(
        BASE_URL + ALL_UNDERGRADS,
        headers=headers,
    )
    return req

def getOneUndergrad(netid):
    headers = genheaders()
    req = requests.get(
        BASE_URL + ALL_UNDERGRADS + "/" + netid,
        headers=headers,
    )
    return req

if __name__ == "__main__":
    print("Please run either all_undergrads.py or one_undergrad.py")