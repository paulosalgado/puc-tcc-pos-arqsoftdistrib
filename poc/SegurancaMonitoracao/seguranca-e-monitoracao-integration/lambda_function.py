import boto3
import json
import os

from services import mail_service, sms_service, webservice_service

def lambda_handler(event, context):
    
    print(event)
    
    sns_client = boto3.client('sns')
    
    records = event['Records']
    
    for record in records: 
        
        body = record['body']
        body = json.loads(body)
        
        mail_service.send_mails(body, sns_client)
        sms_service.send_sms(body, sns_client)
        webservice_service.call_webservices(body, sns_client)
    
    return {
        "statusCode": 200, 
        "body": "OK"
    }
