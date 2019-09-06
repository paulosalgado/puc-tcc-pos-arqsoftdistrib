# Build project
./gradlew clean build

# Build Docker image
docker build -t paulosalgado/puc/compliance-backend .

# Push Docker image
docker tag paulosalgado/puc/compliance-backend 156732442254.dkr.ecr.us-east-1.amazonaws.com/paulosalgado/puc/compliance-backend:v2
$(aws ecr get-login --no-include-email --region us-east-1)
docker push 156732442254.dkr.ecr.us-east-1.amazonaws.com/paulosalgado/puc/compliance-backend

# Run container on ECS
aws ecs register-task-definition --region us-east-1 --family compliance-backend-task --network-mode bridge --container-definitions file://aws/container-definitions.json
aws ecs update-service --cluster dev-cluster --region us-east-1 --service compliance-backend-service --task-definition compliance-backend-task --desired-count 2 --deployment-configuration file://aws/deployment-configuration.json
