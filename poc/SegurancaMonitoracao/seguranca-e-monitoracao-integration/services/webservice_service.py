import boto3
import json
import os

TOPIC_ARN = os.environ['WEBSERVICE_TOPIC_ARN']

def call_webservices(messageBody, sns_client): 
    
    type = messageBody['type']
    areaId = messageBody['areaId']
    
    message = json.dumps({
        "status": "ALERT", 
        "type": type, 
        "area": areaId, 
        "contact": {
            "email": "pjosalgado@gmail.com", 
            "phone": "+5516981743887"
        }
    })
    
    sns_client.publish(
        TopicArn=TOPIC_ARN, 
        Message=message
    )
