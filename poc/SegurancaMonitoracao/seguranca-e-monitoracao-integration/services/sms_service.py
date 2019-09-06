import boto3
import json
import os

TOPIC_ARN = os.environ['SMS_TOPIC_ARN']

def send_sms(messageBody, sns_client): 
    
    type = messageBody['type']
    
    if type == 'risk': 
        message = 'ALERTA DE RISCO DETECTADO!'
    else: 
        message = 'ALERTA DE ROMPIMENTO DETECTADO!'
    
    sns_client.publish(
        TopicArn=TOPIC_ARN, 
        Message=message
    )
