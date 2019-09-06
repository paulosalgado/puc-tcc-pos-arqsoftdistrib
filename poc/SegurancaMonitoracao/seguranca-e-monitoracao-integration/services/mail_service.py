import boto3
import json
import os

from string import Template

TOPIC_ARN = os.environ['MAIL_TOPIC_ARN']

def send_mails(messageBody, sns_client): 
    
    type = messageBody['type']
    areaId = messageBody['areaId']
    
    if type == 'RISK': 
        typeMessage = 'Foi detectado um RISCO DE ROMPIMENTO DE BARRAGEM na área {}.'.format(areaId)
    else: 
        typeMessage = 'Foi detectado um ROMPIMENTO DE BARRAGEM na área {}.'.format(areaId)
    
    activatedBy = messageBody['activatedBy']
    sensorId = messageBody['sensorId']
    
    if activatedBy == 'AUTOMATIC': 
        activatedMessage = 'O alerta foi acionado automaticamente após leitura do sensor {}.'.format(sensorId)
    else: 
        activatedMessage = 'O alerta foi acionado manualmente após análise das leituras do sensor {}.'.format(sensorId)
    
    infoMessage = messageBody['info']
    
    with open('resources/mail_template.txt', mode='r', encoding='utf-8') as file_template:
        mail_template = Template(file_template.read())
    
    message = mail_template.substitute(LINE_1=typeMessage, LINE_2=activatedMessage, LINE_3=infoMessage)
    
    sns_client.publish(
        TopicArn=TOPIC_ARN, 
        Message=message
    )
